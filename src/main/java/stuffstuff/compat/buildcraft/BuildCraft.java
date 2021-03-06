package stuffstuff.compat.buildcraft;

import net.minecraftforge.fluids.FluidRegistry;
import stuffstuff.stuffstuff.info.ModInfo;
import stuffstuff.stuffstuff.items.ItemsStuff;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = "stuffstuff|CompatBuildCraft", name = "stuffstuff compat: BC", version = ModInfo.VERSION, dependencies = "after:stuffstuff;after:BuildCraft|Core")
//@NetworkMod(clientSideRequired = false, serverSideRequired = false)
public class BuildCraft
{
	//
	@EventHandler
	public static void load(FMLInitializationEvent e)
	{
		if (!Loader.isModLoaded("BuildCraft|Core"))
		{
			FMLLog.warning("BuildCraft|Core missing - stuffstuff BC compat not loading");
			return;
		}
		FMLLog.info("BC Compat loaded", null);

		ItemsStuff.itemFluidCleaner.addFluid(FluidRegistry.getFluid("oil"));
	}
}
