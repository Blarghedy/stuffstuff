package stuffstuff.stuffstuff.fluid;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.blocks.PlaidColor;
import stuffstuff.stuffstuff.client.render.Renderers;
import stuffstuff.stuffstuff.info.FluidInfo;
import stuffstuff.stuffstuff.potions.Potions;

public class BlockFluidPlaidWater extends BlockStuffFluid
{
	private IIcon[] stillIcons;
	private IIcon[] flowingIcons;
	private IIcon stillIcon;
	private IIcon flowingIcon;

	public BlockFluidPlaidWater()
	{
		super(Fluids.fluidPlaidWater);
		//		setCreativeTab(StuffStuff.tabPlaidStuff);
	}

	@Override
	public String getUnlocalizedName()
	{
		return FluidInfo.PLAID_WATER_UNLOCALIZED_NAME;
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

	@Override
	public IIcon getStillIcon()
	{
		return stillIcon;
	}

	@Override
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
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityLivingBase)
		{
			EntityLivingBase ent = (EntityLivingBase)entity;
			ent.addPotionEffect(new PotionEffect(Potion.invisibility.id, 5 * 20, 0));
			ent.addPotionEffect(new PotionEffect(Potions.potionPlaid.id, 5 * 20, 0));
		}
	}
}
