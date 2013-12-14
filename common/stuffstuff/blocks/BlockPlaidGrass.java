package stuffstuff.blocks;

import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

public class BlockPlaidGrass extends Block
{
	private Icon[] sideIcons;
	private Icon[] topIcons;
	
	public BlockPlaidGrass(int id)
	{
		super(id, Material.grass);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setStepSound(soundGrassFootstep);
		setHardness(.7F);
		setUnlocalizedName(BlockInfo.BLOCK_PLAID_GRASS_UNLOCALIZED_NAME);
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		sideIcons = new Icon[BlockInfo.BLOCK_PLAID_GRASS_SIDE_TEXTURES.length];
		topIcons = new Icon[BlockInfo.BLOCK_PLAID_GRASS_TOP_TEXTURES.length];

		for (int i = 0; i < sideIcons.length; i++)
		{
			sideIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_PLAID_GRASS_SIDE_TEXTURES[i]);
		}

		for (int i = 0; i < topIcons.length; i++)
		{
			topIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_PLAID_GRASS_TOP_TEXTURES[i]);
		}
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
	    ForgeDirection face = ForgeDirection.getOrientation(side);
	    if (face == ForgeDirection.UP) return topIcons[0];
	    else return sideIcons[0]; 
	}
	
	@Override
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
	    ForgeDirection face = ForgeDirection.getOrientation(side);
	    int index = 0;

		// TODO might need to check on this for quadrants other than 1
	    // This whole thing is an odd way to figure out which plaid icon to use.
		int xmod = Math.abs(x % 64);
		int zmod = Math.abs(z % 64);
		
		if (xmod == 0 || zmod == 0)
		{
			index = 2; // red
		}
		else if (xmod == 32 || zmod == 32)
		{
			index = 3; // white
		}
		else if ((xmod <= 17 || xmod >= 46) && (zmod <= 13 || zmod >= 51))
		{
			index = 1; // green
		}
		else if ((xmod >= 18 && xmod <= 45) && (zmod >= 14 && zmod <= 50))
		{
			index = 0; // blue
		}
		else if (xmod %2 == zmod % 2)
		{
			index = 1; // green
		}
		else
		{
			index = 0; // blue
		}
		
	    switch(face)
	    {
	    	case UP:
	    		return topIcons[index];
	    	case DOWN: // just need vanilla dirt texture
	    		return Block.grass.getBlockTexture(blockAccess, x, y, z, side);
	    	default: // all 4 sides
	    		Material mat = blockAccess.getBlockMaterial(x, y + 1, z);
	    		if (mat == Material.snow || mat == Material.craftedSnow)
	    		{
	    			return Block.dirt.getBlockTexture(blockAccess, x, y, z, side);
	    		}
	    		else
	    		{
	    			return sideIcons[index];
	    		}
	    }
	}
}
