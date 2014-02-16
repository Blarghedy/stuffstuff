package stuffstuff.stuffstuff.worldgen;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import stuffstuff.stuffstuff.worldgen.biome.BiomeGenPlaidPlain;

public class Biomes
{
	public static BiomeGenBase plaidPlainsBiome;

	public static void init()
	{
		System.out.println("BIOMES: " + WorldChunkManager.allowedBiomes);
		WorldChunkManager.allowedBiomes.clear();

		plaidPlainsBiome = new BiomeGenPlaidPlain(100);
		BiomeDictionary.registerBiomeType(plaidPlainsBiome, Type.PLAINS);
		BiomeManager.addSpawnBiome(plaidPlainsBiome);
		BiomeManager.addStrongholdBiome(plaidPlainsBiome);
		BiomeManager.addVillageBiome(plaidPlainsBiome, true);
		
		System.out.println("is registered - " + BiomeDictionary.isBiomeRegistered(plaidPlainsBiome));

		WorldChunkManager.allowedBiomes.add(plaidPlainsBiome);
		System.out.println("BIOMES: " + WorldChunkManager.allowedBiomes);
	}
}
