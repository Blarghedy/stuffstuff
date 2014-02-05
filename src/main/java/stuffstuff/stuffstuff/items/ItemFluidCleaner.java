package stuffstuff.stuffstuff.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import stuffstuff.stuffstuff.fluid.FluidHelper;
import stuffstuff.stuffstuff.info.ItemInfo;
import stuffstuff.stuffstuff.player.NotificationHelper;

public class ItemFluidCleaner extends FluidCleanerBase
{

	public ItemFluidCleaner(int id)
	{
		super(id);
		setUnlocalizedName(ItemInfo.FLUID_CLEANER_UNLOCALIZED_NAME);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			FluidStack fluid = getFluid(itemstack);
			if (fluid == null || fluid.getFluid() == null || fluid.amount == 0)
			{
				// TODO add functionality to fill this item like a bucket
			}
			else
			{
				int startx, starty, startz;
				startx = MathHelper.floor_double(player.posX);
				starty = MathHelper.floor_double(player.posY + 1);
				startz = MathHelper.floor_double(player.posZ);
				int len = getCharge(itemstack);
				NotificationHelper.notifySelf("deleting " + fluid.getFluid().getName());
				for (int i = 0 - len; i < len + 1; i++)
				{
					for (int j = 0 - len; j < len + 1; j++)
					{
						for (int k = 0 - len; k < len + 1; k++)
						{
							if (FluidHelper.isFluid(world, startx + i, starty + j, startz + k, fluid.getFluid()))
							{
								world.setBlockToAir(startx + i, starty + j, startz + k);
							}
						}
					}
				}
			}
		}
		return super.onItemRightClick(itemstack, world, player);
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean par4)
	{
		// add hover text
		String fname = getFluidName(itemstack);
		if (fname == null || fname.equals(""))
		{
			info.add("Add a fluid to this");
			info.add("More useful info here");
		}
		else
		{
			info.add("Delete " + fname);
		}
		super.addInformation(itemstack, player, info, par4);
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		super.registerIcons(par1IconRegister);
	}

	@Override
	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		return super.getIcon(stack, renderPass, player, usingItem, useRemaining);
	}

	@Override
	public Icon getIconIndex(ItemStack par1ItemStack)
	{
		return super.getIconIndex(par1ItemStack);
	}

	@Override
	public String getItemName()
	{
		return ItemInfo.FLUID_CLEANER_NAME;
	}

}
