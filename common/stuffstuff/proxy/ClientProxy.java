package stuffstuff.proxy;

import net.minecraftforge.common.MinecraftForge;
import stuffstuff.handler.DrawBlockHighlightHandler;
import stuffstuff.handler.KeyBindingHandler;
import stuffstuff.handler.KeyBindingHelper;
import stuffstuff.handler.RenderWorldLastHandler;
import stuffstuff.sounds.SoundHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;

public class ClientProxy extends CommonProxy
{
	public void initSounds()
	{
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
		System.out.println("Client sounds initialized");
	}
	
	public void initRenderer()
	{
		System.out.println("Client renderers initialized");
	}
	
	public void registerHandlers()
	{
		super.registerHandlers();
		MinecraftForge.EVENT_BUS.register(new DrawBlockHighlightHandler());
		MinecraftForge.EVENT_BUS.register(new RenderWorldLastHandler());
		KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler());
        MinecraftForge.EVENT_BUS.register(new SoundHandler());
		System.out.println("Client handlers registered.");
	}
	
    public void setKeyBinding(String name, int value) 
    {
    	KeyBindingHelper.addKeyBinding(name, value);
        KeyBindingHelper.addIsRepeating(false);
    }
}
