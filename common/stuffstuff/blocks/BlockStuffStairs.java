package stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockStuffStairs extends BlockStairs
{
	private Block model;

	public BlockStuffStairs(int id, Block modelBlock)
	{
		super(id, modelBlock, 0);
		model = modelBlock;

		setLightOpacity(0);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(modelBlock.blockHardness);
		setResistance(modelBlock.blockResistance / 3.0F);
		setStepSound(modelBlock.stepSound);
		setBurnProperties(id, blockFireSpreadSpeed[modelBlock.blockID], blockFlammability[modelBlock.blockID]);

		Class cl = modelBlock.getClass();
		if (cl.equals(BlockPlaidStone.class))
		{
			setUnlocalizedName(BlockInfo.PLAID_STONE_STAIRS_UNLOCALIZED_NAME);
		}
		else if (cl.equals(BlockPlaidCobblestone.class))
		{
			setUnlocalizedName(BlockInfo.PLAID_COBBLESTONE_STAIRS_UNLOCALIZED_NAME);
		}
		else if (cl.equals(BlockPlaidStoneBrick.class))
		{
			setUnlocalizedName(BlockInfo.PLAID_STONE_BRICK_STAIRS_UNLOCALIZED_NAME);
		}
		else if (cl.equals(BlockPlaidPlank.class))
		{
			setUnlocalizedName(BlockInfo.PLAID_PLANK_STAIRS_UNLOCALIZED_NAME);
		}
		else 
		{
			throw new RuntimeException("Attempted to make a StuffStairs of a non-stuffstuff material");
		}
	}

	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int par5)
	{
		return model.getBlockTexture(world, x, y, z, par5);
	}
}
