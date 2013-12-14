package stuffstuff.blocks.items;

import net.minecraft.item.ItemBlock;

public class ItemPlaidLog extends ItemBlock
{
	public ItemPlaidLog(int id)
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
