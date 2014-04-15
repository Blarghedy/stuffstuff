package stuffstuff.stuffstuff.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.AchievementInfo;
import stuffstuff.stuffstuff.info.ItemInfo;
import stuffstuff.stuffstuff.info.PotionInfo;

public class ConfigHandler
{

	public static void init(File file)
	{
		Configuration config = null;
		try
		{
			config = new Configuration(file);
			config.load();

			ItemInfo.BLOCK_PLACER_MAX_PER_TICK = config.get(ItemInfo.BLOCK_PLACER_CATEGORY, ItemInfo.BLOCK_PLACER_MAX_PER_TICK_KEY, ItemInfo.BLOCK_PLACER_MAX_PER_TICK_DEFAULT).getInt();

			PotionInfo.PLAID_ID = config.get(PotionInfo.POTION_CATEGORY, PotionInfo.PLAID_KEY, PotionInfo.PLAID_DEFAULT).getInt();
			PotionInfo.CUBE_DENSITY = config.get(PotionInfo.POTION_CATEGORY, PotionInfo.CUBE_DENSITY_KEY, PotionInfo.CUBE_DENSITY_DEFAULT).getInt();
			PotionInfo.CUBE_DISTANCE = config.get(PotionInfo.POTION_CATEGORY, PotionInfo.CUBE_DISTANCE_KEY, PotionInfo.CUBE_DISTANCE_DEFAULT).getInt();

			AchievementInfo.PLAID_BIOME_ID = config.get(AchievementInfo.ACHIEVEMENTS_CATEGORY, AchievementInfo.PLAID_BIOME_KEY, AchievementInfo.PLAID_BIOME_DEFAULT).getString();
			AchievementInfo.PLAID_BIOME2_ID = config.get(AchievementInfo.ACHIEVEMENTS_CATEGORY, AchievementInfo.PLAID_BIOME2_KEY, AchievementInfo.PLAID_BIOME2_DEFAULT).getString();

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
