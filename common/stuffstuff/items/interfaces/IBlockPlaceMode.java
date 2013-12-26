package stuffstuff.items.interfaces;

import net.minecraft.item.ItemStack;
import stuffstuff.items.BlockPlaceMode;

public interface IBlockPlaceMode
{
	public BlockPlaceMode getBlockPlaceMode(ItemStack itemstack);
	public BlockPlaceMode setBlockPlaceMode(ItemStack itemstack, BlockPlaceMode mode);
	public BlockPlaceMode incrementBlockPlaceMode(ItemStack itemstack);
	public BlockPlaceMode decrementBlockPlaceMode(ItemStack itemstack);
}
