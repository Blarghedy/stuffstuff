package stuffstuff.fluid;

import net.minecraftforge.fluids.Fluid;
import stuffstuff.info.FluidInfo;

public class FluidPlaidWater extends Fluid
{

	public FluidPlaidWater(String fluidName)
	{
		super(fluidName);
		setUnlocalizedName(FluidInfo.PLAID_WATER_UNLOCALIZED_NAME);
		setBlockID(FluidInfo.PLAID_WATER_ID);
	}
}
