package stuffstuff.stuffstuff.items;

public enum BlockPlaceMode
{
	CREATION(0), EXTENSION(1), PILLAR(2), REPLACE(3), PROJECTION(4);

	int mode;

	BlockPlaceMode(int mode)
	{
		this.mode = mode;
	}

	public static BlockPlaceMode fromInt(int n)
	{
		switch (n)
		{
			case 0:
				return CREATION;
			case 1:
				return EXTENSION;
			case 2:
				return PILLAR;
			case 3:
				return REPLACE;
			case 4:
				return PROJECTION;
			default:
				return CREATION;
		}
	}

	public int getMode()
	{
		return mode;
	}

	public BlockPlaceMode getNext()
	{
		return fromInt((mode + 1) % 5);
	}

	public BlockPlaceMode getPrevious()
	{
		return fromInt((mode - 1) % 5);
	}

}
