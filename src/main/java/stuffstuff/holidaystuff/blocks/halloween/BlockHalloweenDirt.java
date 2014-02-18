package stuffstuff.holidaystuff.blocks.halloween;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import stuffstuff.holidaystuff.HolidayStuff;
import stuffstuff.holidaystuff.info.BlockInfo;
import stuffstuff.stuffstuff.blocks.BlockStuffDirt;

public class BlockHalloweenDirt extends BlockStuffDirt
{
	public BlockHalloweenDirt()
	{
		setCreativeTab(HolidayStuff.tabHolidayStuff);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.HALLOWEEN_DIRT_UNLOCALIZED_NAME;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return blockIcon;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon("stuffstuff:" + BlockInfo.HALLOWEEN_DIRT_TEXTURE);
	}

}
