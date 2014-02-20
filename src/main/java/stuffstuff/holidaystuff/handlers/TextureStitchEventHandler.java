package stuffstuff.holidaystuff.handlers;

import net.minecraftforge.client.event.TextureStitchEvent;
import stuffstuff.holidaystuff.fluids.FluidsHolidayStuff;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TextureStitchEventHandler
{
	@SubscribeEvent
	public void postStitch(TextureStitchEvent.Post event) 
	{
		FluidsHolidayStuff.fluidChocolate.setIcons(FluidsHolidayStuff.blockFluidChocolate.getStillIcon());
	}
}
