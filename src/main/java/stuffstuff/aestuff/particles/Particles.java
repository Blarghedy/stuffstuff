package stuffstuff.aestuff.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public enum Particles
{
	FLUIX_GLASS;
	
	public void spawnParticle(World world, double x, double y, double z, double motX, double motY, double motZ)
	{
		Minecraft mc = Minecraft.getMinecraft();
		if (mc != null && mc.renderViewEntity != null && mc.effectRenderer != null)
		{
			int particleSetting = mc.gameSettings.particleSetting;
			if (particleSetting == 2 || (particleSetting == 1 && world.rand.nextInt(3) == 0))
			{
				return;
			}
			
			double distanceX = mc.renderViewEntity.posX - x;
			double distanceY = mc.renderViewEntity.posY - y;
			double distanceZ = mc.renderViewEntity.posZ - z;
			
			double maxDistance = 16;
			
			if (distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ > maxDistance * maxDistance)
			{
				return;
			}
			
			EntityFX particleEffect = null;
			
			switch(this)
			{
				case FLUIX_GLASS:
					particleEffect = new EntityFluixGlassFX(world, x, y, z, motX, motY, motZ);
					
			}
			
			if (particleEffect != null)
			{
				mc.effectRenderer.addEffect(particleEffect);
			}
		}
	}
}
