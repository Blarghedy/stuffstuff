package stuffstuff.stuffstuff.worldgen;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import stuffstuff.stuffstuff.worldgen.biome.BiomeGenPlaidPlain;
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
