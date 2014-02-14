package stuffstuff.stuffstuff.blocks.stairs;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.StuffStuff;

public class BlockStuffStairs extends BlockStairs
{
	private Block model;
	private int modelMeta;
	private boolean useModelTexture;

	public BlockStuffStairs(Block modelBlock)
	{
		this(modelBlock, 0, true);
	}

	/**
	 * 
	 * @param id
	 * @param modelBlock
	 * @param modelMeta
	 * @param useModelTexture If this is true, this block's getBlockTexture will use model.getBlockTexture.
	 * Otherwise, it defaults to {@link Block#getBlockTexture(IBlockAccess, int, int, int, int)}
	 */
	public BlockStuffStairs(Block modelBlock, int modelMeta, boolean useModelTexture)
	{
		super(modelBlock, modelMeta);
		model = modelBlock;
		this.modelMeta = modelMeta;
		this.useModelTexture = useModelTexture;

		setCreativeTab(modelBlock.getCreativeTabToDisplayOn() == null ? StuffStuff.tabStuffStuff : modelBlock.getCreativeTabToDisplayOn());
		setStepSound(modelBlock.stepSound);
		slipperiness = model.slipperiness;

		lightValue = modelBlock.getLightValue();
		lightOpacity = modelBlock.getLightOpacity();

		// TODO possibly add things to make stairs act even more like their model; for example, make lava stairs burn nearby things
		// TODO check on resistance
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return model.getFireSpreadSpeed(world, x, y, z, face);
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return model.getFlammability(world, x, y, z, face);
	}

	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		return model.getBlockHardness(world, x, y, z);
	}

	@Override
	public String getUnlocalizedName()
	{
		return model.getUnlocalizedName() + "." + modelMeta + "Stairs";
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return model.getIcon(side, modelMeta);
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		if (useModelTexture) 
			return model.getIcon(world, x, y, z, side);
		else 
			return super.getIcon(world, x, y, z, side);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(this);
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

	public Block getModel()
	{
		return model;
	}
}
