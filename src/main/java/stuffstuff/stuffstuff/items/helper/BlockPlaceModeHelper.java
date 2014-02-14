package stuffstuff.stuffstuff.items.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.helper.Point;
import stuffstuff.stuffstuff.items.BlockPlaceMode;
import stuffstuff.stuffstuff.items.ItemBlockPlacer;
import stuffstuff.stuffstuff.player.NotificationHelper;

public class BlockPlaceModeHelper
{
	public static final String MODE_KEY = "stuffstuff mode";

	public static BlockPlaceMode getBlockPlaceMode(ItemStack itemstack)
	{
		NBTTagCompound tag = itemstack.stackTagCompound;

		if (tag == null || !tag.hasKey(MODE_KEY))
			return BlockPlaceMode.CREATION;
		else
		{
			BlockPlaceMode mode = BlockPlaceMode.fromInt(tag.getInteger(MODE_KEY));
			return mode;
		}
	}

	public static BlockPlaceMode setBlockPlaceMode(ItemStack itemstack, BlockPlaceMode mode)
	{
		// TODO make this actually return the thing it sets
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (tag == null)
		{
			tag = itemstack.stackTagCompound = new NBTTagCompound();
		}
		tag.setInteger(MODE_KEY, mode.getMode());
		NotificationHelper.notifySelf("Setting mode " + mode);
		return mode;
	}

	public static BlockPlaceMode setBlockPlaceMode(ItemStack itemstack, int mode)
	{
		return setBlockPlaceMode(itemstack, BlockPlaceMode.fromInt(mode));
	}

	public static BlockPlaceMode incrementBlockPlaceMode(ItemStack itemstack)
	{
		BlockPlaceMode mode = getBlockPlaceMode(itemstack);
		NotificationHelper.notifySelf("trying to increment " + mode + " to " + mode.getNext());
		if (mode != null)
			return setBlockPlaceMode(itemstack, mode.getNext());
		return BlockPlaceMode.CREATION; // default
	}

	public static BlockPlaceMode decrementBlockPlaceMode(ItemStack itemstack)
	{
		BlockPlaceMode mode = getBlockPlaceMode(itemstack);
		System.out.println(mode);
		if (mode != null)
			return setBlockPlaceMode(itemstack, mode.getPrevious());
		return BlockPlaceMode.CREATION; // default
	}

	public static boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		NotificationHelper.notifySelf("Clicked " + x + " " + y + " " + z + " side: " + ForgeDirection.getOrientation(side));
		if (!(itemstack.getItem() instanceof ItemBlockPlacer))
		{
			NotificationHelper.notifySelf("item is not instanceof ItemBlockPlacer");
			return false;
		}
		Point p1 = null, p2 = null;
		int depth = 1;

		ItemBlockPlacer item = (ItemBlockPlacer)itemstack.getItem();
		BlockPlaceMode mode = item.getBlockPlaceMode(itemstack);
		ForgeDirection sideHit = ForgeDirection.getOrientation(side);
		int charge = item.getCharge(itemstack);

		float yaw = player.rotationYaw;
		float pitch = player.rotationPitch;

		int facing = (int)Math.floor(yaw * 4.0F / 360.0F + 0.5D) & 3; // 0 north, 1 east, 2 south, 3 west
		ForgeDirection facingDirection = ForgeDirection.UNKNOWN;
		if (facing == 0)
		{
			facingDirection = ForgeDirection.SOUTH;
		}
		else if (facing == 1)
		{
			facingDirection = ForgeDirection.WEST;
		}
		else if (facing == 2)
		{
			facingDirection = ForgeDirection.NORTH;
		}
		else if (facing == 3)
		{
			facingDirection = ForgeDirection.EAST;
		}
		int dimID = world.provider.dimensionId;

		Point start = new Point(x, y, z, dimID);

		// NotificationHelper.notifySelf("" + sideHit + " " + dimID + " " + charge + " " + mode + " " + item);

		switch (sideHit)
		{
			case UP:
				if (mode == BlockPlaceMode.CREATION)
				{
					y += 2; // taking advantage of this silly structure
				}
			case DOWN:
				switch (mode)
				{
					case PILLAR:
						depth = charge * 10;
					case REPLACE:
					case EXTENSION:
						p1 = new Point(x + charge, y, z + charge, dimID);
						p2 = new Point(x - charge, y, z - charge, dimID);
						break;
					case PROJECTION:

						break;
					case CREATION:
						p1 = new Point(x + charge, y - 1, z + charge, dimID);
						p2 = new Point(x - charge, y - 1, z - charge, dimID);
				}
				break;
			case NORTH:
				if (mode == BlockPlaceMode.CREATION)
				{
					z -= 2;
				}
			case SOUTH:
				switch (mode)
				{
					case PILLAR:
						depth = charge * 10;
					case REPLACE:
					case EXTENSION:
						p1 = new Point(x + charge, y + charge, z, dimID);
						p2 = new Point(x - charge, y - charge, z, dimID);
						break;
					case PROJECTION:

						break;
					case CREATION:
						p1 = new Point(x + charge, y + charge, z + 1, dimID);
						p2 = new Point(x - charge, y - charge, z + 1, dimID);
				}
				break;
			case EAST:
				if (mode == BlockPlaceMode.CREATION)
				{
					x += 2;
				}
			case WEST:
				switch (mode)
				{
					case PILLAR:
						depth = charge * 10;
					case REPLACE:
					case EXTENSION:
						p1 = new Point(x, y + charge, z + charge, dimID);
						p2 = new Point(x, y - charge, z - charge, dimID);
						break;
					case PROJECTION:

						break;
					case CREATION:
						p1 = new Point(x - 1, y + charge, z + charge, dimID);
						p2 = new Point(x - 1, y - charge, z - charge, dimID);
				}
				break;
			default:
				break;
		}

		if (p1 == null || p2 == null || start == null)
		{
			NotificationHelper.notifySelf("P1 or P2 null " + p1 + " " + p2 + " " + start + " Mode: " + mode);
			return false;
		}

		StuffStuff.itemBlockPlacerHandler.addRegion(p1, p2, start, depth, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[sideHit.ordinal()]), itemstack);
		// NotificationHelper.notifySelf("Exiting properly: " + p1 + " " + p2 + " " + start + " " + depth + " " + ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[sideHit.ordinal()]));
		return false;
	}

	// TODO remember to get rid of this nonsense

	// public static void foo(DrawBlockHighlightEvent event)
	// {
	//
	// // double x = event.target.blockX + 0.5F;
	// // double y = event.target.blockY + 0.5F;
	// // double z = event.target.blockZ + 0.5F;
	// // double iPX = event.player.prevPosX + (event.player.posX - event.player.prevPosX) * event.partialTicks;
	// // double iPY = event.player.prevPosY + (event.player.posY - event.player.prevPosY) * event.partialTicks;
	// // double iPZ = event.player.prevPosZ + (event.player.posZ - event.player.prevPosZ) * event.partialTicks;
	//
	// float xScale = 1;
	// float yScale = 1;
	// float zScale = 1;
	// float xShift = 0.01F;
	// float yShift = 0.01F;
	// float zShift = 0.01F;
	//
	// int chargeLevel;
	// int itemChargeLevel = 0;
	//
	// IChargeable item = null;
	//
	// if (event.currentItem.getItem() instanceof IChargeable) {
	// item = (IChargeable)event.currentItem.getItem();
	// itemChargeLevel = item.getCharge(event.currentItem);
	// }
	// chargeLevel = 1 + itemChargeLevel * 2;
	//
	// ForgeDirection sideHit = ForgeDirection.getOrientation(event.target.sideHit);
	//
	// BlockPlaceMode blockPlaceMode = null;
	// if (item instanceof IBlockPlaceMode)
	// blockPlaceMode = ((IBlockPlaceMode)item).getBlockPlaceMode(event.currentItem);
	// else
	// blockPlaceMode = BlockPlaceMode.CREATION;
	// // blockPlaceMode = BlockPlaceMode.PROJECTION;
	//
	// // event.player.rotationYaw; // south 0,
	// // event.player.rotationPitch // -90 straight up, 90 straight down
	// float yaw = event.player.rotationYaw;
	// float pitch = event.player.rotationPitch;
	// int facing = (int)Math.floor(yaw * 4.0F / 360.0F + 0.5D) & 3; // 0 north, 1 east, 2 south, 3 west
	// ForgeDirection facingDirection = ForgeDirection.UNKNOWN;
	// if (facing == 0) facingDirection = ForgeDirection.SOUTH;
	// else if (facing == 1) facingDirection = ForgeDirection.WEST;
	// else if (facing == 2) facingDirection = ForgeDirection.NORTH;
	// else if (facing == 3) facingDirection = ForgeDirection.EAST;
	//
	//
	// // if pitch is down, it only cares about pitch
	// // else if yaw is spot on, it checks pitch
	// // else if yaw is not spot on, it only checks yaw
	//
	// switch (sideHit) {
	// //
	// case UP: {
	// xScale = chargeLevel + 0.025F;
	// zScale = chargeLevel + 0.025F;
	// yScale = yScale + (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel : 0);
	// xShift = 0;
	// yShift = yShift + (blockPlaceMode == BlockPlaceMode.CREATION ||
	// (blockPlaceMode == BlockPlaceMode.PROJECTION && RotationHelper.pointsDown(pitch)) ? 1 : 0) -
	// (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel : 0);
	// zShift = 0;
	// if (blockPlaceMode == BlockPlaceMode.PROJECTION && !RotationHelper.pointsDown(pitch))
	// {
	// if (facingDirection == ForgeDirection.NORTH || facingDirection == ForgeDirection.SOUTH)
	// {
	// // xScale should remain the same
	// float tmp = zScale;
	// zScale = yScale;
	// yScale = tmp;
	// }
	// else if (facingDirection == ForgeDirection.EAST || facingDirection == ForgeDirection.WEST)
	// {
	// // zScale should remain the same
	// float tmp = xScale;
	// xScale = yScale;
	// yScale = tmp;
	// }
	// yShift += yScale / 2 + .5;
	// }
	// break;
	// }
	// case DOWN: {
	// xScale = chargeLevel + 0.025F;
	// zScale = chargeLevel + 0.025F;
	// yScale = yScale + (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel : 0);
	// xShift = 0;
	// yShift = -yShift - (blockPlaceMode == BlockPlaceMode.CREATION ||
	// (blockPlaceMode == BlockPlaceMode.PROJECTION && RotationHelper.pointsUp(pitch)) ? 1 : 0) +
	// (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel : 0);
	// zShift = 0;
	// if (blockPlaceMode == BlockPlaceMode.PROJECTION && !RotationHelper.pointsUp(pitch))
	// {
	// if (facingDirection == ForgeDirection.NORTH || facingDirection == ForgeDirection.SOUTH)
	// {
	// // xScale should remain the same
	// float tmp = zScale;
	// zScale = yScale;
	// yScale = tmp;
	// }
	// else if (facingDirection == ForgeDirection.EAST || facingDirection == ForgeDirection.WEST)
	// {
	// // zScale should remain the same
	// float tmp = xScale;
	// xScale = yScale;
	// yScale = tmp;
	// }
	// yShift -= yScale / 2 + .5;
	// }
	// break;
	// }
	// case NORTH: { // - z
	// // System.out.printf("up %b down %b straight %b \n", RotationHelper.pointsUp(pitch), RotationHelper.pointsDown(pitch), RotationHelper.pointsStraight(pitch));
	// xScale = chargeLevel + 0.025F;
	// yScale = chargeLevel + 0.025F;
	// zScale = zScale + (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel + .025F : 0);
	// xShift = 0;
	// zShift = -zShift - (blockPlaceMode == BlockPlaceMode.CREATION
	// ? 1 : 0) +
	// (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel : 0);
	// if (blockPlaceMode == BlockPlaceMode.PROJECTION)
	// {
	// if(RotationHelper.pointsDown(pitch) || RotationHelper.pointsUp(pitch))
	// {
	// float tmp = zScale;
	// zScale = yScale;
	// yScale = tmp;
	// }
	// else if (facingDirection == ForgeDirection.EAST || facingDirection == ForgeDirection.WEST)
	// {
	// float tmp = zScale;
	// zScale = xScale;
	// xScale = tmp;
	// }
	// zShift -= zScale / 2 + .5;
	// }
	// break;
	// }
	// case SOUTH: {
	// xScale = chargeLevel + 0.025F;
	// yScale = chargeLevel + 0.025F;
	// zScale = zScale - (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel + .025F : 0);
	// xShift = 0;
	// zShift = zShift + (blockPlaceMode == BlockPlaceMode.CREATION
	// ? 1 : 0) -
	// (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel - 1 : 0);
	// if (blockPlaceMode == BlockPlaceMode.PROJECTION)
	// {
	// if(RotationHelper.pointsDown(pitch) || RotationHelper.pointsUp(pitch))
	// {
	// float tmp = zScale;
	// zScale = yScale;
	// yScale = tmp;
	// }
	// else if (facingDirection == ForgeDirection.EAST || facingDirection == ForgeDirection.WEST)
	// {
	// float tmp = zScale;
	// zScale = xScale;
	// xScale = tmp;
	// }
	// zShift += zScale / 2 + .5;
	// }
	// break;
	// }
	// case EAST: { // +x
	// xScale = xScale + (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel + .025F : 0);
	// yScale = chargeLevel + 0.025F;
	// zScale = chargeLevel + 0.025F;
	// yShift = 0;
	// zShift = 0;
	// xShift = xShift + (blockPlaceMode == BlockPlaceMode.CREATION
	// ? 1 : 0) - (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel : 0);
	//
	// if (blockPlaceMode == BlockPlaceMode.PROJECTION)
	// {
	// if(RotationHelper.pointsDown(pitch) || RotationHelper.pointsUp(pitch))
	// {
	// float tmp = xScale;
	// xScale = yScale;
	// yScale = tmp;
	// }
	// else if (facingDirection == ForgeDirection.NORTH || facingDirection == ForgeDirection.SOUTH)
	// {
	// float tmp = zScale;
	// zScale = xScale;
	// xScale = tmp;
	// }
	// xShift += xScale / 2 + .5;
	// }
	// break;
	// }
	// case WEST: {
	// xScale = xScale + (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel + .025F : 0);
	// yScale = chargeLevel + 0.025F;
	// zScale = chargeLevel + 0.025F;
	// xShift = -xShift - (blockPlaceMode == BlockPlaceMode.CREATION
	// ? 1 : 0) + (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel : 0);
	// yShift = 0;
	// zShift = 0;
	// if (blockPlaceMode == BlockPlaceMode.PROJECTION)
	// {
	// if(RotationHelper.pointsDown(pitch) || RotationHelper.pointsUp(pitch))
	// {
	// float tmp = xScale;
	// xScale = yScale;
	// yScale = tmp;
	// }
	// else if (facingDirection == ForgeDirection.NORTH || facingDirection == ForgeDirection.SOUTH)
	// {
	// float tmp = zScale;
	// zScale = xScale;
	// xScale = tmp;
	// }
	// xShift -= xScale / 2 + .5;
	// }
	// break;
	// }
	// default:
	// break;
	// }
	// }

}
