package stuffstuff.blocks.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemPlaidTallGrass extends ItemBlock
{

	public ItemPlaidTallGrass(int par1)
	{
		super(par1);
		setHasSubtypes(false);
	}

	@Override
	public boolean getHasSubtypes()
	{
		return false;
	}

	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(this));
	}
}
