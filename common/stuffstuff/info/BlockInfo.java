package stuffstuff.info;

public class BlockInfo
{
	public static final String TEXTURE_LOCATION = "stuffstuff";
	
	public static int PLACER_ID;
	public static final String PLACER_KEY = "blockPlacer";
	public static final int PLACER_DEFAULT = 3333;
	
	public static final String PLACER_UNLOCALIZED_NAME = "blockBlockPlacer";
	public static final String PLACER_NAME = "Block Placer";
	public static final String PLACER_FACING = "blockPlacerFacing";
	public static final String PLACER_SIDES = "blockPlacerSides";
	public static final String PLACER_TOP = "blockPlacerTop";

	public static int PLAID_PLANK_ID;
	public static final int PLAID_PLANK_DEFAULT = 3334;
	public static final String PLAID_PLANK_KEY = "plankPlaid";
	public static final String PLAID_PLANK_NAME = "Plaid Plank";
	public static final String PLAID_PLANK_UNLOCALIZED_NAME = "plankPlaid";
	public static final String[][] PLAID_PLANK_TEXTURES;
	
	public static final int PLAID_HEIGHT = 4;
	public static final int PLAID_WIDTH = 4;

	public static int PLAID_LOG_ID;
	public static final int PLAID_LOG_DEFAULT = 3335;
	public static final String PLAID_LOG_KEY = "logPlaid";
	public static final String PLAID_LOG_NAME = "Plaid Log";
	public static final String PLAID_LOG_UNLOCALIZED_NAME = "logPlaid";
	public static final String[] PLAID_LOG_TEXTURES = {"log_plaid_blue", "log_plaid_green", "log_plaid_red", "log_plaid_white"};// I guess this isn't compatible with RotatableColumn,  "log_plaid_red_green"};
	public static final String PLAID_LOG_TOP_TEXTURE = "log_plaid_top";

	public static int PLAID_SAPLING_ID;
	public static final int PLAID_SAPLING_DEFAULT = 3336;
	public static final String PLAID_SAPLING_KEY = "saplingPlaid";
	public static final String PLAID_SAPLING_NAME = "Plaid Sapling";
	public static final String PLAID_SAPLING_UNLOCALIZED_NAME = "saplingPlaid";
	public static final String[] PLAID_SAPLING_TEXTURES = {"sapling_plaid"};

	public static int PLAID_GRASS_ID;
	public static final int PLAID_GRASS_DEFAULT = 200;
	public static final String PLAID_GRASS_KEY = "grassPlaid";
	public static final String PLAID_GRASS_NAME = "Plaid Grass";
	public static final String PLAID_GRASS_UNLOCALIZED_NAME = "grassPlaid";
	public static final String[] PLAID_GRASS_TOP_TEXTURES = {"grass_plaid_blue", "grass_plaid_green", "grass_plaid_red", "grass_plaid_white"};
	public static final String[] PLAID_GRASS_SIDE_TEXTURES = {"grass_plaid_side_blue", "grass_plaid_side_green", "grass_plaid_side_red", "grass_plaid_side_white"};

	public static int PLAID_LEAVES_ID;
	public static final int PLAID_LEAVES_DEFAULT = 201;
	public static final String PLAID_LEAVES_KEY = "leavesPlaid";
	public static final String PLAID_LEAVES_NAME = "Plaid Leaves";
	public static final String PLAID_LEAVES_UNLOCALIZED_NAME = "leavesPlaid";
	public static final String[] PLAID_LEAVES_TEXTURES = {"leaves_plaid_blue", "leaves_plaid_green", "leaves_plaid_red", "leaves_plaid_white"};
	public static final String[] PLAID_OPAQUE_LEAVES_TEXTURES = {"leaves_plaid_opaque_blue", "leaves_plaid_opaque_green", "leaves_plaid_opaque_red", "leaves_plaid_opaque_white"};
	
	static
	{
		PLAID_PLANK_TEXTURES = new String[PLAID_HEIGHT][];
		
		for (int i = 0; i < PLAID_HEIGHT; i++)
		{
			PLAID_PLANK_TEXTURES[i] = new String[PLAID_WIDTH];
			
			for (int j = 0; j < PLAID_WIDTH; j++)
			{
				PLAID_PLANK_TEXTURES[i][j] = "plank_plaid_" + i + "_" + j;
			}
		}
	}
}

