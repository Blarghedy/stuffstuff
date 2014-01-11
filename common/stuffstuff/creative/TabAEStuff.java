package stuffstuff.creative;

import stuffstuff.blocks.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabAEStuff extends CreativeTabs
{
	public TabAEStuff(String label)
	{
		super(label);
	}

	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(Blocks.blockFunFluix, 1, 1);
	}
}
