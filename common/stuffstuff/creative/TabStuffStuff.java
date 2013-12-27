package stuffstuff.creative;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabStuffStuff extends CreativeTabs
{
	public TabStuffStuff(String label)
	{
		super(label);
	}

	// @Override
	// public ItemStack getIconItemStack()
	// {
	// // TODO this
	// return super.getIconItemStack();
	// }

	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		// TODO this
		return super.getTabIconItemIndex();
	}

}
