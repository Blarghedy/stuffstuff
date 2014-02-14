package stuffstuff.stuffstuff.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stuffstuff.stuffstuff.items.ItemsStuff;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabStuffStuff extends CreativeTabs
{
	public TabStuffStuff(String label)
	{
		super(label);
	}

	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(ItemsStuff.itemBlockPlacer, 1, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return ItemsStuff.itemBlockPlacer;
	}

}
