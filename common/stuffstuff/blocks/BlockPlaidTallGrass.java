package stuffstuff.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockPlaidTallGrass extends BlockTallGrass
{
	public BlockPlaidTallGrass(int id)
	{
		super(id);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setUnlocalizedName(BlockInfo.PLAID_TALL_GRASS_UNLOCALIZED_NAME);
		setStepSound(soundGrassFootstep);
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		// use the actual grass icon instead of the shrub, etc.
		return super.getIcon(par1, 1);
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
