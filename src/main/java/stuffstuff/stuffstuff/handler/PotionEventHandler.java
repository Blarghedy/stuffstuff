package stuffstuff.stuffstuff.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import org.lwjgl.opengl.GL11;

import stuffstuff.stuffstuff.blocks.PlaidColor;
import stuffstuff.stuffstuff.handler.helper.QuadHelper;
import stuffstuff.stuffstuff.info.PotionInfo;
import stuffstuff.stuffstuff.potions.Potions;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PotionEventHandler
{
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if (event.entityLiving.isPotionActive(Potions.potionPlaid))
		{
			if (event.entityLiving.getActivePotionEffect(Potions.potionPlaid).getDuration() == 0)
			{
				event.entityLiving.removePotionEffect(Potions.potionPlaid.id);
			}
		}
	}

	@SubscribeEvent
	public void renderPlaidOverlayHandler(RenderWorldLastEvent event)
	{
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
		if (player.isPotionActive(Potions.potionPlaid))
		{
			int cubeDensity = PotionInfo.CUBE_DENSITY;
			if (cubeDensity == 0) return;
			int cubeDistance = PotionInfo.CUBE_DISTANCE;

			double x = Math.floor(player.posX) + 0.5F;
			double y = Math.floor(player.posY) + 0.5F;
			double z = Math.floor(player.posZ) + 0.5F;
			float partialTicks = event.partialTicks;
			double iPX = player.prevPosX + (player.posX - player.prevPosX) * partialTicks;
			double iPY = player.prevPosY + (player.posY - player.prevPosY) * partialTicks;
			double iPZ = player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks;

			float xScale = .9f;
			float yScale = .9f;
			float zScale = .9f;
			float xShift = 0.01F;
			float yShift = 0.01F;
			float zShift = 0.01F;

			int intx = (int)x;
			int inty = (int)y;
			int intz = (int)z;

			GL11.glDepthMask(false);
			GL11.glDisable(GL11.GL_CULL_FACE);
			ResourceLocation rloc;
			int pri;
			for (int i = -cubeDistance; i < cubeDistance + 1; i++)
			{
				for (int j = -cubeDistance; j < cubeDistance + 1; j++)
				{
					for (int k = -cubeDistance; k < cubeDistance + 1; k++)
					{
						if (player.worldObj.getBlock(intx + i, inty + j, intz + k) != Blocks.air) continue;

						rloc = Potions.potionCubes[PlaidColor.getPlaidColorFromPos(intx + i, inty + j, intz + k).ordinal()];
						pri = priorityLevel(intx + i, inty + j, intz + k);
						if (pri < cubeDensity)
						{
							for (int side = 0; side < 6; side++)
							{
								ForgeDirection forgeDir = ForgeDirection.getOrientation(side);
								int zCorrection = side == 2 ? -1 : 1;
								GL11.glPushMatrix();
								GL11.glTranslated(-iPX + intx + i + xShift, -iPY + inty + j + yShift, -iPZ + intz + k + zShift);
								GL11.glScalef(1F * xScale, 1F * yScale, 1F * zScale);
								GL11.glRotatef(90, forgeDir.offsetX, forgeDir.offsetY, forgeDir.offsetZ);
								GL11.glTranslated(0, 0, 0.5f * zCorrection);
								GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
								QuadHelper.renderQuad(rloc, .9f, false);
								GL11.glPopMatrix();
							}
						}
					}
				}
			}

			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glDepthMask(true);
		}
	}

	/**
	 * Calculates a priority level from 0 to 100 to determine which blocks to render.
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	private static int priorityLevel(int x, int y, int z)
	{
		long mix = xorShift64(x) + Long.rotateLeft(xorShift64(y),32) + 0xCAFEBABE;
		long mix2 = xorShift64(mix);
		long mix3 = xorShift64(mix2) + Long.rotateLeft(xorShift64(z),32) + 0xCAFEBABE;
		return Math.abs((int)(mix3 % 100));
	}

	private static final long xorShift64(long a) 
	{
		a ^= (a << 21);
		a ^= (a >>> 35);
		a ^= (a << 4);
		return a;
	}
}
