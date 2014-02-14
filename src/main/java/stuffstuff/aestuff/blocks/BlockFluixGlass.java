package stuffstuff.aestuff.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import stuffstuff.aestuff.AEStuff;
import stuffstuff.aestuff.info.BlockInfo;
import stuffstuff.aestuff.particles.Particles;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluixGlass extends Block
{

	public BlockFluixGlass()
	{
		super(Material.glass);
		setCreativeTab(AEStuff.tabAEStuff);
		setHardness(1F);
		setStepSound(soundTypeGlass);
		setLightOpacity(0);
		lightValue = 15;
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.FLUIX_GLASS_UNLOCALIZED_NAME;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return true;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{

	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return Blocks.glass.getIcon(side, meta);
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
