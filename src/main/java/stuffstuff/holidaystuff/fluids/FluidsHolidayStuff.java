package stuffstuff.holidaystuff.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import stuffstuff.holidaystuff.info.FluidInfo;
import stuffstuff.stuffstuff.fluid.BlockStuffFluid;
import cpw.mods.fml.common.registry.GameRegistry;

public class FluidsHolidayStuff
{
	public static BlockStuffFluid blockFluidChocolate;
	public static Fluid fluidChocolate;

	public static BlockStuffFluid blockFluidCandyCane;
	public static Fluid fluidCandyCane;

	public static BlockStuffFluid blockFluidEggNog;
	public static Fluid fluidEggNog;

	public static BlockStuffFluid blockFluidLicorice;
	public static Fluid fluidLicorice;

	public static BlockStuffFluid blockFluidMashedPotatoes;
	public static Fluid fluidMashedPotatoes;

	public static BlockStuffFluid blockFluidGravy;
	public static Fluid fluidGravy;

	public static void init()
	{
		fluidChocolate = new FluidChocolate(FluidInfo.CHOCOLATE_NAME);
		FluidRegistry.registerFluid(fluidChocolate);
		blockFluidChocolate = new BlockFluidChocolate(fluidChocolate);

		fluidCandyCane = new FluidCandyCane(FluidInfo.CANDY_CANE_NAME);
		FluidRegistry.registerFluid(fluidCandyCane);
		blockFluidCandyCane = new BlockFluidCandyCane(fluidCandyCane);

		fluidEggNog = new FluidEggNog(FluidInfo.EGG_NOG_NAME);
		FluidRegistry.registerFluid(fluidEggNog);
		blockFluidEggNog = new BlockFluidEggNog(fluidEggNog);

		fluidLicorice = new FluidLicorice(FluidInfo.LICORICE_NAME);
		FluidRegistry.registerFluid(fluidLicorice);
		blockFluidLicorice = new BlockFluidLicorice(fluidLicorice);

		fluidMashedPotatoes = new FluidMashedPotatoes(FluidInfo.MASHED_POTATOES_NAME);
		FluidRegistry.registerFluid(fluidMashedPotatoes);
		blockFluidMashedPotatoes = new BlockFluidMashedPotatoes(fluidMashedPotatoes);

		fluidGravy = new FluidGravy(FluidInfo.GRAVY_NAME);
		FluidRegistry.registerFluid(fluidGravy);
		blockFluidGravy = new BlockFluidGravy(fluidGravy);

		GameRegistry.registerBlock(blockFluidChocolate, FluidInfo.CHOCOLATE_NAME);
		GameRegistry.registerBlock(blockFluidCandyCane, FluidInfo.CANDY_CANE_NAME);
		GameRegistry.registerBlock(blockFluidEggNog, FluidInfo.EGG_NOG_NAME);
		GameRegistry.registerBlock(blockFluidLicorice, FluidInfo.LICORICE_NAME);
		GameRegistry.registerBlock(blockFluidMashedPotatoes, FluidInfo.MASHED_POTATOES_NAME);
		GameRegistry.registerBlock(blockFluidGravy, FluidInfo.GRAVY_NAME);
	}

	public static void addNames()
	{

	}

}
