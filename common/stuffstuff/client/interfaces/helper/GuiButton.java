package stuffstuff.client.interfaces.helper;

import java.util.Arrays;

import stuffstuff.client.interfaces.GuiBase;
import stuffstuff.player.NotificationHelper;

public class GuiButton
{
	// Thanks vswe!
	
	private int x;
	private int y;
	private int width;
	private int height;
	private int index;
	
	public GuiButton(int x, int y, int width, int height, int index)
	{
		this.x = x;
		this.y = y;
		this.setHeight(height);
		this.setWidth(width);
		this.index = index;
	}
	
	public void draw(GuiBase gui, int srcX, int srcY)
	{
//		NotificationHelper.notifySelf("Drawing rect at: " + (gui.getLeft() + x) + " " + (gui.getTop() + y) + " from );
		gui.drawTexturedModalRect(gui.getLeft() + x, gui.getTop() + y, srcX, srcY, getWidth(), getHeight());
	}
	
	public boolean mouseInButton(GuiBase gui, int mouseX, int mouseY)
	{
		mouseX -= gui.getLeft();
		mouseY -= gui.getTop();
		return x <= mouseX && mouseX <= x + getWidth() && y <= mouseY && mouseY <= y + getHeight();
	}
	
	public void drawString(GuiBase gui, int mouseX, int mouseY, String str)
	{
		if (mouseInButton(gui, mouseX, mouseY))
		{
			gui.drawHoverString(Arrays.asList(str.split("\n")), mouseX - gui.getLeft(), mouseY - gui.getTop());
		}
	}
	
	public double getRelativeMouseY(GuiBase gui, int mouseX, int mouseY)
	{
		mouseY -= gui.getTop();
		
		if (mouseY < getY()) return 1;
		else if (mouseY > getY() + getHeight()) return 0;
		else return (1.0 - 1.0 * (mouseY - getY()) / getHeight());
	}
	
	public int getIndex()
	{
		return index;
	}
	
	public void setIndex(int index)
	{
		this.index = index;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getWidth()
    {
	    return width;
    }

	public void setWidth(int width)
    {
	    this.width = width;
    }

	public int getHeight()
    {
	    return height;
    }

	public void setHeight(int height)
    {
	    this.height = height;
    }
}
