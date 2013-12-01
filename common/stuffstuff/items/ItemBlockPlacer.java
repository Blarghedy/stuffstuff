package stuffstuff.items;

import cpw.mods.fml.common.network.PacketDispatcher;
import stuffstuff.StuffStuff;
import stuffstuff.config.MiscConfig;
import stuffstuff.info.ItemInfo;
import stuffstuff.items.helper.ChargeHelper;
import stuffstuff.items.helper.BlockPlaceModeHelper;
import stuffstuff.items.interfaces.IBlockPlaceMode;
import stuffstuff.items.interfaces.IChargeable;
import stuffstuff.items.interfaces.IKeyBound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBlockPlacer extends Item implements IChargeable, IKeyBound, IBlockPlaceMode
{
	
	public ItemBlockPlacer(int id)
	{
		super(id);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setUnlocalizedName(ItemInfo.BLOCK_PLACER_UNLOCALIZED_NAME);
		
	}

	/*
	 * IChargeable implementation
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

	/*
	 * IKeyBound implementation
	 */
	@Override
    public void doKeyBindingAction(EntityPlayer thePlayer, ItemStack itemStack, String keyBinding)
	{
		System.out.println(keyBinding);
		if (keyBinding.equals(MiscConfig.KEYBINDING_CHARGE)) 
		{
			if (!thePlayer.isSneaking()) 
			{
				// TODO max charge stuff
				//if (getCharge(itemStack) == maxChargeLevel) {
				//	PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.FAIL, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1.5F, 1.5F)));
				//}
				//else {
				incrementCharge(itemStack);
				// TODO sound stuff
//				PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.CHARGE_UP, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 0.5F, 0.5F + 0.5F * (getCharge(itemStack) * 1.0F / maxChargeLevel))));
				//   }
			}
			else {
				if (getCharge(itemStack) == 0) 
				{
					// TODO sound stuff
//					PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.FAIL, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 1.5F, 1.5F)));
				}
				else 
				{
					decrementCharge(itemStack);
//					PacketDispatcher.sendPacketToAllAround(thePlayer.posX, thePlayer.posY, thePlayer.posZ, 64D, thePlayer.worldObj.provider.dimensionId, PacketTypeHandler.populatePacket(new PacketSoundEvent(thePlayer.username, Sounds.CHARGE_DOWN, thePlayer.posX, thePlayer.posY, thePlayer.posZ, 0.5F, 1.0F - (0.5F - 0.5F * (getCharge(itemStack) * 1.0F / maxChargeLevel)))));
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
	}
	
	/**
	 * IBlockPlaceMode implementation
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
}
