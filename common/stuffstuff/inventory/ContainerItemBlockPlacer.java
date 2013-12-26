package stuffstuff.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerItemBlockPlacer extends Container
{
	private static final int PLAYER_ROWS = 3;
	private static final int PLAYER_COLS = 9;
	private IInventory inventory;
	private ItemStack itemstack;
	
	public ContainerItemBlockPlacer(InventoryPlayer player, ItemStack itemstack)
	{
	    inventory = new InventoryBasic("badgers", true, 1);
	    this.itemstack = itemstack;
	    
		// TODO note whether this is the proper order.  VSWE's did it this way but EE3 didn't
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
                this.addSlotToContainer(new Slot(player, inventoryColumnIndex + inventoryRowIndex * PLAYER_COLS + PLAYER_COLS, 
                		8 + inventoryColumnIndex * 18, 84 + inventoryRowIndex * 18));
            }
        }
        
        // they are just private inventories in the tiles with a special slot -- algo
        // make custom inventory to store ghost item in slot 
        // make custom slot to handle that I think
        
        addSlotToContainer(new Slot(inventory, 0, 47, 54));
        System.out.println("stacks: " + this.inventoryItemStacks.size() + " " + this.inventoryItemStacks);
        System.out.println("slots: " + this.inventorySlots.size() + " " + this.inventorySlots);
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
//	    return super.transferStackInSlot(player, index);
		return null;
	}
	
	public ItemStack getItemStack()
	{
		return this.itemstack;
	}

}
