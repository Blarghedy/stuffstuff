package stuffstuff.stuffstuff.handler;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.ForgeSubscribe;
import stuffstuff.stuffstuff.fluid.Fluids;

public class TextureStitchEventHandler
{
	@ForgeSubscribe
	public void postStitch(TextureStitchEvent.Post event) 
	{
		Fluids.fluidPlaidWater.setIcons(Fluids.blockFluidPlaidWater.getStillIcon(), Fluids.blockFluidPlaidWater.getFlowingIcon());
	}
}
