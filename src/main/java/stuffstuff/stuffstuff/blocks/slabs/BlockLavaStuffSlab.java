package stuffstuff.stuffstuff.blocks.slabs;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import stuffstuff.stuffstuff.blocks.helper.LavaHelper;

public class BlockLavaStuffSlab extends BlockFluidStuffSlab
{
	public BlockLavaStuffSlab(boolean isDouble, Block[] modelBlocks, boolean useModelTexture, int[] modelMeta)
	{
		super(isDouble, modelBlocks, useModelTexture, modelMeta);
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		LavaHelper.updateTick(world, x, y, z, rand);
	}
}
