package stuffstuff.config;

public class MiscConfig
{
	public static final String MISC_CONFIG_CATEGORY = "Miscellaneous Config";

	public static final String CATEGORY_KEYBINDINGS = "key bindings";

	// charge key
	public static final String KEYBINDING_CHARGE = "key.stuffstuff-charge";
	public static final int KEYBINDING_CHARGE_DEFAULT = 47; // v key

	// Toggle key - used for modes and enable/disable
	public static final String KEYBINDING_TOGGLE = "key.stuffstuff-toggle";
	public static final int KEYBINDING_TOGGLE_DEFAULT = 34;

	// Extra key - used for GUI access and the like
	public static final String KEYBINDING_EXTRA = "key.stuffstuff-extra";
	public static final int KEYBINDING_EXTRA_DEFAULT = 46;

	public static String PLAY_SOUNDS_KEY = "Enable Sounds";
	public static boolean PLAY_SOUNDS_DEFAULT = true;
	public static boolean PLAY_SOUNDS;
}
