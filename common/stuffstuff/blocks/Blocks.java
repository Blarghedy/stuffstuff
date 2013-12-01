package stuffstuff.blocks;

import stuffstuff.config.ConfigHandler;
import stuffstuff.info.BlockInfo;
import net.minecraft.block.Block;

public class Blocks
{
	public static Block blockBlockPlacer;

	public static void init()
    {
	    blockBlockPlacer = new BlockBlockPlacer(BlockInfo.BLOCK_PLACER_ID);
    }
	
	public static void addNames()
	{
		
	}
	
	public static void registerRecipes()
	{
		
	}

	public static void registerTileEntities()
    {
	    
    }
}
