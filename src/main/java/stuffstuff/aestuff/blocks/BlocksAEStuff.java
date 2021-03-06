package stuffstuff.aestuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import stuffstuff.aestuff.blocks.items.ItemFluixBrick;
import stuffstuff.aestuff.blocks.items.ItemFunFluix;
import stuffstuff.aestuff.info.BlockInfo;
import stuffstuff.stuffstuff.blocks.doors.BlockStuffDoor;
import stuffstuff.stuffstuff.blocks.items.ItemStuffDoor;
import stuffstuff.stuffstuff.blocks.items.ItemStuffSlab;
import stuffstuff.stuffstuff.blocks.slabs.BlockStuffSlab;
import stuffstuff.stuffstuff.blocks.stairs.BlockStuffStairs;
import appeng.api.AEApi;
import appeng.api.IAppEngApi;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksAEStuff
{
	public static Block blockFunFluix;
	public static Block blockFluixBrick;
	public static BlockFluixGlass blockFluixGlass;

	public static BlockStuffSlab blockFluixBrickSlab;
	public static BlockStuffSlab blockFluixBrickDoubleSlab;

	public static BlockStairs blockFunFluixStairs;
	public static BlockStairs blockRunningFluixStairs;
	public static BlockStairs blockFluixBrickStairs;
	public static BlockStairs blockFineFluixBrickStairs;
	public static BlockStairs blockFluixStairs;

	public static BlockStuffDoor blockRunningFluixDoor;

	public static void init()
	{
		IAppEngApi ae = AEApi.instance();

		blockFunFluix = new BlockFunFluix();
		blockFluixBrick = new BlockFluixBrick();
		blockFluixGlass = new BlockFluixGlass();

		Block[] fluixBricks = {BlocksAEStuff.blockFluixBrick, BlocksAEStuff.blockFluixBrick, BlocksAEStuff.blockFunFluix, BlocksAEStuff.blockFunFluix};
		int[] fluixBricksMeta = {0, 1, 0, 1};

		blockFluixBrickSlab = new BlockStuffSlab(false, fluixBricks, false, fluixBricksMeta);
		blockFluixBrickDoubleSlab = new BlockStuffSlab(true, fluixBricks, false, fluixBricksMeta);

		blockFunFluixStairs = new BlockStuffStairs(BlocksAEStuff.blockFunFluix, 0, false);
		blockRunningFluixStairs = new BlockStuffStairs(BlocksAEStuff.blockFunFluix, 1, false);
		blockFluixBrickStairs = new BlockStuffStairs(BlocksAEStuff.blockFluixBrick, 0, false);
		blockFineFluixBrickStairs = new BlockStuffStairs(BlocksAEStuff.blockFluixBrick, 1, false);
		blockFluixStairs = new BlockStuffStairs(ae.blocks().blockFluix.block());

		blockRunningFluixDoor = new BlockStuffDoor(BlocksAEStuff.blockFunFluix, 1, false);

		// register blocks
		GameRegistry.registerBlock(blockFunFluix, ItemFunFluix.class, BlockInfo.FUN_FLUIX_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixBrick, ItemFluixBrick.class, BlockInfo.FLUIX_BRICK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixGlass, BlockInfo.FLUIX_GLASS_UNLOCALIZED_NAME);

		// register slabs
		ItemStuffSlab.setSlabs(blockFluixBrickSlab, blockFluixBrickDoubleSlab);
		GameRegistry.registerBlock(blockFluixBrickSlab, ItemStuffSlab.class, BlockInfo.FLUIX_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixBrickDoubleSlab, ItemStuffSlab.class, BlockInfo.FLUIX_SLAB_DOUBLE_UNLOCALIZED_NAME);

		// register stairs
		GameRegistry.registerBlock(blockFunFluixStairs, BlockInfo.FUN_FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockRunningFluixStairs, BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixBrickStairs, BlockInfo.FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFineFluixBrickStairs, BlockInfo.FINE_FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixStairs, BlockInfo.FLUIX_STAIRS_UNLOCALIZED_NAME);

		// register doors
		ItemStuffDoor.setDoor(blockRunningFluixDoor);
		GameRegistry.registerBlock(blockRunningFluixDoor, ItemStuffDoor.class, BlockInfo.RUNNING_FLUIX_DOOR_UNLOCALIZED_NAME);
	}

	public static void addNames()
	{
		//		LanguageRegistry.addName(blockFunFluix, BlockInfo.FUN_FLUIX_NAME);
		//		LanguageRegistry.addName(blockFluixBrick, BlockInfo.FLUIX_BRICK_NAME);
		//
		//		LanguageRegistry.addName(blockFunFluixStairs, BlockInfo.FUN_FLUIX_BRICK_STAIRS_NAME);
		//		LanguageRegistry.addName(blockRunningFluixStairs, BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_NAME);
		//		LanguageRegistry.addName(blockFluixBrickStairs, BlockInfo.FLUIX_BRICK_STAIRS_NAME);
		//		LanguageRegistry.addName(blockFineFluixBrickStairs, BlockInfo.FINE_FLUIX_BRICK_STAIRS_NAME);
	}

	public static void registerTileEntities()
	{

	}

}
