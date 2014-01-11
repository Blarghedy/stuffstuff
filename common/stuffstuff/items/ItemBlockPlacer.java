package stuffstuff.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import stuffstuff.StuffStuff;
import stuffstuff.config.MiscConfig;
import stuffstuff.info.GuiInfo;
import stuffstuff.info.ItemInfo;
import stuffstuff.items.helper.BlockPlaceModeHelper;
import stuffstuff.items.helper.ChargeHelper;
import stuffstuff.items.interfaces.IBlockPlaceMode;
import stuffstuff.items.interfaces.IChargeable;
import stuffstuff.items.interfaces.IKeyBound;
import stuffstuff.power.IStuffPower;
import stuffstuff.power.helper.StuffPowerHelper;

public class ItemBlockPlacer extends Item implements IChargeable, IKeyBound, IBlockPlaceMode, IStuffPower
{
	public static final int NO_TARGET = -1;
	public static final String TARGET_BLOCK_KEY = "ss target";

	public ItemBlockPlacer(int id)
	{
		super(id);
		setCreativeTab(StuffStuff.tabAEStuff);
		setUnlocalizedName(ItemInfo.BLOCK_PLACER_UNLOCALIZED_NAME);
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.BLOCK_PLACER_ICON);
	}

	@Override
	public Icon getIconIndex(ItemStack itemstack)
	{
		// TODO Auto-generated method stub
		return super.getIconIndex(itemstack);
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		// This function is huge so I'm just sticking it in the helper to avoid bloat here.
		return BlockPlaceModeHelper.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
	}

	public int getTargetBlockID(ItemStack itemstack)
	{
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (tag == null || !tag.hasKey(TARGET_BLOCK_KEY))
			return NO_TARGET;
		else
			return tag.getInteger(TARGET_BLOCK_KEY);
	}

	public int setTargetBlockID(ItemStack itemstack, int target)
	{
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (tag == null)
		{
			tag = itemstack.stackTagCompound = new NBTTagCompound();
		}
		if (target > 4095)
		{
			target = -1; // TODO figure out a solid thing to do here 'cause iunno
		}
		tag.setInteger(TARGET_BLOCK_KEY, target);
		return target;
	}

	// public void fillRegion(InventoryPlayer player, ItemStack itemstack, )

	/**
	 * {@link IChargeable} implementation
	 */
	@Override
	public int getCharge(ItemStack itemstack)
	{
		int charge = ChargeHelper.getCharge(itemstack);
		return charge;
	}

	@Override
	public int setCharge(ItemStack itemstack, short charge)
	{
		int c = ChargeHelper.setCharge(itemstack, charge);
		return c;
	}

	@Override
	public int incrementCharge(ItemStack itemstack)
	{
		int charge = ChargeHelper.incrementCharge(itemstack);
		return charge;
	}

	@Override
	public int decrementCharge(ItemStack itemstack)
	{
		int charge = ChargeHelper.decrementCharge(itemstack);
		return charge;
	}

	@Override
	public double getChargePercent(ItemStack itemstack)
	{
		double charge = ChargeHelper.getChargePercent(itemstack);
		return charge;
	}

	/**
	 * {@link IKeyBound} implementation
	 */
	@Override
	public void doKeyBindingAction(EntityPlayer thePlayer, ItemStack itemStack, String keyBinding)
	{
		// charge: charge up
		// shift + charge: charge down
		// toggle: mode change
		// shift + toggle: mode down
		// extra: GUI
		// shift + extra: select targeted block

		if (keyBinding.equals(MiscConfig.KEYBINDING_CHARGE))
		{
			if (!thePlayer.isSneaking())
			{
				// TODO max charge stuff
				// if (getCharge(itemStack) == maxChargeLevel) {
				// PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.FAIL, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1.5F, 1.5F)));
				// }
				// else {
				incrementCharge(itemStack);
				// TODO sound stuff
				// PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.CHARGE_UP, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 0.5F, 0.5F + 0.5F * (getCharge(itemStack) * 1.0F / maxChargeLevel))));
				// }
			}
			else
			{
				if (getCharge(itemStack) == 0)
				{
					// TODO sound stuff
					// PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.FAIL, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1.5F, 1.5F)));
				}
				else
				{
					decrementCharge(itemStack);
					// PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.CHARGE_DOWN, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 0.5F, 1.0F - (0.5F - 0.5F * (getCharge(itemStack) * 1.0F / maxChargeLevel)))));
				}
			}
		}
		else if (keyBinding.equals(MiscConfig.KEYBINDING_TOGGLE))
		{
			if (!thePlayer.isSneaking())
			{
				incrementBlockPlaceMode(itemStack);
			}
			else
			{
				decrementBlockPlaceMode(itemStack);
			}
		}
		else if (keyBinding.equals(MiscConfig.KEYBINDING_EXTRA))
		{
			// thePlayer.openGui(EquivalentExchange3.instance, GuiIds.PORTABLE_CRAFTING, thePlayer.worldObj, (int) thePlayer.posX, (int) thePlayer.posY, (int) thePlayer.posZ);
			if (!thePlayer.isSneaking())
			{
				thePlayer.openGui(StuffStuff.instance, GuiInfo.ITEM_BLOCK_PLACER_ID, thePlayer.worldObj, (int)thePlayer.posX, (int)thePlayer.posY, (int)thePlayer.posZ);
			}
			else
			{
				// select targeted block
			}
		}
	}

	/**
	 * {@link IBlockPlaceMode} implementation
	 */

	@Override
	public BlockPlaceMode getBlockPlaceMode(ItemStack itemstack)
	{
		return BlockPlaceModeHelper.getBlockPlaceMode(itemstack);
	}

	@Override
	public BlockPlaceMode setBlockPlaceMode(ItemStack itemstack, BlockPlaceMode mode)
	{
		return BlockPlaceModeHelper.setBlockPlaceMode(itemstack, mode);
	}

	@Override
	public BlockPlaceMode incrementBlockPlaceMode(ItemStack itemstack)
	{
		return BlockPlaceModeHelper.incrementBlockPlaceMode(itemstack);
	}

	@Override
	public BlockPlaceMode decrementBlockPlaceMode(ItemStack itemstack)
	{
		return BlockPlaceModeHelper.decrementBlockPlaceMode(itemstack);
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
