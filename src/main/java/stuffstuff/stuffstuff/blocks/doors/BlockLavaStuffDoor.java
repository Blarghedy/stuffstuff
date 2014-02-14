package stuffstuff.stuffstuff.blocks.doors;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import stuffstuff.stuffstuff.blocks.helper.LavaHelper;

public class BlockLavaStuffDoor extends BlockFluidStuffDoor
{
	public BlockLavaStuffDoor(Block modelBlock, int modelMeta, boolean useModelTexture)
	{
		super(modelBlock, modelMeta, useModelTexture);
		this.setTickRandomly(true);
	}

	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		LavaHelper.updateTick(world, x, y, z, rand);
	}

}
