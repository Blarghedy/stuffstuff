package stuffstuff.aestuff.blocks.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemFunFluix extends ItemBlock
{

	public ItemFunFluix(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int dmg)
	{
		return dmg;
	}
}
