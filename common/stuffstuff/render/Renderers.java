package stuffstuff.render;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class Renderers
{
	public static PlaidFluidRenderer plaidFluidRender;
	public static int plaidFluidRenderID;

	public static StuffDoorRenderer stuffDoorRenderer;
	public static int stuffDoorRenderID;

	public static void init()
	{
		plaidFluidRenderID = RenderingRegistry.getNextAvailableRenderId();
		plaidFluidRender = new PlaidFluidRenderer();
		RenderingRegistry.registerBlockHandler(plaidFluidRenderID, plaidFluidRender);

		stuffDoorRenderID = RenderingRegistry.getNextAvailableRenderId();
		stuffDoorRenderer = new StuffDoorRenderer();
		RenderingRegistry.registerBlockHandler(stuffDoorRenderID, stuffDoorRenderer);
	}
}
