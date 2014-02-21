package stuffstuff.holidaystuff.blocks.halloween;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.holidaystuff.HolidayStuff;
import stuffstuff.holidaystuff.blocks.BlocksHolidayStuff;
import stuffstuff.holidaystuff.info.BlockInfo;
import stuffstuff.stuffstuff.blocks.BlockStuffGrass;

public class BlockHalloweenGrass extends BlockStuffGrass
{
	private IIcon sideIcon, topIcon, snowIcon;

	public BlockHalloweenGrass()
	{
		setCreativeTab(HolidayStuff.tabHolidayStuff);
		dirtBlock = BlocksHolidayStuff.blockHalloweenDirt;
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.HALLOWEEN_GRASS_UNLOCALIZED_NAME;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		sideIcon = register.registerIcon("stuffstuff:" + BlockInfo.HALLOWEEN_GRASS_SIDE_TEXTURE);
		snowIcon = register.registerIcon("stuffstuff:" + BlockInfo.HALLOWEEN_GRASS_SIDE_SNOW_TEXTURE);
		topIcon = register.registerIcon("stuffstuff:" + BlockInfo.HALLOWEEN_GRASS_TOP_TEXTURE);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		ForgeDirection dir = ForgeDirection.getOrientation(side);
		switch (dir)
		{
			case UP:
				return topIcon;
			case DOWN:
				return BlocksHolidayStuff.blockHalloweenDirt.getIcon(0, 0);
			default:
				return sideIcon;
		}
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		ForgeDirection dir = ForgeDirection.getOrientation(side);
		switch (dir)
		{
			case UP:
				return topIcon;
			case DOWN:
				return BlocksHolidayStuff.blockHalloweenDirt.getIcon(0, 0);
			default:
				Material mat = world.getBlock(x, y + 1, z).getMaterial(); 
				return mat == Material.snow || mat == Material.craftedSnow ? snowIcon : sideIcon;
		}
	}

}
