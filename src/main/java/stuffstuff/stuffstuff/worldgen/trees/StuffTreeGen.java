package stuffstuff.stuffstuff.worldgen.trees;

import stuffstuff.stuffstuff.worldgen.StuffBlockBuilder;
import net.minecraft.world.IBlockAccess;

import com.google.gson.JsonObject;

public class StuffTreeGen extends StuffBlockBuilder
{

	public StuffTreeGen(JsonObject obj)
	{
		super(obj);
	}

	@Override
	public boolean canReplace(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlock(x, y, z).canBeReplacedByLeaves(world, x, y, z);
	}

}
