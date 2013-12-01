package stuffstuff.items;

import java.util.ArrayList;
import java.util.List;

import stuffstuff.StuffStuff;
import stuffstuff.config.MiscConfig;
import stuffstuff.fluid.IFluidHandler;
import stuffstuff.helper.StringHelper;
import stuffstuff.info.ItemInfo;
import stuffstuff.items.helper.ChargeHelper;
import stuffstuff.items.interfaces.IChargeable;
import stuffstuff.items.interfaces.IKeyBound;
import stuffstuff.sounds.Sounds;
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

public abstract class FluidCleanerBase extends Item implements IFluidContainerItem, IFluidHandler, IChargeable, IKeyBound
{
	ArrayList<ItemStack> itemstacks;
	ArrayList<Fluid> acceptedFluids;
	ItemStack empty;
	
	// TODO: look into making some of these methods private.  Probably don't need public canAcceptFluid, for example
	// TODO: Might be a good idea to abstract this a bit further.  Make an interface and a helper class, rather than requiring this as a super class
	
	public FluidCleanerBase(int id)
    {
	    super(id);
		this.setHasSubtypes(true);
		this.itemstacks = new ArrayList<ItemStack>();
		
		setCreativeTab(StuffStuff.tabStuffStuff);
		empty = new ItemStack(this); // Thanks, Plugins for Forestry!
		itemstacks.add(empty);
		acceptedFluids = new ArrayList<Fluid>();
		addFluid(FluidRegistry.LAVA);
		addFluid(FluidRegistry.WATER);
    }
	
	@Override
	public String getItemDisplayName(ItemStack par1ItemStack)
	{
		String fname = getFluidName(par1ItemStack);
	    return (fname == null || fname.equals("") ? "Empty" : StringHelper.upperFirst(fname)) + " " + getItemName(); //ItemInfo.FLUID_CLEANER_NAME; //this.getUnlocalizedName();
	}
	
	public abstract String getItemName();
	
	@Override
	public void getSubItems(int par1, CreativeTabs tabs, List list)
	{
		list.addAll(this.itemstacks);
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
		return (f == null) ? "" : f.getName();
	}
	
	public String getFluidName(ItemStack itemstack)
	{
		FluidStack fs = null;
		if (itemstack == null) return "";
		else if ((fs = getFluid(itemstack)) == null) return "";
		else return getFluidName(fs.getFluid());
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
		{
			return false;
		}
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
	    else if (!fluid.isFluidEqual(resource)) // can't store 2 fluids in 1
	    {
	    	return 0;
	    }
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
	    	if (tag == null) tag = stack.stackTagCompound = new NBTTagCompound();
	    	if (fluidTag == null) fluidTag = new NBTTagCompound();
	    	
	    	fluid.amount = fill;
	    	tag.setTag("fluid", fluid.writeToNBT(fluidTag));
	    }
	    
	    return fill;
    }

	@Override
    public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain)
    {
		// do nothing!  Hooray!
	    return null;
    }
	
	/*
	 * IChargeable implementation
	 */
	public int getCharge(ItemStack itemstack)
	{
		return ChargeHelper.getCharge(itemstack);
	}
	
	public int setCharge(ItemStack itemstack, short charge)
	{
		return ChargeHelper.setCharge(itemstack, charge);
	}
	
	public int incrementCharge(ItemStack itemstack)
	{
		return ChargeHelper.incrementCharge(itemstack);
	}
	
	public int decrementCharge(ItemStack itemstack)
	{
		return ChargeHelper.decrementCharge(itemstack);
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
			else {
				if (getCharge(itemStack) == 0) 
				{
					if (!thePlayer.worldObj.isRemote)
					{
						Sounds.SHOCK.play(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1, 0);
					}
					// TODO sound stuff
//					PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.FAIL, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1.5F, 1.5F)));
				}
				else {
					decrementCharge(itemStack);
					if (!thePlayer.worldObj.isRemote)
					{
						Sounds.CHARGE_DOWN.play(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1, 0);
					}
//					PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.CHARGE_DOWN, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 0.5F, 1.0F - (0.5F - 0.5F * (getCharge(itemStack) * 1.0F / maxChargeLevel)))));
					
				}
			}
		}
    }
}
