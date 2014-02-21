package stuffstuff.stuffstuff.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.blocks.BlockPlaidSapling;
import stuffstuff.stuffstuff.blocks.BlocksStuff;
import stuffstuff.stuffstuff.blocks.PlaidColor;

public class WorldGenPlaidTrees extends WorldGenStuffTrees
{
	public WorldGenPlaidTrees(boolean doBlockNotify)
	{
		super(doBlockNotify);
	}

	public WorldGenPlaidTrees()
	{
		this(false);
	}

	@Override
	public boolean generate(World world, Random random, int x, int tries, int z)
	{
		for (int i = 0; i < 1; i++)
		{
			int y = world.getActualHeight();
			while (world.isAirBlock(x, y, z) && y-- > 0)
			{
				;
			}

			growTree(world, random, x, y + 1, z);

			x += random.nextInt(16) - 8;
			z += random.nextInt(16) - 8;
		}
		return true;
	}

	public boolean growTree(World world, Random rand, int x, int y, int z)
	{
		int treeHeight = rand.nextInt(3) + 5;
		int worldHeight = world.getHeight();
		Block block;

		if (y >= 1 && y + treeHeight + 1 <= worldHeight)
		{
			int xOffset;
			int yOffset;
			int zOffset;

			block = world.getBlock(x, y - 1, z);

			if (block != null && block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockPlaidSapling)BlocksStuff.blockPlaidSapling) && y < worldHeight - treeHeight - 1)
			{
				for (yOffset = y; yOffset <= y + 1 + treeHeight; ++yOffset)
				{
					byte radius = 1;

					if (yOffset == y)
					{
						radius = 0;
					}

					if (yOffset >= y + 1 + treeHeight - 2)
					{
						radius = 2;
					}

					if (yOffset >= 0 & yOffset < worldHeight)
					{
						for (xOffset = x - radius; xOffset <= x + radius; ++xOffset)
						{
							for (zOffset = z - radius; zOffset <= z + radius; ++zOffset)
							{
								block = world.getBlock(xOffset, yOffset, zOffset);

								if (block != null && !(block.isLeaves(world, xOffset, yOffset, zOffset) || block.isAir(world, xOffset, yOffset, zOffset) || block.canBeReplacedByLeaves(world, xOffset, yOffset, zOffset)))
									return false;
							}
						}
					}
					else
						return false;
				}

				block = world.getBlock(x, y - 1, z);

				if (block == Blocks.air)
					return false;
				block.onPlantGrow(world, x, y - 1, z, x, y, z);

				PlaidColor color = PlaidColor.getPlaidColorFromPos(x, y, z);

				for (yOffset = y - 3 + treeHeight; yOffset <= y + treeHeight; ++yOffset)
				{
					int var12 = yOffset - (y + treeHeight), center = 1 - var12 / 2;

					for (xOffset = x - center; xOffset <= x + center; ++xOffset)
					{

						int xPos = xOffset - x; 
						int t = xPos >> 31;
						xPos = xPos + t ^ t;
	
						for (zOffset = z - center; zOffset <= z + center; ++zOffset)
						{
							int zPos = zOffset - z;
							zPos = zPos + (t = zPos >> 31) ^ t;
	
							block = world.getBlock(xOffset, yOffset, zOffset);
	
							if ((xPos != center | zPos != center || rand.nextInt(2) != 0 && var12 != 0) && (block == null || block.isLeaves(world, xOffset, yOffset, zOffset) || block.isAir(world, xOffset, yOffset, zOffset) || block.canBeReplacedByLeaves(world, xOffset, yOffset, zOffset)))
							{
								this.setBlockAndNotifyAdequately(world, xOffset, yOffset, zOffset, BlocksStuff.blockPlaidLeaves, color.ordinal());
								// TODO plaid leaves here
							}
						}
					}
				}

				for (yOffset = 0; yOffset < treeHeight; ++yOffset)
				{
					block = world.getBlock(x, y + yOffset, z);

					if (block == null || block.isAir(world, x, y + yOffset, z) || block.isLeaves(world, x, y + yOffset, z) || block.isReplaceable(world, x, y + yOffset, z)) // replace snow
					{
						this.setBlockAndNotifyAdequately(world, x, y + yOffset, z, BlocksStuff.blockPlaidLog, color.ordinal());
					}
				}

				return true;
			}
		}
		return false;
	}

}
