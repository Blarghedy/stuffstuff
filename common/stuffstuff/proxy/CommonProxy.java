package stuffstuff.proxy;

import stuffstuff.StuffStuff;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

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
//				MinecraftForge.EVENT_BUS.register(new SoundHandler());
//		MinecraftForge.EVENT_BUS.register(StuffStuff.itemBlockPlacerHandler);
		
		// TODO does this need to be here or in client?
		TickRegistry.registerTickHandler(StuffStuff.itemBlockPlacerHandler, Side.SERVER);
	}
	
    public void setKeyBinding(String name, int value) 
    {
    	
    }
}
