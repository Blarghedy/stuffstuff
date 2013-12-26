package stuffstuff.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlaidLeaves extends BlockLeaves
{
	private Icon[] icons;
	private Icon[] opaqueIcons;
	
	public BlockPlaidLeaves(int id)
    {
		super(id);
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
	    return isOpaqueCube() ? opaqueIcons[meta & 3] : icons[meta & 3];
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
		super.breakBlock(world, x, y, z, id, meta);
	}
	
	@Override
	public boolean isLeaves(World world, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public void beginLeavesDecay(World world, int x, int y, int z)
	{
	    super.beginLeavesDecay(world, x, y, z);
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta & 3;
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
	

    @SideOnly(Side.CLIENT)
    @Override
    public int getBlockColor()
    {
    	// what even is this?
    	return 16777215;
    }
    
    @Override
    public int getRenderColor(int par1)
    {
        return getBlockColor();
    }
    
    @Override
    public int colorMultiplier(IBlockAccess par1iBlockAccess, int par2, int par3, int par4)
    {
    	return getBlockColor();
    }
}
