package stuffstuff.client.interfaces;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

@SideOnly(Side.CLIENT)
public abstract class GuiBase extends GuiContainer
{
	public GuiBase(Container container)
    {
	    super(container);
    }

	public int getLeft()
	{
		return this.guiLeft;
	}
	
	public int getTop()
	{
		return this.guiTop;
	}
	
	public void drawHoverString(List list, int x, int y)
	{
		drawHoveringText(list, x - 3, y, fontRenderer);
	}
}
