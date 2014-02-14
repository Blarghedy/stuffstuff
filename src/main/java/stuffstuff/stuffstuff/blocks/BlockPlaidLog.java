package stuffstuff.stuffstuff.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidLog extends BlockLog
{
	private IIcon[] icons;
	private IIcon topIcon;

	public BlockPlaidLog()
	{
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(2F);
		setStepSound(soundTypeWood);
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
	public String getUnlocalizedName()
	{
		return BlockInfo.PLAID_LOG_UNLOCALIZED_NAME;
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < BlockInfo.PLAID_LOG_TEXTURES.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return super.getIcon(side, meta); // BlockRotatedPillar takes care of this for us
	}

	@Override
	protected IIcon getTopIcon(int meta)
	{
		return topIcon;
	}

	@Override
	protected IIcon getSideIcon(int meta)
	{
		return icons[meta];
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		icons = new IIcon[BlockInfo.PLAID_LOG_TEXTURES.length];

		for (int i = 0; i < BlockInfo.PLAID_LOG_TEXTURES.length; i++)
		{
			icons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_LOG_TEXTURES[i]);
		}

		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_LOG_TOP_TEXTURE);
	}

	@Override
	public int damageDropped(int meta)
	{
		return super.damageDropped(meta);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
}
