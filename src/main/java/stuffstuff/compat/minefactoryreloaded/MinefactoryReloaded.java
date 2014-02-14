package stuffstuff.compat.minefactoryreloaded;

import stuffstuff.stuffstuff.info.ModInfo;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = "stuffstuff|CompatMineFactoryReloaded", name = "stuffstuff compat: MFR", version = ModInfo.VERSION, dependencies = "after:stuffstuff;after:MineFactoryReloaded")
//@NetworkMod(clientSideRequired = false, serverSideRequired = false)
public class MinefactoryReloaded
{
	@EventHandler
	public static void load(FMLInitializationEvent e)
	{
		if (!Loader.isModLoaded("MinefactoryReloaded"))
		{
			FMLLog.warning("MineFactoryReloaded missing - stuffstuff MFR compat not loading");
			return;
		}
		System.out.println("MFR Compat loaded");

	}
}
