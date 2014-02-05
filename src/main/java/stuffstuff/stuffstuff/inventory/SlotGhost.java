package stuffstuff.stuffstuff.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotGhost extends Slot
{

	// new Slot(player, index, left x value, top y value)
	public SlotGhost(IInventory inventory, int index, int x, int y)
	{
		super(inventory, index, x, y);
	}

}
