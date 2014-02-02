package stuffstuff.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import stuffstuff.StuffStuff;
import stuffstuff.info.AchievementInfo;
import stuffstuff.info.BlockInfo;
import stuffstuff.info.FluidInfo;
import stuffstuff.info.ItemInfo;
import stuffstuff.info.PotionInfo;

public class ConfigHandler
{

	public static void init(File file)
	{
		Configuration config = null;
		try
		{
			config = new Configuration(file);
			config.load();

			ItemInfo.FLUID_SMOOTHER_ID = config.getItem(ItemInfo.FLUID_SMOOTHER_KEY, ItemInfo.FLUID_SMOOTHER_DEFAULT).getInt();
			ItemInfo.FLUID_CLEANER_ID = config.getItem(ItemInfo.FLUID_CLEANER_KEY, ItemInfo.FLUID_CLEANER_DEFAULT).getInt();
			ItemInfo.BLOCK_PLACER_ID = config.getItem(ItemInfo.BLOCK_PLACER_KEY, ItemInfo.BLOCK_PLACER_DEFAULT).getInt();
			ItemInfo.BUCKET_PLAID_ID = config.getItem(ItemInfo.BUCKET_PLAID_KEY, ItemInfo.BUCKET_PLAID_DEFAULT).getInt();

			ItemInfo.BLOCK_PLACER_MAX_PER_TICK = config.get(ItemInfo.BLOCK_PLACER_CATEGORY, ItemInfo.BLOCK_PLACER_MAX_PER_TICK_KEY, ItemInfo.BLOCK_PLACER_MAX_PER_TICK_DEFAULT).getInt();

			BlockInfo.PLACER_ID = config.getBlock(BlockInfo.PLACER_KEY, BlockInfo.PLACER_DEFAULT).getInt();
			BlockInfo.PLAID_PLANK_ID = config.getBlock(BlockInfo.PLAID_PLANK_KEY, BlockInfo.PLAID_PLANK_DEFAULT).getInt();
			BlockInfo.PLAID_LOG_ID = config.getBlock(BlockInfo.PLAID_LOG_KEY, BlockInfo.PLAID_LOG_DEFAULT).getInt();
			BlockInfo.PLAID_SAPLING_ID = config.getBlock(BlockInfo.PLAID_SAPLING_KEY, BlockInfo.PLAID_SAPLING_DEFAULT).getInt();
			BlockInfo.PLAID_GRASS_ID = config.getBlock(BlockInfo.PLAID_GRASS_KEY, BlockInfo.PLAID_GRASS_DEFAULT).getInt();
			BlockInfo.PLAID_LEAVES_ID = config.getBlock(BlockInfo.PLAID_LEAVES_KEY, BlockInfo.PLAID_LEAVES_DEFAULT).getInt();
			BlockInfo.PLAID_TALL_GRASS_ID = config.getBlock(BlockInfo.PLAID_TALL_GRASS_KEY, BlockInfo.PLAID_TALL_GRASS_DEFAULT).getInt();
			BlockInfo.PLAID_SAND_ID = config.getBlock(BlockInfo.PLAID_SAND_KEY, BlockInfo.PLAID_SAND_DEFAULT).getInt();
			BlockInfo.PLAID_GRAVEL_ID = config.getBlock(BlockInfo.PLAID_GRAVEL_KEY, BlockInfo.PLAID_GRAVEL_DEFAULT).getInt();
			BlockInfo.PLAID_COBBLESTONE_ID = config.getBlock(BlockInfo.PLAID_COBBLESTONE_KEY, BlockInfo.PLAID_COBBLESTONE_DEFAULT).getInt();
			BlockInfo.PLAID_STONE_ID = config.getBlock(BlockInfo.PLAID_STONE_KEY, BlockInfo.PLAID_STONE_DEFAULT).getInt();
			BlockInfo.PLAID_DIRT_ID = config.getBlock(BlockInfo.PLAID_DIRT_KEY, BlockInfo.PLAID_DIRT_DEFAULT).getInt();
			BlockInfo.PLAID_STONE_BRICK_ID  = config.getBlock(BlockInfo.PLAID_STONE_BRICK_KEY, BlockInfo.PLAID_STONE_BRICK_DEFAULT).getInt();
			BlockInfo.PLAID_GLASS_ID = config.getBlock(BlockInfo.PLAID_GLASS_KEY, BlockInfo.PLAID_GLASS_DEFAULT).getInt();

			BlockInfo.FLUIX_GLASS_ID = config.getBlock(BlockInfo.FLUIX_GLASS_KEY, BlockInfo.FLUIX_GLASS_DEFAULT).getInt();

			BlockInfo.PLAID_COBBLESTONE_STAIRS_ID = config.getBlock(BlockInfo.PLAID_COBBLESTONE_STAIRS_KEY, BlockInfo.PLAID_COBBLESTONE_STAIRS_DEFAULT).getInt();
			BlockInfo.PLAID_STONE_STAIRS_ID = config.getBlock(BlockInfo.PLAID_STONE_STAIRS_KEY, BlockInfo.PLAID_STONE_STAIRS_DEFAULT).getInt();
			BlockInfo.PLAID_STONE_BRICK_STAIRS_ID = config.getBlock(BlockInfo.PLAID_STONE_BRICK_STAIRS_KEY, BlockInfo.PLAID_STONE_BRICK_STAIRS_DEFAULT).getInt();
			BlockInfo.PLAID_PLANK_STAIRS_ID = config.getBlock(BlockInfo.PLAID_PLANK_STAIRS_KEY, BlockInfo.PLAID_PLANK_STAIRS_DEFAULT).getInt();
			BlockInfo.RED_PLAID_LOG_STAIRS_ID = config.getBlock(BlockInfo.RED_PLAID_LOG_STAIRS_KEY, BlockInfo.RED_PLAID_LOG_STAIRS_DEFAULT).getInt();
			BlockInfo.WHITE_PLAID_LOG_STAIRS_ID = config.getBlock(BlockInfo.WHITE_PLAID_LOG_STAIRS_KEY, BlockInfo.WHITE_PLAID_LOG_STAIRS_DEFAULT).getInt();
			BlockInfo.BLUE_PLAID_LOG_STAIRS_ID = config.getBlock(BlockInfo.BLUE_PLAID_LOG_STAIRS_KEY, BlockInfo.BLUE_PLAID_LOG_STAIRS_DEFAULT).getInt();
			BlockInfo.GREEN_PLAID_LOG_STAIRS_ID = config.getBlock(BlockInfo.GREEN_PLAID_LOG_STAIRS_KEY, BlockInfo.GREEN_PLAID_LOG_STAIRS_DEFAULT).getInt();
			BlockInfo.OAK_LOG_STAIRS_ID = config.getBlock(BlockInfo.OAK_LOG_STAIRS_KEY, BlockInfo.OAK_LOG_STAIRS_DEFAULT).getInt();
			BlockInfo.BIRCH_LOG_STAIRS_ID = config.getBlock(BlockInfo.BIRCH_LOG_STAIRS_KEY, BlockInfo.BIRCH_LOG_STAIRS_DEFAULT).getInt();
			BlockInfo.JUNGLE_LOG_STAIRS_ID = config.getBlock(BlockInfo.JUNGLE_LOG_STAIRS_KEY, BlockInfo.JUNGLE_LOG_STAIRS_DEFAULT).getInt();
			BlockInfo.SPRUCE_LOG_STAIRS_ID = config.getBlock(BlockInfo.SPRUCE_LOG_STAIRS_KEY, BlockInfo.SPRUCE_LOG_STAIRS_DEFAULT).getInt();

			BlockInfo.FUN_FLUIX_BRICK_STAIRS_ID = config.getBlock(BlockInfo.FUN_FLUIX_BRICK_STAIRS_KEY, BlockInfo.FUN_FLUIX_BRICK_STAIRS_DEFAULT).getInt();
			BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_ID = config.getBlock(BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_KEY, BlockInfo.RUNNING_FLUIX_BRICK_STAIRS_DEFAULT).getInt();
			BlockInfo.FLUIX_BRICK_STAIRS_ID = config.getBlock(BlockInfo.FLUIX_BRICK_STAIRS_KEY, BlockInfo.FLUIX_BRICK_STAIRS_DEFAULT).getInt();
			BlockInfo.FINE_FLUIX_BRICK_STAIRS_ID = config.getBlock(BlockInfo.FINE_FLUIX_BRICK_STAIRS_KEY, BlockInfo.FINE_FLUIX_BRICK_STAIRS_DEFAULT).getInt();
			BlockInfo.LAVA_STAIRS_ID = config.getBlock(BlockInfo.LAVA_STAIRS_KEY, BlockInfo.LAVA_STAIRS_DEFAULT).getInt();
			BlockInfo.WATER_STAIRS_ID = config.getBlock(BlockInfo.WATER_STAIRS_KEY, BlockInfo.WATER_STAIRS_DEFAULT).getInt();
			BlockInfo.REDSTONE_STAIRS_ID = config.getBlock(BlockInfo.REDSTONE_STAIRS_KEY, BlockInfo.REDSTONE_STAIRS_DEFAULT).getInt();
			BlockInfo.SILVERFISH_STAIRS_ID = config.getBlock(BlockInfo.SILVERFISH_STAIRS_KEY, BlockInfo.SILVERFISH_STAIRS_DEFAULT).getInt();
			BlockInfo.IRON_ORE_STAIRS_ID = config.getBlock(BlockInfo.IRON_ORE_STAIRS_KEY, BlockInfo.IRON_ORE_STAIRS_DEFAULT).getInt();

			BlockInfo.STONE_SLAB_ID = config.getBlock(BlockInfo.STONE_SLAB_KEY, BlockInfo.STONE_SLAB_DEFAULT).getInt();
			BlockInfo.STONE_SLAB_DOUBLE_ID = config.getBlock(BlockInfo.STONE_SLAB_DOUBLE_KEY, BlockInfo.STONE_SLAB_DOUBLE_DEFAULT).getInt();
			BlockInfo.WOOD_SLAB_ID = config.getBlock(BlockInfo.WOOD_SLAB_KEY, BlockInfo.WOOD_SLAB_DEFAULT).getInt();
			BlockInfo.WOOD_SLAB_DOUBLE_ID = config.getBlock(BlockInfo.WOOD_SLAB_DOUBLE_KEY, BlockInfo.WOOD_SLAB_DOUBLE_DEFAULT).getInt();
			BlockInfo.FLUIX_SLAB_ID = config.getBlock(BlockInfo.FLUIX_SLAB_KEY, BlockInfo.FLUIX_SLAB_DEFAULT).getInt();
			BlockInfo.FLUIX_SLAB_DOUBLE_ID = config.getBlock(BlockInfo.FLUIX_SLAB_DOUBLE_KEY, BlockInfo.FLUIX_SLAB_DOUBLE_DEFAULT).getInt();
			BlockInfo.LOG_SLAB_ID = config.getBlock(BlockInfo.LOG_SLAB_KEY, BlockInfo.LOG_SLAB_DEFAULT).getInt();
			BlockInfo.LOG_SLAB_DOUBLE_ID = config.getBlock(BlockInfo.LOG_SLAB_DOUBLE_KEY, BlockInfo.LOG_SLAB_DOUBLE_DEFAULT).getInt();
			BlockInfo.WATER_SLAB_ID = config.getBlock(BlockInfo.WATER_SLAB_KEY, BlockInfo.WATER_SLAB_DEFAULT).getInt();
			BlockInfo.WATER_SLAB_DOUBLE_ID = config.getBlock(BlockInfo.WATER_SLAB_DOUBLE_KEY, BlockInfo.WATER_SLAB_DOUBLE_DEFAULT).getInt();
			BlockInfo.LAVA_SLAB_ID = config.getBlock(BlockInfo.LAVA_SLAB_KEY, BlockInfo.LAVA_SLAB_DEFAULT).getInt();
			BlockInfo.LAVA_SLAB_DOUBLE_ID = config.getBlock(BlockInfo.LAVA_SLAB_DOUBLE_KEY, BlockInfo.LAVA_SLAB_DOUBLE_DEFAULT).getInt();
			BlockInfo.REDSTONE_SLAB_ID = config.getBlock(BlockInfo.REDSTONE_SLAB_KEY, BlockInfo.REDSTONE_SLAB_DEFAULT).getInt();
			BlockInfo.REDSTONE_SLAB_DOUBLE_ID = config.getBlock(BlockInfo.REDSTONE_SLAB_DOUBLE_KEY, BlockInfo.REDSTONE_SLAB_DOUBLE_DEFAULT).getInt();
			BlockInfo.SILVERFISH_SLAB_ID = config.getBlock(BlockInfo.SILVERFISH_SLAB_KEY, BlockInfo.SILVERFISH_SLAB_DEFAULT).getInt();
			BlockInfo.SILVERFISH_SLAB_DOUBLE_ID = config.getBlock(BlockInfo.SILVERFISH_SLAB_DOUBLE_KEY, BlockInfo.SILVERFISH_SLAB_DOUBLE_DEFAULT).getInt();

			BlockInfo.RUNNING_FLUIX_DOOR_ID = config.getBlock(BlockInfo.RUNNING_FLUIX_DOOR_KEY, BlockInfo.RUNNING_FLUIX_DOOR_DEFAULT).getInt();
			BlockInfo.WATER_DOOR_ID = config.getBlock(BlockInfo.WATER_DOOR_KEY, BlockInfo.WATER_DOOR_DEFAULT).getInt();
			BlockInfo.LAVA_DOOR_ID = config.getBlock(BlockInfo.LAVA_DOOR_KEY, BlockInfo.LAVA_DOOR_DEFAULT).getInt();
			BlockInfo.IRON_ORE_DOOR_ID = config.getBlock(BlockInfo.IRON_ORE_DOOR_KEY, BlockInfo.IRON_ORE_DOOR_DEFAULT).getInt();
			BlockInfo.DIAMOND_DOOR_ID = config.getBlock(BlockInfo.DIAMOND_DOOR_KEY, BlockInfo.DIAMOND_DOOR_DEFAULT).getInt();
			BlockInfo.PLAID_PLANK_DOOR_ID = config.getBlock(BlockInfo.PLAID_PLANK_DOOR_KEY, BlockInfo.PLAID_PLANK_DOOR_DEFAULT).getInt();

			BlockInfo.FUN_FLUIX_ID = config.getBlock(BlockInfo.FUN_FLUIX_KEY, BlockInfo.FUN_FLUIX_DEFAULT).getInt();
			BlockInfo.FLUIX_BRICK_ID = config.getBlock(BlockInfo.FLUIX_BRICK_KEY, BlockInfo.FLUIX_BRICK_DEFAULT).getInt();

			FluidInfo.PLAID_WATER_ID = config.getBlock(FluidInfo.PLAID_WATER_KEY, FluidInfo.PLAID_WATER_DEFAULT).getInt();

			PotionInfo.PLAID_ID = config.get(PotionInfo.POTION_CATEGORY, PotionInfo.PLAID_KEY, PotionInfo.PLAID_DEFAULT).getInt();
			PotionInfo.CUBE_DENSITY = config.get(PotionInfo.POTION_CATEGORY, PotionInfo.CUBE_DENSITY_KEY, PotionInfo.CUBE_DENSITY_DEFAULT).getInt();
			PotionInfo.CUBE_DISTANCE = config.get(PotionInfo.POTION_CATEGORY, PotionInfo.CUBE_DISTANCE_KEY, PotionInfo.CUBE_DISTANCE_DEFAULT).getInt();

			AchievementInfo.PLAID_BIOME_ID = config.get(AchievementInfo.ACHIEVEMENTS_CATEGORY, AchievementInfo.PLAID_BIOME_KEY, AchievementInfo.PLAID_BIOME_DEFAULT).getInt();
			AchievementInfo.PLAID_BIOME2_ID = config.get(AchievementInfo.ACHIEVEMENTS_CATEGORY, AchievementInfo.PLAID_BIOME2_KEY, AchievementInfo.PLAID_BIOME2_DEFAULT).getInt();

			MiscConfig.PLAY_SOUNDS = config.get(MiscConfig.MISC_CONFIG_CATEGORY, MiscConfig.PLAY_SOUNDS_KEY, MiscConfig.PLAY_SOUNDS_DEFAULT).getBoolean(MiscConfig.PLAY_SOUNDS_DEFAULT);

			// do keybinding stuff yay
			StuffStuff.proxy.setKeyBinding(MiscConfig.KEYBINDING_CHARGE, config.get(MiscConfig.CATEGORY_KEYBINDINGS, MiscConfig.KEYBINDING_CHARGE, MiscConfig.KEYBINDING_CHARGE_DEFAULT).getInt(MiscConfig.KEYBINDING_CHARGE_DEFAULT));
			StuffStuff.proxy.setKeyBinding(MiscConfig.KEYBINDING_TOGGLE, config.get(MiscConfig.CATEGORY_KEYBINDINGS, MiscConfig.KEYBINDING_TOGGLE, MiscConfig.KEYBINDING_TOGGLE_DEFAULT).getInt(MiscConfig.KEYBINDING_TOGGLE_DEFAULT));
			StuffStuff.proxy.setKeyBinding(MiscConfig.KEYBINDING_EXTRA, config.get(MiscConfig.CATEGORY_KEYBINDINGS, MiscConfig.KEYBINDING_CHARGE, MiscConfig.KEYBINDING_CHARGE_DEFAULT).getInt(MiscConfig.KEYBINDING_EXTRA_DEFAULT));
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
