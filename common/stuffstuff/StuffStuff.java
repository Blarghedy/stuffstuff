package stuffstuff;

import net.minecraft.creativetab.CreativeTabs;
import stuffstuff.blocks.Blocks;
import stuffstuff.config.ConfigHandler;
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

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)//, dependencies = "required-after:AppliedEnergistics")
@NetworkMod(channels = {ModInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class StuffStuff
{
	public static CreativeTabs tabStuffStuff = new CreativeTabs("tabStuffStuff")
    {
		// TODO put this into its own full class.  It needs more functionality and would look silly here.
//    	public ItemStack getIconItemStack()
//    	{
//    		return new ItemStack(Blocks.blockSingularity);
////    		return new ItemStack(Block.stone);
//    	}
    };
	
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
