package stuffstuff.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidBlock;

public class BlockStuffSlab extends BlockHalfSlab
{
	private Block[] modelBlocks;
	private int singleID, doubleID;
	private boolean useModelTexture;
	private int[] modelMeta;

	public BlockStuffSlab(int id, int otherID, boolean isDouble, Block[] modelBlocks)
	{
		this(id, otherID, isDouble, modelBlocks, true, null);
	}

	/**
	 * 
	 * @param id
	 * @param otherID
	 * @param isDouble
	 * @param modelBlocks 
	 * @param useModelTexture If this is true, this block's getBlockTexture will use model.getBlockTexture.
	 * Otherwise, it defaults to {@link Block#getBlockTexture(IBlockAccess, int, int, int, int)}
	 */
	public BlockStuffSlab(int id, int otherID, boolean isDouble, Block[] modelBlocks, boolean useModelTexture, int[] modelMeta)
	{
		super(id, isDouble, modelBlocks[0].blockMaterial);
		this.modelBlocks = modelBlocks;
		this.useModelTexture = useModelTexture;
		this.modelMeta = modelMeta;

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
		meta = meta < modelBlocks.length ? meta : 0;

		return modelBlocks[meta].getLocalizedName() + " Slab";
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
		if (useModelTexture)
		{
			int meta = world.getBlockMetadata(x, y, z) % 8;
			meta = meta < modelBlocks.length ? meta : 0;

			Block model = modelBlocks[meta];
			return model.getBlockTexture(world, x, y, z, side);
		}
		else
		{
			return super.getBlockTexture(world, x, y, z, side);
		}
	}

	@Override
	public Icon getIcon(int side, int meta)
	{
		meta = meta % 8;
		meta = meta < modelBlocks.length ? meta : 0;

		if (modelMeta == null)
			return modelBlocks[meta].getIcon(side, meta);
		else
			return modelBlocks[meta].getIcon(side, modelMeta[meta]);
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
	public int idPicked(World world, int x, int y, int z)
	{
		return singleID;
	}

	@Override
	public boolean canCollideCheck(int meta, boolean boat)
	{
		return modelBlocks[0].canCollideCheck(meta, boat);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		if (modelBlocks[0] instanceof IFluidBlock || modelBlocks[0] instanceof BlockFluid) 
			return modelBlocks[0].getCollisionBoundingBoxFromPool(world, x, y, z);
		else
			return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

}
