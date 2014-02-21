package stuffstuff.holidaystuff.fluids;

import net.minecraftforge.fluids.Fluid;
import stuffstuff.holidaystuff.info.FluidInfo;

public class FluidChocolate extends Fluid
{

	public FluidChocolate(String fluidName)
	{
		super(fluidName);
		setUnlocalizedName(FluidInfo.CHOCOLATE_UNLOCALIZED_NAME);
		setTemperature(305);
		setDensity(641);
		setViscosity(40000);
	}

}
