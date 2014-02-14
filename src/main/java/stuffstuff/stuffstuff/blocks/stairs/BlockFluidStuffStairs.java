package stuffstuff.stuffstuff.blocks.stairs;

import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockFluidStuffStairs extends BlockStuffStairs
{

	public BlockFluidStuffStairs(Block modelBlock, int modelMeta, boolean useModelTexture)
	{
		super(modelBlock, modelMeta, useModelTexture);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return getModel().getCollisionBoundingBoxFromPool(world, x, y, z);
	}

}
