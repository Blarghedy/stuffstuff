package stuffstuff.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import stuffstuff.worldgen.WorldGenPlaidTrees;

public class BlockPlaidSapling extends BlockSapling
{
	private Icon[] icons;
	
	public BlockPlaidSapling(int id)
    {
	    super(id);
        this.setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(0.0F);
		setStepSound(soundGrassFootstep);
		setUnlocalizedName(BlockInfo.PLAID_SAPLING_UNLOCALIZED_NAME);
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
		icons = new Icon[BlockInfo.PLAID_SAPLING_TEXTURES.length];
		
		for (int i = 0; i < BlockInfo.PLAID_SAPLING_TEXTURES.length; i++)
		{
			icons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_SAPLING_TEXTURES[i]);
		}
	}
	
	@Override
	public void getSubBlocks(int id, CreativeTabs tabs, List list)
	{
		for (int i = 0; i < BlockInfo.PLAID_SAPLING_TEXTURES.length; i++)
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
		if (world.isRemote) return;
		
		world.setBlockToAir(x, y, z);
		boolean grew = new WorldGenPlaidTrees().growTree(world, rand, x, y, z);
		if (!grew) world.setBlock(x, y, z, blockID, 0, 4);
	}
	
	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int blockID)
	{
	    return blockID == Blocks.blockPlaidGrass.blockID || super.canThisPlantGrowOnThisBlockID(blockID);
	}
	
	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z)
	{
	    return EnumPlantType.Plains;
	}

}
