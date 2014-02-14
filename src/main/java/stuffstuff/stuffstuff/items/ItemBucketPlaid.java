package stuffstuff.stuffstuff.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBucketPlaid extends ItemBucket
{
	public ItemBucketPlaid(Block block)
	{
		super(block);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setContainerItem(Items.bucket);
		setUnlocalizedName(ItemInfo.BUCKET_PLAID_UNLOCALIZED_NAME);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.BUCKET_PLAID_ICON);
	}
}
