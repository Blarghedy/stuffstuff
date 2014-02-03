package stuffstuff.aestuff.creative;

import stuffstuff.aestuff.blocks.BlocksAEStuff;
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
		return new ItemStack(BlocksAEStuff.blockFunFluix, 1, 1);
	}
}
