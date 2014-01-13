package stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

import org.bouncycastle.asn1.eac.BidirectionalMap;

import stuffstuff.blocks.items.ItemFluixBrick;
import stuffstuff.blocks.items.ItemFunFluix;
import stuffstuff.blocks.items.ItemPlaidLeaves;
import stuffstuff.blocks.items.ItemPlaidLog;
import stuffstuff.blocks.items.ItemPlaidTallGrass;
import stuffstuff.blocks.items.ItemStuffSlab;
import stuffstuff.info.BlockInfo;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks
{
	// public static Block blockBlockPlacer;
	public static Block blockPlaidPlank;
	public static Block blockPlaidLog;
	public static Block blockPlaidSapling;
	public static Block blockPlaidGrass;
	public static Block blockPlaidLeaves;
	public static Block blockPlaidSand;
	public static Block blockPlaidGravel;
	public static Block blockPlaidCobble;
	public static Block blockPlaidStone;
	public static Block blockPlaidDirt;
	public static Block blockPlaidStoneBrick;
	public static BlockStairs blockPlaidStoneStairs;
	public static BlockStairs blockPlaidCobblestoneStairs;
	public static BlockStairs blockPlaidStoneBrickStairs;
	public static BlockStairs blockPlaidPlankStairs;
	public static BlockStairs blockFunFluixStairs;
	public static BlockStairs blockRunningFluixStairs;
	public static BlockStairs blockFluixBrickStairs;
	public static BlockStairs blockFineFluixBrickStairs;

	public static Block blockPlaidTallGrass;
	public static Block blockPlaidGlass;
	public static BlockStuffSlab blockStoneSlab;
	public static BlockStuffSlab blockStoneDoubleSlab;
	public static BlockStuffSlab blockWoodSlab;
	public static BlockStuffSlab blockWoodDoubleSlab;
	public static Block blockFunFluix;
	public static Block blockFluixBrick;

	protected static BidirectionalMap slabs;

	public static void init()
	{
		// blockBlockPlacer = new BlockBlockPlacer(BlockInfo.BLOCK_PLACER_ID);
		blockPlaidPlank = new BlockPlaidPlank(BlockInfo.PLAID_PLANK_ID);
		blockPlaidLog = new BlockPlaidLog(BlockInfo.PLAID_LOG_ID);
		blockPlaidSapling = new BlockPlaidSapling(BlockInfo.PLAID_SAPLING_ID);
		blockPlaidGrass = new BlockPlaidGrass(BlockInfo.PLAID_GRASS_ID);
		blockPlaidLeaves = new BlockPlaidLeaves(BlockInfo.PLAID_LEAVES_ID);
		blockPlaidTallGrass = new BlockPlaidTallGrass(BlockInfo.PLAID_TALL_GRASS_ID);

		blockPlaidSand = new BlockPlaidSand(BlockInfo.PLAID_SAND_ID);
		blockPlaidGravel = new BlockPlaidGravel(BlockInfo.PLAID_GRAVEL_ID);
		blockPlaidCobble = new BlockPlaidCobblestone(BlockInfo.PLAID_COBBLESTONE_ID);
		blockPlaidStone = new BlockPlaidStone(BlockInfo.PLAID_STONE_ID);
		blockPlaidDirt = new BlockPlaidDirt(BlockInfo.PLAID_DIRT_ID);
		blockPlaidStoneBrick = new BlockPlaidStoneBrick(BlockInfo.PLAID_STONE_BRICK_ID);
		blockPlaidGlass = new BlockPlaidGlass(BlockInfo.PLAID_GLASS_ID);

		Block[] stoneBlocks = {blockPlaidStone, blockPlaidCobble, blockPlaidStoneBrick};
		Block[] woodBlocks = {blockPlaidPlank, blockPlaidLog};
		slabs = new BidirectionalMap();
		slabs.put(BlockInfo.STONE_SLAB_ID, BlockInfo.STONE_SLAB_DOUBLE_ID);
		slabs.put(BlockInfo.WOOD_SLAB_ID, BlockInfo.WOOD_SLAB_DOUBLE_ID);

		blockStoneSlab = new BlockStuffSlab(BlockInfo.STONE_SLAB_ID, false, stoneBlocks, BlockInfo.STONE_SLAB_DOUBLE_ID);
		blockStoneDoubleSlab = new BlockStuffSlab(BlockInfo.STONE_SLAB_DOUBLE_ID, true, stoneBlocks, BlockInfo.STONE_SLAB_ID);
		blockWoodSlab = new BlockStuffSlab(BlockInfo.WOOD_SLAB_ID, false, woodBlocks, BlockInfo.WOOD_SLAB_DOUBLE_ID);
		blockWoodDoubleSlab = new BlockStuffSlab(BlockInfo.WOOD_SLAB_DOUBLE_ID, true, woodBlocks, BlockInfo.WOOD_SLAB_ID);

		blockFunFluix = new BlockFunFluix(BlockInfo.FUN_FLUIX_ID);
		blockFluixBrick = new BlockFluixBrick(BlockInfo.FLUIX_BRICK_ID);

		blockPlaidStoneStairs = new BlockStuffStairs(BlockInfo.PLAID_STONE_STAIRS_ID, blockPlaidStone);
		blockPlaidCobblestoneStairs = new BlockStuffStairs(BlockInfo.PLAID_COBBLESTONE_STAIRS_ID, blockPlaidCobble);
		blockPlaidStoneBrickStairs = new BlockStuffStairs(BlockInfo.PLAID_STONE_BRICK_STAIRS_ID, blockPlaidStoneBrick);
		blockPlaidPlankStairs = new BlockStuffStairs(BlockInfo.PLAID_PLANK_STAIRS_ID, blockPlaidPlank);

		blockFunFluixStairs = new BlockStuffStairs(BlockInfo.FUN_FLUIX_BRICK_STAIRS_ID, blockFunFluix, 0, false);
		blockRunningFluixStairs = new BlockStuffStairs(BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_ID, blockFunFluix, 1, false);
		blockFluixBrickStairs = new BlockStuffStairs(BlockInfo.FLUIX_BRICK_STAIRS_ID, blockFluixBrick, 0, false);
		blockFineFluixBrickStairs = new BlockStuffStairs(BlockInfo.FINE_FLUIX_BRICK_STAIRS_ID, blockFluixBrick, 1, false);

		// GameRegistry.registerBlock(blockBlockPlacer, BlockInfo.BLOCK_PLACER_NAME);
		GameRegistry.registerBlock(blockPlaidPlank, BlockInfo.PLAID_PLANK_NAME);
		GameRegistry.registerBlock(blockPlaidLog, ItemPlaidLog.class, BlockInfo.PLAID_LOG_NAME);
		GameRegistry.registerBlock(blockPlaidSapling, BlockInfo.PLAID_SAPLING_NAME);
		GameRegistry.registerBlock(blockPlaidGrass, BlockInfo.PLAID_GRASS_NAME);
		GameRegistry.registerBlock(blockPlaidLeaves, ItemPlaidLeaves.class, BlockInfo.PLAID_LEAVES_NAME);
		GameRegistry.registerBlock(blockPlaidTallGrass, ItemPlaidTallGrass.class, BlockInfo.PLAID_TALL_GRASS_NAME);

		GameRegistry.registerBlock(blockPlaidSand, BlockInfo.PLAID_SAND_NAME);
		GameRegistry.registerBlock(blockPlaidGravel, BlockInfo.PLAID_GRAVEL_NAME);
		GameRegistry.registerBlock(blockPlaidCobble, BlockInfo.PLAID_COBBLESTONE_NAME);
		GameRegistry.registerBlock(blockPlaidStone, BlockInfo.PLAID_STONE_NAME);
		GameRegistry.registerBlock(blockPlaidDirt, BlockInfo.PLAID_DIRT_NAME);
		GameRegistry.registerBlock(blockPlaidStoneBrick, BlockInfo.PLAID_STONE_BRICK_NAME);
		GameRegistry.registerBlock(blockPlaidGlass, BlockInfo.PLAID_GLASS_NAME);

		ItemStuffSlab.setSlabs(blockStoneSlab, blockStoneDoubleSlab);
		GameRegistry.registerBlock(blockStoneSlab, ItemStuffSlab.class, BlockInfo.STONE_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockStoneDoubleSlab, ItemStuffSlab.class, BlockInfo.STONE_SLAB_DOUBLE_UNLOCALIZED_NAME);
		ItemStuffSlab.setSlabs(blockWoodSlab, blockWoodDoubleSlab);
		GameRegistry.registerBlock(blockWoodSlab, ItemStuffSlab.class, BlockInfo.WOOD_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockWoodDoubleSlab, ItemStuffSlab.class, BlockInfo.WOOD_SLAB_DOUBLE_UNLOCALIZED_NAME);

		GameRegistry.registerBlock(blockFunFluix, ItemFunFluix.class, BlockInfo.FUN_FLUIX_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixBrick, ItemFluixBrick.class, BlockInfo.FLUIX_BRICK_UNLOCALIZED_NAME);

		GameRegistry.registerBlock(blockPlaidStoneStairs, BlockInfo.PLAID_STONE_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockPlaidCobblestoneStairs, BlockInfo.PLAID_COBBLESTONE_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockPlaidStoneBrickStairs, BlockInfo.PLAID_STONE_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockPlaidPlankStairs, BlockInfo.PLAID_PLANK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFunFluixStairs, BlockInfo.FUN_FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockRunningFluixStairs, BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixBrickStairs, BlockInfo.FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFineFluixBrickStairs, BlockInfo.FINE_FLUIX_BRICK_STAIRS_NAME);

	}

	public static void addNames()
	{
		// LanguageRegistry.addName(blockBlockPlacer, BlockInfo.BLOCK_PLACER_NAME);
		LanguageRegistry.addName(blockPlaidPlank, BlockInfo.PLAID_PLANK_NAME);
		LanguageRegistry.addName(blockPlaidLog, BlockInfo.PLAID_LOG_NAME);
		LanguageRegistry.addName(blockPlaidSapling, BlockInfo.PLAID_SAPLING_NAME);
		LanguageRegistry.addName(blockPlaidGrass, BlockInfo.PLAID_GRASS_NAME);
		LanguageRegistry.addName(blockPlaidLeaves, BlockInfo.PLAID_LEAVES_NAME);
		LanguageRegistry.addName(blockPlaidTallGrass, BlockInfo.PLAID_TALL_GRASS_NAME);

		LanguageRegistry.addName(blockPlaidSand, BlockInfo.PLAID_SAND_NAME);
		LanguageRegistry.addName(blockPlaidGravel, BlockInfo.PLAID_GRAVEL_NAME);
		LanguageRegistry.addName(blockPlaidCobble, BlockInfo.PLAID_COBBLESTONE_NAME);
		LanguageRegistry.addName(blockPlaidStone, BlockInfo.PLAID_STONE_NAME);
		LanguageRegistry.addName(blockPlaidDirt, BlockInfo.PLAID_DIRT_NAME);
		LanguageRegistry.addName(blockPlaidStoneBrick, BlockInfo.PLAID_STONE_BRICK_NAME);
		LanguageRegistry.addName(blockPlaidGlass, BlockInfo.PLAID_GLASS_NAME);

		LanguageRegistry.addName(blockFunFluix, BlockInfo.FUN_FLUIX_NAME);
		LanguageRegistry.addName(blockFluixBrick, BlockInfo.FLUIX_BRICK_NAME);

		//		LanguageRegistry.addName(objectToName, name); // slab stuff

		LanguageRegistry.addName(blockPlaidStoneStairs, BlockInfo.PLAID_STONE_STAIRS_NAME);
		LanguageRegistry.addName(blockPlaidCobblestoneStairs, BlockInfo.PLAID_COBBLESTONE_STAIRS_NAME);
		LanguageRegistry.addName(blockPlaidStoneBrickStairs, BlockInfo.PLAID_STONE_BRICK_STAIRS_NAME);
		LanguageRegistry.addName(blockPlaidPlankStairs, BlockInfo.PLAID_PLANK_NAME);
		LanguageRegistry.addName(blockFunFluixStairs, BlockInfo.FUN_FLUIX_BRICK_STAIRS_NAME);
		LanguageRegistry.addName(blockRunningFluixStairs, BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_NAME);
		LanguageRegistry.addName(blockFluixBrickStairs, BlockInfo.FLUIX_BRICK_STAIRS_NAME);
		LanguageRegistry.addName(blockFineFluixBrickStairs, BlockInfo.FINE_FLUIX_BRICK_STAIRS_NAME);

	}

	public static void registerRecipes()
	{

	}

	public static void registerTileEntities()
	{

	}
}
