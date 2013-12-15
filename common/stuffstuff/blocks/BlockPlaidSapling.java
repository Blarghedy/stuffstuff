package stuffstuff.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidSapling extends BlockSapling
{
	private Icon[] icons;
	
	public BlockPlaidSapling(int id)
    {
	    super(id);
        this.setCreativeTab(StuffStuff.tabStuffStuff);
    }
	
	@Override
	public Icon getIcon(int side, int meta)
	{
		if (meta >= icons.length) return icons[0];
		else return icons[meta];
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		icons = new Icon[BlockInfo.BLOCK_PLAID_SAPLING_TEXTURES.length];
		
		for (int i = 0; i < BlockInfo.BLOCK_PLAID_SAPLING_TEXTURES.length; i++)
		{
			icons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_PLAID_SAPLING_TEXTURES[i]);
		}
	}
	
	@Override
	public void getSubBlocks(int id, CreativeTabs tabs, List list)
	{
		for (int i = 0; i < BlockInfo.BLOCK_PLAID_SAPLING_TEXTURES.length; i++)
		{
			list.add(new ItemStack(id, 1, i));
		}
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	@Override
	public void growTree(World world, int x, int y, int z, Random rand)
	{
	    // TODO Auto-generated method stub
	    super.growTree(world, x, y, z, rand);
	}
	
	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int blockID)
	{
	    return super.canThisPlantGrowOnThisBlockID(blockID);
	}

}
