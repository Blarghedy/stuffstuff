package stuffstuff.power;

import net.minecraft.item.ItemStack;

public interface IStuffPower
{
	public static final String STUFF_POWER_KEY = "stuffPower";
	public static final String STUFF_POWER_MAX_KEY = "stuffMaxPower";
	
	public double getStuffPower(ItemStack itemstack);
	public double setStuffPower(ItemStack itemstack, double power);
	
	public double increaseStuffPower(ItemStack itemstack, double amount);
	public double decreaseStuffPower(ItemStack itemstack, double amount);
	
	public double getMaxStuffPower(ItemStack itemstack);
	public void setMaxStuffPower(ItemStack itemstack, double power);
}
