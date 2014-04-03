package stuffstuff.stuffstuff.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInfoPrinter extends Item
{

	public ItemInfoPrinter()
	{
		setCreativeTab(StuffStuff.tabStuffStuff);
		setUnlocalizedName(ItemInfo.INFO_PRINTER_UNLOCALIZED_NAME);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.INFO_PRINTER_ICON);
	}

	@Override
	public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (player.isSneaking())
		{
			Block block = world.getBlock(x, y, z);
			setCenter(itemstack, x, y, z);
			setTargetBlock(itemstack, block);
		}
		else
		{
			int index = getTargetIndex(itemstack);
			setTarget(itemstack, index, x, y, z);
			index = index == 0 ? 1 : 0;
			setTargetIndex(itemstack, index);
			if (index == 0)
			{
				int minx, miny, minz;
				int maxx, maxy, maxz;
				
			}
		}
		
		return true;
	}
	
	/**
	 * Set the 'center' of the zone.  This can be any block, but for
	 * trees this is where the sapling originally was.
	 * @param itemstack
	 * @param block
	 */
	public void setCenter(ItemStack itemstack, int x, int y, int z)
	{
		// just set it as a target at index 2
		setTarget(itemstack, 2, x, y, z);
	}
	
	public void setTargetBlock(ItemStack itemstack, Block block)
	{
		
	}
	
	public int getTargetIndex(ItemStack itemstack)
	{
		return 0;
	}
	
	public void setTargetIndex(ItemStack itemstack, int index)
	{
		
	}
	
	public void setTarget(ItemStack itemstack, int index, int x, int y, int z)
	{
		
	}
	
	public void getTargetX(ItemStack itemstack, int index)
	{
		
	}
	
	public void getTargetY(ItemStack itemstack, int index)
	{
		
	}
	
	public void getTargetZ(ItemStack itemstack, int index)
	{
		
	}
}
