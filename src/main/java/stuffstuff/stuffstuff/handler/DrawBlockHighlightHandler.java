package stuffstuff.stuffstuff.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.event.ForgeSubscribe;

import org.lwjgl.opengl.GL11;

import stuffstuff.stuffstuff.handler.helper.QuadHelper;
import stuffstuff.stuffstuff.helper.RotationHelper;
import stuffstuff.stuffstuff.info.ItemInfo;
import stuffstuff.stuffstuff.items.BlockPlaceMode;
import stuffstuff.stuffstuff.items.ItemBlockPlacer;
import stuffstuff.stuffstuff.items.interfaces.IBlockPlaceMode;
import stuffstuff.stuffstuff.items.interfaces.IChargeable;
import cpw.mods.fml.client.FMLClientHandler;

public class DrawBlockHighlightHandler
{
	// Thanks Pahimar!

	@ForgeSubscribe
	public void onDrawBlockHighlightEvent(DrawBlockHighlightEvent event)
	{

		Minecraft minecraft = FMLClientHandler.instance().getClient();

		if (event.currentItem != null)
		{
			if (event.currentItem.getItem() instanceof ItemBlockPlacer)
			{
				if (event.target.typeOfHit == EnumMovingObjectType.TILE)
				{
					if (Minecraft.isGuiEnabled() && minecraft.inGameHasFocus)
					{
						if (true)
						{ // config option stuff here yay
							drawInWorldBlockPlaceOverlay(event);
						}
					}
				}
			}
		}
	}

	public void drawInWorldBlockPlaceOverlay(DrawBlockHighlightEvent event)
	{

		double x = event.target.blockX + 0.5F;
		double y = event.target.blockY + 0.5F;
		double z = event.target.blockZ + 0.5F;
		double iPX = event.player.prevPosX + (event.player.posX - event.player.prevPosX) * event.partialTicks;
		double iPY = event.player.prevPosY + (event.player.posY - event.player.prevPosY) * event.partialTicks;
		double iPZ = event.player.prevPosZ + (event.player.posZ - event.player.prevPosZ) * event.partialTicks;

		float xScale = 1;
		float yScale = 1;
		float zScale = 1;
		float xShift = 0.01F;
		float yShift = 0.01F;
		float zShift = 0.01F;

		int chargeLevel;
		int itemChargeLevel = 0;

		IChargeable item = null;

		if (event.currentItem.getItem() instanceof IChargeable)
		{
			item = (IChargeable)event.currentItem.getItem();
			itemChargeLevel = item.getCharge(event.currentItem);
		}
		chargeLevel = 1 + itemChargeLevel * 2;

		ForgeDirection sideHit = ForgeDirection.getOrientation(event.target.sideHit);

		BlockPlaceMode blockPlaceMode = null;
		if (item instanceof IBlockPlaceMode)
		{
			blockPlaceMode = ((IBlockPlaceMode)item).getBlockPlaceMode(event.currentItem);
		}
		else
		{
			blockPlaceMode = BlockPlaceMode.CREATION;
			// blockPlaceMode = BlockPlaceMode.PROJECTION;
		}

		// event.player.rotationYaw; // south 0,
		// event.player.rotationPitch // -90 straight up, 90 straight down
		float yaw = event.player.rotationYaw;
		float pitch = event.player.rotationPitch;
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

		// if pitch is down, it only cares about pitch
		// else if yaw is spot on, it checks pitch
		// else if yaw is not spot on, it only checks yaw

		switch (sideHit)
		{
		// TODO this SERIOUSLY needs tidied up
			case UP:
			{
				xScale = chargeLevel + 0.025F;
				zScale = chargeLevel + 0.025F;
				yScale = yScale + (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel : 0);
				xShift = 0;
				yShift = yShift + (blockPlaceMode == BlockPlaceMode.CREATION || blockPlaceMode == BlockPlaceMode.PROJECTION && RotationHelper.pointsDown(pitch) ? 1 : 0) - (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel : 0);
				zShift = 0;
				if (blockPlaceMode == BlockPlaceMode.PROJECTION && !RotationHelper.pointsDown(pitch))
				{
					if (facingDirection == ForgeDirection.NORTH || facingDirection == ForgeDirection.SOUTH)
					{
						// xScale should remain the same
						float tmp = zScale;
						zScale = yScale;
						yScale = tmp;
					}
					else if (facingDirection == ForgeDirection.EAST || facingDirection == ForgeDirection.WEST)
					{
						// zScale should remain the same
						float tmp = xScale;
						xScale = yScale;
						yScale = tmp;
					}
					yShift += yScale / 2 + .5;
				}
				break;
			}
			case DOWN:
			{
				xScale = chargeLevel + 0.025F;
				zScale = chargeLevel + 0.025F;
				yScale = yScale + (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel : 0);
				xShift = 0;
				yShift = -yShift - (blockPlaceMode == BlockPlaceMode.CREATION || blockPlaceMode == BlockPlaceMode.PROJECTION && RotationHelper.pointsUp(pitch) ? 1 : 0) + (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel : 0);
				zShift = 0;
				if (blockPlaceMode == BlockPlaceMode.PROJECTION && !RotationHelper.pointsUp(pitch))
				{
					if (facingDirection == ForgeDirection.NORTH || facingDirection == ForgeDirection.SOUTH)
					{
						// xScale should remain the same
						float tmp = zScale;
						zScale = yScale;
						yScale = tmp;
					}
					else if (facingDirection == ForgeDirection.EAST || facingDirection == ForgeDirection.WEST)
					{
						// zScale should remain the same
						float tmp = xScale;
						xScale = yScale;
						yScale = tmp;
					}
					yShift -= yScale / 2 + .5;
				}
				break;
			}
			case NORTH:
			{ // - z
			// System.out.printf("up %b down %b straight %b \n", RotationHelper.pointsUp(pitch), RotationHelper.pointsDown(pitch), RotationHelper.pointsStraight(pitch));
				xScale = chargeLevel + 0.025F;
				yScale = chargeLevel + 0.025F;
				zScale = zScale + (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel + .025F : 0);
				xShift = 0;
				zShift = -zShift - (blockPlaceMode == BlockPlaceMode.CREATION/*
																			 * ||
																			 * (blockPlaceMode == BlockPlaceMode.PROJECTION && RotationHelper.pointsStraight(pitch)) &&
																			 * facingDirection == ForgeDirection.SOUTH
																			 */? 1 : 0) + (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel : 0);
				if (blockPlaceMode == BlockPlaceMode.PROJECTION)
				{
					if (RotationHelper.pointsDown(pitch) || RotationHelper.pointsUp(pitch))
					{
						float tmp = zScale;
						zScale = yScale;
						yScale = tmp;
					}
					else if (facingDirection == ForgeDirection.EAST || facingDirection == ForgeDirection.WEST)
					{
						float tmp = zScale;
						zScale = xScale;
						xScale = tmp;
					}
					zShift -= zScale / 2 + .5;
				}
				break;
			}
			case SOUTH:
			{
				xScale = chargeLevel + 0.025F;
				yScale = chargeLevel + 0.025F;
				zScale = zScale - (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel + .025F : 0);
				xShift = 0;
				zShift = zShift + (blockPlaceMode == BlockPlaceMode.CREATION /*
																			 * ||
																			 * (blockPlaceMode == BlockPlaceMode.PROJECTION && RotationHelper.pointsStraight(pitch)) &&
																			 * facingDirection == ForgeDirection.NORTH
																			 */? 1 : 0) - (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel - 1 : 0);
				if (blockPlaceMode == BlockPlaceMode.PROJECTION)
				{
					if (RotationHelper.pointsDown(pitch) || RotationHelper.pointsUp(pitch))
					{
						float tmp = zScale;
						zScale = yScale;
						yScale = tmp;
					}
					else if (facingDirection == ForgeDirection.EAST || facingDirection == ForgeDirection.WEST)
					{
						float tmp = zScale;
						zScale = xScale;
						xScale = tmp;
					}
					zShift += zScale / 2 + .5;
				}
				break;
			}
			case EAST:
			{ // +x
				xScale = xScale + (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel + .025F : 0);
				yScale = chargeLevel + 0.025F;
				zScale = chargeLevel + 0.025F;
				yShift = 0;
				zShift = 0;
				xShift = xShift + (blockPlaceMode == BlockPlaceMode.CREATION /*
																			 * ||
																			 * (blockPlaceMode == BlockPlaceMode.PROJECTION && RotationHelper.pointsStraight(pitch)) &&
																			 * facingDirection == ForgeDirection.WEST
																			 */? 1 : 0) - (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel : 0);

				if (blockPlaceMode == BlockPlaceMode.PROJECTION)
				{
					if (RotationHelper.pointsDown(pitch) || RotationHelper.pointsUp(pitch))
					{
						float tmp = xScale;
						xScale = yScale;
						yScale = tmp;
					}
					else if (facingDirection == ForgeDirection.NORTH || facingDirection == ForgeDirection.SOUTH)
					{
						float tmp = zScale;
						zScale = xScale;
						xScale = tmp;
					}
					xShift += xScale / 2 + .5;
				}
				break;
			}
			case WEST:
			{
				xScale = xScale + (blockPlaceMode == BlockPlaceMode.PILLAR ? 4 * chargeLevel + .025F : 0);
				yScale = chargeLevel + 0.025F;
				zScale = chargeLevel + 0.025F;
				xShift = -xShift - (blockPlaceMode == BlockPlaceMode.CREATION /*
																			 * ||
																			 * (blockPlaceMode == BlockPlaceMode.PROJECTION && RotationHelper.pointsStraight(pitch)) &&
																			 * facingDirection == ForgeDirection.EAST
																			 */? 1 : 0) + (blockPlaceMode == BlockPlaceMode.PILLAR ? 2 * chargeLevel : 0);
				yShift = 0;
				zShift = 0;
				if (blockPlaceMode == BlockPlaceMode.PROJECTION)
				{
					if (RotationHelper.pointsDown(pitch) || RotationHelper.pointsUp(pitch))
					{
						float tmp = xScale;
						xScale = yScale;
						yScale = tmp;
					}
					else if (facingDirection == ForgeDirection.NORTH || facingDirection == ForgeDirection.SOUTH)
					{
						float tmp = zScale;
						zScale = xScale;
						xScale = tmp;
					}
					xShift -= xScale / 2 + .5;
				}
				break;
			}
			default:
				break;
		}

		GL11.glDepthMask(false);
		GL11.glDisable(GL11.GL_CULL_FACE);

		for (int i = 0; i < 6; i++)
		{
			ForgeDirection forgeDir = ForgeDirection.getOrientation(i);
			int zCorrection = i == 2 ? -1 : 1;
			GL11.glPushMatrix();
			GL11.glTranslated(-iPX + x + xShift, -iPY + y + yShift, -iPZ + z + zShift);
			GL11.glScalef(1F * xScale, 1F * yScale, 1F * zScale);
			GL11.glRotatef(90, forgeDir.offsetX, forgeDir.offsetY, forgeDir.offsetZ);
			GL11.glTranslated(0, 0, 0.5f * zCorrection);
			GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
			ResourceLocation rloc = new ResourceLocation(ItemInfo.TEXTURE_LOCATION, "textures/effects/placer_overlay.png");
			QuadHelper.renderPulsingQuad(rloc, 0.5F);
			GL11.glPopMatrix();
		}

		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDepthMask(true);
	}
}