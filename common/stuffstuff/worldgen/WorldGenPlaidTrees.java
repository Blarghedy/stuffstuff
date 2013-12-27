package stuffstuff.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraftforge.common.ForgeDirection;
import stuffstuff.blocks.BlockPlaidSapling;
import stuffstuff.blocks.Blocks;
import stuffstuff.blocks.PlaidColor;

public class WorldGenPlaidTrees extends WorldGenTrees
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

			boolean grew = growTree(world, random, x, y + 1, z);

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
			int blockId;
			int xOffset;
			int yOffset;
			int zOffset;

			blockId = world.getBlockId(x, y - 1, z);
			block = Block.blocksList[blockId];

			if (block != null && block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, (BlockPlaidSapling)Blocks.blockPlaidSapling) && y < worldHeight - treeHeight - 1)
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
								blockId = world.getBlockId(xOffset, yOffset, zOffset);

								block = Block.blocksList[blockId];

								if (block != null && !(block.isLeaves(world, xOffset, yOffset, zOffset) || block.isAirBlock(world, xOffset, yOffset, zOffset) || block.canBeReplacedByLeaves(world, xOffset, yOffset, zOffset)))
									return false;
							}
						}
					}
					else
						return false;
				}

				blockId = world.getBlockId(x, y - 1, z);
				block = Block.blocksList[blockId];
				if (block == null)
					return false;
				block.onPlantGrow(world, x, y - 1, z, x, y, z);

				PlaidColor color = PlaidColor.getPlaidColorFromPos(x, y, z);

				for (yOffset = y - 3 + treeHeight; yOffset <= y + treeHeight; ++yOffset)
				{
					int var12 = yOffset - (y + treeHeight), center = 1 - var12 / 2;

					for (xOffset = x - center; xOffset <= x + center; ++xOffset)
					{
						int xPos = xOffset - x, t = xPos >> 31;
						xPos = xPos + t ^ t;

						for (zOffset = z - center; zOffset <= z + center; ++zOffset)
						{
							int zPos = zOffset - z;
							zPos = zPos + (t = zPos >> 31) ^ t;

							block = Block.blocksList[world.getBlockId(xOffset, yOffset, zOffset)];

							if ((xPos != center | zPos != center || rand.nextInt(2) != 0 && var12 != 0) && (block == null || block.isLeaves(world, xOffset, yOffset, zOffset) || block.isAirBlock(world, xOffset, yOffset, zOffset) || block.canBeReplacedByLeaves(world, xOffset, yOffset, zOffset)))
							{
								this.setBlockAndMetadata(world, xOffset, yOffset, zOffset, Blocks.blockPlaidLeaves.blockID, color.ordinal());
								// TODO plaid leaves here
							}
						}
					}
				}

				for (yOffset = 0; yOffset < treeHeight; ++yOffset)
				{
					blockId = world.getBlockId(x, y + yOffset, z);

					block = Block.blocksList[blockId];

					if (block == null || block.isAirBlock(world, x, y + yOffset, z) || block.isLeaves(world, x, y + yOffset, z) || block.isBlockReplaceable(world, x, y + yOffset, z)) // replace snow
					{
						this.setBlockAndMetadata(world, x, y + yOffset, z, Blocks.blockPlaidLog.blockID, color.ordinal());
					}
				}

				return true;
			}
		}
		return false;
	}

}
