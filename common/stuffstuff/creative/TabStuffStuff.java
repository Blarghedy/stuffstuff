package stuffstuff.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import stuffstuff.items.Items;
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
		return new ItemStack(Items.itemBlockPlacer, 1, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		// TODO this
		return super.getTabIconItemIndex();
	}

}
