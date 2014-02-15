package stuffstuff.holidaystuff.blocks;

import net.minecraft.client.renderer.texture.IIconRegister;
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
	public void registerBlockIcons(IIconRegister register)
	{
		sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.HALLOWEEN_LOG_SIDE);
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.HALLOWEEN_LOG_TOP);
	}

}
