package stuffstuff.fluid;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;

public class FluidHelper
{
	public static boolean isFlowingFluid(World world, int x, int y, int z, Fluid fluid)
	{
		boolean isFluid, isFlowingFluid;
		isFluid = isFluid(world, x, y, z, fluid);
		isFlowingFluid = isFlowingFluid(world, x, y, z);
		return isFluid && isFlowingFluid;
	}
	
	public static boolean isFlowingFluid(World world, int x, int y, int z)
	{
		// TODO: figure out if this whole nonsense is even remotely necessary
		// There's got to be a better helper method that does all this for me
		int blockID = world.getBlockId(x, y, z);
		if (blockID == Block.waterMoving.blockID || blockID == Block.lavaMoving.blockID)
		{ // seriously why is this even a thing
			return true;
		}
		else if (blockID == Block.waterStill.blockID || blockID == Block.lavaStill.blockID)
		{
			return false;
		}
		Block block = Block.blocksList[blockID];
		IFluidBlock fluidblock = null;
		if (block != null && block instanceof IFluidBlock)
		{
			fluidblock = (IFluidBlock)block;
		}
		else
		{
			return false;
		}
		
		if (fluidblock.getFilledPercentage(world, x, y, z) < 1)
		{ // does this even work? I dunno!
			return true;
		}
		return false;
	}
	
	public static boolean isFluid(World world, int x, int y, int z)
	{ // TODO: Figure out if this is necessary too.  
		int id = world.getBlockId(x, y, z);
		Block block = Block.blocksList[id];
		if (block == null)
		{
			System.out.printf("null block at %d %d %d\n", x, y, z);
			return false;
		}
		else
		{
			System.out.printf("not null block at %d %d %d\n", x, y, z);
			return block instanceof IFluidBlock || 
					id == Block.waterMoving.blockID || 
					id == Block.waterStill.blockID || 
					id == Block.lavaMoving.blockID || 
					id == Block.lavaStill.blockID;
		}
	}
	
	public static boolean isFluid(World world, int x, int y, int z, Fluid fluid)
	{ // TODO: refactor this all into a helper module for easier later refactoring
		int id = world.getBlockId(x, y, z);
		if (Block.blocksList[id] == null)
		{
			return false;
		}
		else if (fluid.equals(FluidRegistry.LAVA))
		{
			System.out.println(" - lava");
			return id == Block.lavaMoving.blockID || id == Block.lavaStill.blockID;
		}
		else if (fluid.equals(FluidRegistry.WATER))
		{
			System.out.println(" - water");
			return id == Block.waterMoving.blockID || id == Block.waterStill.blockID;
		}
		else
		{
			System.out.print("ID: " + id + " ");
			System.out.println((id == fluid.getBlockID()) + " " + Block.blocksList[id].getUnlocalizedName());
			return id == fluid.getBlockID();
		}
	}
}
