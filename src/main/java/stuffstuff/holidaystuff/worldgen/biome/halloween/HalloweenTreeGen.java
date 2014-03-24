package stuffstuff.holidaystuff.worldgen.biome.halloween;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.holidaystuff.blocks.BlocksHolidayStuff;
import stuffstuff.holidaystuff.blocks.halloween.BlockHalloweenLog;
import stuffstuff.stuffstuff.worldgen.StuffTreeGenBase;

public class HalloweenTreeGen extends StuffTreeGenBase
{
	private int currentWidth;
	private ForgeDirection primaryOrientation;
	
	public HalloweenTreeGen(World world, int x, int y, int z, int maxDepth)
	{
		super(world, x, y, z, maxDepth);
		currentWidth = 4;
		primaryOrientation = ForgeDirection.NORTH;
	}

	@Override
	public void genTree()
	{
		BlockHalloweenLog log = (BlockHalloweenLog)BlocksHolidayStuff.blockHalloweenLog;
		float branchRatio = .3f;
		int height = maxDepth / 3;
		float logSpawnChance;
		ForgeDirection leanDirection = ForgeDirection.EAST;
		float leanWeight = .5f;
		int currentLean = 0;
		float leanChance;

		// fill in the trunk, dealing with lean, and push some branch locations to the stack
		for (int i = 0; i < height; i++)
		{
			leanChance = world.rand.nextFloat();
			if (leanChance > leanWeight / height && false)
			{
				currentLean++;
			}

			System.out.println("Setting block at " + x + " " + y + " " + z);
			world.setBlock(startx + currentLean * leanDirection.offsetX + orientation.offsetX, 
					starty + i, 
					startz + currentLean * leanDirection.offsetZ + orientation.offsetZ, 
					log);
			log.setOrientation(world, x, y, z, ForgeDirection.UP);
			logSpawnChance = world.rand.nextFloat();

			if (logSpawnChance > i * 2.0f / height)
			{
				orientation = ForgeDirection.getOrientation(4 * world.rand.nextInt() + 2);
				primaryOrientation = orientation;
				x = startx + currentLean * leanDirection.offsetX + orientation.offsetX;
				y = starty + i;
				z = startz + currentLean * leanDirection.offsetZ + orientation.offsetZ;
				pushToStack();
			}
		}

		if (true) return;
		while (!stackIsEmpty())
		{
			popFromStack(); // overwrite current x, y, z, orientation, currentWidth
			depth++;
			int logx = x;
			int logy = y;
			int logz = z;
			ForgeDirection oldOrientation = orientation;
			int oldWidth = currentWidth;
			Block blockAtLocation = world.getBlock(x, y, z);

			if (blockAtLocation.canBeReplacedByLeaves(world, logx, logy, logz))
			{
				world.setBlock(x, y, z, log);
			}
			else if (blockAtLocation == log)
			{
				int metaAtLocation = world.getBlockMetadata(logx, logy, logz);
				if (log.getWidth(metaAtLocation) / 4 <= currentWidth)
				{
					// At this point we're apparently trying to grow a small branch  
					// through a big branch and we want to avoid that, so continue
					continue; 
				}
			}

			// At this point, we're either overriding a smaller branch or filling in 
			// something that can be replaced by a log, so set the orientation
			// and width.
			log.setOrientationAndMeta(world, x, y, z, orientation, 4 - currentWidth);

			for (ForgeDirection targetDirection : ForgeDirection.VALID_DIRECTIONS)
			{
				// We don't want to branch back to where we came from
				if (targetDirection == oldOrientation.getOpposite())
				{
					continue;
				}
				else if (targetDirection == primaryOrientation.getOpposite())
				{
					// we want to mostly avoid going backward or the tree ends up becoming a bush
					if (world.rand.nextFloat() < .8) 
						continue; 
				}
				else if (targetDirection == ForgeDirection.DOWN)
				{
					// likewise, we want to avoid going down most of the time
					if (world.rand.nextFloat() < .5)
						continue;
				}

				currentWidth = oldWidth;
				if (world.rand.nextFloat() < getDepth() * 1.0 / getMaxDepth())
				{
					// if currentWidth is 4, set it to 2; otherwise, subtract 1.
					switch (currentWidth)
					{
						case 4:
							currentWidth = 2;
							break;
						case 2:
							currentWidth = 1;
							break;
						case 1:
						case 0:
						default:
							continue;
					}
				}

				if (currentWidth == 0)
				{
					continue;
				}

				if (world.rand.nextFloat() < branchRatio)
				{
					x = logx + targetDirection.offsetX;
					y = logy + targetDirection.offsetY;
					z = logz + targetDirection.offsetZ;
					orientation = targetDirection;
					pushToStack();
				}
			}
		}
	}

	@Override
	protected void pushToStack()
	{
		super.pushToStack();
		push(currentWidth);
		push(primaryOrientation.ordinal());
	}

	@Override
	protected void popFromStack()
	{
		primaryOrientation = ForgeDirection.getOrientation(pop());
		currentWidth = pop();
		super.popFromStack();
	}

}
