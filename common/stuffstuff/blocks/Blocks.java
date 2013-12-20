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
	
	public static void init()
    {
//	    blockBlockPlacer = new BlockBlockPlacer(BlockInfo.BLOCK_PLACER_ID);
	    blockPlaidPlank = new BlockPlaidPlank(BlockInfo.PLAID_PLANK_ID);
	    blockPlaidLog = new BlockPlaidLog(BlockInfo.PLAID_LOG_ID);
	    blockPlaidSapling = new BlockPlaidSapling(BlockInfo.PLAID_SAPLING_ID);
	    blockPlaidGrass = new BlockPlaidGrass(BlockInfo.PLAID_GRASS_ID);
	    blockPlaidLeaves = new BlockPlaidLeaves(BlockInfo.PLAID_LEAVES_ID);
	    
//		GameRegistry.registerBlock(blockBlockPlacer, BlockInfo.BLOCK_PLACER_NAME);
		GameRegistry.registerBlock(blockPlaidPlank, BlockInfo.PLAID_PLANK_NAME);
		GameRegistry.registerBlock(blockPlaidLog, ItemPlaidLog.class, BlockInfo.PLAID_LOG_NAME);
		GameRegistry.registerBlock(blockPlaidSapling, BlockInfo.PLAID_SAPLING_NAME);
		GameRegistry.registerBlock(blockPlaidGrass, BlockInfo.PLAID_GRASS_NAME);
		GameRegistry.registerBlock(blockPlaidLeaves, ItemPlaidLeaves.class, BlockInfo.PLAID_LEAVES_NAME);
	}
	
	public static void addNames()
	{
//		LanguageRegistry.addName(blockBlockPlacer, BlockInfo.BLOCK_PLACER_NAME);
		LanguageRegistry.addName(blockPlaidPlank, BlockInfo.PLAID_PLANK_NAME);
		LanguageRegistry.addName(blockPlaidLog, BlockInfo.PLAID_LOG_NAME);
		LanguageRegistry.addName(blockPlaidSapling, BlockInfo.PLAID_SAPLING_NAME);
		LanguageRegistry.addName(blockPlaidGrass, BlockInfo.PLAID_GRASS_NAME);
		LanguageRegistry.addName(blockPlaidLeaves, BlockInfo.PLAID_LEAVES_NAME);
	}

	
	public static void registerRecipes()
	{
		
	}

	public static void registerTileEntities()
    {
	    
    }
}
