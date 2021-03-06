package stuffstuff.stuffstuff.client.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.GuiInfo;
import stuffstuff.stuffstuff.inventory.ContainerFluidCleanerBase;
import stuffstuff.stuffstuff.inventory.ContainerItemBlockPlacer;
import stuffstuff.stuffstuff.items.FluidCleanerBase;
import stuffstuff.stuffstuff.items.ItemBlockPlacer;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler
{

	public GuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(StuffStuff.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		ItemStack itemstack;

		switch (ID)
		{
			case GuiInfo.ITEM_BLOCK_PLACER_ID:
				itemstack = player.getHeldItem();
				if (itemstack != null)
				{
					Item item = itemstack.getItem();
					if (item instanceof ItemBlockPlacer)
						return new ContainerItemBlockPlacer(player.inventory, itemstack);
				}
				break;
			case GuiInfo.FLUID_CLEANER_BASE_ID:
				itemstack = player.getHeldItem();
				if (itemstack != null)
				{
					Item item = itemstack.getItem();
					if (item instanceof FluidCleanerBase)
						return new ContainerFluidCleanerBase(player.inventory, itemstack);
				}
				break;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		ItemStack itemstack;
		switch (ID)
		{
			case GuiInfo.ITEM_BLOCK_PLACER_ID:
				itemstack = player.getHeldItem();
				if (itemstack != null)
				{
					Item item = itemstack.getItem();
					if (item instanceof ItemBlockPlacer)
						return new GuiItemBlockPlacer(player.inventory, itemstack);
				}
				break;
			case GuiInfo.FLUID_CLEANER_BASE_ID:
				itemstack = player.getHeldItem();
				if (itemstack != null)
				{
					Item item = itemstack.getItem();
					if (item instanceof FluidCleanerBase)
						return new GuiFluidCleanerBase(player.inventory, itemstack);
				}
				break;
				// TileEntity te = world.getBlockTileEntity(x, y, z);
				// if (te != null && te instanceof TileEntityMachine)
				// {
				// return new GuiMachine(player.inventory, (TileEntityMachine)te);
				// }
				// break;
		}
		return null;
	}

}
