package stuffstuff.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPlaidTree extends WorldGenerator
{
	public WorldGenPlaidTree(boolean doBlockNotify)
	{
		super(doBlockNotify);
	}
	
	public WorldGenPlaidTree()
	{
		this(false);
	}
	
	@Override
    public boolean generate(World world, Random random, int i, int j, int k)
    {
	    // TODO Auto-generated method stub
	    return false;
    }

}
