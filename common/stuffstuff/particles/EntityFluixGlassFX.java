package stuffstuff.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class EntityFluixGlassFX extends EntityFX 
{

	protected EntityFluixGlassFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ)
	{
		super (world, x, y, z, motionX, motionY, motionZ);
		//		setParticleIcon(Blocks.blockFluixGlass.particleIcon);

		float f = this.rand.nextFloat() * 0.1F + 0.8F;
		particleRed = f * 0.7f;
		particleGreen = f * 0.89f;
		particleBlue = f * 0.9f;
		setParticleTextureIndex(0);
		setSize(0.04F, 0.04F);
		particleScale *= this.rand.nextFloat() * 0.6F + 1.9F;
		motionX = 0.0D;
		motionY = 1D;
		motionZ = 0.0D;
		prevPosX = this.posX;
		prevPosY = this.posY;
		prevPosZ = this.posZ;
		particleMaxAge = (int)(20.0D / (Math.random() * 0.8D + 0.1D));
		noClip = true;
	}

	@Override
	public void onUpdate()
	{
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.particleScale *= 0.95;

		if (this.particleMaxAge-- <= 0 || this.particleScale < 0.1)
		{
			this.setDead();
		}
	}

}
