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
		Configuration config = new Configuration(file);
		config.load();
		
		ItemInfo.FLUID_SMOOTHER_ID = config.getItem(ItemInfo.FLUID_SMOOTHER_KEY, ItemInfo.FLUID_SMOOTHER_DEFAULT).getInt();
		ItemInfo.FLUID_CLEANER_ID = config.getItem(ItemInfo.FLUID_CLEANER_KEY, ItemInfo.FLUID_CLEANER_DEFAULT).getInt();
		ItemInfo.BLOCK_PLACER_ID = config.getItem(ItemInfo.BLOCK_PLACER_KEY, ItemInfo.BLOCK_PLACER_DEFAULT).getInt();
		
		BlockInfo.BLOCK_PLACER_ID = config.getBlock(BlockInfo.BLOCK_PLACER_KEY, BlockInfo.BLOCK_PLACER_DEFAULT).getInt();
		
		MiscConfig.PLAY_SOUNDS = config.get(MiscConfig.MISC_CONFIG_CATEGORY, MiscConfig.PLAY_SOUNDS_KEY, MiscConfig.PLAY_SOUNDS_DEFAULT).getBoolean(MiscConfig.PLAY_SOUNDS_DEFAULT); 
		
		// do keybinding stuff yay
		StuffStuff.proxy.setKeyBinding(MiscConfig.KEYBINDING_CHARGE, config.get(MiscConfig.CATEGORY_KEYBINDINGS, MiscConfig.KEYBINDING_CHARGE, MiscConfig.KEYBINDING_CHARGE_DEFAULT).getInt(MiscConfig.KEYBINDING_CHARGE_DEFAULT));
		StuffStuff.proxy.setKeyBinding(MiscConfig.KEYBINDING_TOGGLE, config.get(MiscConfig.CATEGORY_KEYBINDINGS, MiscConfig.KEYBINDING_TOGGLE, MiscConfig.KEYBINDING_TOGGLE_DEFAULT).getInt(MiscConfig.KEYBINDING_TOGGLE_DEFAULT));
		StuffStuff.proxy.setKeyBinding(MiscConfig.KEYBINDING_EXTRA, config.get(MiscConfig.CATEGORY_KEYBINDINGS, MiscConfig.KEYBINDING_CHARGE, MiscConfig.KEYBINDING_CHARGE_DEFAULT).getInt(MiscConfig.KEYBINDING_EXTRA_DEFAULT));
		
	}
}
