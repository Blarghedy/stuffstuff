package stuffstuff.compat.minefactoryreloaded;

import stuffstuff.StuffStuff;
import stuffstuff.info.ModInfo;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "stuffstuff|CompatMineFactoryReloaded", name = "stuffstuff compat: MFR", version = ModInfo.VERSION, dependencies = "after:stuffstuff;after:MineFactoryReloaded")
@NetworkMod(clientSideRequired = false, serverSideRequired = false)
public class MinefactoryReloaded
{
	@EventHandler
	public static void load(FMLInitializationEvent e)
	{
		if(!Loader.isModLoaded("MinefactoryReloaded"))
		{
			FMLLog.warning("MineFactoryReloaded missing - stuffstuff MFR compat not loading");
			return;
		}
		System.out.println("MFR Compat loaded");
		
	}
}

