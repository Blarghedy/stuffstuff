package stuffstuff.stuffstuff.blocks.doors;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidBlock;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.client.render.Renderers;

public class BlockStuffDoor extends BlockDoor
{
	private Block modelBlock;
	private int modelMeta;
	private boolean useModelTexture;

	public BlockStuffDoor(Block modelBlock)
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
	public BlockStuffDoor(Block modelBlock, int modelMeta, boolean useModelTexture)
	{
		super(modelBlock.getMaterial());
		this.modelBlock = modelBlock;
		this.modelMeta = modelMeta;
		this.useModelTexture = useModelTexture;

		lightValue = modelBlock.getLightValue();
		slipperiness = modelBlock.slipperiness;
		setStepSound(modelBlock.stepSound);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setLightOpacity(0);
	}

	@Override
	public String getUnlocalizedName()
	{
		return "stuffdoor." + modelMeta + "." + modelBlock.getUnlocalizedName();
	}

	@Override
    public int func_150013_e(IBlockAccess world, int x, int y, int z)
    {
		// used to be getDoorOrientation
    	return super.func_150013_e(world, x, y, z);
    }
	
	@Override
    public boolean func_150015_f(IBlockAccess world, int x, int y, int z)
    {
		// used to be isDoorOpen
    	return super.func_150015_f(world, x, y, z);
    }

	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		return modelBlock.getBlockHardness(world, x, y, z);
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return modelBlock.getFlammability(world, x, y, z, face);
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return modelBlock.getFireSpreadSpeed(world, x, y, z, face);
	}

	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		// TODO test this (middle mouse button click in creative)
		// used to be idPicked
		return Item.getItemFromBlock(this);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return (par1 & 8) != 0 ? null : Item.getItemFromBlock(this);
	}

	@Override
	public int getRenderType()
	{
		return Renderers.stuffDoorRenderID;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return modelBlock.getIcon(side, modelMeta);
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{

	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		if (useModelTexture) 
			return modelBlock.getIcon(world, x, y, z, side);
		else 
			return getIcon(side, modelMeta);
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int par5, EntityPlayer par6EntityPlayer)
	{
		super.onBlockHarvested(world, x, y, z, par5, par6EntityPlayer);
	}

	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
	{
		super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	}

	@Override
	public boolean canCollideCheck(int meta, boolean boat)
	{
		return modelBlock.canCollideCheck(meta, boat);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		if (modelBlock instanceof IFluidBlock || modelBlock instanceof BlockLiquid) 
			return modelBlock.getCollisionBoundingBoxFromPool(world, x, y, z);
		else
			return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	public Block getModel()
	{
		return modelBlock;
	}

}
