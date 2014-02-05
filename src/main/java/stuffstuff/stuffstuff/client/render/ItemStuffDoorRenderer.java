package stuffstuff.stuffstuff.client.render;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import stuffstuff.stuffstuff.blocks.items.ItemStuffDoor;

public class ItemStuffDoorRenderer implements IItemRenderer
{

	// TODO finish this.  

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		ItemStuffDoor door = (ItemStuffDoor)(item.getItem());
		//	    BlockStuffDoorRenderer.renderFaceXNeg(door.getModel(), 0, 0, 0, icon, renderer);
	}

}
