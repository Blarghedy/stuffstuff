package stuffstuff.holidaystuff.worldgen.biome;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
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
		}
		return true;
	}

	@Override
	public boolean growTree(World world, Random rand, int x, int y, int z)
	{
		int height;
		RootGen rootGen;

		y--;

		for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
		{
			height = rand.nextInt(100) > 70 ? 1 : 0;
			rootGen = new RootGen(world, x, y + height, z, direction, rand);
			rootGen.generate();
		}

		height = 6 + rand.nextInt(4);

		for (int i = 0; i < height; i++)
		{

		}
		world.setBlock(x, y + 1, z, BlocksHolidayStuff.blockHalloweenLog);
		return true;
	}

	private class LogGen
	{
		private int x, y, z;
		private int width;
		ForgeDirection direction;
		Random rand;
		World world;

		public LogGen(World world, int x, int y, int z, ForgeDirection direction, int width, Random rand)
		{
			this.world = world;
			this.x = x;
			this.y = y;
			this.z = z;
			this.direction = direction;
			this.width = width;
			this.rand = rand;
		}

		public void generate()
		{
			
		}
		
		public void goToNextBlock()
		{
			goToNextBlock(Direction.FORWARD);
		}
		
		public void goToNextBlock(Direction way)
		{
			switch (direction)
			{
				case NORTH:
					z--;
					break;
				case SOUTH:
					z++;
					break;
				case EAST:
					x++;
					break;
				case WEST:
					x--;
					break;
				case UP:
					y++;
					break;
				case DOWN:
					y--;
			}
		}
		
		
	}

	private class RootGen extends LogGen
	{

		public RootGen(World world, int x, int y, int z, ForgeDirection direction, Random rand)
		{
			super(world, x, y, z, direction, 3, rand);
		}

		public void generate()
		{
			int length = rand.nextInt(5);
			for (int i = 0; i < length; i++)
			{
//				world.setBlockMetadataWithNotify(par1, par2, par3, par4, par5)
			}
		}
	}
	
	private enum Direction
	{
		RIGHT, LEFT, UP, DOWN, FORWARD, BACK;
	}

}
