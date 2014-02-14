package stuffstuff.stuffstuff.handler;

import net.minecraft.block.Block;
import net.minecraftforge.event.entity.player.BonemealEvent;
import stuffstuff.stuffstuff.blocks.BlockPlaidSapling;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BonemealEventHandler
{

	@SubscribeEvent
	public void onBonemeal(BonemealEvent e)
	{
		Block block = e.block;

		if (block instanceof BlockPlaidSapling)
		{
			BlockPlaidSapling sap = (BlockPlaidSapling)block;
			sap.func_149878_d(e.world, e.x, e.y, e.z, e.world.rand);
		}
	}
}
