package stuffstuff.aestuff.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import stuffstuff.aestuff.info.BlockInfo;
import stuffstuff.aestuff.info.ItemInfo;

public class ConfigHandler
{
	public static void init(File file)
	{
		Configuration config = null;
		try
		{
			config = new Configuration(file);
			config.load();

			// parts

			// items
			ItemInfo.ITEM_STUFF_PART_ID = config.getItem(ItemInfo.ITEM_STUFF_PART_KEY, ItemInfo.ITEM_STUFF_PART_DEFAULT).getInt();

			// blocks
			BlockInfo.FLUIX_GLASS_ID = config.getBlock(BlockInfo.FLUIX_GLASS_KEY, BlockInfo.FLUIX_GLASS_DEFAULT).getInt();
			BlockInfo.FUN_FLUIX_ID = config.getBlock(BlockInfo.FUN_FLUIX_KEY, BlockInfo.FUN_FLUIX_DEFAULT).getInt();
			BlockInfo.FLUIX_BRICK_ID = config.getBlock(BlockInfo.FLUIX_BRICK_KEY, BlockInfo.FLUIX_BRICK_DEFAULT).getInt();

			// stairs
			BlockInfo.FUN_FLUIX_BRICK_STAIRS_ID = config.getBlock(BlockInfo.FUN_FLUIX_BRICK_STAIRS_KEY, BlockInfo.FUN_FLUIX_BRICK_STAIRS_DEFAULT).getInt();
			BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_ID = config.getBlock(BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_KEY, BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_DEFAULT).getInt();
			BlockInfo.FLUIX_BRICK_STAIRS_ID = config.getBlock(BlockInfo.FLUIX_BRICK_STAIRS_KEY, BlockInfo.FLUIX_BRICK_STAIRS_DEFAULT).getInt();
			BlockInfo.FINE_FLUIX_BRICK_STAIRS_ID = config.getBlock(BlockInfo.FINE_FLUIX_BRICK_STAIRS_KEY, BlockInfo.FINE_FLUIX_BRICK_STAIRS_DEFAULT).getInt();
			BlockInfo.FLUIX_STAIRS_ID = config.getBlock(BlockInfo.FLUIX_STAIRS_KEY, BlockInfo.FLUIX_STAIRS_DEFAULT).getInt();

			// slabs
			BlockInfo.FLUIX_SLAB_ID = config.getBlock(BlockInfo.FLUIX_SLAB_KEY, BlockInfo.FLUIX_SLAB_DEFAULT).getInt();
			BlockInfo.FLUIX_SLAB_DOUBLE_ID = config.getBlock(BlockInfo.FLUIX_SLAB_DOUBLE_KEY, BlockInfo.FLUIX_SLAB_DOUBLE_DEFAULT).getInt();

			// doors
			BlockInfo.RUNNING_FLUIX_DOOR_ID = config.getBlock(BlockInfo.RUNNING_FLUIX_DOOR_KEY, BlockInfo.RUNNING_FLUIX_DOOR_DEFAULT).getInt();
		}
		finally
		{
			if (config != null)
			{
				config.save();
			}
		}
	}
}
