package stuffstuff.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
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
	public void renderPlaidOverlayHandler(RenderGameOverlayEvent event)
	{
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
		if (player.isPotionActive(Potions.potionPlaid))
		{
			int level = player.getActivePotionEffect(Potions.potionPlaid).getAmplifier() + 1;
			
		}
	}
}
