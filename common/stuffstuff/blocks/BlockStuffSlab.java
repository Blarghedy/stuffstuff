package stuffstuff.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockStuffSlab extends BlockHalfSlab
{
	private Block[] modelBlocks;

	public BlockStuffSlab(int id, boolean isDouble, Block[] modelBlocks)
	{
		super(id, isDouble, modelBlocks[0].blockMaterial);
		this.modelBlocks = modelBlocks;
		setHardness(modelBlocks[0].blockHardness);
		setCreativeTab(StuffStuff.tabStuffStuff);

		if (blockID == BlockInfo.STONE_SLAB_ID)
		{
			setUnlocalizedName(BlockInfo.STONE_SLAB_UNLOCALIZED_NAME);
		}
		else if (blockID == BlockInfo.STONE_SLAB_DOUBLE_ID)
		{
			setUnlocalizedName(BlockInfo.STONE_SLAB_DOUBLE_UNLOCALIZED_NAME);
		}
		else if (blockID == BlockInfo.WOOD_SLAB_ID)
		{
			setUnlocalizedName(BlockInfo.WOOD_SLAB_UNLOCALIZED_NAME);
		}
		else if (blockID == BlockInfo.WOOD_SLAB_DOUBLE_ID)
		{
			setUnlocalizedName(BlockInfo.WOOD_SLAB_DOUBLE_UNLOCALIZED_NAME);
		}
		
		if (blockID == BlockInfo.STONE_SLAB_ID || blockID == BlockInfo.STONE_SLAB_DOUBLE_ID)
		{
			setStepSound(Block.soundStoneFootstep);
		}
		else // is wood
		{
			setBurnProperties(blockID, 5, 20);
			setResistance(5.0F);
			setStepSound(Block.soundWoodFootstep);
		}
	}

	@Override
	public String getFullSlabName(int meta)
	{
		return modelBlocks[meta].getLocalizedName() + " Slab";
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		super.registerIcons(register);
	}

	@Override
	public void getSubBlocks(int id, CreativeTabs tabs, List list)
	{
		for (int i = 0; i < modelBlocks.length; ++i) 
		{
			list.add(new ItemStack(blockID, 1, i));
		}
	}

	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side)
	{
		// TODO check if this works - try slabs placed on the bottoms of things and double slabs
		Block model = modelBlocks[world.getBlockMetadata(x, y, z) % 8];
		return model.getBlockTexture(world, x, y, z, side);
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
		return modelBlocks[meta % 8].getIcon(side, meta % 8);
	}

	@Override
	public int idDropped(int meta, Random rand, int par3)
	{
		if (!isDoubleSlab)
		{
			return blockID;
		}
		else if (blockID == Blocks.blockStoneDoubleSlab.blockID)
		{
			return Blocks.blockStoneSlab.blockID;
		}
		else if (blockID == Blocks.blockWoodDoubleSlab.blockID)
		{
			return Blocks.blockWoodSlab.blockID;
		}
		else return 0;
	}

	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		return (isDoubleSlab ? blockHardness : blockHardness / 2);
	}

	@Override
	public float getExplosionResistance(Entity par1Entity)
	{
		return super.getExplosionResistance(par1Entity);
	}

	@Override
	public int idPicked(World world, int x, int y, int z)
	{
		return super.idPicked(world, x, y, z);
	}

	@Override
	protected ItemStack createStackedBlock(int meta)
	{
		return super.createStackedBlock(meta);
	}

	
}
