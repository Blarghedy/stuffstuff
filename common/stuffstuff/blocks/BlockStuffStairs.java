package stuffstuff.blocks;

import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockStuffStairs extends BlockStairs
{
	public BlockStuffStairs(int id, Block modelBlock)
	{
		super(id, modelBlock, 0);
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
}
