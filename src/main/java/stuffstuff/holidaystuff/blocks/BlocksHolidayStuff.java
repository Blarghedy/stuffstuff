package stuffstuff.holidaystuff.blocks;

import net.minecraft.block.Block;
import stuffstuff.holidaystuff.blocks.halloween.BlockHalloweenDirt;
import stuffstuff.holidaystuff.blocks.halloween.BlockHalloweenGrass;
import stuffstuff.holidaystuff.blocks.halloween.BlockHalloweenLog;
import stuffstuff.holidaystuff.blocks.halloween.BlockHalloweenSapling;
import stuffstuff.holidaystuff.info.BlockInfo;
import stuffstuff.stuffstuff.blocks.items.ItemStuffLog;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksHolidayStuff
{
	public static Block blockHalloweenDirt;
	public static Block blockHalloweenGrass;
	public static Block blockHalloweenLog;
	public static Block blockHalloweenPlank;
	public static Block blockHalloweenSapling;

	public static void init()
	{
		blockHalloweenDirt = new BlockHalloweenDirt();
		blockHalloweenGrass = new BlockHalloweenGrass();
		blockHalloweenLog = new BlockHalloweenLog();
		blockHalloweenSapling = new BlockHalloweenSapling();

		GameRegistry.registerBlock(blockHalloweenDirt, BlockInfo.HALLOWEEN_DIRT_NAME);
		GameRegistry.registerBlock(blockHalloweenGrass, BlockInfo.HALLOWEEN_GRASS_NAME);
		GameRegistry.registerBlock(blockHalloweenLog, ItemStuffLog.class, BlockInfo.HALLOWEEN_LOG_NAME);
		GameRegistry.registerBlock(blockHalloweenSapling, BlockInfo.HALLOWEEN_SAPLING_NAME);
	}

	public static void registerTileEntities()
	{

	}

	public static void addNames()
	{

	}
}
