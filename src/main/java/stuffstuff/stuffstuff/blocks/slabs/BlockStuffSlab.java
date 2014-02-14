package stuffstuff.stuffstuff.blocks.slabs;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidBlock;

public class BlockStuffSlab extends BlockSlab
{
	private Block[] modelBlocks;
	private Block singleBlock, doubleBlock;
	private boolean useModelTexture;
	private int[] modelMeta;

	public BlockStuffSlab(boolean isDouble, Block[] modelBlocks)
	{
		this(isDouble, modelBlocks, true, null);
	}

	/**
	 * 
	 * @param other
	 * @param isDouble
	 * @param modelBlocks 
	 * @param useModelTexture If this is true, this block's getBlockTexture will use model.getBlockTexture.
	 * Otherwise, it defaults to {@link Block#getBlockTexture(IBlockAccess, int, int, int, int)}
	 */
	public BlockStuffSlab(boolean isDouble, Block[] modelBlocks, boolean useModelTexture, int[] modelMeta)
	{
		super(isDouble, modelBlocks[0].getMaterial());
		this.modelBlocks = modelBlocks;
		this.useModelTexture = useModelTexture;
		this.modelMeta = modelMeta;
		lightValue = modelBlocks[0].getLightValue();
		slipperiness = modelBlocks[0].slipperiness;

		setCreativeTab(modelBlocks[0].getCreativeTabToDisplayOn());

		setStepSound(modelBlocks[0].stepSound);
	}

	public void setOther(BlockStuffSlab other)
	{
		if (opaque)
		{
			this.doubleBlock = this;
			this.singleBlock = other;
		}
		else
		{
			this.singleBlock = this;
			this.doubleBlock = other;
		}
	}

	@Override
	public String getUnlocalizedName()
	{
		return modelBlocks[0].getUnlocalizedName() + "Slab";
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return modelBlocks[0].getFireSpreadSpeed(world, x, y, z, face);
	}

	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) 
	{
		return modelBlocks[0].getFlammability(world, x, y, z, face);
	}

	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		float blockHardness = modelBlocks[0].getBlockHardness(world, x, y, z);
		return (opaque ? blockHardness : blockHardness / 2);
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		for (int i = 0; i < modelBlocks.length; ++i) 
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		if (useModelTexture)
		{
			int meta = world.getBlockMetadata(x, y, z) % 8;
			meta = meta < modelBlocks.length ? meta : 0;

			Block model = modelBlocks[meta];
			return model.getIcon(world, x, y, z, side);
		}
		else
		{
			return super.getIcon(world, x, y, z, side);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		meta = meta % 8;
		meta = meta < modelBlocks.length ? meta : 0;

		if (modelMeta == null)
			return modelBlocks[meta].getIcon(side, meta);
		else
			return modelBlocks[meta].getIcon(side, modelMeta[meta]);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int par3)
	{
		return Item.getItemFromBlock(singleBlock);
	}

	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return Item.getItemFromBlock(singleBlock);
	}

	@Override
	public boolean canCollideCheck(int meta, boolean boat)
	{
		return modelBlocks[0].canCollideCheck(meta, boat);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		if (modelBlocks[0] instanceof IFluidBlock || modelBlocks[0] instanceof BlockLiquid) 
			return modelBlocks[0].getCollisionBoundingBoxFromPool(world, x, y, z);
		else
			return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	public Block[] getModels()
	{
		return modelBlocks;
	}

	//	@Override
	//	public String getFullSlabName(int meta)
	//	{
	//		meta = meta < modelBlocks.length ? meta : 0;
	//
	//		return modelBlocks[meta].getLocalizedName() + " Slab";
	//	}

	/**
	 * {@link BlockSlab} implementation
	 */

	@Override
	public String func_150002_b(int meta)
	{
		// possibly getFullSlabName?
		meta = meta < modelBlocks.length ? meta : 0;

		return modelBlocks[meta].getLocalizedName() + " Slab";
	}
}
