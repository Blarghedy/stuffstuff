package stuffstuff.blocks.items;

import java.util.List;

import stuffstuff.blocks.BlockPlaidTallGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemPlaidTallGrass extends ItemBlock
{
	/**
	 * Because otherwise I would probably have no idea why I made this class:
	 * {@link BlockPlaidTallGrass} extends {@link BlockTallGrass}, which has
	 * a lot of code to do things like rendering, the icon, coloring the grass,
	 * and dealing with subtypes.  I don't want subtypes for this class, but
	 * I want most of the other stuff, so I added this to get rid of all
	 * subtypes.  This is noteworthy because normally I would only use an
	 * {@link ItemBlock} to add subtypes or extend functionality in some 
	 * other way.  For example, see {@link ItemPlaidLeaves}.
	 */
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
