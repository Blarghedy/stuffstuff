package stuffstuff.stuffstuff.blocks;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidGlass extends BlockGlass
{
	public BlockPlaidGlass()
	{
		super(Material.glass, false);
		setCreativeTab(StuffStuff.tabPlaidStuff);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.PLAID_GLASS_UNLOCALIZED_NAME;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_GLASS_TEXTURE);
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return super.getIcon(par1, par2);
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int par5)
	{
		return super.getIcon(world, x, y, z, par5);
	}

	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

}
