package stuffstuff.holidaystuff;

import net.minecraft.creativetab.CreativeTabs;
import stuffstuff.holidaystuff.blocks.BlocksHolidayStuff;
import stuffstuff.holidaystuff.config.ConfigHandler;
import stuffstuff.holidaystuff.creative.TabHolidayStuff;
import stuffstuff.holidaystuff.fluids.FluidsHolidayStuff;
import stuffstuff.holidaystuff.info.ModInfo;
import stuffstuff.holidaystuff.items.ItemsHolidayStuff;
import stuffstuff.holidaystuff.proxy.CommonProxy;
import stuffstuff.holidaystuff.worldgen.Biomes;
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

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:stuffstuff")
public class HolidayStuff
{
	public static CreativeTabs tabHolidayStuff;
	private static boolean loadHolidayStuff;

	static 
	{
		loadHolidayStuff = Loader.isModLoaded("appliedenergistics2");
		if (loadHolidayStuff)
		{
			tabHolidayStuff = new TabHolidayStuff("Holiday Stuff");
		}
	}

	@Instance(ModInfo.ID)
	public static HolidayStuff instance;

	@SidedProxy(clientSide = "stuffstuff.holidaystuff.proxy.ClientProxy", serverSide = "stuffstuff.holidaystuff.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		if (loadHolidayStuff)
		{
			ConfigHandler.init(StuffStuff.stuffstuffConfig);
			FluidsHolidayStuff.init();
			ItemsHolidayStuff.init();
			BlocksHolidayStuff.init();
			Biomes.init();

			proxy.initSounds();
			proxy.initRenderer();
			proxy.registerHandlers();

			ItemsHolidayStuff.addNames();
			BlocksHolidayStuff.addNames();
			FluidsHolidayStuff.addNames();
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		if (loadHolidayStuff)
		{
			ItemsHolidayStuff.registerRecipes();
			BlocksHolidayStuff.registerTileEntities();
			new GuiHandler();
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		if (loadHolidayStuff)
		{

		}
	}

}

