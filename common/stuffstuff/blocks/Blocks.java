package stuffstuff.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
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
	
	public static void init()
    {
//	    blockBlockPlacer = new BlockBlockPlacer(BlockInfo.BLOCK_PLACER_ID);
	    blockPlaidPlank = new BlockPlaidPlank(BlockInfo.BLOCK_PLAID_PLANK_ID);
	    blockPlaidLog = new BlockPlaidLog(BlockInfo.BLOCK_PLAID_LOG_ID);
	    blockPlaidSapling = new BlockPlaidSapling(BlockInfo.BLOCK_PLAID_SAPLING_ID);
	    blockPlaidGrass = new BlockPlaidGrass(BlockInfo.BLOCK_PLAID_GRASS_ID);
	    
//		GameRegistry.registerBlock(blockBlockPlacer, BlockInfo.BLOCK_PLACER_NAME);
		GameRegistry.registerBlock(blockPlaidPlank, BlockInfo.BLOCK_PLAID_PLANK_NAME);
		GameRegistry.registerBlock(blockPlaidLog, ItemPlaidLog.class, BlockInfo.BLOCK_PLAID_LOG_NAME);
		GameRegistry.registerBlock(blockPlaidSapling, BlockInfo.BLOCK_PLAID_SAPLING_NAME);
		GameRegistry.registerBlock(blockPlaidGrass, BlockInfo.BLOCK_PLAID_GRASS_NAME);
	}
	
	public static void addNames()
	{
//		LanguageRegistry.addName(blockBlockPlacer, BlockInfo.BLOCK_PLACER_NAME);
		LanguageRegistry.addName(blockPlaidPlank, BlockInfo.BLOCK_PLAID_PLANK_NAME);
		LanguageRegistry.addName(blockPlaidLog, BlockInfo.BLOCK_PLAID_LOG_NAME);
		LanguageRegistry.addName(blockPlaidSapling, BlockInfo.BLOCK_PLAID_SAPLING_NAME);
		LanguageRegistry.addName(blockPlaidGrass, BlockInfo.BLOCK_PLAID_GRASS_NAME);
	}

	
	public static void registerRecipes()
	{
		
	}

	public static void registerTileEntities()
    {
	    
    }
}
