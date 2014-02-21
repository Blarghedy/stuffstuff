package stuffstuff.holidaystuff.worldgen.biome;

import java.util.Random;

import net.minecraft.world.World;
import stuffstuff.holidaystuff.blocks.BlocksHolidayStuff;
import stuffstuff.stuffstuff.worldgen.WorldGenStuffTrees;

public class WorldGenHalloweenTrees extends WorldGenStuffTrees
{
	public WorldGenHalloweenTrees()
	{
		this(false);
	}

	public WorldGenHalloweenTrees(boolean b)
	{
		super(b);
	}

	@Override
	public boolean generate(World world, Random rand, int x, int tries, int z)
	{
		if (rand.nextInt(100) < 30)
		{
			int y = world.getActualHeight();
			while (world.isAirBlock(x, y, z) && y-- > 0)
			{
				;
			}

			growTree(world, rand, x, y + 1, z);

			x += rand.nextInt(16) - 8;
			z += rand.nextInt(16) - 8;
		}
		return true;
	}

	@Override
	public boolean growTree(World world, Random rand, int x, int y, int z)
	{
		world.setBlock(x, y + 1, z, BlocksHolidayStuff.blockHalloweenLog);
		return false;
	}

}
