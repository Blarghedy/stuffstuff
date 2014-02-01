package stuffstuff.blocks.stairs;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class BlockRedstoneStuffStairs extends BlockStuffStairs
{

	public BlockRedstoneStuffStairs(int id, Block modelBlock, int modelMeta, boolean useModelTexture)
	{
		super(id, modelBlock, modelMeta, useModelTexture);
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
