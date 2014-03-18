package stuffstuff.holidaystuff.worldgen.biome.halloween;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.holidaystuff.blocks.BlocksHolidayStuff;
import stuffstuff.stuffstuff.blocks.BlockStuffLog;
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
		LogGen logGen;
		
		y--;

		for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
		{
			height = rand.nextInt(100) > 70 ? 1 : 0;
			rootGen = new RootGen(world, x, y + height, z, direction, rand);
			rootGen.generate();
		}

		height = 6 + rand.nextInt(4);

		for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
		{
			logGen = new LogGen(world, x, y, z, direction, 4, rand);
			logGen.generate();
		}
		world.setBlock(x, y + 1, z, BlocksHolidayStuff.blockHalloweenLog);
		return true;
	}

	private class LogGen
	{
		private int worldX, worldY, worldZ;
		private int curX, curY, curZ;
		private int width;
		ForgeDirection wholeLogOrientation;
		ForgeDirection facing;
		Random rand;
		World world;
		private BlockStuffLog log;

		public LogGen(World world, int x, int y, int z, ForgeDirection direction, int width, Random rand)
		{
			this.world = world;
			this.worldX = x;
			this.worldY = y;
			this.worldZ = z;
			this.wholeLogOrientation = direction;
			this.facing = direction;
			this.width = width;
			this.rand = rand;
			log = (BlockStuffLog)BlocksHolidayStuff.blockHalloweenLog;
			curX = 0;
			curY = 0;
			curZ = 0;
		}

		public void generate()
		{
			for (int i = 1; i < 6; i++)
			{
				setLogAt(i, 0, 0, 0);
			}
		}

		void setLogAt(int x, int y, int z, int meta)
		{
			switch(wholeLogOrientation)
			{
				case NORTH:
					world.setBlock(worldX + x, worldY + y, worldZ + z, log, meta, 2);
					break;
				case SOUTH:
					world.setBlock(worldX - x, worldY + y, worldZ - z, log, meta, 2);
					break;
				case EAST:
					world.setBlock(worldX - z, worldY + y, worldZ - x, log, meta, 2);
					break;
				case WEST:
					world.setBlock(worldX + z, worldY + y, worldZ + x, log, meta, 2);
					break;
				case UP:
					world.setBlock(worldX + x, worldY + z, worldZ - y, log, meta, 2);
					break;
				case DOWN:
					world.setBlock(worldX - x, worldY - z, worldZ + y, log, meta, 2);
			}
		}

		public int getMetaAt(int x, int y, int z)
		{
			switch(wholeLogOrientation)
			{
				case NORTH:
					return world.getBlockMetadata(worldX + x, worldY + y, worldZ + z);
				case SOUTH:
					return world.getBlockMetadata(worldX - x, worldY + y, worldZ - z);
				case EAST:
					return world.getBlockMetadata(worldX - z, worldY + y, worldZ - x);
				case WEST:
					return world.getBlockMetadata(worldX + z, worldY + y, worldZ + x);
				case UP:
					return world.getBlockMetadata(worldX + x, worldY + z, worldZ - y);
				case DOWN:
					return world.getBlockMetadata(worldX - x, worldY - z, worldZ + y);
				default:
					return 0;
			}
		}

		public Block getBlockAt(int x, int y, int z)
		{
			switch(wholeLogOrientation)
			{
				case NORTH:
					return world.getBlock(worldX + x, worldY + y, worldZ + z);
				case SOUTH:
					return world.getBlock(worldX - x, worldY + y, worldZ - z);
				case EAST:
					return world.getBlock(worldX - z, worldY + y, worldZ - x);
				case WEST:
					return world.getBlock(worldX + z, worldY + y, worldZ + x);
				case UP:
					return world.getBlock(worldX + x, worldY + z, worldZ - y);
				case DOWN:
					return world.getBlock(worldX - x, worldY - z, worldZ + y);
				default:
					return null;
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
