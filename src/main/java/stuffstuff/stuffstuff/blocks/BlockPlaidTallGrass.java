package stuffstuff.stuffstuff.blocks;

import net.minecraft.world.IBlockAccess;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlaidTallGrass extends BlockStuffTallGrassBase
{
	public BlockPlaidTallGrass()
	{
		setCreativeTab(StuffStuff.tabPlaidStuff);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.PLAID_TALL_GRASS_UNLOCALIZED_NAME;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getBlockColor()
	{
		return 16777215;
	}

	@Override
	public int getRenderColor(int par1)
	{
		return getBlockColor();
	}

	@Override
	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		PlaidColor color = PlaidColor.getPlaidColorFromPos(x, y, z);
		switch (color)
		{
			case RED:
				return 0x990000;
			case WHITE:
				return 0xFFFFFF;
			case BLUE:
				return 0x0000CC;
			default:
				return 0x006600;
		}
	}
}
