package stuffstuff.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import stuffstuff.blocks.BlockStuffDoor;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class StuffDoorRenderer implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		//		renderer.renderBlockDoor(block, x, y, z);
		renderBlockStuffDoor(world, block, x, y, z, renderer);
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return 0;
	}

	public boolean renderBlockStuffDoor(IBlockAccess world, Block block, int x, int y, int z, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		int meta = world.getBlockMetadata(x, y, z);
		BlockStuffDoor door;

		if (block instanceof BlockStuffDoor) 
			door = (BlockStuffDoor)block;
		else
			return false;

		if ((meta & 8) != 0)
		{
			if (world.getBlockId(x, y - 1, z) != block.blockID)
			{
				return false;
			}
		}
		else if (world.getBlockId(x, y + 1, z) != block.blockID)
		{
			return false;
		}

		float bottomOpacity = 0.5F;
		float topOpacity = 1.0F;
		float zOpacity = 0.8F;
		float xOpacity = 0.6F;
		int mixedBrightness = block.getMixedBrightnessForBlock(world, x, y, z);
		Icon icon;
		int orientation = door.getDoorOrientation(world, x, y, z);
		boolean isDoorOpen = door.isDoorOpen(world, x, y, z);

		icon = renderer.getBlockIcon(block, world, x, y, z, 0);
		tessellator.setBrightness(renderer.renderMinY > 0.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x, y - 1, z));
		tessellator.setColorOpaque_F(bottomOpacity, bottomOpacity, bottomOpacity);
		renderer.renderFaceYNeg(block, (double)x, (double)y, (double)z, icon);

		icon = renderer.getBlockIcon(block, world, x, y, z, 1);
		tessellator.setBrightness(renderer.renderMaxY < 1.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x, y + 1, z));
		tessellator.setColorOpaque_F(topOpacity, topOpacity, topOpacity);
		renderer.renderFaceYPos(block, (double)x, (double)y, (double)z, icon);

		icon = renderer.getBlockIcon(block, world, x, y, z, 2);
		tessellator.setBrightness(renderer.renderMinZ > 0.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x, y, z - 1));
		tessellator.setColorOpaque_F(zOpacity, zOpacity, zOpacity);

		System.out.println(orientation + " " + isDoorOpen);
		if (((orientation == 1 || orientation == 3) && !isDoorOpen))// || ((orientation == 0 || orientation == 2) && isDoorOpen))
		{
			renderFaceZNeg(block, x, y, z, icon, renderer);
		}
		else
		{
			renderer.renderFaceZNeg(block, x, y, z, icon);
		}

		icon = renderer.getBlockIcon(block, world, x, y, z, 3);
		tessellator.setBrightness(renderer.renderMaxZ < 1.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x, y, z + 1));
		tessellator.setColorOpaque_F(zOpacity, zOpacity, zOpacity);
		if (((orientation == 1 || orientation == 3) && !isDoorOpen) || ((orientation == 0 || orientation == 2) && isDoorOpen))
		{
			renderFaceZPos(block, x, y, z, icon, renderer);
		}
		else
		{
			renderer.renderFaceZPos(block, x, y, z, icon);
		}

		icon = renderer.getBlockIcon(block, world, x, y, z, 4);
		tessellator.setBrightness(renderer.renderMinX > 0.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x - 1, y, z));
		tessellator.setColorOpaque_F(xOpacity, xOpacity, xOpacity);
		if (((orientation == 1 || orientation == 3) && isDoorOpen) || ((orientation == 0 || orientation == 2) && !isDoorOpen))
		{
			renderFaceXNeg(block, x, y, z, icon, renderer);
		}
		else
		{
			renderer.renderFaceXNeg(block, x, y, z, icon);
		}

		icon = renderer.getBlockIcon(block, world, x, y, z, 5);
		tessellator.setBrightness(renderer.renderMaxX < 1.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x + 1, y, z));
		tessellator.setColorOpaque_F(xOpacity, xOpacity, xOpacity);
		
		if (((orientation == 1 || orientation == 3) && isDoorOpen) || ((orientation == 0 || orientation == 2) && !isDoorOpen))
		{
			renderFaceXPos(block, x, y, z, icon, renderer);
		}
		else
		{
			renderer.renderFaceXPos(block, x, y, z, icon);
		}

		return true;
	}

	public void renderFaceZNeg(Block block, double x, double y, double z, Icon icon, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;

		if (renderer.hasOverrideBlockTexture())
		{
			icon = renderer.overrideBlockTexture;
		}

		double minU = icon.getInterpolatedU(renderer.renderMinX * 16.0D);
		double maxU = icon.getInterpolatedU(renderer.renderMaxX * 16.0D);
		double minV = icon.getInterpolatedV(16.0D - renderer.renderMaxY * 16.0D);
		double maxV = icon.getInterpolatedV(16.0D - renderer.renderMinY * 16.0D);
		double tmp;

		if (renderer.renderMinX < 0.0D || renderer.renderMaxX > 1.0D)
		{
			minU = icon.getMinU();
			maxU = icon.getMaxU();
		}

		if (renderer.renderMinY < 0.0D || renderer.renderMaxY > 1.0D)
		{
			minV = icon.getMinV();
			maxV = icon.getMaxV();
		}

		tmp = maxU;
		double U = minU;
		double v = minV;
		double V = maxV;

		//		if (renderer.uvRotateEast == 2)
		//		{
		//			minU = icon.getInterpolatedU(renderer.renderMinY * 16.0D);
		//			minV = icon.getInterpolatedV(16.0D - renderer.renderMinX * 16.0D);
		//			maxU = icon.getInterpolatedU(renderer.renderMaxY * 16.0D);
		//			maxV = icon.getInterpolatedV(16.0D - renderer.renderMaxX * 16.0D);
		//			v = minV;
		//			V = maxV;
		//			tmp = minU;
		//			U = maxU;
		//			minV = maxV;
		//			maxV = v;
		//		}
		//		else if (renderer.uvRotateEast == 1)
		//		{
		//			minU = icon.getInterpolatedU(16.0D - renderer.renderMaxY * 16.0D);
		//			minV = icon.getInterpolatedV(renderer.renderMaxX * 16.0D);
		//			maxU = icon.getInterpolatedU(16.0D - renderer.renderMinY * 16.0D);
		//			maxV = icon.getInterpolatedV(renderer.renderMinX * 16.0D);
		//			tmp = maxU;
		//			U = minU;
		//			minU = maxU;
		//			maxU = U;
		//			v = maxV;
		//			V = minV;
		//		}
		//		else if (renderer.uvRotateEast == 3)
		//		{
		//			minU = icon.getInterpolatedU(16.0D - renderer.renderMinX * 16.0D);
		//			maxU = icon.getInterpolatedU(16.0D - renderer.renderMaxX * 16.0D);
		//			minV = icon.getInterpolatedV(renderer.renderMaxY * 16.0D);
		//			maxV = icon.getInterpolatedV(renderer.renderMinY * 16.0D);
		//			tmp = maxU;
		//			U = minU;
		//			v = minV;
		//			V = maxV;
		//		}

		double xx = x + renderer.renderMinX;
		double XX = x + renderer.renderMaxX;
		double yy = y + renderer.renderMinY;
		double YY = y + renderer.renderMaxY;
		double zz = z + renderer.renderMinZ;

		if (renderer.enableAO)
		{
			tessellator.setColorOpaque_F(renderer.colorRedTopLeft, renderer.colorGreenTopLeft, renderer.colorBlueTopLeft);
			tessellator.setBrightness(renderer.brightnessTopLeft);
			tessellator.addVertexWithUV(xx, YY, zz, tmp, v);
			tessellator.setColorOpaque_F(renderer.colorRedBottomLeft, renderer.colorGreenBottomLeft, renderer.colorBlueBottomLeft);
			tessellator.setBrightness(renderer.brightnessBottomLeft);
			tessellator.addVertexWithUV(XX, YY, zz, minU, minV);
			tessellator.setColorOpaque_F(renderer.colorRedBottomRight, renderer.colorGreenBottomRight, renderer.colorBlueBottomRight);
			tessellator.setBrightness(renderer.brightnessBottomRight);
			tessellator.addVertexWithUV(XX, yy, zz, U, V);
			tessellator.setColorOpaque_F(renderer.colorRedTopRight, renderer.colorGreenTopRight, renderer.colorBlueTopRight);
			tessellator.setBrightness(renderer.brightnessTopRight);
			tessellator.addVertexWithUV(xx, yy, zz, maxU, maxV);
		}
		else
		{
			tessellator.addVertexWithUV(xx, YY, zz, tmp, v);
			tessellator.addVertexWithUV(XX, YY, zz, minU, minV);
			tessellator.addVertexWithUV(XX, yy, zz, U, V);
			tessellator.addVertexWithUV(xx, yy, zz, maxU, maxV);
		}
	}

	public void renderFaceZPos(Block block, double x, double y, double z, Icon icon, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;

		if (renderer.hasOverrideBlockTexture())
		{
			icon = renderer.overrideBlockTexture;
		}

		double minU = icon.getInterpolatedU(renderer.renderMinX * 16.0D);
		double maxU = icon.getInterpolatedU(renderer.renderMaxX * 16.0D);
		double maxV = icon.getInterpolatedV(16.0D - renderer.renderMaxY * 16.0D);
		double minV = icon.getInterpolatedV(16.0D - renderer.renderMinY * 16.0D);
		double tmp;

		if (renderer.flipTexture)
		{
			tmp = minU;
			minU = maxU;
			maxU = tmp;
		}

		if (renderer.renderMinX < 0.0D || renderer.renderMaxX > 1.0D)
		{
			minU = icon.getMinU();
			maxU = icon.getMaxU();
		}

		if (renderer.renderMinY < 0.0D || renderer.renderMaxY > 1.0D)
		{
			maxV = icon.getMinV();
			minV = icon.getMaxV();
		}

		tmp = maxU;
		double u = minU;
		double V = maxV;
		double v = minV;
		//
		//		if (renderer.uvRotateWest == 1)
		//		{
		//			minU = icon.getInterpolatedU(renderer.renderMinY * 16.0D);
		//			minV = icon.getInterpolatedV(16.0D - renderer.renderMinX * 16.0D);
		//			maxU = icon.getInterpolatedU(renderer.renderMaxY * 16.0D);
		//			maxV = icon.getInterpolatedV(16.0D - renderer.renderMaxX * 16.0D);
		//			V = maxV;
		//			v = minV;
		//			tmp = minU;
		//			u = maxU;
		//			maxV = minV;
		//			minV = V;
		//		}
		//		else if (renderer.uvRotateWest == 2)
		//		{
		//			minU = icon.getInterpolatedU(16.0D - renderer.renderMaxY * 16.0D);
		//			maxV = icon.getInterpolatedV(renderer.renderMinX * 16.0D);
		//			maxU = icon.getInterpolatedU(16.0D - renderer.renderMinY * 16.0D);
		//			minV = icon.getInterpolatedV(renderer.renderMaxX * 16.0D);
		//			tmp = maxU;
		//			u = minU;
		//			minU = maxU;
		//			maxU = u;
		//			V = minV;
		//			v = maxV;
		//		}
		//		else if (renderer.uvRotateWest == 3)
		//		{
		//			minU = icon.getInterpolatedU(16.0D - renderer.renderMinX * 16.0D);
		//			maxU = icon.getInterpolatedU(16.0D - renderer.renderMaxX * 16.0D);
		//			maxV = icon.getInterpolatedV(renderer.renderMaxY * 16.0D);
		//			minV = icon.getInterpolatedV(renderer.renderMinY * 16.0D);
		//			tmp = maxU;
		//			u = minU;
		//			V = maxV;
		//			v = minV;
		//		}

		double xx = x + renderer.renderMinX;
		double XX = x + renderer.renderMaxX;
		double yy = y + renderer.renderMinY;
		double YY = y + renderer.renderMaxY;
		double ZZ = z + renderer.renderMaxZ;

		if (renderer.enableAO)
		{
			tessellator.setColorOpaque_F(renderer.colorRedTopLeft, renderer.colorGreenTopLeft, renderer.colorBlueTopLeft);
			tessellator.setBrightness(renderer.brightnessTopLeft);
			tessellator.addVertexWithUV(xx, YY, ZZ, minU, maxV);
			tessellator.setColorOpaque_F(renderer.colorRedBottomLeft, renderer.colorGreenBottomLeft, renderer.colorBlueBottomLeft);
			tessellator.setBrightness(renderer.brightnessBottomLeft);
			tessellator.addVertexWithUV(xx, yy, ZZ, u, v);
			tessellator.setColorOpaque_F(renderer.colorRedBottomRight, renderer.colorGreenBottomRight, renderer.colorBlueBottomRight);
			tessellator.setBrightness(renderer.brightnessBottomRight);
			tessellator.addVertexWithUV(XX, yy, ZZ, maxU, minV);
			tessellator.setColorOpaque_F(renderer.colorRedTopRight, renderer.colorGreenTopRight, renderer.colorBlueTopRight);
			tessellator.setBrightness(renderer.brightnessTopRight);
			tessellator.addVertexWithUV(XX, YY, ZZ, tmp, V);
		}
		else
		{
			tessellator.addVertexWithUV(xx, YY, ZZ, minU, maxV);
			tessellator.addVertexWithUV(xx, yy, ZZ, u, v);
			tessellator.addVertexWithUV(XX, yy, ZZ, maxU, minV);
			tessellator.addVertexWithUV(XX, YY, ZZ, tmp, V);
		}
	}

	public void renderFaceXNeg(Block block, double x, double y, double z, Icon icon, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;

		if (renderer.hasOverrideBlockTexture())
		{
			icon = renderer.overrideBlockTexture;
		}

		double minU = icon.getInterpolatedU(renderer.renderMinZ * 16.0D);
		double maxU = icon.getInterpolatedU(renderer.renderMaxZ * 16.0D);
		double maxV = icon.getInterpolatedV(16.0D - renderer.renderMaxY * 16.0D);
		double minV = icon.getInterpolatedV(16.0D - renderer.renderMinY * 16.0D);
		double tmp;

		if (renderer.flipTexture)
		{
			tmp = minU;
			minU = maxU;
			maxU = tmp;
		}

		if (renderer.renderMinZ < 0.0D || renderer.renderMaxZ > 1.0D)
		{
			minU = icon.getMinU();
			maxU = icon.getMaxU();
		}

		if (renderer.renderMinY < 0.0D || renderer.renderMaxY > 1.0D)
		{
			maxV = icon.getMinV();
			minV = icon.getMaxV();
		}

		tmp = maxU;
		double uu = minU;
		double VV = maxV;
		double vv = minV;

		//		if (renderer.uvRotateNorth == 1)
		//		{
		//			minU = icon.getInterpolatedU(renderer.renderMinY * 16.0D);
		//			maxV = icon.getInterpolatedV(16.0D - renderer.renderMaxZ * 16.0D);
		//			maxU = icon.getInterpolatedU(renderer.renderMaxY * 16.0D);
		//			minV = icon.getInterpolatedV(16.0D - renderer.renderMinZ * 16.0D);
		//			VV = maxV;
		//			vv = minV;
		//			tmp = minU;
		//			uu = maxU;
		//			maxV = minV;
		//			minV = VV;
		//		}
		//		else if (renderer.uvRotateNorth == 2)
		//		{
		//			minU = icon.getInterpolatedU(16.0D - renderer.renderMaxY * 16.0D);
		//			maxV = icon.getInterpolatedV(renderer.renderMinZ * 16.0D);
		//			maxU = icon.getInterpolatedU(16.0D - renderer.renderMinY * 16.0D);
		//			minV = icon.getInterpolatedV(renderer.renderMaxZ * 16.0D);
		//			tmp = maxU;
		//			uu = minU;
		//			minU = maxU;
		//			maxU = uu;
		//			VV = minV;
		//			vv = maxV;
		//		}
		//		else if (renderer.uvRotateNorth == 3)
		//		{
		//			minU = icon.getInterpolatedU(16.0D - renderer.renderMinZ * 16.0D);
		//			maxU = icon.getInterpolatedU(16.0D - renderer.renderMaxZ * 16.0D);
		//			maxV = icon.getInterpolatedV(renderer.renderMaxY * 16.0D);
		//			minV = icon.getInterpolatedV(renderer.renderMinY * 16.0D);
		//			tmp = maxU;
		//			uu = minU;
		//			VV = maxV;
		//			vv = minV;
		//		}

		double xx = x + renderer.renderMinX;
		double yy = y + renderer.renderMinY;
		double YY = y + renderer.renderMaxY;
		double zz = z + renderer.renderMinZ;
		double ZZ = z + renderer.renderMaxZ;

		if (renderer.enableAO)
		{
			tessellator.setColorOpaque_F(renderer.colorRedTopLeft, renderer.colorGreenTopLeft, renderer.colorBlueTopLeft);
			tessellator.setBrightness(renderer.brightnessTopLeft);
			tessellator.addVertexWithUV(xx, YY, ZZ, tmp, VV);
			tessellator.setColorOpaque_F(renderer.colorRedBottomLeft, renderer.colorGreenBottomLeft, renderer.colorBlueBottomLeft);
			tessellator.setBrightness(renderer.brightnessBottomLeft);
			tessellator.addVertexWithUV(xx, YY, zz, minU, maxV);
			tessellator.setColorOpaque_F(renderer.colorRedBottomRight, renderer.colorGreenBottomRight, renderer.colorBlueBottomRight);
			tessellator.setBrightness(renderer.brightnessBottomRight);
			tessellator.addVertexWithUV(xx, yy, zz, uu, vv);
			tessellator.setColorOpaque_F(renderer.colorRedTopRight, renderer.colorGreenTopRight, renderer.colorBlueTopRight);
			tessellator.setBrightness(renderer.brightnessTopRight);
			tessellator.addVertexWithUV(xx, yy, ZZ, maxU, minV);
		}
		else
		{
			tessellator.addVertexWithUV(xx, YY, ZZ, tmp, VV);
			tessellator.addVertexWithUV(xx, YY, zz, minU, maxV);
			tessellator.addVertexWithUV(xx, yy, zz, uu, vv);
			tessellator.addVertexWithUV(xx, yy, ZZ, maxU, minV);
		}
	}

	public void renderFaceXPos(Block block, double x, double y, double z, Icon icon, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;

		double minU = icon.getInterpolatedU(renderer.renderMinZ * 16.0D);
		double maxU = icon.getInterpolatedU(renderer.renderMaxZ * 16.0D);
		double minV = icon.getInterpolatedV(16.0D - renderer.renderMaxY * 16.0D);
		double maxV = icon.getInterpolatedV(16.0D - renderer.renderMinY * 16.0D);

		double XX = x + renderer.renderMaxX;
		double yy = y + renderer.renderMinY;
		double YY = y + renderer.renderMaxY;
		double zz = z + renderer.renderMinZ;
		double ZZ = z + renderer.renderMaxZ;

		if (renderer.enableAO)
		{
			tessellator.setColorOpaque_F(renderer.colorRedTopLeft, renderer.colorGreenTopLeft, renderer.colorBlueTopLeft);
			tessellator.setBrightness(renderer.brightnessTopLeft);
			tessellator.addVertexWithUV(XX, yy, ZZ, minU, maxV);
			tessellator.setColorOpaque_F(renderer.colorRedBottomLeft, renderer.colorGreenBottomLeft, renderer.colorBlueBottomLeft);
			tessellator.setBrightness(renderer.brightnessBottomLeft);
			tessellator.addVertexWithUV(XX, yy, zz, maxU, maxV);
			tessellator.setColorOpaque_F(renderer.colorRedBottomRight, renderer.colorGreenBottomRight, renderer.colorBlueBottomRight);
			tessellator.setBrightness(renderer.brightnessBottomRight);
			tessellator.addVertexWithUV(XX, YY, zz, maxU, minV);
			tessellator.setColorOpaque_F(renderer.colorRedTopRight, renderer.colorGreenTopRight, renderer.colorBlueTopRight);
			tessellator.setBrightness(renderer.brightnessTopRight);
			tessellator.addVertexWithUV(XX, YY, ZZ, minU, minV);
		}
		else
		{
			double zdif = ZZ - zz;
			double ydif = YY - yy;
			double udif = maxU - minU;
			double vdif = maxV - minV;

			/**
			 * yy, ZZ, minu, maxv
			 * yy, zz, maxu, maxv
			 * YY, zz, maxu, minv
			 * YY, ZZ, minu, minv
			 */
			// render top
			tessellator.addVertexWithUV(XX, yy + ydif * 13.0 / 16, ZZ, 	minU, minV + vdif * 3.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 13.0 / 16, zz, 	maxU, minV);
			tessellator.addVertexWithUV(XX, YY, zz, 					maxU, minV);
			tessellator.addVertexWithUV(XX, YY, ZZ, 					minU, minV + vdif * 3.0 / 16);

			// render bottom
			tessellator.addVertexWithUV(XX, yy, ZZ, 					minU, maxV);
			tessellator.addVertexWithUV(XX, yy, zz, 					maxU, maxV);
			tessellator.addVertexWithUV(XX, yy + ydif * 5.0 / 16, zz, 	maxU, minV + vdif * 11.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 5.0 / 16, ZZ, 	minU, minV + vdif * 11.0 / 16);

			// render middle horizontal
			tessellator.addVertexWithUV(XX, yy + ydif * 8.0 / 16, zz + zdif * 13.0 / 16, 	minU + udif * 3.0 / 16, minV + vdif * 8.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 8.0 / 16, zz + zdif * 3.0 / 16, 	minU + udif * 13.0 / 16, minV + vdif * 8.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 10.0 / 16, zz + zdif * 3.0 / 16, 	minU + udif * 13.0 / 16, minV + vdif * 6.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 10.0 / 16, zz + zdif * 13.0 / 16, 	minU + udif * 3.0 / 16, minV + vdif * 6.0 / 16);

			// render left vertical
			tessellator.addVertexWithUV(XX, yy + ydif * 5.0 / 16, zz + zdif * 16.0 / 16, 	minU + udif * 0.0 / 16, minV + vdif * 11.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 5.0 / 16, zz + zdif * 13.0 / 16, 	minU + udif * 3.0 / 16, minV + vdif * 11.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 13.0 / 16, zz + zdif * 13.0 / 16, 	minU + udif * 3.0 / 16, minV + vdif * 3.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 13.0 / 16, zz + zdif * 16.0 / 16, 	minU + udif * 0.0 / 16, minV + vdif * 3.0 / 16);

			// render right vertical
			tessellator.addVertexWithUV(XX, yy + ydif * 5.0 / 16, zz + zdif * 3.0 / 16, 	minU + udif * 13.0 / 16, minV + vdif * 11.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 5.0 / 16, zz + zdif * 0.0 / 16, 	minU + udif * 16.0 / 16, minV + vdif * 11.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 13.0 / 16, zz + zdif * 0.0 / 16, 	minU + udif * 16.0 / 16, minV + vdif * 3.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 13.0 / 16, zz + zdif * 3.0 / 16, 	minU + udif * 13.0 / 16, minV + vdif * 3.0 / 16);

			// middle top vertical
			tessellator.addVertexWithUV(XX, yy + ydif * 10.0 / 16, zz + zdif * 9.0 / 16, 	minU + udif * 7.0 / 16, minV + vdif * 6.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 10.0 / 16, zz + zdif * 7.0 / 16, 	minU + udif * 9.0 / 16, minV + vdif * 6.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 13.0 / 16, zz + zdif * 7.0 / 16, 	minU + udif * 9.0 / 16, minV + vdif * 3.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 13.0 / 16, zz + zdif * 9.0 / 16, 	minU + udif * 7.0 / 16, minV + vdif * 3.0 / 16);

			// middle bottom vertical
			tessellator.addVertexWithUV(XX, yy + ydif * 5.0 / 16, zz + zdif * 9.0 / 16, 	minU + udif * 7.0 / 16, minV + vdif * 11.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 5.0 / 16, zz + zdif * 7.0 / 16, 	minU + udif * 9.0 / 16, minV + vdif * 11.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 8.0 / 16, zz + zdif * 7.0 / 16, 	minU + udif * 9.0 / 16, minV + vdif * 9.0 / 16);
			tessellator.addVertexWithUV(XX, yy + ydif * 8.0 / 16, zz + zdif * 9.0 / 16, 	minU + udif * 7.0 / 16, minV + vdif * 9.0 / 16);
		}
	}

}
