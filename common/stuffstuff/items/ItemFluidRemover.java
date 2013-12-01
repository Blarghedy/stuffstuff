package stuffstuff.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

public class ItemFluidRemover extends Item
{
	int stillFluid, movingFluid;
	Fluid flu;
	
	public ItemFluidRemover(int id, int stillFluid, int movingFluid)
	{
		super(id);
		this.stillFluid = stillFluid;
		this.movingFluid = movingFluid;
		flu = null;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			int startx, starty, startz;
			startx = (int)(player.posX);
			starty = (int)(player.posY);
			startz = (int)(player.posZ);
			int id;
			int len = 8;
			
			if (player.isSneaking())
			{
				player.sendChatToPlayer(ChatMessageComponent.createFromText("fixing " + stillFluid));
				for (int i = 0 - len; i < len; i++)
				{
					for (int j = 0 - len; j < len; j++)
					{
						for (int k = 0 - len; k < len; k++)
						{
							id = world.getBlockId(startx + i, starty + j, startz + k);
							if (id == stillFluid || id == movingFluid)
							{
								world.setBlockToAir(startx + i, starty + j, startz + k);
								world.setBlock(startx + i, starty + j, startz + k, stillFluid);
							}
						}
					}
				}
			}
			else
			{
				player.sendChatToPlayer(ChatMessageComponent.createFromText("deleting " + stillFluid));
				for (int i = 0 - len; i < len; i++)
				{
					for (int j = 0 - len; j < len; j++)
					{
						for (int k = 0 - len; k < len; k++)
						{
							id = world.getBlockId(startx + i, starty + j, startz + k);
							if (id == movingFluid || id == stillFluid)
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
		String name = Block.blocksList[this.stillFluid].getLocalizedName();
		info.add("Delete " + name);
		info.add("or hold shift to fix");
		
	    super.addInformation(itemstack, player, info, par4);
	}
	
	@Override
	public String getItemDisplayName(ItemStack par1ItemStack)
	{
	    return (flu == null ? "Empty" : flu.getName()) + " " + this.getUnlocalizedName();
	}
	
	/*
	 * @Override
    public String getItemDisplayName(ItemStack par1ItemStack) {
        if (par1ItemStack.getItemDamage() > 0) {
            return PfFLib.FluidUtils.fixName(fluids.get(par1ItemStack.getItemDamage())).concat(" ").concat(PfFTranslator.instance.translateKey(unloc));
        }
        return PfFTranslator.instance.translateKey(unloc);
    }
	 */
	
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
	
	@Override
	public Icon getIconIndex(ItemStack par1ItemStack)
	{
	    // TODO Auto-generated method stub
	    return super.getIconIndex(par1ItemStack);
	}
}
