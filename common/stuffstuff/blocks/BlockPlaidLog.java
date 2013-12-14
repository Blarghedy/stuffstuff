package stuffstuff.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidLog extends Block
{
	private Icon[] icons;
	private Icon topIcon;
	
	public BlockPlaidLog(int id)
    {
	    super(id, Material.wood);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(2F);
		setStepSound(soundWoodFootstep);
		setUnlocalizedName(BlockInfo.BLOCK_PLAID_LOG_UNLOCALIZED_NAME);
    }

	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
	    for (int i = 0; i < BlockInfo.BLOCK_PLAID_LOG_TEXTURES.length; i++)
	    {
	    	list.add(new ItemStack(id, 1, i));
	    }
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
		ForgeDirection d = ForgeDirection.getOrientation(side);
		return (d == ForgeDirection.UP || d == ForgeDirection.DOWN ? topIcon : icons[meta]);
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		icons = new Icon[BlockInfo.BLOCK_PLAID_LOG_TEXTURES.length];
		
	    for (int i = 0; i < BlockInfo.BLOCK_PLAID_LOG_TEXTURES.length; i++)
	    {
	    	icons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_PLAID_LOG_TEXTURES[i]);
	    }
	    
	    topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_PLAID_LOG_TOP_TEXTURE);
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
}
