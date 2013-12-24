package stuffstuff.fluid;

import javax.swing.Renderer;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.BlockFluidClassic;
import stuffstuff.StuffStuff;
import stuffstuff.blocks.PlaidColor;
import stuffstuff.fluids.Fluids;
import stuffstuff.info.FluidInfo;
import stuffstuff.render.Renderers;

public class BlockFluidPlaidWater extends BlockFluidClassic
{
	//	private Icon stillIcon;
	//	private Icon flowingIcon;
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
		// TODO Auto-generated method stub
		return super.renderAsNormalBlock();
	}

	@Override
	public int getRenderType()
	{
	    // TODO Auto-generated method stub
//	    return super.getRenderType();
		return Renderers.plaidFluidRenderID;
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		//		stillIcon = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":" + FluidInfo.PLAID_WATER_STILL_TEXTURE);
		//		flowingIcon = register.registerIcon(FluidInfo.TEXTURE_LOCATION + ":" + FluidInfo.PLAID_WATER_MOVING_TEXTURE);

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

}
