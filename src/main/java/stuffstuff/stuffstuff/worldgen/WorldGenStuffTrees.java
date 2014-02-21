package stuffstuff.stuffstuff.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

public abstract class WorldGenStuffTrees extends WorldGenTrees
{
	
	public WorldGenStuffTrees(boolean doBlockNotify)
	{
		super(doBlockNotify);
	}

	public WorldGenStuffTrees()
	{
		this(false);
	}
	
	@Override
	public abstract boolean generate(World world, Random rand, int x, int tries, int z);
	
	public abstract boolean growTree(World world, Random rand, int x, int y, int z);

}
