package stuffstuff.stuffstuff.client.interfaces;

import stuffstuff.stuffstuff.client.interfaces.helper.GuiButton;

public class GuiScaledRectangle extends GuiButton
{
	public GuiScaledRectangle(int x, int y, int width, int height, int index)
	{
		super(x, y, width, height, index);
	}

	public void draw(GuiBase gui, int srcX, int srcY, double percent)
	{
		if (percent > 1)
		{
			percent = 1;
		}
		else if (percent < 0)
		{
			percent = 0;
		}

		int h = (int)(getHeight() * (1 - percent));
		gui.drawTexturedModalRect(gui.getLeft() + getX(), gui.getTop() + getY() + h, srcX, srcY, getWidth(), getHeight() - h);
	}

	@Override
	public void draw(GuiBase gui, int srcX, int srcY)
	{
		draw(gui, srcX, srcY, 1);
	}
}
