package stuffstuff.handler;

import stuffstuff.blocks.BlockPlaidSapling;
import net.minecraft.block.Block;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class BonemealEventHandler
{

	@ForgeSubscribe
	public void onBonemeal(BonemealEvent e)
	{
		Block block = Block.blocksList[e.ID];

		if (block instanceof BlockPlaidSapling)
		{
			BlockPlaidSapling sap = (BlockPlaidSapling)block;
			sap.growTree(e.world, e.X, e.Y, e.Z, e.world.rand);
		}
	}
}
