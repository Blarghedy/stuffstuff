package stuffstuff.blocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.world.World;

public class BlockSilverfishStuffSlab extends BlockStuffSlab
{
	public BlockSilverfishStuffSlab(int id, int otherID, boolean isDouble, Block[] modelBlocks, boolean useModelTexture, int[] modelMeta)
	{
		super(id, otherID, isDouble, modelBlocks, useModelTexture, modelMeta);
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
	{
		if (!world.isRemote)
		{
			EntitySilverfish entitysilverfish = new EntitySilverfish(world);
			entitysilverfish.setLocationAndAngles(x + 0.5D, y, z + 0.5D, 0.0F, 0.0F);
			world.spawnEntityInWorld(entitysilverfish);
			entitysilverfish.spawnExplosionParticle();
		}

		super.onBlockDestroyedByPlayer(world, x, y, z, meta);
	}
}
