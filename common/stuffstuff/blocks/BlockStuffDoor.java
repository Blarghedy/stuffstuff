package stuffstuff.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFluid;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidBlock;
import stuffstuff.StuffStuff;
import stuffstuff.client.render.Renderers;

public class BlockStuffDoor extends BlockDoor
{
	private Block modelBlock;
	private int modelMeta;
	private boolean useModelTexture;

	public BlockStuffDoor(int id, Block modelBlock)
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
	public BlockStuffDoor(int id, Block modelBlock, int modelMeta, boolean useModelTexture)
	{
		super(id, modelBlock.blockMaterial);
		this.modelBlock = modelBlock;
		this.modelMeta = modelMeta;
		this.useModelTexture = useModelTexture;

		lightValue[id] = lightValue[modelBlock.blockID];
		slipperiness = modelBlock.slipperiness;
		setHardness(modelBlock.blockHardness);
		setResistance(modelBlock.blockResistance / 3.0F);
		setStepSound(modelBlock.stepSound);
		setBurnProperties(id, blockFireSpreadSpeed[modelBlock.blockID], blockFlammability[modelBlock.blockID]);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setLightOpacity(0);

		setUnlocalizedName(modelBlock.getUnlocalizedName() + "." + modelMeta + ".Door");
	}

	@Override
	public int idPicked(World world, int x, int y, int z)
	{
		return blockID;
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return (par1 & 8) != 0 ? 0 : blockID; // this might drop the block and not the item, which might matter
	}

	@Override
	public int getRenderType()
	{
		return Renderers.stuffDoorRenderID;
	}

	@Override
	public Icon getIcon(int side, int meta)
	{
		return modelBlock.getIcon(side, modelMeta);
	}

	@Override
	public void registerIcons(IconRegister register)
	{

	}

	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side)
	{
		//	    return modelBlock.getBlockTexture(world, x, y, z, side);
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
		if (modelBlock instanceof IFluidBlock || modelBlock instanceof BlockFluid) 
			return modelBlock.getCollisionBoundingBoxFromPool(world, x, y, z);
		else
			return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	public Block getModelBlock()
	{
		return modelBlock;
	}

}
