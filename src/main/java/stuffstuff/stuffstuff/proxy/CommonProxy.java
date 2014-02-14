package stuffstuff.stuffstuff.proxy;

import net.minecraftforge.common.MinecraftForge;
import stuffstuff.stuffstuff.StuffStuff;

public class CommonProxy
{
	public void initSounds()
	{

	}

	public void initRenderer()
	{

	}

	public void registerHandlers()
	{
		// MinecraftForge.EVENT_BUS.register(new SoundHandler());
		// MinecraftForge.EVENT_BUS.register(StuffStuff.itemBlockPlacerHandler);

		// TODO does this need to be here or in client?
		MinecraftForge.EVENT_BUS.register(StuffStuff.itemBlockPlacerHandler);
	}

	public void setKeyBinding(String name, int value)
	{

	}
}
