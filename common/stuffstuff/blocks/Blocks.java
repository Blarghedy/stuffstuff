package stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

import org.bouncycastle.asn1.eac.BidirectionalMap;

import stuffstuff.blocks.doors.BlockFluidStuffDoor;
import stuffstuff.blocks.doors.BlockLavaStuffDoor;
import stuffstuff.blocks.doors.BlockStuffDoor;
import stuffstuff.blocks.items.ItemFluixBrick;
import stuffstuff.blocks.items.ItemFunFluix;
import stuffstuff.blocks.items.ItemPlaidLeaves;
import stuffstuff.blocks.items.ItemPlaidLog;
import stuffstuff.blocks.items.ItemPlaidTallGrass;
import stuffstuff.blocks.items.ItemStuffDoor;
import stuffstuff.blocks.items.ItemStuffSlab;
import stuffstuff.blocks.slabs.BlockFluidStuffSlab;
import stuffstuff.blocks.slabs.BlockLavaStuffSlab;
import stuffstuff.blocks.slabs.BlockRedstoneStuffSlab;
import stuffstuff.blocks.slabs.BlockSilverfishStuffSlab;
import stuffstuff.blocks.slabs.BlockStuffSlab;
import stuffstuff.blocks.stairs.BlockFluidStuffStairs;
import stuffstuff.blocks.stairs.BlockLavaStuffStairs;
import stuffstuff.blocks.stairs.BlockRedstoneStuffStairs;
import stuffstuff.blocks.stairs.BlockSilverfishStuffStairs;
import stuffstuff.blocks.stairs.BlockStuffStairs;
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
	public static Block blockFunFluix;
	public static Block blockFluixBrick;
	public static Block blockPlaidTallGrass;
	public static Block blockPlaidGlass;
	public static BlockFluixGlass blockFluixGlass;

	public static BlockStairs blockPlaidStoneStairs;
	public static BlockStairs blockPlaidCobblestoneStairs;
	public static BlockStairs blockPlaidStoneBrickStairs;
	public static BlockStairs blockPlaidPlankStairs;
	public static BlockStairs blockFunFluixStairs;
	public static BlockStairs blockRunningFluixStairs;
	public static BlockStairs blockFluixBrickStairs;
	public static BlockStairs blockFineFluixBrickStairs;
	public static BlockStairs blockWhitePlaidLogStairs;
	public static BlockStairs blockRedPlaidLogStairs;
	public static BlockStairs blockGreenPlaidLogStairs;
	public static BlockStairs blockBluePlaidLogStairs;
	public static BlockStairs blockOakLogStairs;
	public static BlockStairs blockBirchLogStairs;
	public static BlockStairs blockSpruceLogStairs;
	public static BlockStairs blockJungleLogStairs;
	public static BlockStairs blockLavaStairs;
	public static BlockStairs blockWaterStairs;
	public static BlockStairs blockRedstoneStairs;
	public static BlockStairs blockIronOreStairs;
	public static BlockStairs blockSilverfishStairs;

	public static BlockStuffSlab blockStoneSlab;
	public static BlockStuffSlab blockStoneDoubleSlab;
	public static BlockStuffSlab blockWoodSlab;
	public static BlockStuffSlab blockWoodDoubleSlab;
	public static BlockStuffSlab blockFluixBrickSlab;
	public static BlockStuffSlab blockFluixBrickDoubleSlab;
	public static BlockStuffSlab blockLogSlab;
	public static BlockStuffSlab blockLogDoubleSlab;
	public static BlockStuffSlab blockWaterSlab;
	public static BlockStuffSlab blockWaterDoubleSlab;
	public static BlockStuffSlab blockLavaSlab;
	public static BlockStuffSlab blockLavaDoubleSlab;
	public static BlockStuffSlab blockRedstoneSlab;
	public static BlockStuffSlab blockRedstoneDoubleSlab;
	public static BlockStuffSlab blockSilverfishSlab;
	public static BlockStuffSlab blockSilverfishDoubleSlab;

	public static BlockStuffDoor blockRunningFluixDoor;
	public static BlockStuffDoor blockWaterDoor;
	public static BlockStuffDoor blockLavaDoor;
	public static BlockStuffDoor blockIronOreDoor;
	public static BlockStuffDoor blockDiamondDoor;

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
		blockFunFluix = new BlockFunFluix(BlockInfo.FUN_FLUIX_ID);
		blockFluixBrick = new BlockFluixBrick(BlockInfo.FLUIX_BRICK_ID);
		blockFluixGlass = new BlockFluixGlass(BlockInfo.FLUIX_GLASS_ID);

		Block[] stoneBlocks = {blockPlaidStone, blockPlaidCobble, blockPlaidStoneBrick};
		Block[] woodBlocks = {blockPlaidPlank};
		Block[] logBlocks = {blockPlaidLog, blockPlaidLog, blockPlaidLog, blockPlaidLog, Block.wood, Block.wood, Block.wood, Block.wood};
		int[] logsMeta = {0, 1, 2, 3, 0, 1, 2, 3};
		Block[] fluixBricks = {blockFluixBrick, blockFluixBrick, blockFunFluix, blockFunFluix};
		int[] fluixBricksMeta = {0, 1, 0, 1};
		Block[] redstone = {Block.blockRedstone};
		Block[] water = {Block.waterStill};
		Block[] lava = {Block.lavaStill};
		Block[] silverfish = {Block.silverfish, Block.cobblestoneMossy};

		blockStoneSlab = new BlockStuffSlab(BlockInfo.STONE_SLAB_ID, BlockInfo.STONE_SLAB_DOUBLE_ID, false, stoneBlocks);
		blockStoneDoubleSlab = new BlockStuffSlab(BlockInfo.STONE_SLAB_DOUBLE_ID, BlockInfo.STONE_SLAB_ID, true, stoneBlocks);
		blockWoodSlab = new BlockStuffSlab(BlockInfo.WOOD_SLAB_ID, BlockInfo.WOOD_SLAB_DOUBLE_ID, false, woodBlocks);
		blockWoodDoubleSlab = new BlockStuffSlab(BlockInfo.WOOD_SLAB_DOUBLE_ID, BlockInfo.WOOD_SLAB_ID, true, woodBlocks);
		blockFluixBrickSlab = new BlockStuffSlab(BlockInfo.FLUIX_SLAB_ID, BlockInfo.FLUIX_SLAB_DOUBLE_ID, false, fluixBricks, false, fluixBricksMeta);
		blockFluixBrickDoubleSlab = new BlockStuffSlab(BlockInfo.FLUIX_SLAB_DOUBLE_ID, BlockInfo.FLUIX_SLAB_ID, true, fluixBricks, false, fluixBricksMeta);
		blockLogSlab = new BlockStuffSlab(BlockInfo.LOG_SLAB_ID, BlockInfo.LOG_SLAB_DOUBLE_ID, false, logBlocks, false, logsMeta);
		blockLogDoubleSlab = new BlockStuffSlab(BlockInfo.LOG_SLAB_DOUBLE_ID, BlockInfo.LOG_SLAB_ID, true, logBlocks, false, logsMeta);
		blockRedstoneSlab = new BlockRedstoneStuffSlab(BlockInfo.REDSTONE_SLAB_ID, BlockInfo.REDSTONE_SLAB_DOUBLE_ID, false, redstone, false, null);
		blockRedstoneDoubleSlab = new BlockRedstoneStuffSlab(BlockInfo.REDSTONE_SLAB_DOUBLE_ID, BlockInfo.REDSTONE_SLAB_ID, true, redstone, false, null);
		blockWaterSlab = new BlockFluidStuffSlab(BlockInfo.WATER_SLAB_ID, BlockInfo.WATER_SLAB_DOUBLE_ID, false, water, false, null);
		blockWaterDoubleSlab = new BlockFluidStuffSlab(BlockInfo.WATER_SLAB_DOUBLE_ID, BlockInfo.WATER_SLAB_ID, true, water, false, null);
		blockLavaSlab = new BlockLavaStuffSlab(BlockInfo.LAVA_SLAB_ID, BlockInfo.LAVA_SLAB_DOUBLE_ID, false, lava, false, null);
		blockLavaDoubleSlab = new BlockLavaStuffSlab(BlockInfo.LAVA_SLAB_DOUBLE_ID, BlockInfo.LAVA_SLAB_ID, true, lava, false, null);
		blockSilverfishSlab = new BlockSilverfishStuffSlab(BlockInfo.SILVERFISH_SLAB_ID, BlockInfo.SILVERFISH_SLAB_DOUBLE_ID, false, silverfish, false, null);
		blockSilverfishDoubleSlab = new BlockSilverfishStuffSlab(BlockInfo.SILVERFISH_SLAB_DOUBLE_ID, BlockInfo.SILVERFISH_SLAB_ID, true, silverfish, false, null);

		blockPlaidStoneStairs = new BlockStuffStairs(BlockInfo.PLAID_STONE_STAIRS_ID, blockPlaidStone);
		blockPlaidCobblestoneStairs = new BlockStuffStairs(BlockInfo.PLAID_COBBLESTONE_STAIRS_ID, blockPlaidCobble);
		blockPlaidStoneBrickStairs = new BlockStuffStairs(BlockInfo.PLAID_STONE_BRICK_STAIRS_ID, blockPlaidStoneBrick);
		blockPlaidPlankStairs = new BlockStuffStairs(BlockInfo.PLAID_PLANK_STAIRS_ID, blockPlaidPlank);

		blockFunFluixStairs = new BlockStuffStairs(BlockInfo.FUN_FLUIX_BRICK_STAIRS_ID, blockFunFluix, 0, false);
		blockRunningFluixStairs = new BlockStuffStairs(BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_ID, blockFunFluix, 1, false);
		blockFluixBrickStairs = new BlockStuffStairs(BlockInfo.FLUIX_BRICK_STAIRS_ID, blockFluixBrick, 0, false);
		blockFineFluixBrickStairs = new BlockStuffStairs(BlockInfo.FINE_FLUIX_BRICK_STAIRS_ID, blockFluixBrick, 1, false);

		blockBluePlaidLogStairs = new BlockStuffStairs(BlockInfo.BLUE_PLAID_LOG_STAIRS_ID, blockPlaidLog, 0, false);
		blockGreenPlaidLogStairs = new BlockStuffStairs(BlockInfo.GREEN_PLAID_LOG_STAIRS_ID, blockPlaidLog, 1, false);
		blockRedPlaidLogStairs = new BlockStuffStairs(BlockInfo.RED_PLAID_LOG_STAIRS_ID, blockPlaidLog, 2, false);
		blockWhitePlaidLogStairs = new BlockStuffStairs(BlockInfo.WHITE_PLAID_LOG_STAIRS_ID, blockPlaidLog, 3, false);

		blockOakLogStairs = new BlockStuffStairs(BlockInfo.OAK_LOG_STAIRS_ID, Block.wood, 0, false);
		blockSpruceLogStairs = new BlockStuffStairs(BlockInfo.SPRUCE_LOG_STAIRS_ID, Block.wood, 1, false);
		blockBirchLogStairs = new BlockStuffStairs(BlockInfo.BIRCH_LOG_STAIRS_ID, Block.wood, 2, false);
		blockJungleLogStairs = new BlockStuffStairs(BlockInfo.JUNGLE_LOG_STAIRS_ID, Block.wood, 3, false);

		blockWaterStairs = new BlockFluidStuffStairs(BlockInfo.WATER_STAIRS_ID, Block.waterStill, 0, false);
		blockLavaStairs = new BlockLavaStuffStairs(BlockInfo.LAVA_STAIRS_ID, Block.lavaStill, 0, false);
		blockRedstoneStairs = new BlockRedstoneStuffStairs(BlockInfo.REDSTONE_STAIRS_ID, Block.blockRedstone, 0, false);
		blockSilverfishStairs = new BlockSilverfishStuffStairs(BlockInfo.SILVERFISH_STAIRS_ID, Block.silverfish, 0, false);
		blockIronOreStairs = new BlockStuffStairs(BlockInfo.IRON_ORE_STAIRS_ID, Block.oreIron);

		blockRunningFluixDoor = new BlockStuffDoor(BlockInfo.RUNNING_FLUIX_DOOR_ID, blockFunFluix, 1, false);
		blockWaterDoor = new BlockFluidStuffDoor(BlockInfo.WATER_DOOR_ID, Block.waterStill, 0, false);
		blockLavaDoor = new BlockLavaStuffDoor(BlockInfo.LAVA_DOOR_ID, Block.lavaStill, 0, false);
		blockDiamondDoor = new BlockStuffDoor(BlockInfo.DIAMOND_DOOR_ID, Block.blockDiamond);
		blockIronOreDoor = new BlockStuffDoor(BlockInfo.IRON_ORE_DOOR_ID, Block.oreIron);

		// register normal blocks
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

		GameRegistry.registerBlock(blockFunFluix, ItemFunFluix.class, BlockInfo.FUN_FLUIX_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixBrick, ItemFluixBrick.class, BlockInfo.FLUIX_BRICK_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixGlass, BlockInfo.FLUIX_GLASS_UNLOCALIZED_NAME);

		// register slabs
		ItemStuffSlab.setSlabs(blockStoneSlab, blockStoneDoubleSlab);
		GameRegistry.registerBlock(blockStoneSlab, ItemStuffSlab.class, BlockInfo.STONE_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockStoneDoubleSlab, ItemStuffSlab.class, BlockInfo.STONE_SLAB_DOUBLE_UNLOCALIZED_NAME);

		ItemStuffSlab.setSlabs(blockWoodSlab, blockWoodDoubleSlab);
		GameRegistry.registerBlock(blockWoodSlab, ItemStuffSlab.class, BlockInfo.WOOD_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockWoodDoubleSlab, ItemStuffSlab.class, BlockInfo.WOOD_SLAB_DOUBLE_UNLOCALIZED_NAME);

		ItemStuffSlab.setSlabs(blockFluixBrickSlab, blockFluixBrickDoubleSlab);
		GameRegistry.registerBlock(blockFluixBrickSlab, ItemStuffSlab.class, BlockInfo.FLUIX_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixBrickDoubleSlab, ItemStuffSlab.class, BlockInfo.FLUIX_SLAB_DOUBLE_UNLOCALIZED_NAME);

		ItemStuffSlab.setSlabs(blockLogSlab, blockLogDoubleSlab);
		GameRegistry.registerBlock(blockLogSlab, ItemStuffSlab.class, BlockInfo.LOG_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockLogDoubleSlab, ItemStuffSlab.class, BlockInfo.LOG_SLAB_DOUBLE_UNLOCALIZED_NAME);

		ItemStuffSlab.setSlabs(blockRedstoneSlab, blockRedstoneDoubleSlab);
		GameRegistry.registerBlock(blockRedstoneSlab, ItemStuffSlab.class, BlockInfo.REDSTONE_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockRedstoneDoubleSlab, ItemStuffSlab.class, BlockInfo.REDSTONE_SLAB_DOUBLE_UNLOCALIZED_NAME);

		ItemStuffSlab.setSlabs(blockWaterSlab, blockWaterDoubleSlab);
		GameRegistry.registerBlock(blockWaterSlab, ItemStuffSlab.class, BlockInfo.WATER_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockWaterDoubleSlab, ItemStuffSlab.class, BlockInfo.WATER_SLAB_DOUBLE_UNLOCALIZED_NAME);

		ItemStuffSlab.setSlabs(blockLavaSlab, blockLavaDoubleSlab);
		GameRegistry.registerBlock(blockLavaSlab, ItemStuffSlab.class, BlockInfo.LAVA_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockLavaDoubleSlab, ItemStuffSlab.class, BlockInfo.LAVA_SLAB_DOUBLE_UNLOCALIZED_NAME);

		ItemStuffSlab.setSlabs(blockSilverfishSlab, blockSilverfishDoubleSlab);
		GameRegistry.registerBlock(blockSilverfishSlab, ItemStuffSlab.class, BlockInfo.SILVERFISH_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockSilverfishDoubleSlab, ItemStuffSlab.class, BlockInfo.SILVERFISH_SLAB_DOUBLE_UNLOCALIZED_NAME);

		// register stairs
		GameRegistry.registerBlock(blockPlaidStoneStairs, BlockInfo.PLAID_STONE_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockPlaidCobblestoneStairs, BlockInfo.PLAID_COBBLESTONE_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockPlaidStoneBrickStairs, BlockInfo.PLAID_STONE_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockPlaidPlankStairs, BlockInfo.PLAID_PLANK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFunFluixStairs, BlockInfo.FUN_FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockRunningFluixStairs, BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFluixBrickStairs, BlockInfo.FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockFineFluixBrickStairs, BlockInfo.FINE_FLUIX_BRICK_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockRedPlaidLogStairs, BlockInfo.RED_PLAID_LOG_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockBluePlaidLogStairs, BlockInfo.BLUE_PLAID_LOG_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockGreenPlaidLogStairs, BlockInfo.GREEN_PLAID_LOG_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockWhitePlaidLogStairs, BlockInfo.WHITE_PLAID_LOG_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockOakLogStairs, BlockInfo.OAK_LOG_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockBirchLogStairs, BlockInfo.BIRCH_LOG_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockSpruceLogStairs, BlockInfo.SPRUCE_LOG_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockJungleLogStairs, BlockInfo.JUNGLE_LOG_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockWaterStairs, BlockInfo.WATER_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockLavaStairs, BlockInfo.LAVA_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockRedstoneStairs, BlockInfo.REDSTONE_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockSilverfishStairs, BlockInfo.SILVERFISH_STAIRS_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockIronOreStairs, BlockInfo.IRON_ORE_STAIRS_UNLOCALIZED_NAME);

		// register doors
		ItemStuffDoor.setDoor(blockRunningFluixDoor);
		GameRegistry.registerBlock(blockRunningFluixDoor, ItemStuffDoor.class, BlockInfo.RUNNING_FLUIX_DOOR_UNLOCALIZED_NAME);

		ItemStuffDoor.setDoor(blockWaterDoor);
		GameRegistry.registerBlock(blockWaterDoor, ItemStuffDoor.class, BlockInfo.WATER_DOOR_UNLOCALIZED_NAME);

		ItemStuffDoor.setDoor(blockLavaDoor);
		GameRegistry.registerBlock(blockLavaDoor, ItemStuffDoor.class, BlockInfo.LAVA_DOOR_UNLOCALIZED_NAME);

		ItemStuffDoor.setDoor(blockDiamondDoor);
		GameRegistry.registerBlock(blockDiamondDoor, ItemStuffDoor.class, BlockInfo.DIAMOND_DOOR_UNLOCALIZED_NAME);

		ItemStuffDoor.setDoor(blockIronOreDoor);
		GameRegistry.registerBlock(blockIronOreDoor, ItemStuffDoor.class, BlockInfo.IRON_ORE_DOOR_UNLOCALIZED_NAME);
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
