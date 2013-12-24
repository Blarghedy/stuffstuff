package stuffstuff.fluid;

import stuffstuff.info.FluidInfo;
import net.minecraftforge.fluids.Fluid;

public class FluidPlaidWater extends Fluid
{

	public FluidPlaidWater(String fluidName)
    {
	    super(fluidName);
	    setUnlocalizedName(FluidInfo.PLAID_WATER_UNLOCALIZED_NAME);
	    setBlockID(FluidInfo.PLAID_WATER_ID);
    }
	
}
