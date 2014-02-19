package stuffstuff.holidaystuff.blocks.halloween;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
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
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 2));
		list.add(new ItemStack(item, 1, 3));
	}

	public int getWidth(int meta)
	{
		return 16 - 4 * (meta % 4);
	}

	public float getWidthAsPercent(int meta)
	{
		return getWidth(meta) / 16.0f;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		float width = getWidthAsPercent(meta);
		ForgeDirection orientation = getOrientation(world, x, y, z);
		float minx, miny, minz, maxx, maxy, maxz;

		minx = (1 - width) / 2;
		maxx = .5f + width / 2;
		miny = minz = minx;
		maxy = maxz = maxx;
		int metaPos, metaNeg;

		switch (orientation)
		{
			case UP:
				metaNeg = world.getBlockMetadata(x, y - 1, z);
				metaPos = world.getBlockMetadata(x, y + 1, z);
				miny = world.getBlock(x, y - 1, z) == this && getOrientation(metaNeg) != ForgeDirection.UP ? -.5f + getWidthAsPercent(metaNeg) / 2 : 0;
				maxy = world.getBlock(x, y + 1, z) == this && getOrientation(metaPos) != ForgeDirection.UP ? 1.5f - getWidthAsPercent(metaPos) / 2 : 1;
				break;
			case NORTH:
				metaNeg = world.getBlockMetadata(x, y, z - 1);
				metaPos = world.getBlockMetadata(x, y, z + 1);
				minz = world.getBlock(x, y, z - 1) == this && getOrientation(metaNeg) != ForgeDirection.NORTH ? -.5f + getWidthAsPercent(metaNeg) / 2 : 0;
				maxz = world.getBlock(x, y, z + 1) == this && getOrientation(metaPos) != ForgeDirection.NORTH ? 1.5f - getWidthAsPercent(metaPos) / 2 : 1;
				break;
			case EAST:
				metaNeg = world.getBlockMetadata(x - 1, y, z);
				metaPos = world.getBlockMetadata(x + 1, y, z);
				minx = world.getBlock(x - 1, y, z) == this && getOrientation(metaNeg) != ForgeDirection.EAST ? -.5f + getWidthAsPercent(metaNeg) / 2 : 0;
				maxx = world.getBlock(x + 1, y, z) == this && getOrientation(metaPos) != ForgeDirection.EAST ? 1.5f - getWidthAsPercent(metaPos) / 2 : 1;
				break;
			default:
				minx = miny = minz = 0;
				maxx = maxy = maxz = 1;
		}

		setBlockBounds(minx, miny, minz, maxx, maxy, maxz);
	}

	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity)
	{
		super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		float width = getWidthAsPercent(meta);
		ForgeDirection orientation = getOrientation(world, x, y, z);
		float minx, miny, minz, maxx, maxy, maxz;

		minx = (1 - width) / 2;
		maxx = .5f + width / 2;
		miny = minz = minx;
		maxy = maxz = maxx;
		int metaPos, metaNeg;

		switch (orientation)
		{
			case UP:
				metaNeg = world.getBlockMetadata(x, y - 1, z);
				metaPos = world.getBlockMetadata(x, y + 1, z);
				miny = world.getBlock(x, y - 1, z) == this && getOrientation(metaNeg) != ForgeDirection.UP ? -.5f + getWidthAsPercent(metaNeg) / 2 : 0;
				maxy = world.getBlock(x, y + 1, z) == this && getOrientation(metaPos) != ForgeDirection.UP ? 1.5f - getWidthAsPercent(metaPos) / 2 : 1;
				break;
			case NORTH:
				metaNeg = world.getBlockMetadata(x, y, z - 1);
				metaPos = world.getBlockMetadata(x, y, z + 1);
				minz = world.getBlock(x, y, z - 1) == this && getOrientation(metaNeg) != ForgeDirection.NORTH ? -.5f + getWidthAsPercent(metaNeg) / 2 : 0;
				maxz = world.getBlock(x, y, z + 1) == this && getOrientation(metaPos) != ForgeDirection.NORTH ? 1.5f - getWidthAsPercent(metaPos) / 2 : 1;
				break;
			case EAST:
				metaNeg = world.getBlockMetadata(x - 1, y, z);
				metaPos = world.getBlockMetadata(x + 1, y, z);
				minx = world.getBlock(x - 1, y, z) == this && getOrientation(metaNeg) != ForgeDirection.EAST ? -.5f + getWidthAsPercent(metaNeg) / 2 : 0;
				maxx = world.getBlock(x + 1, y, z) == this && getOrientation(metaPos) != ForgeDirection.EAST ? 1.5f - getWidthAsPercent(metaPos) / 2 : 1;
				break;
			default:
				minx = miny = minz = 0;
				maxx = maxy = maxz = 1;
		}

		return AxisAlignedBB.getBoundingBox(x + minx, y + miny, z + minz, x + maxx, y + maxy, z + maxz);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		float width = getWidthAsPercent(meta);
		ForgeDirection orientation = getOrientation(world, x, y, z);
		float minx, miny, minz, maxx, maxy, maxz;

		minx = (1 - width) / 2;
		maxx = .5f + width / 2;
		miny = minz = minx;
		maxy = maxz = maxx;
		int metaPos, metaNeg;

		switch (orientation)
		{
			case UP:
				metaNeg = world.getBlockMetadata(x, y - 1, z);
				metaPos = world.getBlockMetadata(x, y + 1, z);
				miny = world.getBlock(x, y - 1, z) == this && getOrientation(metaNeg) != ForgeDirection.UP ? -.5f + getWidthAsPercent(metaNeg) / 2 : 0;
				maxy = world.getBlock(x, y + 1, z) == this && getOrientation(metaPos) != ForgeDirection.UP ? 1.5f - getWidthAsPercent(metaPos) / 2 : 1;
				break;
			case NORTH:
				metaNeg = world.getBlockMetadata(x, y, z - 1);
				metaPos = world.getBlockMetadata(x, y, z + 1);
				minz = world.getBlock(x, y, z - 1) == this && getOrientation(metaNeg) != ForgeDirection.NORTH ? -.5f + getWidthAsPercent(metaNeg) / 2 : 0;
				maxz = world.getBlock(x, y, z + 1) == this && getOrientation(metaPos) != ForgeDirection.NORTH ? 1.5f - getWidthAsPercent(metaPos) / 2 : 1;
				break;
			case EAST:
				metaNeg = world.getBlockMetadata(x - 1, y, z);
				metaPos = world.getBlockMetadata(x + 1, y, z);
				minx = world.getBlock(x - 1, y, z) == this && getOrientation(metaNeg) != ForgeDirection.EAST ? -.5f + getWidthAsPercent(metaNeg) / 2 : 0;
				maxx = world.getBlock(x + 1, y, z) == this && getOrientation(metaPos) != ForgeDirection.EAST ? 1.5f - getWidthAsPercent(metaPos) / 2 : 1;
				break;
			default:
				minx = miny = minz = 0;
				maxx = maxy = maxz = 1;
		}

		return AxisAlignedBB.getBoundingBox(x + minx, y + miny, z + minz, x + maxx, y + maxy, z + maxz);
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	{
		return true;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isNormalCube()
	{
		return false;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		sideIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.HALLOWEEN_LOG_SIDE);
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.HALLOWEEN_LOG_TOP);
	}

}
