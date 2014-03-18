package stuffstuff.holidaystuff.worldgen.biome.halloween;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.holidaystuff.blocks.BlocksHolidayStuff;
import stuffstuff.holidaystuff.blocks.halloween.BlockHalloweenLog;
import stuffstuff.stuffstuff.worldgen.StuffTreeGenBase;

public class HalloweenTreeGen extends StuffTreeGenBase
{
	private int currentWidth;

	public HalloweenTreeGen(World world, int x, int y, int z, int maxDepth)
	{
		super(world, x, y, z, maxDepth);
		currentWidth = 4;
	}

	@Override
	public void genTree()
	{
		BlockHalloweenLog log = (BlockHalloweenLog)BlocksHolidayStuff.blockHalloweenLog;
		int branchRatio = 2;
		int height = maxDepth / 3;
		float logSpawnChance;
		ForgeDirection leanDirection = ForgeDirection.EAST;
		float leanWeight = 2;
		int currentLean = 0;
		float leanChance;
		
		// fill in the trunk, dealing with lean, and push some branch locations to the stack
		for (int i = 0; i < height; i++)
		{
			leanChance = world.rand.nextFloat();
			if (leanChance > leanWeight / height)
			{
				currentLean++;
			}
			
			world.setBlock(x, y, z, log);
			log.setOrientation(world, x, y, z, ForgeDirection.UP);
			logSpawnChance = world.rand.nextFloat();
			
			if (logSpawnChance > i * 1.0f / height)
			{
				orientation = ForgeDirection.getOrientation(4 * world.rand.nextInt() + 2);
				x = startx + currentLean * leanDirection.offsetX + orientation.offsetX;
				y = starty + i;
				z = startz + currentLean * leanDirection.offsetZ + orientation.offsetZ;
				pushToStack();
			}
		}
		
		while (!stackIsEmpty())
		{
			popFromStack();
			log.setOrientationAndMeta(world, x, y, z, orientation, 4 - currentWidth);
			
		}
	}
	
	@Override
	protected void pushToStack()
	{
	    super.pushToStack();
	    push(currentWidth);
	}
	
	@Override
	protected void popFromStack()
	{
		currentWidth = pop();
	    super.popFromStack();
	}

}
