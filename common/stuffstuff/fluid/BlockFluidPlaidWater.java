package stuffstuff.fluid;

import javax.swing.Renderer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.BlockFluidClassic;
import stuffstuff.StuffStuff;
import stuffstuff.blocks.PlaidColor;
import stuffstuff.fluids.Fluids;
import stuffstuff.info.FluidInfo;
import stuffstuff.render.Renderers;

public class BlockFluidPlaidWater extends BlockFluidClassic
{
	private Icon[] stillIcons;
	private Icon[] flowingIcons;

	public BlockFluidPlaidWater(int id)
	{
		super(id, Fluids.fluidPlaidWater, Material.water);
		setUnlocalizedName(FluidInfo.PLAID_WATER_UNLOCALIZED_NAME);
		setCreativeTab(StuffStuff.tabStuffStuff);
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
	public void registerIcons(IconRegister register)
	{
		stillIcons = new Icon[FluidInfo.PLAID_WATER_STILL_TEXTURES.length];
		flowingIcons = new Icon[FluidInfo.PLAID_WATER_MOVING_TEXTURES.length];

		for (int i = 0; i < stillIcons.length; i++)
		{
			stillIcons[i] = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":" + FluidInfo.PLAID_WATER_STILL_TEXTURES[i]);
			flowingIcons[i] = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":" + FluidInfo.PLAID_WATER_MOVING_TEXTURES[i]);
		}
	}

	@Override
	public Icon getIcon(int side, int meta)
	{
		ForgeDirection face = ForgeDirection.getOrientation(side);
		switch(face)
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
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		ForgeDirection face = ForgeDirection.getOrientation(side);
		PlaidColor color = PlaidColor.getPlaidColorFromPos(x, y, z);
		Icon[] icons;
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
	    return world.getBlockId(x, y, z) == Block.waterStill.blockID || world.getBlockId(x, y, z) == Block.waterMoving.blockID ? false : super.canFlowInto(world, x, y, z);
	}
	
	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlockMaterial(x, y, z).isLiquid() ? false : super.canDisplace(world, x, y, z);
	}
	
	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
	    return world.getBlockMaterial(x, y, z).isLiquid() ? false : super.displaceIfPossible(world, x, y, z);
	}

}
