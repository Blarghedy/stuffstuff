package stuffstuff.blocks.doors;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockLavaStuffDoor extends BlockFluidStuffDoor
{
	public BlockLavaStuffDoor(int id, Block modelBlock, int modelMeta, boolean useModelTexture)
	{
		super(id, modelBlock, modelMeta, useModelTexture);
	}

	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		int iterations = rand.nextInt(3);
		int i;
		int id;

		for (i = 0; i < iterations; ++i)
		{
			x += rand.nextInt(3) - 1;
			++y;
			z += rand.nextInt(3) - 1;
			id = world.getBlockId(x, y, z);

			if (id == 0)
			{
				if (isFlammable(world, x - 1, y, z) || isFlammable(world, x + 1, y, z) || 
						isFlammable(world, x, y, z - 1) || isFlammable(world, x, y, z + 1) || 
						isFlammable(world, x, y - 1, z) || isFlammable(world, x, y + 1, z))
				{
					world.setBlock(x, y, z, Block.fire.blockID);
					return;
				}
			}
			else if (Block.blocksList[id].blockMaterial.blocksMovement())
			{
				return;
			}
		}

		if (iterations == 0)
		{
			i = x;
			id = z;

			for (int k1 = 0; k1 < 3; ++k1)
			{
				x = i + rand.nextInt(3) - 1;
				z = id + rand.nextInt(3) - 1;

				if (world.isAirBlock(x, y + 1, z) && this.isFlammable(world, x, y, z))
				{
					world.setBlock(x, y + 1, z, Block.fire.blockID);
				}
			}
		}

	}

	private boolean isFlammable(World world, int x, int y, int z)
	{
		return world.getBlockMaterial(x, y, z).getCanBurn();
	}

}
