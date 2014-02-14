package stuffstuff.aestuff.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import stuffstuff.aestuff.AEStuff;
import stuffstuff.aestuff.info.BlockInfo;

public class BlockFunFluix extends Block
{
	private IIcon fun, sliding;
	private static final int FUN_META = 0, SLIDING_META = 1;

	public BlockFunFluix()
	{
		super(Material.rock);
		setCreativeTab(AEStuff.tabAEStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundTypeStone);
		this.lightValue = 15;
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.FUN_FLUIX_UNLOCALIZED_NAME;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		fun = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.FUN_FLUIX_TEXTURE);
		sliding = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.FUN_FLUIX_SLIDING_TEXTURE);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return meta == FUN_META ? fun : sliding;
	}

	@Override
	public IIcon getIcon(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5)
	{
		return super.getIcon(par1iBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
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
