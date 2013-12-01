package stuffstuff.items.interfaces;

import stuffstuff.items.BlockPlaceMode;
import net.minecraft.item.ItemStack;

public interface IBlockPlaceMode
{
	public BlockPlaceMode getBlockPlaceMode(ItemStack itemstack);
	public BlockPlaceMode setBlockPlaceMode(ItemStack itemstack, BlockPlaceMode mode);
	public BlockPlaceMode incrementBlockPlaceMode(ItemStack itemstack);
	public BlockPlaceMode decrementBlockPlaceMode(ItemStack itemstack);
}
