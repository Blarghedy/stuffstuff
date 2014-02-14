package stuffstuff.aestuff.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stuffstuff.aestuff.blocks.BlocksAEStuff;

public class TabAEStuff extends CreativeTabs
{
	public TabAEStuff(String label)
	{
		super(label);
	}

	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(BlocksAEStuff.blockFunFluix, 1, 1);
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(BlocksAEStuff.blockFunFluix);
	}
}
