package stuffstuff.handler;

import net.minecraft.client.renderer.entity.RenderOcelot;
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
//		if (event.entityLiving.isPotionActive(Potions.potionPlaid))
//		{
//			
//		}
	}
}
