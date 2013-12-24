package stuffstuff.worldgen;

import java.util.Random;

import stuffstuff.worldgen.biome.BiomeGenPlaidPlain;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class Biomes
{
	public static BiomeGenBase plaidPlainsBiome;

	public static void init()
	{	
		plaidPlainsBiome = new BiomeGenPlaidPlain(100);
		BiomeDictionary.registerBiomeType(plaidPlainsBiome, Type.PLAINS);
		GameRegistry.addBiome(plaidPlainsBiome);
		BiomeManager.addSpawnBiome(plaidPlainsBiome);
		BiomeManager.addStrongholdBiome(plaidPlainsBiome);
		BiomeManager.addVillageBiome(plaidPlainsBiome, true);
	}
}
