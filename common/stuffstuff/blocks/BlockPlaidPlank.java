package stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidPlank extends Block
{
	private Icon[][] icons;

	public BlockPlaidPlank(int id)
	{
		super(id, Material.wood);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(2F);
		setStepSound(soundWoodFootstep);
		setUnlocalizedName(BlockInfo.PLAID_PLANK_UNLOCALIZED_NAME);
		setBurnProperties(id, 5, 20);
	}

	@Override
	public Icon getIcon(int side, int meta)
	{
		return icons[0][0];
	}

	@Override
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side)
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
	public void registerIcons(IconRegister register)
	{
		icons = new Icon[BlockInfo.PLAID_HEIGHT][];
		for (int i = 0; i < BlockInfo.PLAID_HEIGHT; i++)
		{
			icons[i] = new Icon[BlockInfo.PLAID_WIDTH];

			for (int j = 0; j < BlockInfo.PLAID_WIDTH; j++)
			{
				icons[i][j] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_PLANK_TEXTURES[i][j]);
			}
		}
	}
}
