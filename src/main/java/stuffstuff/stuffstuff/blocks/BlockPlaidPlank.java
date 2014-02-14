package stuffstuff.stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidPlank extends Block
{
	private IIcon[][] icons;

	public BlockPlaidPlank()
	{
		super(Material.wood);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(2F);
		setStepSound(soundTypeWood);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.PLAID_PLANK_UNLOCALIZED_NAME;
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 20;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return icons[0][0];
	}

	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		ForgeDirection face = ForgeDirection.getOrientation(side);
		int modx;
		int mody;
		int modz;
		modx = x % 4 < 0 ? 4 + x % 4 : x % 4;
		mody = y % 4 < 0 ? 4 + y % 4 : y % 4;
		modz = z % 4 < 0 ? 4 + z % 4 : z % 4;

		switch (face)
		{
			case NORTH: // x y
				return icons[3 - modx][3 - mody];
			case SOUTH:
				return icons[modx][3 - mody];
			case EAST: // y z
				return icons[3 - modz][3 - mody];
			case WEST:
				return icons[modz][3 - mody];
			case UP:
			case DOWN:
				return icons[modx][modz];

			case UNKNOWN:
			default:
				return icons[0][0];
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		icons = new IIcon[BlockInfo.PLAID_HEIGHT][];
		for (int i = 0; i < BlockInfo.PLAID_HEIGHT; i++)
		{
			icons[i] = new IIcon[BlockInfo.PLAID_WIDTH];

			for (int j = 0; j < BlockInfo.PLAID_WIDTH; j++)
			{
				icons[i][j] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_PLANK_TEXTURES[i][j]);
			}
		}
	}
}
