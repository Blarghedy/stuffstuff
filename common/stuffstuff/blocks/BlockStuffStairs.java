package stuffstuff.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockStuffStairs extends BlockStairs
{
	private Block model;

	public BlockStuffStairs(int id, Block modelBlock)
	{
		this(id, modelBlock, 0);
	}

	public BlockStuffStairs(int id, Block modelBlock, int modelMeta)
	{
		super(id, modelBlock, modelMeta);
		model = modelBlock;

		setLightOpacity(0);
		setCreativeTab(modelBlock.getCreativeTabToDisplayOn());
		setHardness(modelBlock.blockHardness);
		setResistance(modelBlock.blockResistance / 3.0F);
		setStepSound(modelBlock.stepSound);
		setBurnProperties(id, blockFireSpreadSpeed[modelBlock.blockID], blockFlammability[modelBlock.blockID]);

		//		Class cl = modelBlock.getClass();
		setUnlocalizedName(modelBlock.getUnlocalizedName() + "." + modelMeta + "Stairs");
		//		if (cl.equals(BlockPlaidStone.class))
		//		{
		//			setUnlocalizedName(BlockInfo.PLAID_STONE_STAIRS_UNLOCALIZED_NAME);
		//		}
		//		else if (cl.equals(BlockPlaidCobblestone.class))
		//		{
		//			setUnlocalizedName(BlockInfo.PLAID_COBBLESTONE_STAIRS_UNLOCALIZED_NAME);
		//		}
		//		else if (cl.equals(BlockPlaidStoneBrick.class))
		//		{
		//			setUnlocalizedName(BlockInfo.PLAID_STONE_BRICK_STAIRS_UNLOCALIZED_NAME);
		//		}
		//		else if (cl.equals(BlockPlaidPlank.class))
		//		{
		//			setUnlocalizedName(BlockInfo.PLAID_PLANK_STAIRS_UNLOCALIZED_NAME);
		//		}
		//		else 
		//		{
		//			throw new RuntimeException("Attempted to make a StuffStairs of a non-stuffstuff material");
		//		}
	}

	@Override
	public Icon getIcon(int side, int meta)
	{
		return model.getIcon(side, meta);
	}

	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side)
	{
		return model.getBlockTexture(world, x, y, z, side);
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
}
