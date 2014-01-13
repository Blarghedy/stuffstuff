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

public class BlockStuffSlab extends BlockHalfSlab
{
	private Block[] modelBlocks;
	private int singleID, doubleID;

	public BlockStuffSlab(int id, boolean isDouble, Block[] modelBlocks, int otherID)
	{
		super(id, isDouble, modelBlocks[0].blockMaterial);
		this.modelBlocks = modelBlocks;
		if (isDouble)
		{
			this.doubleID = id;
			this.singleID = otherID;
		}
		else
		{
			this.singleID = id;
			this.doubleID = otherID;
		}
		
		setHardness(modelBlocks[0].blockHardness);
		setCreativeTab(modelBlocks[0].getCreativeTabToDisplayOn());
		
		setStepSound(modelBlocks[0].stepSound);
		setResistance(modelBlocks[0].blockResistance / 2);
		setBurnProperties(id, blockFireSpreadSpeed[modelBlocks[0].blockID], blockFlammability[modelBlocks[0].blockID]);
		
		setUnlocalizedName(modelBlocks[0].getUnlocalizedName() + "Slab");
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
		return singleID;
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
		return singleID;
	}

	@Override
	protected ItemStack createStackedBlock(int meta)
	{
		return super.createStackedBlock(meta);
	}


}
