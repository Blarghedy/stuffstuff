package stuffstuff.stuffstuff.blocks.items;

import net.minecraft.item.ItemBlock;

public class ItemPlaidLeaves extends ItemBlock
{

	public ItemPlaidLeaves(int id)
	{
		super(id);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int dmg)
	{
		return dmg;
	}
}
