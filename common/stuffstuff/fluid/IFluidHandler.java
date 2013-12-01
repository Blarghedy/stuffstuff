package stuffstuff.fluid;

import net.minecraftforge.fluids.Fluid;

/**
 * Classes that use this interface should be able to accept fluids
 * @author Blarghedy
 *
 */
public interface IFluidHandler
{
	/**
	 * 
	 * @param f Fluid to add to this IFluidHandler
	 * @return
	 */
	public boolean addFluid(Fluid f);
}
