package stuffstuff.proxy;

import net.minecraftforge.common.MinecraftForge;
import stuffstuff.StuffStuff;
import stuffstuff.client.sounds.SoundHandler;
import stuffstuff.handler.BonemealEventHandler;
import stuffstuff.handler.DrawBlockHighlightHandler;
import stuffstuff.handler.KeyBindingHandler;
import stuffstuff.handler.PotionEventHandler;
import stuffstuff.handler.RenderWorldLastHandler;
import stuffstuff.handler.helper.KeyBindingHelper;
import stuffstuff.render.Renderers;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initSounds()
	{
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
		System.out.println("Client sounds initialized");
	}

	@Override
	public void initRenderer()
	{
		Renderers.init();
		System.out.println("Client renderers initialized");
	}

	@Override
	public void registerHandlers()
	{
		KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler());

		MinecraftForge.EVENT_BUS.register(new DrawBlockHighlightHandler());
		MinecraftForge.EVENT_BUS.register(new RenderWorldLastHandler());
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
		MinecraftForge.EVENT_BUS.register(new BonemealEventHandler());
		MinecraftForge.EVENT_BUS.register(new PotionEventHandler());

		TickRegistry.registerTickHandler(StuffStuff.itemBlockPlacerHandler, Side.CLIENT);
		System.out.println("Client handlers registered.");
	}

	@Override
	public void setKeyBinding(String name, int value)
	{
		KeyBindingHelper.addKeyBinding(name, value);
		KeyBindingHelper.addIsRepeating(false);
	}
}
