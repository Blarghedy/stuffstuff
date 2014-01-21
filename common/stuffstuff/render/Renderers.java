package stuffstuff.render;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class Renderers
{
	public static PlaidFluidRenderer plaidFluidRender;
	public static int plaidFluidRenderID;

	public static StuffDoorTopRenderer stuffDoorTopRenderer;
	public static int stuffDoorTopRenderID;

	public static void init()
	{
		plaidFluidRenderID = RenderingRegistry.getNextAvailableRenderId();
		plaidFluidRender = new PlaidFluidRenderer();
		RenderingRegistry.registerBlockHandler(plaidFluidRenderID, plaidFluidRender);

		stuffDoorTopRenderID = RenderingRegistry.getNextAvailableRenderId();
		stuffDoorTopRenderer = new StuffDoorTopRenderer();
		RenderingRegistry.registerBlockHandler(stuffDoorTopRenderID, stuffDoorTopRenderer);
	}
}
