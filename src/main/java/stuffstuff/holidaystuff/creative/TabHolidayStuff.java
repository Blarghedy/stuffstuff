package stuffstuff.holidaystuff.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TabHolidayStuff extends CreativeTabs
{

	public TabHolidayStuff(String label)
    {
	    super(label);
    }

	@Override
    public Item getTabIconItem()
    {
	    return Items.apple;
    }

}
