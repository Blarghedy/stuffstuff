package stuffstuff.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidLog extends BlockLog
{
	private Icon[] icons;
	private Icon topIcon;
	
	public BlockPlaidLog(int id)
    {
	    super(id);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(2F);
		setStepSound(soundWoodFootstep);
		setUnlocalizedName(BlockInfo.PLAID_LOG_UNLOCALIZED_NAME);
		setBurnProperties(id, 5, 20);
    }

	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
	    for (int i = 0; i < BlockInfo.PLAID_LOG_TEXTURES.length; i++)
	    {
	    	list.add(new ItemStack(id, 1, i));
	    }
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
		return super.getIcon(side, meta); // BlockRotatedPillar takes care of this for us
	}
	
	@Override
	protected Icon getEndIcon(int par1)
	{
	    return topIcon;
	}
	
	@Override
	protected Icon getSideIcon(int meta)
	{
		return icons[meta];
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		icons = new Icon[BlockInfo.PLAID_LOG_TEXTURES.length];
		
	    for (int i = 0; i < BlockInfo.PLAID_LOG_TEXTURES.length; i++)
	    {
	    	icons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_LOG_TEXTURES[i]);
	    }
	    
	    topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_LOG_TOP_TEXTURE);
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return blockID;
	}
	
	@Override
	public boolean isWood(World world, int x, int y, int z)
	{
	    return true;
	}
	
	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z)
	{
		return true;
	}
}
