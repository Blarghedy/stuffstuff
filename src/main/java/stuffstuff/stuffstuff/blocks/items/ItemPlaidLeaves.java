package stuffstuff.stuffstuff.blocks.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemPlaidLeaves extends ItemBlock
{

	public ItemPlaidLeaves(Block block)
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
