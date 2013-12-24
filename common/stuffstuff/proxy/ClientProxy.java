package stuffstuff.proxy;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.BiomeDictionary.Type;
import stuffstuff.StuffStuff;
import stuffstuff.client.sounds.SoundHandler;
import stuffstuff.handler.BonemealEventHandler;
import stuffstuff.handler.DrawBlockHighlightHandler;
import stuffstuff.handler.KeyBindingHandler;
import stuffstuff.handler.RenderWorldLastHandler;
import stuffstuff.handler.helper.KeyBindingHelper;
import stuffstuff.worldgen.Biomes;
import stuffstuff.worldgen.biome.BiomeGenPlaidPlain;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

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
		KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler());
		
		MinecraftForge.EVENT_BUS.register(new DrawBlockHighlightHandler());
		MinecraftForge.EVENT_BUS.register(new RenderWorldLastHandler());
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
		MinecraftForge.EVENT_BUS.register(new BonemealEventHandler());
        
		TickRegistry.registerTickHandler(StuffStuff.itemBlockPlacerHandler, Side.CLIENT);
		System.out.println("Client handlers registered.");
	}
	
    public void setKeyBinding(String name, int value) 
    {
    	KeyBindingHelper.addKeyBinding(name, value);
        KeyBindingHelper.addIsRepeating(false);
    }
}
