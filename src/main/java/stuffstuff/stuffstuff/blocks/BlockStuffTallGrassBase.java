package stuffstuff.stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public abstract class BlockStuffTallGrassBase extends BlockTallGrass
{

	public BlockStuffTallGrassBase()
	{
		setStepSound(soundTypeGrass);
	}

	@Override
	public abstract String getUnlocalizedName();

	@Override
	public IIcon getIcon(int side, int meta)
	{
		// use the actual grass icon instead of the shrub, etc.
		return super.getIcon(side, 1);
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return this.canPlaceBlockOn(world.getBlock(x, y - 1, z));
	}

	@Override
	protected boolean canPlaceBlockOn(Block onBlock)
	{
		return super.canPlaceBlockOn(onBlock) || onBlock instanceof BlockStuffDirt || onBlock instanceof BlockStuffGrass;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return EnumPlantType.Plains;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return super.canPlaceBlockAt(world, x, y, z) && this.canBlockStay(world, x, y, z);
	}

	@Override
	public int getBlockColor()
	{
		return ColorizerGrass.getGrassColor(.5, 1);
	}

	@Override
	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		return meta == 0 ? 16777215 : world.getBiomeGenForCoords(x, z).getBiomeGrassColor(x, y, z);
	}
}
