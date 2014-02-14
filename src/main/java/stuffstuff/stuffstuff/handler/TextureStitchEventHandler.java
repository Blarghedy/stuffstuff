package stuffstuff.stuffstuff.handler;

import net.minecraftforge.client.event.TextureStitchEvent;
import stuffstuff.stuffstuff.fluid.Fluids;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TextureStitchEventHandler
{
	@SubscribeEvent
	public void postStitch(TextureStitchEvent.Post event) 
	{
		Fluids.fluidPlaidWater.setIcons(Fluids.blockFluidPlaidWater.getStillIcon(), Fluids.blockFluidPlaidWater.getFlowingIcon());
	}
}
