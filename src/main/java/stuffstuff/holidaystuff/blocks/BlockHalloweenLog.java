package stuffstuff.holidaystuff.blocks;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stuffstuff.holidaystuff.HolidayStuff;
import stuffstuff.holidaystuff.info.BlockInfo;
import stuffstuff.stuffstuff.blocks.BlockStuffLog;

public class BlockHalloweenLog extends BlockStuffLog
{

	public BlockHalloweenLog()
	{
		setCreativeTab(HolidayStuff.tabHolidayStuff);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.HALLOWEEN_LOG_UNLOCALIZED_NAME;
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 4; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.HALLOWEEN_LOG_SIDE);
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.HALLOWEEN_LOG_TOP);
	}

}
