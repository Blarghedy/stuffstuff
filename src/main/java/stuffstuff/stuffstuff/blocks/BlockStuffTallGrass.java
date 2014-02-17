package stuffstuff.stuffstuff.blocks;

import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockStuffTallGrass extends BlockStuffTallGrassBase
{
	public BlockStuffTallGrass()
	{
		setCreativeTab(StuffStuff.tabStuffStuff);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.TALL_GRASS_UNLOCALIZED_NAME;
	}

}
