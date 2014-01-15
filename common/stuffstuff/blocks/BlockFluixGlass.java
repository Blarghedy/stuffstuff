package stuffstuff.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import stuffstuff.info.ParticleInfo;
import stuffstuff.particles.Particles;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluixGlass extends Block
{
	public Icon particleIcon;

	public BlockFluixGlass(int id)
	{
		super(id, Material.glass);
		setCreativeTab(StuffStuff.tabAEStuff);
		setHardness(1F);
		setStepSound(soundGlassFootstep);
		setUnlocalizedName(BlockInfo.PLAID_GLASS_UNLOCALIZED_NAME);
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		particleIcon = register.registerIcon(ParticleInfo.TEXTURE_LOCATION + ":" + ParticleInfo.FLUIX_GLASS_PARTICLE);
	}

	@Override
	public Icon getIcon(int side, int meta)
	{
		return Block.glass.getIcon(side, meta);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{
		float particleX, particleY, particleZ;
		float particleMotionX, particleMotionY, particleMotionZ;

		for (int i = 0; i < 4; i++)
		{
			particleX = x + rand.nextFloat();
			particleY = y + rand.nextFloat();
			particleZ = z + rand.nextFloat();

			particleMotionX = -.5F + rand.nextFloat();
			particleMotionY = -.5F + rand.nextFloat();
			particleMotionZ = -.5F + rand.nextFloat();

			Particles.FLUIX_GLASS.spawnParticle(world, particleX, particleY, particleZ, particleMotionX, particleMotionY, particleMotionZ);
		}
	}
}
