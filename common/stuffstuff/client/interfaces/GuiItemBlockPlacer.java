package stuffstuff.client.interfaces;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import stuffstuff.client.interfaces.helper.GuiButton;
import stuffstuff.info.GuiInfo;
import stuffstuff.info.ModInfo;
import stuffstuff.inventory.ContainerItemBlockPlacer;
import stuffstuff.items.BlockPlaceMode;
import stuffstuff.items.ItemBlockPlacer;
import stuffstuff.items.Items;
import stuffstuff.items.helper.ChargeHelper;
import stuffstuff.network.PacketHandler;
import stuffstuff.player.NotificationHelper;

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
		this.item = (ItemBlockPlacer)itemstack.getItem();
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
		this.mc.getTextureManager().bindTexture(texture);
		int xStart = (width - xSize) / 2;
		int yStart = (height - ySize) / 2;
		this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);

		int mode = item.getBlockPlaceMode(itemstack).getMode();
		buttons[mode].draw(this, 176, 70);
		// TODO possibly make a getChargePercent or something in IChargeable? This is kinda awkward
		double charge = Items.itemBlockPlacer.getChargePercent(itemstack);
		chargeRect.draw(this, 176, 10, charge);
		powerRect.draw(this, 186, 10);
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
			chargeRect.drawString(this, x, y, "Charge: " + Items.itemBlockPlacer.getCharge(itemstack) + "\nClick to edit.");
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
				Items.itemBlockPlacer.setBlockPlaceMode(this.itemstack, BlockPlaceMode.fromInt(b.getIndex()));
				PacketHandler.sendGuiPacket((byte)b.getIndex(), (byte)-1);
			}
		}
		
		if (chargeRect.mouseInButton(this, x, y))
		{
			int charge = (int)(chargeRect.getRelativeMouseY(this, x, y) * 10 + .5);
			Items.itemBlockPlacer.setCharge(itemstack, (short)charge);
			PacketHandler.sendGuiPacket(CHARGE_RECT_INDEX, (byte)charge);
		}
	}
}
