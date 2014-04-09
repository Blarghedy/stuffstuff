package stuffstuff.stuffstuff.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.helper.JsonHelper;
import stuffstuff.stuffstuff.info.ItemInfo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import cpw.mods.fml.common.registry.GameRegistry;
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
			System.out.println("Setting center to " + x + " " + y + " " + z + " " + GameRegistry.findUniqueIdentifierFor(block).toString());
		}
		else
		{
			int index = getTargetIndex(itemstack);
			setTarget(itemstack, index, x, y, z);
			// switch target index between 0 and 1 and save it
			index = index == 0 ? 1 : 0;
			setTargetIndex(itemstack, index);

			String targetName = getTargetBlock(itemstack);

			if (index == 0)
			{
				int minx, miny, minz;
				int maxx, maxy, maxz;
				int tmp;
				minx = getTargetX(itemstack, 0);
				maxx = getTargetX(itemstack, 1);
				if (minx > maxx) 
				{
					tmp = minx;
					minx = maxx;
					maxx = tmp;
				}
				miny = getTargetY(itemstack, 0);
				maxy = getTargetY(itemstack, 1);
				if (miny > maxy) 
				{
					tmp = miny;
					miny = maxy;
					maxy = tmp;
				}
				minz = getTargetZ(itemstack, 0);
				maxz = getTargetZ(itemstack, 1);
				if (minz > maxz) 
				{
					tmp = minz;
					minz = maxz;
					maxz = tmp;
				}

				if (maxx == Integer.MAX_VALUE || maxy == Integer.MAX_VALUE || maxz == Integer.MAX_VALUE)
				{
					return true;
				}

				int centerx = getTargetX(itemstack, 2);
				int centery = getTargetY(itemstack, 2);
				int centerz = getTargetZ(itemstack, 2);
				if (centerx == Integer.MAX_VALUE || centery == Integer.MAX_VALUE || centerz == Integer.MAX_VALUE)
				{
					return true;
				}

				JsonObject out = new JsonObject();
				JsonArray outArray = new JsonArray();

				out.addProperty("target", targetName);

				for (int i = minx; i <= maxx; i++)
				{
					for (int j = miny; j <= maxy; j++)
					{
						for (int k = minz; k <= maxz; k++)
						{
							String name = GameRegistry.findUniqueIdentifierFor(world.getBlock(i, j, k)).toString();
							if (name.equals(targetName))
							{
								JsonArray point = new JsonArray();
								point.add(new JsonPrimitive(i - centerx));
								point.add(new JsonPrimitive(j - centery));
								point.add(new JsonPrimitive(k - centerz));
								point.add(new JsonPrimitive(world.getBlockMetadata(i, j, k)));
								outArray.add(point);
							}
						}
					}
				}

				out.add("points", outArray);

				System.out.print(JsonHelper.prettyPrint(out).toString());
			}
		}

		return true;
	}

	private void setNBTTag(ItemStack itemstack, String tag, int value)
	{
		NBTTagCompound stackTagCompound = getStackTagCompound(itemstack);
		stackTagCompound.setInteger(tag, value);
	}

	private void setNBTTag(ItemStack itemstack, String tag, String value)
	{
		NBTTagCompound stackTagCompound = getStackTagCompound(itemstack);
		stackTagCompound.setString(tag, value);		
	}

	private int getIntFromNBT(ItemStack itemstack, String tag)
	{
		NBTTagCompound stackTagCompound = getStackTagCompound(itemstack);
		if (stackTagCompound.hasKey(tag))
		{
			return stackTagCompound.getInteger(tag);
		}
		else
		{
			return Integer.MAX_VALUE;
		}
	}

	private String getStringFromNBT(ItemStack itemstack, String tag)
	{
		NBTTagCompound stackTagCompound = getStackTagCompound(itemstack);
		return stackTagCompound.getString(tag);
	}

	private NBTTagCompound getStackTagCompound(ItemStack itemstack)
	{
		if (itemstack.stackTagCompound == null) 
			itemstack.stackTagCompound = new NBTTagCompound();
		return itemstack.stackTagCompound;
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
		setNBTTag(itemstack, "targetName", GameRegistry.findUniqueIdentifierFor(block).toString());
	}

	public String getTargetBlock(ItemStack itemstack)
	{
		return getStringFromNBT(itemstack, "targetName");
	}

	public int getTargetIndex(ItemStack itemstack)
	{
		return getIntFromNBT(itemstack, "targetIndex");
	}

	public void setTargetIndex(ItemStack itemstack, int index)
	{
		setNBTTag(itemstack, "targetIndex", index);
	}

	public void setTarget(ItemStack itemstack, int index, int x, int y, int z)
	{
		setNBTTag(itemstack, "xtarget" + index, x);
		setNBTTag(itemstack, "ytarget" + index, y);
		setNBTTag(itemstack, "ztarget" + index, z);
	}

	public int getTargetX(ItemStack itemstack, int index)
	{
		return getIntFromNBT(itemstack, "xtarget" + index);
	}

	public int getTargetY(ItemStack itemstack, int index)
	{
		return getIntFromNBT(itemstack, "ytarget" + index);
	}

	public int getTargetZ(ItemStack itemstack, int index)
	{
		return getIntFromNBT(itemstack, "ztarget" + index);
	}
}
