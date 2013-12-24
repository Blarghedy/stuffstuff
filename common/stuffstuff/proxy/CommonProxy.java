package stuffstuff.proxy;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;
import stuffstuff.StuffStuff;

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
		
		System.out.println("REGISTERING TICK ON SERVER: " + StuffStuff.itemBlockPlacerHandler);
		TickRegistry.registerTickHandler(StuffStuff.itemBlockPlacerHandler, Side.SERVER);
	}
	
    public void setKeyBinding(String name, int value) 
    {
    	
    }
}
