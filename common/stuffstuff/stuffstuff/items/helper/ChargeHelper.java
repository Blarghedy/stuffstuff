package stuffstuff.stuffstuff.items.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import stuffstuff.stuffstuff.player.NotificationHelper;

public class ChargeHelper
{
	// TODO move these to config
	public static final String CHARGE_KEY = "stuffstuff charge";
	public static final int MAX_CHARGE = 10;

	public static int getCharge(ItemStack itemstack)
	{
		NBTTagCompound tag = itemstack.stackTagCompound;

		short charge = 0;
		if (tag == null || !tag.hasKey(CHARGE_KEY))
			return setCharge(itemstack, (short)2);
		else
		{
			charge = tag.getShort(CHARGE_KEY);
			if (charge < 0)
				return setCharge(itemstack, (short)2);
			else if (charge > MAX_CHARGE)
				return setCharge(itemstack, (short)MAX_CHARGE);
			else
				return charge;
		}
	}

	public static int setCharge(ItemStack itemstack, short charge)
	{
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (charge < -1)
		{
			charge = (short)0;
		}
		else if (charge > MAX_CHARGE)
		{
			charge = MAX_CHARGE;
		}

		if (tag == null)
		{
			tag = new NBTTagCompound();
			itemstack.stackTagCompound = tag;
		}
		tag.setShort(CHARGE_KEY, charge);
		// TODO once localization happens, change to "set <name>'s charge"
		NotificationHelper.notifySelf("Set charge to " + charge);
		return charge;
	}

	public static int incrementCharge(ItemStack itemstack)
	{
		int charge = getCharge(itemstack);
		if (charge == MAX_CHARGE)
			return charge; // no need to touch NBT any more than this

		setCharge(itemstack, (short)(charge + 1));
		return charge + 1;
	}

	public static int decrementCharge(ItemStack itemstack)
	{
		int charge = getCharge(itemstack);
		if (charge == 0)
			return charge; // no need to touch NBT any more than this

		setCharge(itemstack, (short)(charge - 1));
		return charge - 1;
	}

	public static double getChargePercent(ItemStack itemstack)
	{
		return 1.0 * getCharge(itemstack) / MAX_CHARGE;
	}
}
