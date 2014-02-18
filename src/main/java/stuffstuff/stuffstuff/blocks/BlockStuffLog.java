package stuffstuff.stuffstuff.blocks;

import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.StuffStuff;

public abstract class BlockStuffLog extends BlockLog
{
	protected IIcon topIcon, sideIcon;

	public BlockStuffLog()
	{
		setHardness(2F);
		setStepSound(soundTypeWood);
		setCreativeTab(StuffStuff.tabStuffStuff);
	}

	@Override
	public abstract void registerBlockIcons(IIconRegister register);

	@Override
	public abstract String getUnlocalizedName();

	public ForgeDirection getOrientation(int meta)
	{
		switch (meta & 12)
		{
			case 0:
				return ForgeDirection.UP;
			case 4:
				return ForgeDirection.EAST;
			case 8:
				return ForgeDirection.NORTH;
			default:
				return ForgeDirection.UNKNOWN;
		}
	}

	public ForgeDirection getOrientation(IBlockAccess world, int x, int y, int z)
	{
		return getOrientation(world.getBlockMetadata(x, y, z));
	}

	public void setOrientation(World world, int x, int y, int z, ForgeDirection orientation)
	{
		int meta = world.getBlockMetadata(x, y, z);
		orientation = getValidOrientation(orientation);
		meta = meta & 3; // isolate non-directional meta
		meta = meta & getIntForOrientation(orientation); // fill in orientation meta
		world.setBlockMetadataWithNotify(x, y, z, meta, 2);
	}

	public int getIntForOrientation(ForgeDirection orientation)
	{
		switch (orientation)
		{
			case UP:
				return 0;
			case EAST:
				return 4;
			case NORTH:
				return 8;
			default:
				return 0;
		}
	}

	public ForgeDirection getValidOrientation(ForgeDirection orientation)
	{
		switch (orientation)
		{
			case DOWN:
				return ForgeDirection.UP;
			case SOUTH:
				return ForgeDirection.NORTH;
			case WEST:
				return ForgeDirection.EAST;
			default:
				return orientation;
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
		return sideIcon;
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
	public int damageDropped(int meta)
	{
		return meta & 3;
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
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
