package stuffstuff.items.interfaces;

import net.minecraft.item.ItemStack;

public interface IChargeable
{
	// TODO refactor these to be static, or figure out a reason why not to do so
	public int getCharge(ItemStack itemstack);
	public int setCharge(ItemStack itemstack, short charge);
	public int incrementCharge(ItemStack itemstack);
	public int decrementCharge(ItemStack itemstack);
}
