package stuffstuff.items;

import stuffstuff.info.ItemInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class Items
{
	public static ItemFluidCleaner itemFluidCleaner;
	public static ItemFluidSmoother itemFluidSmoother;
	public static ItemBlockPlacer itemBlockPlacer;
	
	public static void init()
	{
		itemFluidCleaner = new ItemFluidCleaner(ItemInfo.FLUID_CLEANER_ID); 
		itemFluidSmoother = new ItemFluidSmoother(ItemInfo.FLUID_SMOOTHER_ID);
		itemBlockPlacer = new ItemBlockPlacer(ItemInfo.BLOCK_PLACER_ID);

		GameRegistry.registerItem(itemFluidCleaner, ItemInfo.FLUID_CLEANER_NAME);
		GameRegistry.registerItem(itemFluidSmoother, ItemInfo.FLUID_SMOOTHER_NAME);
		GameRegistry.registerItem(itemBlockPlacer, ItemInfo.BLOCK_PLACER_NAME);
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(itemFluidCleaner, ItemInfo.FLUID_CLEANER_NAME);
		LanguageRegistry.addName(itemFluidSmoother, ItemInfo.FLUID_CLEANER_NAME);
		LanguageRegistry.addName(itemBlockPlacer, ItemInfo.BLOCK_PLACER_NAME);
	}

	public static void registerRecipes()
    {
	    // TODO come up with recipes that make sense and stuff
    }
}
