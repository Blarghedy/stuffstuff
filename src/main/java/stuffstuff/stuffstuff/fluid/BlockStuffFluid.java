package stuffstuff.stuffstuff.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public abstract class BlockStuffFluid extends BlockFluidClassic
{

	public BlockStuffFluid(Fluid fluid, Material material)
	{
		super(fluid, material);
	}

	public BlockStuffFluid(Fluid fluid)
	{
		this(fluid, Material.water);
	}

	@Override
	public abstract String getUnlocalizedName();

	@Override
	public abstract IIcon getIcon(int side, int meta);

	public abstract IIcon getStillIcon();

	public abstract IIcon getFlowingIcon();

	@Override
	protected boolean canFlowInto(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlock(x, y, z) == Blocks.water || world.getBlock(x, y, z) == Blocks.flowing_water ? false : super.canFlowInto(world, x, y, z);
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlock(x, y, z).getMaterial().isLiquid() ? false : super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		return world.getBlock(x, y, z).getMaterial().isLiquid() ? false : super.displaceIfPossible(world, x, y, z);
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
