package stuffstuff.stuffstuff.handler.helper;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import stuffstuff.stuffstuff.handler.DrawBlockHighlightHandler;
import cpw.mods.fml.client.FMLClientHandler;

public class QuadHelper
{

	private static int pulse = 0;
	private static boolean doInc = true;

	/**
	 * Renders a single pulsing quad in the render layer, if that's the proper term. The
	 * rendering environment MUST be set up before this function is called.
	 * For a sample use see {@link DrawBlockHighlightHandler#drawInWorldBlockPlaceOverlay(DrawBlockHighlightEvent)}
	 * 
	 * @param texture
	 * @param maxTransparency
	 */
	public static void renderPulsingQuad(ResourceLocation texture, float maxTransparency)
	{
		renderQuad(texture, maxTransparency, true);
	}

	public static void renderQuad(ResourceLocation texture, float maxTransparency, boolean doPulse)
	{

		float pulseTransparency = doPulse ? getPulseValue() * maxTransparency / 3000f : maxTransparency;

		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
		Tessellator tessellator = Tessellator.instance;

		// what even is all this
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1, 1, 1, pulseTransparency);

		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(1, 1, 1, pulseTransparency);

		tessellator.addVertexWithUV(-0.5D, 0.5D, 0F, 0, 1);
		tessellator.addVertexWithUV(0.5D, 0.5D, 0F, 1, 1);
		tessellator.addVertexWithUV(0.5D, -0.5D, 0F, 1, 0);
		tessellator.addVertexWithUV(-0.5D, -0.5D, 0F, 0, 0);

		tessellator.draw();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	}

	private static int getPulseValue()
	{

		if (doInc)
		{
			pulse += 8;
		}
		else
		{
			pulse -= 8;
		}

		if (pulse == 3000)
		{
			doInc = false;
		}

		if (pulse == 1000)
		{
			doInc = true;
		}

		return pulse;
	}
}
