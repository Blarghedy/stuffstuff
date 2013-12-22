package stuffstuff.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import stuffstuff.blocks.items.ItemPlaidLeaves;
import stuffstuff.blocks.items.ItemPlaidLog;
import stuffstuff.config.ConfigHandler;
import stuffstuff.info.BlockInfo;
import stuffstuff.info.ItemInfo;
import net.minecraft.block.Block;

public class Blocks
{
//	public static Block blockBlockPlacer;
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
	
	public static void init()
    {
//	    blockBlockPlacer = new BlockBlockPlacer(BlockInfo.BLOCK_PLACER_ID);
	    blockPlaidPlank = new BlockPlaidPlank(BlockInfo.PLAID_PLANK_ID);
	    blockPlaidLog = new BlockPlaidLog(BlockInfo.PLAID_LOG_ID);
	    blockPlaidSapling = new BlockPlaidSapling(BlockInfo.PLAID_SAPLING_ID);
	    blockPlaidGrass = new BlockPlaidGrass(BlockInfo.PLAID_GRASS_ID);
	    blockPlaidLeaves = new BlockPlaidLeaves(BlockInfo.PLAID_LEAVES_ID);
	    
	    blockPlaidSand = new BlockPlaidSand(BlockInfo.PLAID_SAND_ID);
	    blockPlaidGravel = new BlockPlaidGravel(BlockInfo.PLAID_GRAVEL_ID);
	    blockPlaidCobble = new BlockPlaidCobblestone(BlockInfo.PLAID_COBBLESTONE_ID);
	    blockPlaidStone = new BlockPlaidStone(BlockInfo.PLAID_STONE_ID);
	    blockPlaidDirt = new BlockPlaidDirt(BlockInfo.PLAID_DIRT_ID);
	    
//		GameRegistry.registerBlock(blockBlockPlacer, BlockInfo.BLOCK_PLACER_NAME);
		GameRegistry.registerBlock(blockPlaidPlank, BlockInfo.PLAID_PLANK_NAME);
		GameRegistry.registerBlock(blockPlaidLog, ItemPlaidLog.class, BlockInfo.PLAID_LOG_NAME);
		GameRegistry.registerBlock(blockPlaidSapling, BlockInfo.PLAID_SAPLING_NAME);
		GameRegistry.registerBlock(blockPlaidGrass, BlockInfo.PLAID_GRASS_NAME);
		GameRegistry.registerBlock(blockPlaidLeaves, ItemPlaidLeaves.class, BlockInfo.PLAID_LEAVES_NAME);
		
		GameRegistry.registerBlock(blockPlaidSand, BlockInfo.PLAID_SAND_NAME);
		GameRegistry.registerBlock(blockPlaidGravel, BlockInfo.PLAID_GRAVEL_NAME);
		GameRegistry.registerBlock(blockPlaidCobble, BlockInfo.PLAID_COBBLESTONE_NAME);
		GameRegistry.registerBlock(blockPlaidStone, BlockInfo.PLAID_STONE_NAME);
		GameRegistry.registerBlock(blockPlaidDirt, BlockInfo.PLAID_DIRT_NAME);
		
	}
	
	public static void addNames()
	{
//		LanguageRegistry.addName(blockBlockPlacer, BlockInfo.BLOCK_PLACER_NAME);
		LanguageRegistry.addName(blockPlaidPlank, BlockInfo.PLAID_PLANK_NAME);
		LanguageRegistry.addName(blockPlaidLog, BlockInfo.PLAID_LOG_NAME);
		LanguageRegistry.addName(blockPlaidSapling, BlockInfo.PLAID_SAPLING_NAME);
		LanguageRegistry.addName(blockPlaidGrass, BlockInfo.PLAID_GRASS_NAME);
		LanguageRegistry.addName(blockPlaidLeaves, BlockInfo.PLAID_LEAVES_NAME);
		
		LanguageRegistry.addName(blockPlaidSand, BlockInfo.PLAID_SAND_NAME);
		LanguageRegistry.addName(blockPlaidGravel, BlockInfo.PLAID_GRAVEL_NAME);
		LanguageRegistry.addName(blockPlaidCobble, BlockInfo.PLAID_COBBLESTONE_NAME);
		LanguageRegistry.addName(blockPlaidStone, BlockInfo.PLAID_STONE_NAME);
		LanguageRegistry.addName(blockPlaidDirt, BlockInfo.PLAID_DIRT_NAME);
	}

	
	public static void registerRecipes()
	{
		
	}

	public static void registerTileEntities()
    {
	    
    }
}
