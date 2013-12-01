package stuffstuff;

import net.minecraft.creativetab.CreativeTabs;
import stuffstuff.blocks.Blocks;
import stuffstuff.config.ConfigHandler;
import stuffstuff.creative.TabStuffStuff;
import stuffstuff.info.ModInfo;
import stuffstuff.items.Items;
import stuffstuff.network.PacketHandler;
import stuffstuff.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = {ModInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class StuffStuff
{
	public static CreativeTabs tabStuffStuff = new TabStuffStuff("StuffStuff");
	
	@Instance(ModInfo.ID)
	public StuffStuff instance;

	@SidedProxy(clientSide = "stuffstuff.proxy.ClientProxy", serverSide = "stuffstuff.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		ConfigHandler.init(e.getSuggestedConfigurationFile());
		Items.init();
		Blocks.init();
		
		proxy.initSounds();
		proxy.initRenderer();
		proxy.registerHandlers();
	}
	
	@EventHandler 
	public void init(FMLInitializationEvent e)
	{
		Items.addNames();
		Items.registerRecipes();
		Blocks.addNames();
		Blocks.registerTileEntities();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}
	
}
