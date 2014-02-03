package stuffstuff.aestuff.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import stuffstuff.aestuff.AEStuff;
import stuffstuff.aestuff.info.BlockInfo;

public class BlockFunFluix extends Block
{
	private Icon fun, sliding;
	private static final int FUN_META = 0, SLIDING_META = 1;

	public BlockFunFluix(int id)
	{
		super(id, Material.rock);
		setCreativeTab(AEStuff.tabAEStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(BlockInfo.FUN_FLUIX_UNLOCALIZED_NAME);
		setLightValue(1);
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		fun = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.FUN_FLUIX_TEXTURE);
		sliding = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.FUN_FLUIX_SLIDING_TEXTURE);
	}

	@Override
	public Icon getIcon(int side, int meta)
	{
		return meta == FUN_META ? fun : sliding;
	}

	@Override
	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5)
	{
		return super.getBlockTexture(par1iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(this, 1, FUN_META));
		list.add(new ItemStack(this, 1, SLIDING_META));
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}

}
