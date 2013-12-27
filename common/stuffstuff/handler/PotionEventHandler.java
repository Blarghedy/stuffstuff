package stuffstuff.handler;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import org.lwjgl.opengl.GL11;

import stuffstuff.handler.helper.QuadHelper;
import stuffstuff.info.PotionInfo;
import stuffstuff.potions.Potions;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PotionEventHandler implements ITickHandler
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
		// EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
		// if (player.isPotionActive(Potions.potionPlaid))
		// {
		// // crosshairs kinda works
		// // helmet is the same
		// // ALL doesn't work?
		// if (event.type == RenderGameOverlayEvent.ElementType.HELMET)
		// {
		// int level = player.getActivePotionEffect(Potions.potionPlaid).getAmplifier() + 1;
		// ResourceLocation rloc = new ResourceLocation(PotionInfo.PLAID_OVERLAY_TEXTURE);
		//
		// GL11.glDepthMask(false);
		// GL11.glDisable(GL11.GL_CULL_FACE);
		//
		// GL11.glPushMatrix();
		// GL11.glTranslated(256/2, 256/2, 0);
		// GL11.glScalef(59900, 59900, 0);
		// GL11.glTranslated(0, 0, -1f);
		// // GL11.glDisable(GL11.GL_DEPTH_TEST); // might need to do this to help with zfighting
		// QuadHelper.renderPulsingQuad(rloc, .9F);
		// GL11.glPopMatrix();
		//
		// GL11.glEnable(GL11.GL_CULL_FACE);
		// GL11.glDepthMask(true);
		// }
		// }
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
		if (type.contains(TickType.RENDER) && player.isPotionActive(Potions.potionPlaid))
		{
			// crosshairs kinda works
			// helmet is the same
			// ALL doesn't work?
			int level = player.getActivePotionEffect(Potions.potionPlaid).getAmplifier() + 1;
			ResourceLocation rloc = new ResourceLocation(PotionInfo.PLAID_OVERLAY_TEXTURE);

			GL11.glDepthMask(false);
			GL11.glDisable(GL11.GL_CULL_FACE);

			GL11.glPushMatrix();
			// GL11.glTranslated(256/2, 256/2, 0);
			GL11.glScalef(59900, 59900, 0);
			// GL11.glTranslated(0, 0, -1f);
			// GL11.glDisable(GL11.GL_DEPTH_TEST); // might need to do this to help with zfighting
			QuadHelper.renderPulsingQuad(rloc, .9F);
			GL11.glPopMatrix();

			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glDepthMask(true);
		}

	}

	@Override
	public EnumSet<TickType> ticks()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
