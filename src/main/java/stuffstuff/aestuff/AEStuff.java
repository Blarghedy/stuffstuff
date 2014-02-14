package stuffstuff.aestuff;

import net.minecraft.creativetab.CreativeTabs;
import stuffstuff.aestuff.blocks.BlocksAEStuff;
import stuffstuff.aestuff.config.ConfigHandler;
import stuffstuff.aestuff.creative.TabAEStuff;
import stuffstuff.aestuff.fluids.FluidsAEStuff;
import stuffstuff.aestuff.info.ModInfo;
import stuffstuff.aestuff.items.ItemsAEStuff;
import stuffstuff.aestuff.parts.Parts;
import stuffstuff.aestuff.proxy.CommonProxy;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.client.interfaces.GuiHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:stuffstuff;after:appliedenergistics2")
//@NetworkMod(channels = { ModInfo.CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class AEStuff
{
	public static CreativeTabs tabAEStuff;
	private static boolean isAELoaded;

	static 
	{
		isAELoaded = Loader.isModLoaded("appliedenergistics2");
		if (isAELoaded)
		{
			tabAEStuff = new TabAEStuff("AE Stuff");
		}
	}

	@Instance(ModInfo.ID)
	public static AEStuff instance;

	@SidedProxy(clientSide = "stuffstuff.aestuff.proxy.ClientProxy", serverSide = "stuffstuff.aestuff.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		if (isAELoaded)
		{
			ConfigHandler.init(StuffStuff.stuffstuffConfig);
			FluidsAEStuff.init();
			ItemsAEStuff.init();
			BlocksAEStuff.init();
			Parts.init();

			proxy.initSounds();
			proxy.initRenderer();
			proxy.registerHandlers();

			ItemsAEStuff.addNames();
			BlocksAEStuff.addNames();
			FluidsAEStuff.addNames();
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		if (isAELoaded)
		{
			ItemsAEStuff.registerRecipes();
			BlocksAEStuff.registerTileEntities();
			new GuiHandler();
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		if (isAELoaded)
		{

		}
	}

}
