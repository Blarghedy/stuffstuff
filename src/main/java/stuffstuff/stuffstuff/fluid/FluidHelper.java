package stuffstuff.stuffstuff.fluid;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
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
		Block block = world.getBlock(x, y, z);
		if (block == Blocks.flowing_water || block == Blocks.flowing_lava)
			return true;
		else if (block == Blocks.water || block == Blocks.lava)
			return false;

		IFluidBlock fluidblock = null;
		if (block != null && block instanceof IFluidBlock)
		{
			fluidblock = (IFluidBlock)block;
		}
		else
			return false;

		if (fluidblock.getFilledPercentage(world, x, y, z) < 1)
			return true;
		return false;
	}

	public static boolean isFluid(World world, int x, int y, int z)
	{ // TODO: Figure out if this is necessary too.
		Block block = world.getBlock(x, y, z);

		if (block == null)
			return false;
		else
			return block instanceof IFluidBlock || block == Blocks.flowing_water || block == Blocks.water || block == Blocks.flowing_lava || block == Blocks.lava;
	}

	public static boolean isFluid(World world, int x, int y, int z, Fluid fluid)
	{ // TODO: refactor this all into a helper module for easier later refactoring
		Block block = world.getBlock(x, y, z);
		if (block == null)
			return false;
		else if (fluid.equals(FluidRegistry.LAVA))
			return block == Blocks.lava || block == Blocks.flowing_lava;
		else if (fluid.equals(FluidRegistry.WATER))
			return block == Blocks.water || block == Blocks.flowing_water;
		else
			return block == fluid.getBlock();
	}
}
