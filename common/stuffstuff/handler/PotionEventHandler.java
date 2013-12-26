package stuffstuff.handler;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import stuffstuff.handler.helper.QuadHelper;
import stuffstuff.info.ItemInfo;
import stuffstuff.info.PotionInfo;
import stuffstuff.potions.Potions;

public class PotionEventHandler
{
	@ForgeSubscribe
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
	
	@ForgeSubscribe
	public void renderPlaidOverlayHandler(RenderGameOverlayEvent.Pre event)
	{
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
		if (player.isPotionActive(Potions.potionPlaid))
		{
			// crosshairs kinda works
			// helmet is the same
			// ALL doesn't work?
			if (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS)
			{
			int level = player.getActivePotionEffect(Potions.potionPlaid).getAmplifier() + 1;
			ResourceLocation rloc = new ResourceLocation(PotionInfo.PLAID_OVERLAY_TEXTURE);
			
			GL11.glDepthMask(false);
	        GL11.glDisable(GL11.GL_CULL_FACE);

//	            int zCorrection = i == 2 ? -1 : 1;
	            GL11.glPushMatrix();
//	            GL11.glTranslated(-iPX + x + xShift, -iPY + y + yShift, -iPZ + z + zShift);
	            GL11.glTranslated(256/2, 256/2, 0);
//	            GL11.glScalef(1F * xScale, 1F * yScale, 1F * zScale);
	            GL11.glScalef(500, 500, 0);
//	            GL11.glRotatef(90, forgeDir.offsetX, forgeDir.offsetY, forgeDir.offsetZ);
//	            GL11.glTranslated(0, 0, 0.5f * zCorrection);
	            GL11.glTranslated(0, 0, -1f);
	            GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
	            QuadHelper.renderPulsingQuad(rloc, .9F);
	            GL11.glPopMatrix();

	        GL11.glEnable(GL11.GL_CULL_FACE);
	        GL11.glDepthMask(true);
			}
		}
	}
}
