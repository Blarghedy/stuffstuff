package stuffstuff;

import net.minecraft.creativetab.CreativeTabs;
import stuffstuff.blocks.Blocks;
import stuffstuff.client.interfaces.GuiHandler;
import stuffstuff.config.ConfigHandler;
import stuffstuff.creative.TabStuffStuff;
import stuffstuff.fluids.Fluids;
import stuffstuff.info.ModInfo;
import stuffstuff.items.Items;
import stuffstuff.items.handler.ItemBlockPlacerHandler;
import stuffstuff.network.PacketHandler;
import stuffstuff.potions.Potions;
import stuffstuff.proxy.CommonProxy;
import stuffstuff.worldgen.Biomes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = { ModInfo.CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class StuffStuff
{
	public static CreativeTabs tabStuffStuff = new TabStuffStuff("StuffStuff");
	public static ItemBlockPlacerHandler itemBlockPlacerHandler;

	@Instance(ModInfo.ID)
	public static StuffStuff instance;

	@SidedProxy(clientSide = "stuffstuff.proxy.ClientProxy", serverSide = "stuffstuff.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		ConfigHandler.init(e.getSuggestedConfigurationFile());
		Items.init();
		Blocks.init();
		Biomes.init();
		Fluids.init();
		Potions.init();

		itemBlockPlacerHandler = new ItemBlockPlacerHandler();

		proxy.initSounds();
		proxy.initRenderer();
		proxy.registerHandlers();

		Items.addNames();
		Blocks.addNames();
		Fluids.addNames();
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		Items.registerRecipes();
		Blocks.registerTileEntities();
		new GuiHandler();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{

	}

}
