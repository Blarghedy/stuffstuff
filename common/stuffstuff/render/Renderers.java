package stuffstuff.render;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.RenderBlocks;

public class Renderers
{
	public static PlaidFluidRenderer plaidFluidRender;
	public static int plaidFluidRenderID;
	
	public static void init()
	{
		plaidFluidRenderID = RenderingRegistry.getNextAvailableRenderId();
		plaidFluidRender = new PlaidFluidRenderer();
		RenderingRegistry.registerBlockHandler(plaidFluidRenderID, plaidFluidRender);
	}
}