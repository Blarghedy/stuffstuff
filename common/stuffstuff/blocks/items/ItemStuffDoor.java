package stuffstuff.blocks.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import stuffstuff.blocks.BlockStuffDoor;

public class ItemStuffDoor extends ItemBlock //ItemDoor
{
	public static BlockStuffDoor door;
	private BlockStuffDoor modelDoor;

	public static void setDoor(BlockStuffDoor targetDoor)
	{
		door = targetDoor;
	}

	public ItemStuffDoor(int id)
	{
		super(id);
		this.modelDoor = door;
		setCreativeTab(modelDoor.getCreativeTabToDisplayOn());
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz)
	{
		if (side != 1)
		{
			return false;
		}
		else
		{
			++y;

			if (player.canPlayerEdit(x, y, z, side, itemstack) && player.canPlayerEdit(x, y + 1, z, side, itemstack))
			{
				if (!modelDoor.canPlaceBlockAt(world, x, y, z))
				{
					return false;
				}
				else
				{
					int i1 = MathHelper.floor_double((double)((player.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
					ItemDoor.placeDoorBlock(world, x, y, z, i1, modelDoor);
					--itemstack.stackSize;
					return true;
				}
			}
			else
			{
				return false;
			}
		}
	}

}
