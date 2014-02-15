package stuffstuff.stuffstuff.blocks;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidLog extends BlockStuffLog
{
	private IIcon[] icons;
	private IIcon topIcon;

	public BlockPlaidLog()
	{
		setCreativeTab(StuffStuff.tabPlaidStuff);
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
	public IIcon getTopIcon(int meta)
	{
		return topIcon;
	}

	@Override
	public IIcon getSideIcon(int meta)
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
}
