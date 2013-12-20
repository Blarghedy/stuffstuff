package stuffstuff.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidLeaves extends BlockLeavesBase
{
	private Icon[] icons;
	private Icon[] opaqueIcons;
	
	public BlockPlaidLeaves(int id)
    {
		// TODO figure out how to use this third argument.
	    super(id, Material.leaves, false);
	    setCreativeTab(StuffStuff.tabStuffStuff);
	    setLightOpacity(1);
	    setStepSound(soundGrassFootstep);
	    setHardness(.2F);
    }
	
	@Override
	public boolean isOpaqueCube()
	{
		// If the vanilla leaves are opaque, we want to render opaque as well.
		// This basically lets me be lazy and not determine this myself.
	    return Block.leaves.isOpaqueCube();
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
	    return !isOpaqueCube() || super.shouldSideBeRendered(blockAccess, x, y, z, side);
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		icons = new Icon[BlockInfo.PLAID_LEAVES_TEXTURES.length];
		opaqueIcons = new Icon[BlockInfo.PLAID_OPAQUE_LEAVES_TEXTURES.length];
		
		for (int i = 0; i < BlockInfo.PLAID_LEAVES_TEXTURES.length; i++)
		{
			icons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_LEAVES_TEXTURES[i]);
			opaqueIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_OPAQUE_LEAVES_TEXTURES[i]);
		}
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
	    return isOpaqueCube() ? opaqueIcons[meta % opaqueIcons.length] : icons[meta % icons.length];
	}
	
	@Override
	public void getSubBlocks(int id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < BlockInfo.PLAID_LEAVES_TEXTURES.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int meta)
	{
    	if (world.checkChunksExist(x - 2, y - 2, z - 2, x + 2, y + 2, z + 2))
    	{
    		// TODO this
    	}
	}
	
	@Override
	public boolean isLeaves(World world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public void beginLeavesDecay(World world, int x, int y, int z)
	{
	    // TODO Auto-generated method stub
	    super.beginLeavesDecay(world, x, y, z);
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	@Override
	public int idDropped(int meta, Random rand, int a)
	{
		return Blocks.blockPlaidSapling.blockID;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(20) > 1 ? 0 : 1;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int meta, float chance, int par7)
	{
		if(!world.isRemote)
		{
			ArrayList<ItemStack> items = getBlockDropped(world, x, y, z, meta, par7);
			
			for (ItemStack item : items)
			{
				if (world.rand.nextFloat() <= chance)
				{
					this.dropBlockAsItem_do(world, x, y, z, item);
				}
			}
		}
	}
}
