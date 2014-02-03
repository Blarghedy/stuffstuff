package stuffstuff.aestuff;

import net.minecraft.creativetab.CreativeTabs;
import stuffstuff.aestuff.blocks.BlocksAEStuff;
import stuffstuff.aestuff.config.ConfigHandler;
import stuffstuff.aestuff.creative.TabAEStuff;
import stuffstuff.aestuff.fluids.FluidsAEStuff;
import stuffstuff.aestuff.info.ModInfo;
import stuffstuff.aestuff.items.ItemsAEStuff;
import stuffstuff.aestuff.proxy.CommonProxy;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.blocks.Blocks;
import stuffstuff.stuffstuff.client.interfaces.GuiHandler;
import stuffstuff.stuffstuff.items.Items;
import stuffstuff.stuffstuff.network.PacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "after:stuffstuff;after:appeng")
@NetworkMod(channels = { ModInfo.CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class AEStuff
{
	public static CreativeTabs tabAEStuff = new TabAEStuff("AE Stuff");

	@Instance(ModInfo.ID)
	public static AEStuff instance;

	@SidedProxy(clientSide = "stuffstuff.aestuff.proxy.ClientProxy", serverSide = "stuffstuff.aestuff.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		ConfigHandler.init(StuffStuff.stuffstuffConfig);
		FluidsAEStuff.init();
		ItemsAEStuff.init();
		BlocksAEStuff.init();

		proxy.initSounds();
		proxy.initRenderer();
		proxy.registerHandlers();

		ItemsAEStuff.addNames();
		BlocksAEStuff.addNames();
		FluidsAEStuff.addNames();
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		ItemsAEStuff.registerRecipes();
		BlocksAEStuff.registerTileEntities();
		new GuiHandler();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{

	}

}
