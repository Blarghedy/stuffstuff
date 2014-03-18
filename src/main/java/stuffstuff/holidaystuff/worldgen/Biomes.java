package stuffstuff.holidaystuff.worldgen;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import stuffstuff.holidaystuff.worldgen.biome.halloween.BiomeGenHalloweenForest;
import stuffstuff.stuffstuff.worldgen.BiomeEventHandler;
import stuffstuff.stuffstuff.worldgen.BiomeEventHandler.EnumBiomeType;

public class Biomes
{

	public static BiomeGenBase halloweenBiome;

	public static void init()
	{
		halloweenBiome = new BiomeGenHalloweenForest(201);
		BiomeDictionary.registerBiomeType(halloweenBiome, Type.PLAINS);
		BiomeManager.addSpawnBiome(halloweenBiome);
		BiomeManager.addStrongholdBiome(halloweenBiome);
		BiomeManager.addVillageBiome(halloweenBiome, true);
		BiomeEventHandler.registerBiome(halloweenBiome, EnumBiomeType.WARM);
		
	}
}
