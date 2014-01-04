package stuffstuff.blocks;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidGlass extends BlockGlass
{
	public BlockPlaidGlass(int id)
	{
		super(id, Material.glass, false);
		setUnlocalizedName(BlockInfo.PLAID_GLASS_UNLOCALIZED_NAME);
		setCreativeTab(StuffStuff.tabStuffStuff);
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_GLASS_TEXTURE);
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
	{
	    return super.getIcon(par1, par2);
	}
	
	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int par5)
	{
	    return super.getBlockTexture(world, x, y, z, par5);
	}
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
	
}
