package stuffstuff.items;

import java.util.List;

import stuffstuff.StuffStuff;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemWaterRemover extends ItemFluidRemover
{
	public ItemWaterRemover(int id)
	{
		super(id, Block.waterStill.blockID, Block.waterMoving.blockID);
		setCreativeTab(StuffStuff.tabStuffStuff);
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
	    // TODO Auto-generated method stub
	    super.registerIcons(par1IconRegister);
	}

	
	@Override
	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
	    // TODO Auto-generated method stub
	    return super.getIcon(stack, renderPass, player, usingItem, useRemaining);
	}
}
