package stuffstuff.stuffstuff.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import stuffstuff.stuffstuff.blocks.BlocksStuff;
import stuffstuff.stuffstuff.fluid.Fluids;
import stuffstuff.stuffstuff.info.ItemInfo;
import stuffstuff.stuffstuff.recipe.Smelt;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemsStuff
{
	public static ItemFluidCleaner itemFluidCleaner;
	public static ItemFluidSmoother itemFluidSmoother;
	public static ItemBlockPlacer itemBlockPlacer;
	public static ItemBucketPlaid itemBucketPlaid;

	public static void init()
	{
		itemFluidCleaner = new ItemFluidCleaner();
		itemFluidSmoother = new ItemFluidSmoother();
		itemBlockPlacer = new ItemBlockPlacer();
		itemBucketPlaid = new ItemBucketPlaid(Fluids.blockFluidPlaidWater);

		GameRegistry.registerItem(itemFluidCleaner, ItemInfo.FLUID_CLEANER_NAME);
		GameRegistry.registerItem(itemFluidSmoother, ItemInfo.FLUID_SMOOTHER_NAME);
		GameRegistry.registerItem(itemBlockPlacer, ItemInfo.BLOCK_PLACER_NAME);
		GameRegistry.registerItem(itemBucketPlaid, ItemInfo.BUCKET_PLAID_NAME);

		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(Fluids.fluidPlaidWater.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(itemBucketPlaid), new ItemStack(Items.bucket));
	}

	public static void addNames()
	{
		//		LanguageRegistry.addName(itemFluidCleaner, ItemInfo.FLUID_CLEANER_NAME);
		//		LanguageRegistry.addName(itemFluidSmoother, ItemInfo.FLUID_CLEANER_NAME);
		//		LanguageRegistry.addName(itemBlockPlacer, ItemInfo.BLOCK_PLACER_NAME);
		//		LanguageRegistry.addName(itemBucketPlaid, ItemInfo.BUCKET_PLAID_NAME);
	}

	public static void registerRecipes()
	{
		// TODO come up with recipes that make sense and stuff
		Smelt.register(new ItemStack(BlocksStuff.blockPlaidSand), new ItemStack(BlocksStuff.blockPlaidGlass));
		Smelt.register(new ItemStack(BlocksStuff.blockPlaidCobble), new ItemStack(BlocksStuff.blockPlaidStone));
		Smelt.register(new ItemStack(BlocksStuff.blockPlaidLog), new ItemStack(Items.coal, 1, 1));
	}
}
