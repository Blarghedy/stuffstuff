package stuffstuff.blocks;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;

public interface IDirectionHaver
{
	public static final String KEY = "facing_direction";
	public ForgeDirection setDirection(ForgeDirection direction, ItemStack itemstack);

	public ForgeDirection getDirection(ItemStack itemstack);
}
