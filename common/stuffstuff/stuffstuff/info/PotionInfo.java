package stuffstuff.stuffstuff.info;

public class PotionInfo
{
	public static final String POTION_CATEGORY = "Potions";
	public static final String ICON_TEXTURE_LOCATION = "stuffstuff:textures/gui/potion_effects.png";
	public static final String TEXTURE_LOCATION = "stuffstuff";

	public static int PLAID_ID;
	public static final int PLAID_DEFAULT = 50;
	public static final String PLAID_NAME = "Plaid Potion";
	public static final String PLAID_POTION_NAME = "Plaid Vision";
	public static final String PLAID_KEY = "potionPlaid";
	public static final String PLAID_UNLOCALIZED_NAME = "potionPlaid";
	public static final String PLAID_OVERLAY_TEXTURE = "stuffstuff:textures/effects/plaid_potion.png";

	public static final String[] PLAID_CUBE_TEXTURES = {"blue", "green", "red", "white"};
	public static int CUBE_DENSITY;
	public static int CUBE_DISTANCE;
	public static final int CUBE_DENSITY_DEFAULT = 2;
	public static final int CUBE_DISTANCE_DEFAULT = 20;
	public static final String CUBE_DENSITY_KEY = "Plaid vision effect density (default to " + CUBE_DENSITY_DEFAULT + ")";
	public static final String CUBE_DISTANCE_KEY = "Plaid vision render distance (default to " + CUBE_DISTANCE_DEFAULT + ")";

	static{
		for (int i = 0; i < PLAID_CUBE_TEXTURES.length; i++)
		{
			PLAID_CUBE_TEXTURES[i] = "stuffstuff:textures/effects/plaid_cube_" + PLAID_CUBE_TEXTURES[i] + ".png";
		}
	}
}
