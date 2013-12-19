package stuffstuff.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class PlaidWorldGen implements IWorldGenerator
{

	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
//		System.out.println("Generating chunk " + chunkX + " " + chunkZ);
		
		BiomeGenBase b = world.getBiomeGenForCoords(x, z);
		
//		if(random.nextInt(100) < 40)
		{
			new WorldGenPlaidTree().generate(world, random, x, random.nextInt(3) + 4, z);
		}
    }

}
