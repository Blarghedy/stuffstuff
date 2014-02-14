package stuffstuff.stuffstuff.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.BlockFluidClassic;
import stuffstuff.stuffstuff.blocks.PlaidColor;
import stuffstuff.stuffstuff.client.render.Renderers;
import stuffstuff.stuffstuff.info.FluidInfo;
import stuffstuff.stuffstuff.potions.Potions;

public class BlockFluidPlaidWater extends BlockFluidClassic
{
	private IIcon[] stillIcons;
	private IIcon[] flowingIcons;
	private IIcon stillIcon;
	private IIcon flowingIcon;

	public BlockFluidPlaidWater()
	{
		super(Fluids.fluidPlaidWater, Material.water);
		//		setCreativeTab(StuffStuff.tabPlaidStuff);
	}

	@Override
	public String getUnlocalizedName()
	{
		return FluidInfo.PLAID_WATER_UNLOCALIZED_NAME;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return super.renderAsNormalBlock();
	}

	@Override
	public int getRenderType()
	{
		return Renderers.plaidFluidRenderID;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		stillIcon = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":" + FluidInfo.PLAID_WATER_STILL_TEXTURE);
		flowingIcon = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":" + FluidInfo.PLAID_WATER_FLOWING_TEXTURE);

		stillIcons = new IIcon[FluidInfo.PLAID_WATER_STILL_TEXTURES.length];
		flowingIcons = new IIcon[FluidInfo.PLAID_WATER_MOVING_TEXTURES.length];

		for (int i = 0; i < stillIcons.length; i++)
		{
			stillIcons[i] = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":" + FluidInfo.PLAID_WATER_STILL_TEXTURES[i]);
			flowingIcons[i] = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":" + FluidInfo.PLAID_WATER_MOVING_TEXTURES[i]);
		}
	}

	public IIcon getStillIcon()
	{
		return stillIcon;
	}

	public IIcon getFlowingIcon()
	{
		return flowingIcon;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		ForgeDirection face = ForgeDirection.getOrientation(side);
		switch (face)
		{
			case UP:
			case DOWN:
				return stillIcons[0];
			case NORTH:
				return flowingIcons[1];
			case SOUTH:
				return flowingIcons[2];
			case EAST:
				return flowingIcons[3];
			case WEST:
			default:
				return flowingIcons[3];
		}
	}

	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		ForgeDirection face = ForgeDirection.getOrientation(side);
		PlaidColor color = PlaidColor.getPlaidColorFromPos(x, y, z);
		IIcon[] icons;
		if (face == ForgeDirection.UP || face == ForgeDirection.DOWN)
		{
			icons = stillIcons;
		}
		else
		{
			icons = flowingIcons;
		}

		return icons[(color.ordinal() + 3) % 4];
	}

	@Override
	protected boolean canFlowInto(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlock(x, y, z) == Blocks.water || world.getBlock(x, y, z) == Blocks.flowing_water ? false : super.canFlowInto(world, x, y, z);
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlock(x, y, z).getMaterial().isLiquid() ? false : super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		return world.getBlock(x, y, z).getMaterial().isLiquid() ? false : super.displaceIfPossible(world, x, y, z);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		// if(entity instanceof EntityPlayer || entity instanceof EntityMob || entity instanceof EntityCreature)
		if (entity instanceof EntityLivingBase)
		{
			// ent.addPotionEffect(new PotionEffect(Potion.poison.id, 12 * 20, 0));
			EntityLivingBase ent = (EntityLivingBase)entity;
			ent.addPotionEffect(new PotionEffect(Potion.invisibility.id, 5 * 20, 0));
			ent.addPotionEffect(new PotionEffect(Potions.potionPlaid.id, 5 * 20, 0));
		}
	}
}
