package stuffstuff.config;

import java.io.File;

import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import stuffstuff.info.ItemInfo;
import net.minecraftforge.common.Configuration;

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
			ItemInfo.BLOCK_PLACER_MAX_PER_TICK = config.get(ItemInfo.BLOCK_PLACER_CATEGORY, ItemInfo.BLOCK_PLACER_MAX_PER_TICK_KEY, ItemInfo.BLOCK_PLACER_MAX_PER_TICK_DEFAULT).getInt();
			
			BlockInfo.PLACER_ID = config.getBlock(BlockInfo.PLACER_KEY, BlockInfo.PLACER_DEFAULT).getInt();
			BlockInfo.PLAID_PLANK_ID = config.getBlock(BlockInfo.PLAID_PLANK_KEY, BlockInfo.PLAID_PLANK_DEFAULT).getInt();
			BlockInfo.PLAID_LOG_ID = config.getBlock(BlockInfo.PLAID_LOG_KEY, BlockInfo.PLAID_LOG_DEFAULT).getInt();
			BlockInfo.PLAID_SAPLING_ID = config.getBlock(BlockInfo.PLAID_SAPLING_KEY, BlockInfo.PLAID_SAPLING_DEFAULT).getInt();
			BlockInfo.PLAID_GRASS_ID = config.getBlock(BlockInfo.PLAID_GRASS_KEY, BlockInfo.PLAID_GRASS_DEFAULT).getInt();
			BlockInfo.PLAID_LEAVES_ID = config.getBlock(BlockInfo.PLAID_LEAVES_KEY, BlockInfo.PLAID_LEAVES_DEFAULT).getInt();
			
			MiscConfig.PLAY_SOUNDS = config.get(MiscConfig.MISC_CONFIG_CATEGORY, MiscConfig.PLAY_SOUNDS_KEY, MiscConfig.PLAY_SOUNDS_DEFAULT).getBoolean(MiscConfig.PLAY_SOUNDS_DEFAULT);
			
			// do keybinding stuff yay
			StuffStuff.proxy.setKeyBinding(MiscConfig.KEYBINDING_CHARGE, config.get(MiscConfig.CATEGORY_KEYBINDINGS, MiscConfig.KEYBINDING_CHARGE, MiscConfig.KEYBINDING_CHARGE_DEFAULT).getInt(MiscConfig.KEYBINDING_CHARGE_DEFAULT));
			StuffStuff.proxy.setKeyBinding(MiscConfig.KEYBINDING_TOGGLE, config.get(MiscConfig.CATEGORY_KEYBINDINGS, MiscConfig.KEYBINDING_TOGGLE, MiscConfig.KEYBINDING_TOGGLE_DEFAULT).getInt(MiscConfig.KEYBINDING_TOGGLE_DEFAULT));
			StuffStuff.proxy.setKeyBinding(MiscConfig.KEYBINDING_EXTRA, config.get(MiscConfig.CATEGORY_KEYBINDINGS, MiscConfig.KEYBINDING_CHARGE, MiscConfig.KEYBINDING_CHARGE_DEFAULT).getInt(MiscConfig.KEYBINDING_EXTRA_DEFAULT));
		}
		finally
		{
			if (config != null)
				config.save();
		}
	}
}
