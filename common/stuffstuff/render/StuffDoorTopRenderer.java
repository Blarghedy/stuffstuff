package stuffstuff.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class StuffDoorTopRenderer implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		//		renderer.renderBlockDoor(block, x, y, z);
		renderBlockDoor(world, block, x, y, z, renderer);
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

	public boolean renderBlockDoor(IBlockAccess world, Block block, int x, int y, int z, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		int meta = world.getBlockMetadata(x, y, z);

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

		float opacity_0_5 = 0.5F;
		float opacity_1 = 1.0F;
		float opacity_0_8 = 0.8F;
		float opacity_0_6 = 0.6F;
		int mixedBrightness = block.getMixedBrightnessForBlock(world, x, y, z);

		tessellator.setBrightness(renderer.renderMinY > 0.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x, y - 1, z));
		tessellator.setColorOpaque_F(opacity_0_5, opacity_0_5, opacity_0_5);
		renderer.renderFaceYNeg(block, (double)x, (double)y, (double)z, renderer.getBlockIcon(block, world, x, y, z, 0));

		tessellator.setBrightness(renderer.renderMaxY < 1.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x, y + 1, z));
		tessellator.setColorOpaque_F(opacity_1, opacity_1, opacity_1);
		renderer.renderFaceYPos(block, (double)x, (double)y, (double)z, renderer.getBlockIcon(block, world, x, y, z, 1));

		tessellator.setBrightness(renderer.renderMinZ > 0.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x, y, z - 1));
		tessellator.setColorOpaque_F(opacity_0_8, opacity_0_8, opacity_0_8);
		Icon icon = renderer.getBlockIcon(block, world, x, y, z, 2);
		renderer.renderFaceZNeg(block, x, y, z, icon);

		renderer.flipTexture = false;
		tessellator.setBrightness(renderer.renderMaxZ < 1.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x, y, z + 1));
		tessellator.setColorOpaque_F(opacity_0_8, opacity_0_8, opacity_0_8);
		icon = renderer.getBlockIcon(block, world, x, y, z, 3);
		renderer.renderFaceZPos(block, x, y, z, icon);

		renderer.flipTexture = false;
		tessellator.setBrightness(renderer.renderMinX > 0.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x - 1, y, z));
		tessellator.setColorOpaque_F(opacity_0_6, opacity_0_6, opacity_0_6);
		icon = renderer.getBlockIcon(block, world, x, y, z, 4);
		renderer.renderFaceXNeg(block, x, y, z, icon);

		renderer.flipTexture = false;
		tessellator.setBrightness(renderer.renderMaxX < 1.0D ? mixedBrightness : block.getMixedBrightnessForBlock(world, x + 1, y, z));
		tessellator.setColorOpaque_F(opacity_0_6, opacity_0_6, opacity_0_6);
		icon = renderer.getBlockIcon(block, world, x, y, z, 5);
		renderer.renderFaceXPos(block, x, y, z, icon);

		renderer.flipTexture = false;

		return true;
	}

}
