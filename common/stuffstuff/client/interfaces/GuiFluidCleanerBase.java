package stuffstuff.client.interfaces;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import stuffstuff.info.GuiInfo;
import stuffstuff.info.ModInfo;
import stuffstuff.inventory.ContainerFluidCleanerBase;
import stuffstuff.items.FluidCleanerBase;
import stuffstuff.items.Items;
import stuffstuff.network.PacketHandler;

public class GuiFluidCleanerBase extends GuiBase
{
	private static final ResourceLocation texture = new ResourceLocation(ModInfo.ID, GuiInfo.FLUID_CLEANER_BASE_GUI);
	private ItemStack itemstack;
	private FluidCleanerBase item;
	private static final GuiScaledRectangle chargeRect;
	private static final GuiScaledRectangle powerRect;
	public static final byte CHARGE_RECT_INDEX = -1;
	public static final byte POWER_RECT_INDEX = -2;

	public GuiFluidCleanerBase(InventoryPlayer invPlayer, ItemStack itemstack)
	{
		super(new ContainerFluidCleanerBase(invPlayer, itemstack));
		xSize = 175;
		ySize = 165;
		this.itemstack = itemstack;
		item = (FluidCleanerBase)itemstack.getItem();
	}

	static
	{
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

		double charge = item.getChargePercent(itemstack);
		chargeRect.draw(this, 176, 10, charge);
		double power = item.getStuffPowerPercent(itemstack);
		powerRect.draw(this, 186, 10, power);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{
		if (chargeRect.mouseInButton(this, x, y))
		{
			chargeRect.drawString(this, x, y, "Charge: " + Items.itemBlockPlacer.getCharge(itemstack) + "\nClick to edit.");
		}

		if (powerRect.mouseInButton(this, x, y))
		{
			// TODO add color coding for when power is low
			powerRect.drawString(this, x, y, "Power: " + Items.itemBlockPlacer.getStuffPower(itemstack) + " / " + Items.itemBlockPlacer.getMaxStuffPower());
		}
	}

	@Override
	protected void mouseClicked(int x, int y, int button)
	{
		// button: 0 left, 1 right, maybe 2 middle
		super.mouseClicked(x, y, button);

		if (chargeRect.mouseInButton(this, x, y))
		{
			int charge = (int)(chargeRect.getRelativeMouseY(this, x, y) * 10 + .5);
			item.setCharge(itemstack, (short)charge);
			PacketHandler.sendGuiPacket(CHARGE_RECT_INDEX, (byte)charge);
		}
	}
}
