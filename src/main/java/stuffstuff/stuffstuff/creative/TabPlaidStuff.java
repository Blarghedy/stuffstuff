package stuffstuff.stuffstuff.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stuffstuff.stuffstuff.items.ItemsStuff;

public class TabPlaidStuff extends CreativeTabs
{
	public TabPlaidStuff(String label)
	{
		super(label);
	}

	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(ItemsStuff.itemBucketPlaid, 1, 0);
	}

	@Override
	public Item getTabIconItem()
	{
		return ItemsStuff.itemBucketPlaid;
	}
}
