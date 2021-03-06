package stuffstuff.aestuff.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import stuffstuff.aestuff.AEStuff;
import stuffstuff.aestuff.info.BlockInfo;

public class BlockFluixBrick extends Block
{
	private IIcon normal, fine;
	private static final int NORMAL_META = 0, FINE_META = 1;

	public BlockFluixBrick()
	{
		super(Material.rock);
		setCreativeTab(AEStuff.tabAEStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundTypeStone);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.FLUIX_BRICK_UNLOCALIZED_NAME;
	}

	@Override
	public void getSubBlocks(Item id, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(this, 1, 0));
		list.add(new ItemStack(this, 1, 1));
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		normal = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.FLUIX_BRICK_TEXTURE);
		fine = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.FINE_FLUIX_BRICK_TEXTURE);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return meta == FINE_META ? fine : normal;
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}

}
