package stuffstuff.power.helper;

import stuffstuff.power.IStuffPower;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class StuffPowerHelper
{
	public static double getStuffPower(ItemStack itemstack)
	{
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (tag == null) return 0;
		if (!tag.hasKey(IStuffPower.STUFF_POWER_KEY))
		{
			return 0;
		}
		else
		{
			return tag.getDouble(IStuffPower.STUFF_POWER_KEY);
		}
	}
	
	/**
	 * 
	 * @param itemstack
	 * @param power
	 * @return amount of power actually set. If power > max power, only sets power.
	 */
	public static double setStuffPower(ItemStack itemstack, double power)
	{
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (tag == null) tag = itemstack.stackTagCompound = new NBTTagCompound();
		if (!tag.hasKey(IStuffPower.STUFF_POWER_MAX_KEY)) return 0; // can't add power over max and max is 0/doesn't exist
		if (power < 0) power = 0;
		
		double max = tag.getDouble(IStuffPower.STUFF_POWER_MAX_KEY);
		if (power > max) 
		{
			power = max;
		}
		tag.setDouble(IStuffPower.STUFF_POWER_KEY, power);
		return power;
	}
	
	/**
	 * 
	 * @param itemstack
	 * @param amount
	 * @return amount of power actually set. If total power > max power, only sets max power.
	 */
	public static double increaseStuffPower(ItemStack itemstack, double amount)
	{
		double powerStored = getStuffPower(itemstack);
		double powerSet = setStuffPower(itemstack, powerStored + amount);
		return powerSet;
	}
	
	/**
	 * 
	 * @param itemstack
	 * @param amount
	 * @return amount of power actually set. If total power < 0, sets 0.
	 */
	public static double decreaseStuffPower(ItemStack itemstack, double amount)
	{
		double powerStored = getStuffPower(itemstack);
		double powerSet = setStuffPower(itemstack, powerStored - amount);
		return powerSet;
	}
	
	public static void setMaxStuffPower(ItemStack itemstack, double amount)
	{
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (tag == null) tag = itemstack.stackTagCompound = new NBTTagCompound();
		tag.setDouble(IStuffPower.STUFF_POWER_MAX_KEY, amount);
	}
	
	public static double getMaxStuffPower(ItemStack itemstack)
	{
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (tag == null) return 0;
		if (!tag.hasKey(IStuffPower.STUFF_POWER_MAX_KEY))
		{
			return 0;
		}
		else
		{
			return tag.getDouble(IStuffPower.STUFF_POWER_MAX_KEY);
		}
	}
}
