package stuffstuff.stuffstuff.blocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockFluidStuffSlab extends BlockStuffSlab
{
	public BlockFluidStuffSlab(int id, int otherID, boolean isDouble, Block[] modelBlocks, boolean useModelTexture, int[] modelMeta)
    {
	    super(id, otherID, isDouble, modelBlocks, useModelTexture, modelMeta);
    }

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return getModels()[0].getCollisionBoundingBoxFromPool(world, x, y, z);
	}
}
