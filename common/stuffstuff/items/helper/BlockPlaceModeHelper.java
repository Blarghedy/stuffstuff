package stuffstuff.items.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import stuffstuff.items.BlockPlaceMode;
import stuffstuff.player.NotificationHelper;

public class BlockPlaceModeHelper
{
	public static final String MODE_KEY = "stuffstuff mode";
	
	public static BlockPlaceMode getBlockPlaceMode(ItemStack itemstack)
	{
		NBTTagCompound tag = itemstack.stackTagCompound;
		
		if (tag == null || !tag.hasKey(MODE_KEY))
		{
			return BlockPlaceMode.CREATION;
		}
		else
		{
			BlockPlaceMode mode = BlockPlaceMode.fromInt(tag.getInteger(MODE_KEY));
			return mode;
		}
	}
	
	public static BlockPlaceMode setBlockPlaceMode(ItemStack itemstack, BlockPlaceMode mode)
	{
		// TODO make this actually return the thing it sets
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (tag == null)
		{
			tag = itemstack.stackTagCompound = new NBTTagCompound();
		}
		tag.setInteger(MODE_KEY, mode.getMode());
		NotificationHelper.notifySelf("Setting mode " + mode);
		return mode;
	}
	
	public static BlockPlaceMode setBlockPlaceMode(ItemStack itemstack, int mode)
	{
		return setBlockPlaceMode(itemstack, BlockPlaceMode.fromInt(mode));
	}
	
	public static BlockPlaceMode incrementBlockPlaceMode(ItemStack itemstack)
	{
		BlockPlaceMode mode = getBlockPlaceMode(itemstack);
		NotificationHelper.notifySelf("trying to increment " + mode + " to " + mode.getNext());
		if (mode != null)
		{
			return setBlockPlaceMode(itemstack, mode.getNext());
		}
		return BlockPlaceMode.CREATION; // default
	}
	
	public static BlockPlaceMode decrementBlockPlaceMode(ItemStack itemstack)
	{
		BlockPlaceMode mode = getBlockPlaceMode(itemstack);
		System.out.println(mode);
		if (mode != null)
		{
			return setBlockPlaceMode(itemstack, mode.getPrevious());
		}
		return BlockPlaceMode.CREATION; // default
	}
}
