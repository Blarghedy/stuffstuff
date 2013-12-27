package stuffstuff.fluids;

import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import stuffstuff.fluid.BlockFluidPlaidWater;
import stuffstuff.fluid.FluidPlaidWater;
import stuffstuff.info.FluidInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Fluids
{
	public static BlockFluidBase blockFluidPlaidWater;
	public static Fluid fluidPlaidWater;

	public static void init()
	{
		fluidPlaidWater = new FluidPlaidWater(FluidInfo.PLAID_WATER_NAME);
		FluidRegistry.registerFluid(fluidPlaidWater);
		int tmp = FluidInfo.PLAID_WATER_ID;
		blockFluidPlaidWater = new BlockFluidPlaidWater(tmp);// FluidInfo.PLAID_WATER_ID);

		GameRegistry.registerBlock(blockFluidPlaidWater, FluidInfo.PLAID_WATER_NAME);
	}

	public static void addNames()
	{
		LanguageRegistry.addName(blockFluidPlaidWater, FluidInfo.PLAID_WATER_NAME);
	}
}
