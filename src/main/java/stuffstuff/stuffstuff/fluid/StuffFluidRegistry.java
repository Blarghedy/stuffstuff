package stuffstuff.stuffstuff.fluid;

import java.util.ArrayList;

import net.minecraftforge.fluids.Fluid;

public class StuffFluidRegistry
{
	public static ArrayList<IFluidHandler> fluidHandlers = new ArrayList<IFluidHandler>();
	public static ArrayList<Fluid> registeredFluids = new ArrayList<Fluid>();

	/**
	 * Registers Fluid f with all registered handlers and adds f to the list of registered Fluids.
	 * 
	 * @param f
	 *            Fluid to be registered
	 */
	public static void registerFluid(Fluid f)
	{
		for (IFluidHandler handler : fluidHandlers)
		{
			handler.addFluid(f);
		}

		registeredFluids.add(f);
	}

	/**
	 * Registers all registered Fluids with IFluidHandler handler and adds
	 * handler to the list of registered IFluidHandlers.
	 * 
	 * @param handler
	 *            IFluidHandler to be registered
	 */
	public static void registerHandler(IFluidHandler handler)
	{
		for (Fluid f : registeredFluids)
		{
			handler.addFluid(f);
		}

		fluidHandlers.add(handler);
	}
}
