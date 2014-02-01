package stuffstuff.blocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class BlockRedstoneStuffSlab extends BlockStuffSlab
{
	public BlockRedstoneStuffSlab(int id, int otherID, boolean isDouble, Block[] modelBlocks, boolean useModelTexture, int[] modelMeta)
	{
		super(id, otherID, isDouble, modelBlocks, useModelTexture, modelMeta);
	}

	@Override
	public boolean canProvidePower()
	{
		return true;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side)
	{
		return 15;
	}
}
