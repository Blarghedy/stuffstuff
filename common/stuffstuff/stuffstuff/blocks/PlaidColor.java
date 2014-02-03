package stuffstuff.stuffstuff.blocks;

public enum PlaidColor
{
	BLUE, GREEN, RED, WHITE;

	/**
	 * Function used to determine which {@link PlaidColor} to use at position (x, y, z)
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @return {@link PlaidColor} to use for pos x y z
	 */
	public static PlaidColor getPlaidColorFromPos(int x, int y, int z)
	{
		// This whole thing is an odd way to figure out which plaid icon to use.
		int xmod = Math.abs(x % 64);
		int zmod = Math.abs(z % 64);

		if (xmod == 0 || zmod == 0)
			return RED;
		else if (xmod == 32 || zmod == 32)
			return WHITE;
		else if ((xmod <= 17 || xmod >= 46) && (zmod <= 13 || zmod >= 51))
			return GREEN;
		else if (xmod >= 18 && xmod <= 45 && zmod >= 14 && zmod <= 50)
			return BLUE;
		else if (xmod % 2 == zmod % 2)
			return GREEN;
		else
			return BLUE;
	}
}
