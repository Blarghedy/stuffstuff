package stuffstuff.stuffstuff.blocks.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import stuffstuff.stuffstuff.blocks.slabs.BlockStuffSlab;

public class ItemStuffSlab extends ItemSlab
{
	private static BlockStuffSlab singleSlab;
	private static BlockStuffSlab doubleSlab;

	static public void setSlabs(BlockStuffSlab sing, BlockStuffSlab doub)
	{
		singleSlab = sing;
		doubleSlab = doub;
	}

	public ItemStuffSlab(Block block)
	{
		super(block, singleSlab, doubleSlab, block == doubleSlab);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta % 8;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		BlockStuffSlab slab = (BlockStuffSlab)Block.getBlockFromItem(itemStack.getItem());

		return super.getUnlocalizedName() + "." + new StringBuilder().append(slab.func_150002_b(itemStack.getItemDamage())).toString();
	}
}
