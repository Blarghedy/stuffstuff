package stuffstuff.stuffstuff.client.interfaces;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import stuffstuff.stuffstuff.client.interfaces.helper.GuiButton;
import stuffstuff.stuffstuff.info.GuiInfo;
import stuffstuff.stuffstuff.info.ModInfo;
import stuffstuff.stuffstuff.inventory.ContainerItemBlockPlacer;
import stuffstuff.stuffstuff.items.BlockPlaceMode;
import stuffstuff.stuffstuff.items.ItemBlockPlacer;
import stuffstuff.stuffstuff.items.ItemsStuff;
import stuffstuff.stuffstuff.network.StuffPacketHandler;

public class GuiItemBlockPlacer extends GuiBase
{
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.ID, GuiInfo.ITEM_BLOCK_PLACER_GUI);
	protected static final GuiButton buttons[];
	private ItemStack itemstack;
	private ItemBlockPlacer item;
	private static final GuiScaledRectangle chargeRect;
	private static final GuiScaledRectangle powerRect;
	public static final byte CHARGE_RECT_INDEX = -1;
	public static final byte POWER_RECT_INDEX = -2;

	public GuiItemBlockPlacer(InventoryPlayer invPlayer, ItemStack itemstack)
	{
		super(new ContainerItemBlockPlacer(invPlayer, itemstack));
		xSize = 175;
		ySize = 165;
		this.itemstack = itemstack;
		item = (ItemBlockPlacer)itemstack.getItem();
	}

	static
	{
		buttons = new GuiButton[5];
		for (int i = 0; i < 5; i++)
		{
			buttons[i] = new GuiButton(46 + i * (18 + 5), 9, 18, 18, i);
		}

		chargeRect = new GuiScaledRectangle(10, 10, 10, 60, CHARGE_RECT_INDEX);
		powerRect = new GuiScaledRectangle(28, 10, 10, 60, POWER_RECT_INDEX);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		// 176, 70
		mc.getTextureManager().bindTexture(texture);
		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;
		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

		int mode = item.getBlockPlaceMode(itemstack).getMode();
		buttons[mode].draw(this, 176, 70);
		// TODO possibly make a getChargePercent or something in IChargeable? This is kinda awkward
		double charge = ItemsStuff.itemBlockPlacer.getChargePercent(itemstack);
		chargeRect.draw(this, 176, 10, charge);
		double power = ItemsStuff.itemBlockPlacer.getStuffPowerPercent(itemstack);
		powerRect.draw(this, 186, 10, power);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{
		for (GuiButton button : buttons)
		{
			if (button.mouseInButton(this, x, y))
			{
				button.drawString(this, x, y, BlockPlaceMode.fromInt(button.getIndex()).toString());
			}
		}

		if (chargeRect.mouseInButton(this, x, y))
		{
			chargeRect.drawString(this, x, y, "Charge: " + ItemsStuff.itemBlockPlacer.getCharge(itemstack) + "\nClick to edit.");
		}

		if (powerRect.mouseInButton(this, x, y))
		{
			// TODO add color coding for when power is low
			powerRect.drawString(this, x, y, "Power: " + ItemsStuff.itemBlockPlacer.getStuffPower(itemstack) + " / " + ItemsStuff.itemBlockPlacer.getMaxStuffPower());
		}
	}

	@Override
	protected void mouseClicked(int x, int y, int button)
	{
		// button: 0 left, 1 right, maybe 2 middle
		super.mouseClicked(x, y, button);

		for (GuiButton b : buttons)
		{
			if (b.mouseInButton(this, x, y))
			{
				ItemsStuff.itemBlockPlacer.setBlockPlaceMode(itemstack, BlockPlaceMode.fromInt(b.getIndex()));
				StuffPacketHandler.sendGuiPacket((byte)b.getIndex(), (byte)-1);
			}
		}

		if (chargeRect.mouseInButton(this, x, y))
		{
			int charge = (int)(chargeRect.getRelativeMouseY(this, x, y) * 10 + .5);
			ItemsStuff.itemBlockPlacer.setCharge(itemstack, (short)charge);
			StuffPacketHandler.sendGuiPacket(CHARGE_RECT_INDEX, (byte)charge);
		}
	}
}
