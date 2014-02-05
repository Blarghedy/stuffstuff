package stuffstuff.stuffstuff.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import stuffstuff.stuffstuff.info.FluidInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Fluids
{
	public static BlockFluidPlaidWater blockFluidPlaidWater;
	public static Fluid fluidPlaidWater;

	public static void init()
	{
		fluidPlaidWater = new FluidPlaidWater(FluidInfo.PLAID_WATER_NAME);
		FluidRegistry.registerFluid(fluidPlaidWater);
		blockFluidPlaidWater = new BlockFluidPlaidWater(FluidInfo.PLAID_WATER_ID);

		GameRegistry.registerBlock(blockFluidPlaidWater, FluidInfo.PLAID_WATER_NAME);
	}

	public static void addNames()
	{
		LanguageRegistry.addName(blockFluidPlaidWater, FluidInfo.PLAID_WATER_NAME);
	}
}
