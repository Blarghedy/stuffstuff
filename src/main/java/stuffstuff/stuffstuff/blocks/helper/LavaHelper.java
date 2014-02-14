package stuffstuff.stuffstuff.blocks.helper;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class LavaHelper
{
	public static void updateTick(World world, int x, int y, int z, Random rand)
	{
		int iterations = rand.nextInt(3);
		int i;
		Block block;
		int tmp;

		for (i = 0; i < iterations; ++i)
		{
			x += rand.nextInt(3) - 1;
			++y;
			z += rand.nextInt(3) - 1;
			block = world.getBlock(x, y, z);

			if (block == null)
			{
				if (isFlammable(world, x - 1, y, z) || isFlammable(world, x + 1, y, z) || 
						isFlammable(world, x, y, z - 1) || isFlammable(world, x, y, z + 1) || 
						isFlammable(world, x, y - 1, z) || isFlammable(world, x, y + 1, z))
				{
					world.setBlock(x, y, z, Blocks.fire);
					return;
				}
			}
			else if (block.getMaterial().blocksMovement())
			{
				return;
			}
		}

		if (iterations == 0)
		{
			i = x;
			tmp = z;

			for (int k1 = 0; k1 < 3; ++k1)
			{
				x = i + rand.nextInt(3) - 1;
				z = tmp + rand.nextInt(3) - 1;

				if (world.isAirBlock(x, y + 1, z) && isFlammable(world, x, y, z))
				{
					world.setBlock(x, y + 1, z, Blocks.fire);
				}
			}
		}

	}

	private static boolean isFlammable(World world, int x, int y, int z)
	{
		return world.getBlock(x, y, z).getMaterial().getCanBurn();
	}
}
