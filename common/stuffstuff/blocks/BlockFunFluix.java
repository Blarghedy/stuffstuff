package stuffstuff.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockFunFluix extends Block
{
	private Icon fun, sliding;
	private static final int FUN_META = 0, SLIDING_META = 1;

	public BlockFunFluix(int id)
	{
		super(id, Material.rock);
		setCreativeTab(StuffStuff.tabAEStuff);
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
