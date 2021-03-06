package stuffstuff.stuffstuff.proxy;

import net.minecraftforge.common.MinecraftForge;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.achievements.Achievements;
import stuffstuff.stuffstuff.client.render.Renderers;
import stuffstuff.stuffstuff.client.sounds.SoundHandler;
import stuffstuff.stuffstuff.handler.BonemealEventHandler;
import stuffstuff.stuffstuff.handler.BucketEventHandler;
import stuffstuff.stuffstuff.handler.DrawBlockHighlightHandler;
import stuffstuff.stuffstuff.handler.KeyBindingHandler;
import stuffstuff.stuffstuff.handler.PotionEventHandler;
import stuffstuff.stuffstuff.handler.RenderWorldLastHandler;
import stuffstuff.stuffstuff.handler.TextureStitchEventHandler;
import stuffstuff.stuffstuff.handler.helper.KeyBindingHelper;
import stuffstuff.stuffstuff.worldgen.BiomeEventHandler;

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
		MinecraftForge.EVENT_BUS.register(new KeyBindingHandler());
		MinecraftForge.EVENT_BUS.register(new DrawBlockHighlightHandler());
		MinecraftForge.EVENT_BUS.register(new RenderWorldLastHandler());
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
		MinecraftForge.EVENT_BUS.register(new BonemealEventHandler());
		MinecraftForge.EVENT_BUS.register(new PotionEventHandler());
		MinecraftForge.EVENT_BUS.register(new BucketEventHandler());
		MinecraftForge.EVENT_BUS.register(new TextureStitchEventHandler());
		MinecraftForge.EVENT_BUS.register(new Achievements());
		MinecraftForge.EVENT_BUS.register(StuffStuff.itemBlockPlacerHandler);
		MinecraftForge.TERRAIN_GEN_BUS.register(new BiomeEventHandler());

		System.out.println("Client handlers registered.");
	}

	@Override
	public void setKeyBinding(String name, int value)
	{
		KeyBindingHelper.addKeyBinding(name, value, "Stuff Stuff Keys");
		KeyBindingHelper.addIsRepeating(false);
	}
}
