package stuffstuff.client.render;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class Renderers
{
	public static PlaidFluidRenderer plaidFluidRender;
	public static int plaidFluidRenderID;

	public static BlockStuffDoorRenderer stuffDoorRenderer;
	public static int stuffDoorRenderID;

	public static void init()
	{
		plaidFluidRenderID = RenderingRegistry.getNextAvailableRenderId();
		plaidFluidRender = new PlaidFluidRenderer();
		RenderingRegistry.registerBlockHandler(plaidFluidRenderID, plaidFluidRender);

		stuffDoorRenderID = RenderingRegistry.getNextAvailableRenderId();
		stuffDoorRenderer = new BlockStuffDoorRenderer();
		RenderingRegistry.registerBlockHandler(stuffDoorRenderID, stuffDoorRenderer);
	}
}
