package stuffstuff.items;

import stuffstuff.fluid.FluidHelper;
import stuffstuff.info.ItemInfo;
import stuffstuff.player.NotificationHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

public class ItemFluidSmoother extends FluidCleanerBase
{

	public ItemFluidSmoother(int id)
    {
	    super(id);
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

				NotificationHelper.notifySelf("fixing " + fluid.getFluid().getName());
				for (int i = 0 - len; i < len + 1; i++)
				{
					for (int j = 0 - len; j < len + 1; j++)
					{
						for (int k = 0 - len; k < len + 1; k++)
						{
							if (FluidHelper.isFlowingFluid(world, startx + i, starty + j, startz + k, fluid.getFluid()))
							{
								world.setBlockToAir(startx + i, starty + j, startz + k); 
								world.setBlock(startx + i, starty + j, startz + k, fluid.getFluid().getBlockID());
							}
						}
					}
				}
			}
		}
	    return super.onItemRightClick(itemstack, world, player);
	}

	@Override
    public String getItemName()
    {
	    return ItemInfo.FLUID_SMOOTHER_NAME;
    }
}
