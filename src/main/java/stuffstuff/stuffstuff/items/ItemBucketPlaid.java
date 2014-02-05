package stuffstuff.stuffstuff.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBucketPlaid extends ItemBucket
{
	public ItemBucketPlaid(int fluidId, int blockId)
	{
		super(fluidId, blockId);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setContainerItem(Item.bucketEmpty);
		setUnlocalizedName(ItemInfo.BUCKET_PLAID_UNLOCALIZED_NAME);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.BUCKET_PLAID_ICON);
	}
}
