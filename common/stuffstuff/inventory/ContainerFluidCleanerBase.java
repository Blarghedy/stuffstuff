package stuffstuff.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFluidCleanerBase extends Container
{
	private static final int PLAYER_ROWS = 3;
	private static final int PLAYER_COLS = 9;
	private ItemStack itemstack;

	public ContainerFluidCleanerBase(InventoryPlayer player, ItemStack itemstack)
	{
		this.itemstack = itemstack;

		// TODO note whether this is the proper order. VSWE's did it this way but EE3 didn't
		// Add the player's action bar slots to the container
		for (int actionBarSlotIndex = 0; actionBarSlotIndex < PLAYER_COLS; ++actionBarSlotIndex)
		{
			// new Slot(inventory, index, left x value, top y value) // 8, 142
			this.addSlotToContainer(new Slot(player, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
		}

		// Add the player's inventory slots to the container
		for (int inventoryRowIndex = 0; inventoryRowIndex < PLAYER_ROWS; ++inventoryRowIndex)
		{
			for (int inventoryColumnIndex = 0; inventoryColumnIndex < PLAYER_COLS; ++inventoryColumnIndex)
			{
				this.addSlotToContainer(new Slot(player, inventoryColumnIndex + inventoryRowIndex * PLAYER_COLS + PLAYER_COLS, 8 + inventoryColumnIndex * 18, 84 + inventoryRowIndex * 18));
			}
		}

		// TODO add support for fluid stuff here, probably with a custom box... probably extend my button class

		// addSlotToContainer(new Slot(inventory, 0, 47, 54));
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index)
	{
		// TODO Auto-generated method stub
		// return super.transferStackInSlot(player, index);
		return null;
	}

	public ItemStack getItemStack()
	{
		return itemstack;
	}

}
