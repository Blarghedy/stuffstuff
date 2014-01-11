package stuffstuff.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import stuffstuff.items.Items;

public class TabPlaidStuff extends CreativeTabs
{
	public TabPlaidStuff(String label)
	{
		super(label);
	}

	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(Items.itemBucketPlaid, 1, 0);
	}
}
