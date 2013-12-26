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
		setCreativeTab(StuffStuff.tabStuffStuff);
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
		x = x > 0 ? x : -x;
		y = y > 0 ? y : -y;
		z = z > 0 ? z : -z;
		
		ForgeDirection face = ForgeDirection.getOrientation(side);
		
		switch(face)
		{
			case NORTH: // x y
				return icons[3 - x%4][3 - y%4];
			case SOUTH:
				return icons[x%4][3 - y%4];
			case EAST: // y z
				return icons[3 - z%4][3 - y%4];
			case WEST:
				return icons[z%4][3 - y%4];
			case UP:
			case DOWN:
				return icons[x%4][z%4];
				
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
