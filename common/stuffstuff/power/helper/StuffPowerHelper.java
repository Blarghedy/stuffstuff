package stuffstuff.power.helper;

import stuffstuff.power.IStuffPower;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class StuffPowerHelper
{
	/**
	 * 
	 * @param itemstack {@link ItemStack} whose item must implement {@link IStuffPower}
	 * @return itemstack's current power or 0 if things aren't set up properly
	 */
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
	 * @param itemstack {@link ItemStack} whose item must implement {@link IStuffPower}
	 * @param power
	 * @return amount of power actually set. If power > max power, only sets power.
	 */
	public static double setStuffPower(ItemStack itemstack, double power)
	{
		
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (tag == null) tag = itemstack.stackTagCompound = new NBTTagCompound();
		if (power < 0) power = 0;
		
		double max = getMaxStuffPower(itemstack);
		if (power > max) 
		{
			power = max;
		}
		tag.setDouble(IStuffPower.STUFF_POWER_KEY, power);
		return power;
	}
	
	/**
	 * 
	 * @param itemstack {@link ItemStack} whose item must implement {@link IStuffPower}
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
	 * @param itemstack {@link ItemStack} whose item must implement {@link IStuffPower}
	 * @param amount
	 * @return amount of power actually set. If total power < 0, sets 0.
	 */
	public static double decreaseStuffPower(ItemStack itemstack, double amount)
	{
		double powerStored = getStuffPower(itemstack);
		double powerSet = setStuffPower(itemstack, powerStored - amount);
		return powerSet;
	}
	
	/**
	 * This function is NOT a base implementation for {@link IStuffPower#getMaxStuffPower(ItemStack)}.
	 * It is private and should only be used in this class (obviously).
	 * @param itemstack {@link ItemStack} whose item must implement {@link IStuffPower}
	 * @return
	 */
	private static double getMaxStuffPower(ItemStack itemstack)
	{
		IStuffPower item = null;
		
		if (itemstack == null) return 0;
		else if (itemstack.getItem() instanceof IStuffPower) item = (IStuffPower)itemstack.getItem();
		else return 0;
		
		return item.getMaxStuffPower();
	}
	
	public double getStuffPowerPercent(ItemStack itemstack)
	{
		double max = getMaxStuffPower(itemstack);
		if (max == 0) return 0;
		else return getStuffPower(itemstack) / max; 
	}

}
