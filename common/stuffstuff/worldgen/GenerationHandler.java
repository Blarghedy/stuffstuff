package stuffstuff.worldgen;

import java.util.Random;

import stuffstuff.blocks.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class GenerationHandler implements IWorldGenerator
{
	private WorldGenerator plaidStoneGen;
	
	public GenerationHandler()
	{
//	    GameRegistry.registerWorldGenerator(this);
//	    plaidStoneGen = new WorldGenMinable(Blocks.blockPlaidStone.blockID, 100);
	}
	
	private void generateStandardOre(Random rand, int chunkX, int chunkZ, World world, int iterations, WorldGenerator gen, int lowestY, int highestY)
	{
		for (int i = 0; i < iterations; i++)
		{
			int x = chunkX + rand.nextInt(16);
			int y = rand.nextInt(highestY - lowestY) + lowestY;
			int z = chunkZ + rand.nextInt(16);
			
			gen.generate(world, rand, x, y, z);
		}
	}
	
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
		generateStandardOre(random, chunkX, chunkZ, world, 20, plaidStoneGen, 0, 250);
    }

}
