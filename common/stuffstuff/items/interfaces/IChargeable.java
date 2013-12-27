package stuffstuff.items.interfaces;

import net.minecraft.item.ItemStack;

public interface IChargeable
{
	public int getCharge(ItemStack itemstack);

	public int setCharge(ItemStack itemstack, short charge);

	public int incrementCharge(ItemStack itemstack);

	public int decrementCharge(ItemStack itemstack);

	public double getChargePercent(ItemStack itemstack);
}
