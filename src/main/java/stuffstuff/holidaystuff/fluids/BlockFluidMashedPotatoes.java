package stuffstuff.holidaystuff.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import stuffstuff.holidaystuff.HolidayStuff;
import stuffstuff.holidaystuff.info.FluidInfo;
import stuffstuff.stuffstuff.fluid.BlockStuffFluid;

public class BlockFluidMashedPotatoes extends BlockStuffFluid
{

	public BlockFluidMashedPotatoes(Fluid fluid)
	{
		super(fluid, Material.lava);
		setCreativeTab(HolidayStuff.tabHolidayStuff);
		setQuantaPerBlock(2);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		float height = getQuantaPercentage(world, x, y, z);
		return AxisAlignedBB.getAABBPool().getAABB(x + this.minX, y + this.minY, z + this.minZ, x + this.maxX, y + this.maxY * height * .5, z + this.maxZ);
	}

	@Override
	public void velocityToAddToEntity(World world, int x, int y, int z, Entity entity, Vec3 vec)
	{

	}

	/**
	 * {@link BlockStuffFluid} implementation
	 */

	@Override
	public String getUnlocalizedName()
	{
		return FluidInfo.MASHED_POTATOES_UNLOCALIZED_NAME;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":" + FluidInfo.MASHED_POTATOES_TEXTURE);
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
