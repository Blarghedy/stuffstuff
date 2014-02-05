package stuffstuff.stuffstuff.client.interfaces;

import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class GuiBase extends GuiContainer
{
	public GuiBase(Container container)
	{
		super(container);
	}

	public int getLeft()
	{
		return guiLeft;
	}

	public int getTop()
	{
		return guiTop;
	}

	public void drawHoverString(List list, int x, int y)
	{
		drawHoveringText(list, x - 3, y, fontRenderer);
	}
}
