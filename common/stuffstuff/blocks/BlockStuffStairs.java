package stuffstuff.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockStairs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidBlock;
import stuffstuff.StuffStuff;

public class BlockStuffStairs extends BlockStairs
{
	private Block model;
	private int modelMeta;
	private boolean useModelTexture;

	public BlockStuffStairs(int id, Block modelBlock)
	{
		this(id, modelBlock, 0, true);
	}

	/**
	 * 
	 * @param id
	 * @param modelBlock
	 * @param modelMeta
	 * @param useModelTexture If this is true, this block's getBlockTexture will use model.getBlockTexture.
	 * Otherwise, it defaults to {@link Block#getBlockTexture(IBlockAccess, int, int, int, int)}
	 */
	public BlockStuffStairs(int id, Block modelBlock, int modelMeta, boolean useModelTexture)
	{
		super(id, modelBlock, modelMeta);
		model = modelBlock;
		this.modelMeta = modelMeta;
		this.useModelTexture = useModelTexture;

		setCreativeTab(modelBlock.getCreativeTabToDisplayOn() == null ? StuffStuff.tabStuffStuff : modelBlock.getCreativeTabToDisplayOn());
		setHardness(modelBlock.blockHardness);
		setResistance(modelBlock.blockResistance / 3.0F);
		setStepSound(modelBlock.stepSound);
		setBurnProperties(id, blockFireSpreadSpeed[modelBlock.blockID], blockFlammability[modelBlock.blockID]);
		slipperiness = model.slipperiness;

		int light = lightValue[modelBlock.blockID];
		setLightValue(light);
		setLightOpacity(lightOpacity[model.blockID]);
		setUnlocalizedName(modelBlock.getUnlocalizedName() + "." + modelMeta + "Stairs");

		// TODO possibly add things to make stairs act even more like their model; for example, make lava stairs burn nearby things
	}

	@Override
	public Icon getIcon(int side, int meta)
	{
		return model.getIcon(side, modelMeta);
	}

	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side)
	{
		if (useModelTexture) 
			return model.getBlockTexture(world, x, y, z, side);
		else 
			return super.getBlockTexture(world, x, y, z, side);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return blockID;
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}

	@Override
	public boolean canCollideCheck(int meta, boolean boat)
	{
		return model.canCollideCheck(meta, boat);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		if (model instanceof IFluidBlock || model instanceof BlockFluid) 
			return model.getCollisionBoundingBoxFromPool(world, x, y, z);
		else
			return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
}
