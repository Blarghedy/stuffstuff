package stuffstuff.stuffstuff;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import stuffstuff.stuffstuff.achievements.Achievements;
import stuffstuff.stuffstuff.blocks.BlocksStuff;
import stuffstuff.stuffstuff.client.interfaces.GuiHandler;
import stuffstuff.stuffstuff.config.ConfigHandler;
import stuffstuff.stuffstuff.creative.TabPlaidStuff;
import stuffstuff.stuffstuff.creative.TabStuffStuff;
import stuffstuff.stuffstuff.fluid.Fluids;
import stuffstuff.stuffstuff.info.ModInfo;
import stuffstuff.stuffstuff.items.ItemsStuff;
import stuffstuff.stuffstuff.items.handler.ItemBlockPlacerHandler;
import stuffstuff.stuffstuff.network.StuffPacketHandler;
import stuffstuff.stuffstuff.potions.Potions;
import stuffstuff.stuffstuff.proxy.CommonProxy;
import stuffstuff.stuffstuff.worldgen.Biomes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class StuffStuff
{
	// TODO change core Stuff Stuff stuff to StuffStuffCore

	public static CreativeTabs tabStuffStuff = new TabStuffStuff("StuffStuff");
	public static CreativeTabs tabPlaidStuff = new TabPlaidStuff("Plaid Stuff");

	public static ItemBlockPlacerHandler itemBlockPlacerHandler;

	@Instance(ModInfo.ID)
	public static StuffStuff instance;

	@SidedProxy(clientSide = "stuffstuff.stuffstuff.proxy.ClientProxy", serverSide = "stuffstuff.stuffstuff.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static FMLEventChannel channel;
	public static String configDirectory;
	public static String treeConfigDirectory;
	public static File stuffstuffConfig;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		configDirectory = e.getModConfigurationDirectory() + "/stuffstuff/";
		stuffstuffConfig = new File(configDirectory, "stuffstuff.cfg");

		treeConfigDirectory = configDirectory + "trees/";

		ConfigHandler.init(stuffstuffConfig);
		Fluids.init();
		ItemsStuff.init();
		BlocksStuff.init();
		Biomes.init();
		Potions.init();
		Achievements.init();

		itemBlockPlacerHandler = new ItemBlockPlacerHandler();
		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(ModInfo.CHANNEL);
		channel.register(new StuffPacketHandler());

		proxy.initSounds();
		proxy.initRenderer();
		proxy.registerHandlers();

		ItemsStuff.addNames();
		BlocksStuff.addNames();
		Fluids.addNames();
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		ItemsStuff.registerRecipes();
		BlocksStuff.registerTileEntities();
		new GuiHandler();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{

	}

}
