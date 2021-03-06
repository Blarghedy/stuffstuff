package stuffstuff.stuffstuff.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.client.sounds.Sounds;
import stuffstuff.stuffstuff.config.MiscConfig;
import stuffstuff.stuffstuff.fluid.IFluidHandler;
import stuffstuff.stuffstuff.helper.StringHelper;
import stuffstuff.stuffstuff.info.GuiInfo;
import stuffstuff.stuffstuff.items.helper.ChargeHelper;
import stuffstuff.stuffstuff.items.interfaces.IChargeable;
import stuffstuff.stuffstuff.items.interfaces.IKeyBound;
import stuffstuff.stuffstuff.power.IStuffPower;
import stuffstuff.stuffstuff.power.helper.StuffPowerHelper;

public abstract class FluidCleanerBase extends Item implements IFluidContainerItem, IFluidHandler, IChargeable, IKeyBound, IStuffPower
{
	ArrayList<ItemStack> itemstacks;
	ArrayList<Fluid> acceptedFluids;
	ItemStack empty;

	// TODO: look into making some of these methods private. Probably don't need public canAcceptFluid, for example
	// TODO: Might be a good idea to abstract this a bit further. Make an interface and a helper class, rather than requiring this as a super class

	public FluidCleanerBase()
	{
		this.setHasSubtypes(true);
		itemstacks = new ArrayList<ItemStack>();

		setCreativeTab(StuffStuff.tabStuffStuff);
		empty = new ItemStack(this); // Thanks, Plugins for Forestry!
		itemstacks.add(empty);
		acceptedFluids = new ArrayList<Fluid>();
		addFluid(FluidRegistry.LAVA);
		addFluid(FluidRegistry.WATER);
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemstack)
	{
		String fname = getFluidName(itemstack);
		return (fname == null || fname.equals("") ? "Empty" : StringHelper.upperFirst(fname)) + " " + getItemName(); // ItemInfo.FLUID_CLEANER_NAME; //this.getUnlocalizedName();
	}

	public abstract String getItemName();

	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List list)
	{
		list.addAll(itemstacks);
	}

	public boolean canAcceptFluid(Fluid f)
	{
		// TODO: this. Do it.
		// this is where we get to use this.ITEM_NAME to
		// check for permissions and such
		return true;
	}

	public String getFluidName(Fluid f)
	{
		return f == null ? "" : f.getName();
	}

	public String getFluidName(ItemStack itemstack)
	{
		FluidStack fs = null;
		if (itemstack == null)
			return "";
		else if ((fs = getFluid(itemstack)) == null)
			return "";
		else
			return getFluidName(fs.getFluid());
	}

	/*
	 * IFluidHandler implementations
	 */
	@Override
	public boolean addFluid(Fluid f)
	{
		if (canAcceptFluid(f))
		{
			if (f.canBePlacedInWorld() && !acceptedFluids.contains(f))
			{
				System.out.println("Adding " + f.getName() + " to cleaner");
				acceptedFluids.add(f);

				ItemStack stack = new ItemStack(this);
				// TODO: figure out if I need this filled variable at all
				int filled = fill(stack, new FluidStack(f, this.getCapacity(stack)), true);
				FluidContainerRegistry.registerFluidContainer(f, stack, empty);
				itemstacks.add(stack);
				return true;
			}
			return false;
		}
		else
			return false;
	}

	/*
	 * IFluidContainerItem methods
	 * @see net.minecraftforge.fluids.IFluidContainerItem#getFluid(net.minecraft.item.ItemStack)
	 * thanks to skyboy and powercrystals in MFR for knowledge of how to do this at all
	 */

	@Override
	public FluidStack getFluid(ItemStack container)
	{
		NBTTagCompound tag = container.stackTagCompound;
		FluidStack fluid = null;
		if (tag != null && tag.hasKey("fluid"))
		{
			fluid = FluidStack.loadFluidStackFromNBT(tag.getCompoundTag("fluid"));
			if (fluid == null) // some weird fluid is saved so get rid of it
			{
				tag.removeTag("fluid");
			}
		}
		return fluid;
	}

	@Override
	public int getCapacity(ItemStack container)
	{
		return FluidContainerRegistry.BUCKET_VOLUME;
	}

	@Override
	public int fill(ItemStack stack, FluidStack resource, boolean doFill)
	{
		if (resource == null)
			return 0;
		int capacity = getCapacity(stack); // should be 1000 but let's do it this way
		int fill = 0;
		FluidStack fluid = null;
		NBTTagCompound tag = stack.stackTagCompound;
		NBTTagCompound fluidTag = null;

		if (tag == null || !tag.hasKey("fluid") || // no tags or fluid not in tag yet
				(fluidTag = tag.getCompoundTag("fluid")) == null || // null is stored as a fluid
				(fluid = FluidStack.loadFluidStackFromNBT(fluidTag)) == null) // an invalid fluid somehow
		{
			fill = Math.min(capacity, resource.amount);
		}
		if (fluid == null)
		{
			fluid = resource.copy();
		}
		else if (!fluid.isFluidEqual(resource))
			return 0;
		else
		{
			fill = Math.min(resource.amount, capacity - fluid.amount);
		}

		if (fill < 0)
		{
			fill = 0;
		}

		if (doFill)
		{
			if (tag == null)
			{
				tag = stack.stackTagCompound = new NBTTagCompound();
			}
			if (fluidTag == null)
			{
				fluidTag = new NBTTagCompound();
			}

			fluid.amount = fill;
			tag.setTag("fluid", fluid.writeToNBT(fluidTag));
		}

		return fill;
	}

	@Override
	public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain)
	{
		// do nothing! Hooray!
		return null;
	}

	/*
	 * IChargeable implementation
	 */
	@Override
	public int getCharge(ItemStack itemstack)
	{
		return ChargeHelper.getCharge(itemstack);
	}

	@Override
	public int setCharge(ItemStack itemstack, short charge)
	{
		return ChargeHelper.setCharge(itemstack, charge);
	}

	@Override
	public int incrementCharge(ItemStack itemstack)
	{
		return ChargeHelper.incrementCharge(itemstack);
	}

	@Override
	public int decrementCharge(ItemStack itemstack)
	{
		return ChargeHelper.decrementCharge(itemstack);
	}

	@Override
	public double getChargePercent(ItemStack itemstack)
	{
		return ChargeHelper.getChargePercent(itemstack);
	}

	/*
	 * IKeyBound implementation
	 */
	@Override
	public void doKeyBindingAction(EntityPlayer thePlayer, ItemStack itemStack, String keyBinding)
	{
		if (keyBinding.equals(MiscConfig.KEYBINDING_CHARGE))
		{
			if (!thePlayer.isSneaking())
			{
				if (getCharge(itemStack) == ChargeHelper.MAX_CHARGE)
				{
					if (!thePlayer.worldObj.isRemote)
					{
						Sounds.SHOCK.play(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1, 0);
					}
				}
				else
				{
					if (!thePlayer.worldObj.isRemote)
					{
						Sounds.CHARGE_UP.play(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1, 0);
					}
					incrementCharge(itemStack);
				}
			}
			else
			{
				if (getCharge(itemStack) == 0)
				{
					if (!thePlayer.worldObj.isRemote)
					{
						Sounds.SHOCK.play(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1, 0);
					}
					// TODO sound stuff
					// PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.FAIL, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1.5F, 1.5F)));
				}
				else
				{
					decrementCharge(itemStack);
					if (!thePlayer.worldObj.isRemote)
					{
						Sounds.CHARGE_DOWN.play(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1, 0);
					}
					// PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.CHARGE_DOWN, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 0.5F, 1.0F - (0.5F - 0.5F * (getCharge(itemStack) * 1.0F / maxChargeLevel)))));

				}
			}
		}
		else if (keyBinding.equals(MiscConfig.KEYBINDING_EXTRA))
		{
			if (!thePlayer.isSneaking())
			{
				thePlayer.openGui(StuffStuff.instance, GuiInfo.FLUID_CLEANER_BASE_ID, thePlayer.worldObj, (int)thePlayer.posX, (int)thePlayer.posY, (int)thePlayer.posZ);
			}
			else
			{
				// TODO I like the idea of selecting a fluid here with shift + c
			}
		}
	}

	/**
	 * {@link IStuffPower} implementation
	 */

	@Override
	public double getStuffPower(ItemStack itemstack)
	{
		return StuffPowerHelper.getStuffPower(itemstack);
	}

	@Override
	public double setStuffPower(ItemStack itemstack, double power)
	{
		return StuffPowerHelper.setStuffPower(itemstack, power);
	}

	@Override
	public double increaseStuffPower(ItemStack itemstack, double amount)
	{
		return StuffPowerHelper.increaseStuffPower(itemstack, amount);
	}

	@Override
	public double decreaseStuffPower(ItemStack itemstack, double amount)
	{
		return StuffPowerHelper.decreaseStuffPower(itemstack, amount);
	}

	@Override
	public double getMaxStuffPower()
	{
		return 100;
	}

	@Override
	public double getStuffPowerPercent(ItemStack itemstack)
	{
		return StuffPowerHelper.getStuffPower(itemstack);
	}
}
