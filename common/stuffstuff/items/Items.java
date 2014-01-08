package stuffstuff.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import stuffstuff.blocks.BlockPlaidGlass;
import stuffstuff.blocks.BlockPlaidSand;
import stuffstuff.blocks.Blocks;
import stuffstuff.fluid.Fluids;
import stuffstuff.info.ItemInfo;
import stuffstuff.recipe.Smelt;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items
{
	public static ItemFluidCleaner itemFluidCleaner;
	public static ItemFluidSmoother itemFluidSmoother;
	public static ItemBlockPlacer itemBlockPlacer;
	public static ItemBucketPlaid itemBucketPlaid;

	public static void init()
	{
		itemFluidCleaner = new ItemFluidCleaner(ItemInfo.FLUID_CLEANER_ID);
		itemFluidSmoother = new ItemFluidSmoother(ItemInfo.FLUID_SMOOTHER_ID);
		itemBlockPlacer = new ItemBlockPlacer(ItemInfo.BLOCK_PLACER_ID);
		itemBucketPlaid = new ItemBucketPlaid(Fluids.fluidPlaidWater.getBlockID(), Fluids.blockFluidPlaidWater.blockID);

		GameRegistry.registerItem(itemFluidCleaner, ItemInfo.FLUID_CLEANER_NAME);
		GameRegistry.registerItem(itemFluidSmoother, ItemInfo.FLUID_SMOOTHER_NAME);
		GameRegistry.registerItem(itemBlockPlacer, ItemInfo.BLOCK_PLACER_NAME);
		GameRegistry.registerItem(itemBucketPlaid, ItemInfo.BUCKET_PLAID_NAME);

		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack(Fluids.fluidPlaidWater.getName(), FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(itemBucketPlaid), new ItemStack(Item.bucketEmpty));
	}

	public static void addNames()
	{
		LanguageRegistry.addName(itemFluidCleaner, ItemInfo.FLUID_CLEANER_NAME);
		LanguageRegistry.addName(itemFluidSmoother, ItemInfo.FLUID_CLEANER_NAME);
		LanguageRegistry.addName(itemBlockPlacer, ItemInfo.BLOCK_PLACER_NAME);
		LanguageRegistry.addName(itemBucketPlaid, ItemInfo.BUCKET_PLAID_NAME);
	}

	public static void registerRecipes()
	{
		// TODO come up with recipes that make sense and stuff
		Smelt.register(new ItemStack(Blocks.blockPlaidSand), new ItemStack(Blocks.blockPlaidGlass));
		Smelt.register(new ItemStack(Blocks.blockPlaidCobble), new ItemStack(Blocks.blockPlaidStone));
		Smelt.register(new ItemStack(Blocks.blockPlaidLog), new ItemStack(Item.coal, 1, 1));
	}
}
