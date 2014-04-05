package stuffstuff.stuffstuff.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
			System.out.println("Setting center to " + x + " " + y + " " + z + " " + block.getUnlocalizedName());
		}
		else
		{
			int index = getTargetIndex(itemstack);
			setTarget(itemstack, index, x, y, z);
			index = index == 0 ? 1 : 0;
			setTargetIndex(itemstack, index);
			String targetUnlocalizedName = getTargetBlock(itemstack);

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

				System.out.println("Searching for " + targetUnlocalizedName);
				System.out.print("{");
				int count = 0;
				boolean printComma = false;

				for (int i = minx; i <= maxx; i++)
				{
					for (int j = miny; j <= maxy; j++)
					{
						for (int k = minz; k <= maxz; k++)
						{
							String unlocalizedName = world.getBlock(i, j, k).getUnlocalizedName();
							if (unlocalizedName.equals(targetUnlocalizedName))
							{
								count++;
								System.out.print((printComma ? "," : "") + "\n\t{" + i + ", " + j + ", " + k + ", " + world.getBlockMetadata(i, j, k) + "}");
								printComma = true;
							}
						}
					}
				}

				System.out.println("\n}");
				System.out.println("Central location: " + getTargetX(itemstack, 2) + " " + getTargetY(itemstack, 2) + " " + getTargetZ(itemstack, 2));
				System.out.println("Found " + count + " indexes of " + targetUnlocalizedName);
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
		setNBTTag(itemstack, "targetUnlocalized", block.getUnlocalizedName());
	}

	public String getTargetBlock(ItemStack itemstack)
	{
		return getStringFromNBT(itemstack, "targetUnlocalized");
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
