package stuffstuff.client.render;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class PlaidFluidRenderer implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		int l = block.colorMultiplier(blockAccess, x, y, z);
		float f = (l >> 16 & 255) / 255.0F;
		float f1 = (l >> 8 & 255) / 255.0F;
		float f2 = (l & 255) / 255.0F;
		boolean flag = block.shouldSideBeRendered(blockAccess, x, y + 1, z, 1);
		boolean flag1 = block.shouldSideBeRendered(blockAccess, x, y - 1, z, 0);
		boolean[] aboolean = new boolean[] { block.shouldSideBeRendered(blockAccess, x, y, z - 1, 2), block.shouldSideBeRendered(blockAccess, x, y, z + 1, 3), block.shouldSideBeRendered(blockAccess, x - 1, y, z, 4), block.shouldSideBeRendered(blockAccess, x + 1, y, z, 5) };

		if (!flag && !flag1 && !aboolean[0] && !aboolean[1] && !aboolean[2] && !aboolean[3])
			return false;
		else
		{
			boolean flag2 = false;
			float f3 = 0.5F;
			float f4 = 1.0F;
			float f5 = 0.8F;
			float f6 = 0.6F;
			double d0 = 0.0D;
			double d1 = 1.0D;
			Material material = block.blockMaterial;
			int meta = blockAccess.getBlockMetadata(x, y, z);
			double d2 = renderer.getFluidHeight(x, y, z, material);
			double d3 = renderer.getFluidHeight(x, y, z + 1, material);
			double d4 = renderer.getFluidHeight(x + 1, y, z + 1, material);
			double d5 = renderer.getFluidHeight(x + 1, y, z, material);
			double d6 = 0.0010000000474974513D;
			float f7;
			float f8;
			float f9;

			if (renderer.renderAllFaces || flag)
			{
				flag2 = true;
				// Icon icon = this.getBlockIconFromSideAndMetadata(par1Block, 1, meta);
				Icon icon = block.getBlockTexture(blockAccess, x, y, z, 1);

				float f10 = (float)BlockFluid.getFlowDirection(blockAccess, x, y, z, material);

				if (f10 > -999.0F)
				{
					// icon = this.getBlockIconFromSideAndMetadata(par1Block, 2, meta);
					icon = block.getBlockTexture(blockAccess, x, y, z, 2);
				}

				d2 -= d6;
				d3 -= d6;
				d4 -= d6;
				d5 -= d6;
				double d7;
				double d8;
				double d9;
				double d10;
				double d11;
				double d12;
				double d13;
				double d14;

				if (f10 < -999.0F)
				{
					d8 = icon.getInterpolatedU(0.0D);
					d12 = icon.getInterpolatedV(0.0D);
					d7 = d8;
					d11 = icon.getInterpolatedV(16.0D);
					d10 = icon.getInterpolatedU(16.0D);
					d14 = d11;
					d9 = d10;
					d13 = d12;
				}
				else
				{
					f9 = MathHelper.sin(f10) * 0.25F;
					f8 = MathHelper.cos(f10) * 0.25F;
					f7 = 8.0F;
					d8 = icon.getInterpolatedU(8.0F + (-f8 - f9) * 16.0F);
					d12 = icon.getInterpolatedV(8.0F + (-f8 + f9) * 16.0F);
					d7 = icon.getInterpolatedU(8.0F + (-f8 + f9) * 16.0F);
					d11 = icon.getInterpolatedV(8.0F + (f8 + f9) * 16.0F);
					d10 = icon.getInterpolatedU(8.0F + (f8 + f9) * 16.0F);
					d14 = icon.getInterpolatedV(8.0F + (f8 - f9) * 16.0F);
					d9 = icon.getInterpolatedU(8.0F + (f8 - f9) * 16.0F);
					d13 = icon.getInterpolatedV(8.0F + (-f8 - f9) * 16.0F);
				}

				tessellator.setBrightness(block.getMixedBrightnessForBlock(blockAccess, x, y, z));
				f9 = 1.0F;
				tessellator.setColorOpaque_F(f4 * f9 * f, f4 * f9 * f1, f4 * f9 * f2);
				tessellator.addVertexWithUV(x + 0, y + d2, z + 0, d8, d12);
				tessellator.addVertexWithUV(x + 0, y + d3, z + 1, d7, d11);
				tessellator.addVertexWithUV(x + 1, y + d4, z + 1, d10, d14);
				tessellator.addVertexWithUV(x + 1, y + d5, z + 0, d9, d13);
			}

			if (renderer.renderAllFaces || flag1)
			{
				tessellator.setBrightness(block.getMixedBrightnessForBlock(blockAccess, x, y - 1, z));
				float f11 = 1.0F;
				tessellator.setColorOpaque_F(f3 * f11, f3 * f11, f3 * f11);
				Icon tmpIcon = block.getBlockTexture(blockAccess, x, y, z, 0);
				renderer.renderFaceYNeg(block, x, y + d6, z, tmpIcon); // this.getBlockIconFromSide(par1Block, 0));
				flag2 = true;
			}

			for (int j1 = 0; j1 < 4; ++j1)
			{
				int k1 = x;
				int l1 = z;

				if (j1 == 0)
				{
					l1 = z - 1;
				}

				if (j1 == 1)
				{
					++l1;
				}

				if (j1 == 2)
				{
					k1 = x - 1;
				}

				if (j1 == 3)
				{
					++k1;
				}

				// Icon icon1 = this.getBlockIconFromSideAndMetadata(par1Block, j1 + 2, meta);
				Icon icon1 = block.getBlockTexture(blockAccess, x, y, z, j1 + 2);

				if (renderer.renderAllFaces || aboolean[j1])
				{
					double d15;
					double d16;
					double d17;
					double d18;
					double d19;
					double d20;

					if (j1 == 0)
					{
						d15 = d2;
						d17 = d5;
						d16 = x;
						d18 = x + 1;
						d19 = z + d6;
						d20 = z + d6;
					}
					else if (j1 == 1)
					{
						d15 = d4;
						d17 = d3;
						d16 = x + 1;
						d18 = x;
						d19 = z + 1 - d6;
						d20 = z + 1 - d6;
					}
					else if (j1 == 2)
					{
						d15 = d3;
						d17 = d2;
						d16 = x + d6;
						d18 = x + d6;
						d19 = z + 1;
						d20 = z;
					}
					else
					{
						d15 = d5;
						d17 = d4;
						d16 = x + 1 - d6;
						d18 = x + 1 - d6;
						d19 = z;
						d20 = z + 1;
					}

					flag2 = true;
					float f12 = icon1.getInterpolatedU(0.0D);
					f9 = icon1.getInterpolatedU(8.0D);
					f8 = icon1.getInterpolatedV((1.0D - d15) * 16.0D * 0.5D);
					f7 = icon1.getInterpolatedV((1.0D - d17) * 16.0D * 0.5D);
					float f13 = icon1.getInterpolatedV(8.0D);
					tessellator.setBrightness(block.getMixedBrightnessForBlock(blockAccess, k1, y, l1));
					float f14 = 1.0F;

					if (j1 < 2)
					{
						f14 *= f5;
					}
					else
					{
						f14 *= f6;
					}

					tessellator.setColorOpaque_F(f4 * f14 * f, f4 * f14 * f1, f4 * f14 * f2);
					tessellator.addVertexWithUV(d16, y + d15, d19, f12, f8);
					tessellator.addVertexWithUV(d18, y + d17, d20, f9, f7);
					tessellator.addVertexWithUV(d18, y + 0, d20, f9, f13);
					tessellator.addVertexWithUV(d16, y + 0, d19, f12, f13);
				}
			}

			renderer.renderMinY = d0;
			renderer.renderMaxY = d1;
			return flag2;
		}
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRenderId()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
