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
	private int maxLength;
	private ForgeDirection primaryOrientation;

	public HalloweenTreeGen(World world, int x, int y, int z, int maxDepth, int maxLength)
	{
		super(world, x, y, z, maxDepth);
		this.maxLength = maxLength;
		currentWidth = 8;
		primaryOrientation = ForgeDirection.NORTH;
	}

	@Override
	public void genTree()
	{
		BlockHalloweenLog log = (BlockHalloweenLog)BlocksHolidayStuff.blockHalloweenLog;
		float branchRatio = .3f;
		int height = maxDepth / 3;
		float logSpawnWeight = .5f;
		float chanceToGoBackward = .2f;
		float chanceToGoDown = .2f;
		ForgeDirection leanDirection = ForgeDirection.EAST;
		//		float leanWeight = .5f;
		int currentLean = 0;
		boolean hasLog = false;

		// fill in the trunk, dealing with lean, and push some branch locations to the stack
		for (int i = 0; i < height; i++)
		{
			// TODO fix lean
			//	if (world.rand.nextFloat() / 2 > (i + 1) * leanWeight / height)
			//	{
			//		currentLean++;
			//	}

			world.setBlock(startx + currentLean * leanDirection.offsetX, 
					starty + i, 
					startz + currentLean * leanDirection.offsetZ, 
					log);
			log.setOrientation(world, x, y, z, ForgeDirection.UP);

			if (i > height / 3 && world.rand.nextFloat() < i * 2.0f / height && world.rand.nextFloat() > logSpawnWeight)
			{
				hasLog = true;

				int next = world.rand.nextInt() + 2;
				next = world.rand.nextInt(4) + 2;
				orientation = ForgeDirection.getOrientation(next);

				primaryOrientation = orientation;
				x = startx + currentLean * leanDirection.offsetX + orientation.offsetX;
				y = starty + i;
				z = startz + currentLean * leanDirection.offsetZ + orientation.offsetZ;
				pushToStack();
			}
		}

		if (!hasLog)
		{
			int next;
			next = world.rand.nextInt(4) + 2;
			orientation = ForgeDirection.getOrientation(next);

			primaryOrientation = orientation;
			x = startx + currentLean * leanDirection.offsetX + orientation.offsetX;
			y = starty + height;
			z = startz + currentLean * leanDirection.offsetZ + orientation.offsetZ;
			pushToStack();
		}

		while (!stackIsEmpty())
		{
			popFromStack(); // overwrite current x, y, z, orientation, currentWidth
			depth++;

			int logx = x;
			int logy = y;
			int logz = z;
			ForgeDirection oldOrientation = orientation;
			int oldWidth = currentWidth;
			boolean keepGoingIGuess = true;

			for (int i = 0; i < maxLength; i++)
			{
				Block blockAtLocation = world.getBlock(x, y, z);
				log.setOrientationAndMeta(world, x, y, z, orientation, currentWidth);

				if (blockAtLocation.canBeReplacedByLeaves(world, logx, logy, logz))
				{
					world.setBlock(x, y, z, log);
				}
				else if (blockAtLocation == log)
				{
					int metaAtLocation = world.getBlockMetadata(logx, logy, logz);
					// log.getWidth(0) / 4 -> 4
					if (log.getWidth(metaAtLocation) <= currentWidth)
					{
						// At this point we're apparently trying to grow a small branch  
						// through a big branch and we want to avoid that, so continue
						keepGoingIGuess = false; // good programming practice. I promise.
						continue; 
					}
				}

				// At this point, we're either overriding a smaller branch or filling in 
				// something that can be replaced by a log, so set the orientation
				// and width.
				log.setOrientation(world, x, y, z, orientation);
				log.setWidth(world, logx, logy, logz, currentWidth);
			}

			if (!keepGoingIGuess) continue;

			for (ForgeDirection targetDirection : ForgeDirection.VALID_DIRECTIONS)
			{
				// Determine whether or not to even branch this way

				// We don't want to branch back to where we came from
				if (targetDirection == oldOrientation.getOpposite())
				{
					continue;
				}
				else if (targetDirection == ForgeDirection.DOWN)
				{
					// likewise, we want to avoid going down most of the time
					if (world.rand.nextFloat() < chanceToGoDown)
						continue;
				}
				else if (targetDirection == primaryOrientation.getOpposite())
				{
					// we want to mostly avoid going backward or the tree ends up becoming a bush
					if (world.rand.nextFloat() < chanceToGoBackward) 
						continue; 
				}

				// Now we're branching in the direction of targetDirection

				// Set the width and decrease it if necessary
				currentWidth = oldWidth;
				if (world.rand.nextFloat() < getDepth() * 1.0 / getMaxDepth())
				{
					// Decrement currentWidth.  Valid values are 16, 8, and 4.
					currentWidth = currentWidth / 2;
				}

				// If currentWidth is too low, don't do anything here.
				if (currentWidth < 4)
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
