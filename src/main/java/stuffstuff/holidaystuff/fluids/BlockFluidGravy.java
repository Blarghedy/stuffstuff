package stuffstuff.holidaystuff.fluids;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;
import stuffstuff.holidaystuff.HolidayStuff;
import stuffstuff.holidaystuff.info.FluidInfo;
import stuffstuff.stuffstuff.fluid.BlockStuffFluid;

public class BlockFluidGravy extends BlockStuffFluid
{

	public BlockFluidGravy(Fluid fluid)
	{
		super(fluid);
		setCreativeTab(HolidayStuff.tabHolidayStuff);
	}

	/**
	 * {@link BlockStuffFluid} implementation
	 */

	@Override
	public String getUnlocalizedName()
	{
		return FluidInfo.GRAVY_UNLOCALIZED_NAME;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(FluidInfo.GRAVY_TEXTURE);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return blockIcon;
	}

	@Override
	public IIcon getStillIcon()
	{
		return blockIcon;
	}

	@Override
	public IIcon getFlowingIcon()
	{
		return blockIcon;
	}

}
