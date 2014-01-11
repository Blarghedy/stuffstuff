package stuffstuff.blocks.items;

import net.minecraft.item.ItemBlock;

public class ItemFluixBrick extends ItemBlock
{

	public ItemFluixBrick(int id)
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
