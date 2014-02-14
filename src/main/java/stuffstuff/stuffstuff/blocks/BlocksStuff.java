package stuffstuff.stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.init.Blocks;
import stuffstuff.stuffstuff.blocks.doors.BlockFluidStuffDoor;
import stuffstuff.stuffstuff.blocks.doors.BlockLavaStuffDoor;
import stuffstuff.stuffstuff.blocks.doors.BlockStuffDoor;
import stuffstuff.stuffstuff.blocks.items.ItemPlaidLeaves;
import stuffstuff.stuffstuff.blocks.items.ItemPlaidLog;
import stuffstuff.stuffstuff.blocks.items.ItemPlaidTallGrass;
import stuffstuff.stuffstuff.blocks.items.ItemStuffDoor;
import stuffstuff.stuffstuff.blocks.items.ItemStuffSlab;
import stuffstuff.stuffstuff.blocks.slabs.BlockFluidStuffSlab;
import stuffstuff.stuffstuff.blocks.slabs.BlockLavaStuffSlab;
import stuffstuff.stuffstuff.blocks.slabs.BlockRedstoneStuffSlab;
import stuffstuff.stuffstuff.blocks.slabs.BlockSilverfishStuffSlab;
import stuffstuff.stuffstuff.blocks.slabs.BlockStuffSlab;
import stuffstuff.stuffstuff.blocks.stairs.BlockFluidStuffStairs;
import stuffstuff.stuffstuff.blocks.stairs.BlockLavaStuffStairs;
import stuffstuff.stuffstuff.blocks.stairs.BlockRedstoneStuffStairs;
import stuffstuff.stuffstuff.blocks.stairs.BlockSilverfishStuffStairs;
import stuffstuff.stuffstuff.blocks.stairs.BlockStuffStairs;
import stuffstuff.stuffstuff.info.BlockInfo;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksStuff
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
	public static Block blockPlaidTallGrass;
	public static Block blockPlaidGlass;

	public static BlockStairs blockPlaidStoneStairs;
	public static BlockStairs blockPlaidCobblestoneStairs;
	public static BlockStairs blockPlaidStoneBrickStairs;
	public static BlockStairs blockPlaidPlankStairs;
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

	public static BlockStuffDoor blockWaterDoor;
	public static BlockStuffDoor blockLavaDoor;
	public static BlockStuffDoor blockIronOreDoor;
	public static BlockStuffDoor blockDiamondDoor;
	public static BlockStuffDoor blockPlaidPlankDoor;

	public static void init()
	{
		blockPlaidPlank = new BlockPlaidPlank();
		blockPlaidLog = new BlockPlaidLog();
		blockPlaidSapling = new BlockPlaidSapling();
		blockPlaidGrass = new BlockPlaidGrass();
		blockPlaidLeaves = new BlockPlaidLeaves();
		blockPlaidTallGrass = new BlockPlaidTallGrass();

		blockPlaidSand = new BlockPlaidSand();
		blockPlaidGravel = new BlockPlaidGravel();
		blockPlaidCobble = new BlockPlaidCobblestone();
		blockPlaidStone = new BlockPlaidStone();
		blockPlaidDirt = new BlockPlaidDirt();
		blockPlaidStoneBrick = new BlockPlaidStoneBrick();
		blockPlaidGlass = new BlockPlaidGlass();

		Block[] stoneBlocks = {blockPlaidStone, blockPlaidCobble, blockPlaidStoneBrick};
		Block[] woodBlocks = {blockPlaidPlank};
		Block[] logBlocks = {blockPlaidLog, blockPlaidLog, blockPlaidLog, blockPlaidLog, Blocks.log, Blocks.log, Blocks.log, Blocks.log};
		int[] logsMeta = {0, 1, 2, 3, 0, 1, 2, 3};
		Block[] redstone = {Blocks.redstone_block};
		Block[] water = {Blocks.water};
		Block[] lava = {Blocks.lava};
		Block[] silverfish = {Blocks.monster_egg, Blocks.mossy_cobblestone};

		blockStoneSlab = new BlockStuffSlab(false, stoneBlocks);
		blockStoneDoubleSlab = new BlockStuffSlab(true, stoneBlocks);
		blockWoodSlab = new BlockStuffSlab(false, woodBlocks);
		blockWoodDoubleSlab = new BlockStuffSlab(true, woodBlocks);
		blockLogSlab = new BlockStuffSlab(false, logBlocks, false, logsMeta);
		blockLogDoubleSlab = new BlockStuffSlab(true, logBlocks, false, logsMeta);
		blockRedstoneSlab = new BlockRedstoneStuffSlab(false, redstone, false, null);
		blockRedstoneDoubleSlab = new BlockRedstoneStuffSlab(true, redstone, false, null);
		blockWaterSlab = new BlockFluidStuffSlab(false, water, false, null);
		blockWaterDoubleSlab = new BlockFluidStuffSlab(true, water, false, null);
		blockLavaSlab = new BlockLavaStuffSlab(false, lava, false, null);
		blockLavaDoubleSlab = new BlockLavaStuffSlab(true, lava, false, null);
		blockSilverfishSlab = new BlockSilverfishStuffSlab(false, silverfish, false, null);
		blockSilverfishDoubleSlab = new BlockSilverfishStuffSlab(true, silverfish, false, null);

		blockPlaidStoneStairs = new BlockStuffStairs(blockPlaidStone);
		blockPlaidCobblestoneStairs = new BlockStuffStairs(blockPlaidCobble);
		blockPlaidStoneBrickStairs = new BlockStuffStairs(blockPlaidStoneBrick);
		blockPlaidPlankStairs = new BlockStuffStairs(blockPlaidPlank);

		blockBluePlaidLogStairs = new BlockStuffStairs(blockPlaidLog, 0, false);
		blockGreenPlaidLogStairs = new BlockStuffStairs(blockPlaidLog, 1, false);
		blockRedPlaidLogStairs = new BlockStuffStairs(blockPlaidLog, 2, false);
		blockWhitePlaidLogStairs = new BlockStuffStairs(blockPlaidLog, 3, false);

		blockOakLogStairs = new BlockStuffStairs(Blocks.log, 0, false);
		blockSpruceLogStairs = new BlockStuffStairs(Blocks.log, 1, false);
		blockBirchLogStairs = new BlockStuffStairs(Blocks.log, 2, false);
		blockJungleLogStairs = new BlockStuffStairs(Blocks.log, 3, false);

		blockWaterStairs = new BlockFluidStuffStairs(Blocks.water, 0, false);
		blockLavaStairs = new BlockLavaStuffStairs(Blocks.lava, 0, false);
		blockRedstoneStairs = new BlockRedstoneStuffStairs(Blocks.redstone_block, 0, false);
		blockSilverfishStairs = new BlockSilverfishStuffStairs(Blocks.monster_egg, 0, false);
		blockIronOreStairs = new BlockStuffStairs(Blocks.iron_ore);

		blockWaterDoor = new BlockFluidStuffDoor(Blocks.water, 0, false);
		blockLavaDoor = new BlockLavaStuffDoor(Blocks.lava, 0, false);
		blockDiamondDoor = new BlockStuffDoor(Blocks.diamond_block);
		blockIronOreDoor = new BlockStuffDoor(Blocks.iron_ore);
		blockPlaidPlankDoor = new BlockStuffDoor(blockPlaidPlank, 0, true);

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

		// register slabs
		ItemStuffSlab.setSlabs(blockStoneSlab, blockStoneDoubleSlab);
		GameRegistry.registerBlock(blockStoneSlab, ItemStuffSlab.class, BlockInfo.STONE_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockStoneDoubleSlab, ItemStuffSlab.class, BlockInfo.STONE_SLAB_DOUBLE_UNLOCALIZED_NAME);

		ItemStuffSlab.setSlabs(blockWoodSlab, blockWoodDoubleSlab);
		GameRegistry.registerBlock(blockWoodSlab, ItemStuffSlab.class, BlockInfo.WOOD_SLAB_UNLOCALIZED_NAME);
		GameRegistry.registerBlock(blockWoodDoubleSlab, ItemStuffSlab.class, BlockInfo.WOOD_SLAB_DOUBLE_UNLOCALIZED_NAME);

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
		ItemStuffDoor.setDoor(blockWaterDoor);
		GameRegistry.registerBlock(blockWaterDoor, ItemStuffDoor.class, BlockInfo.WATER_DOOR_UNLOCALIZED_NAME);

		ItemStuffDoor.setDoor(blockLavaDoor);
		GameRegistry.registerBlock(blockLavaDoor, ItemStuffDoor.class, BlockInfo.LAVA_DOOR_UNLOCALIZED_NAME);

		ItemStuffDoor.setDoor(blockDiamondDoor);
		GameRegistry.registerBlock(blockDiamondDoor, ItemStuffDoor.class, BlockInfo.DIAMOND_DOOR_UNLOCALIZED_NAME);

		ItemStuffDoor.setDoor(blockIronOreDoor);
		GameRegistry.registerBlock(blockIronOreDoor, ItemStuffDoor.class, BlockInfo.IRON_ORE_DOOR_UNLOCALIZED_NAME);

		ItemStuffDoor.setDoor(blockPlaidPlankDoor);
		GameRegistry.registerBlock(blockPlaidPlankDoor, ItemStuffDoor.class, BlockInfo.PLAID_PLANK_DOOR_UNLOCALIZED_NAME);
	}

	public static void addNames()
	{
		//		LanguageRegistry.addName(blockPlaidPlank, BlockInfo.PLAID_PLANK_NAME);
		//		LanguageRegistry.addName(blockPlaidLog, BlockInfo.PLAID_LOG_NAME);
		//		LanguageRegistry.addName(blockPlaidSapling, BlockInfo.PLAID_SAPLING_NAME);
		//		LanguageRegistry.addName(blockPlaidGrass, BlockInfo.PLAID_GRASS_NAME);
		//		LanguageRegistry.addName(blockPlaidLeaves, BlockInfo.PLAID_LEAVES_NAME);
		//		LanguageRegistry.addName(blockPlaidTallGrass, BlockInfo.PLAID_TALL_GRASS_NAME);
		//
		//		LanguageRegistry.addName(blockPlaidSand, BlockInfo.PLAID_SAND_NAME);
		//		LanguageRegistry.addName(blockPlaidGravel, BlockInfo.PLAID_GRAVEL_NAME);
		//		LanguageRegistry.addName(blockPlaidCobble, BlockInfo.PLAID_COBBLESTONE_NAME);
		//		LanguageRegistry.addName(blockPlaidStone, BlockInfo.PLAID_STONE_NAME);
		//		LanguageRegistry.addName(blockPlaidDirt, BlockInfo.PLAID_DIRT_NAME);
		//		LanguageRegistry.addName(blockPlaidStoneBrick, BlockInfo.PLAID_STONE_BRICK_NAME);
		//		LanguageRegistry.addName(blockPlaidGlass, BlockInfo.PLAID_GLASS_NAME);
		//
		//		LanguageRegistry.addName(blockPlaidStoneStairs, BlockInfo.PLAID_STONE_STAIRS_NAME);
		//		LanguageRegistry.addName(blockPlaidCobblestoneStairs, BlockInfo.PLAID_COBBLESTONE_STAIRS_NAME);
		//		LanguageRegistry.addName(blockPlaidStoneBrickStairs, BlockInfo.PLAID_STONE_BRICK_STAIRS_NAME);
		//		LanguageRegistry.addName(blockPlaidPlankStairs, BlockInfo.PLAID_PLANK_NAME);
	}

	public static void registerRecipes()
	{

	}

	public static void registerTileEntities()
	{

	}
}
