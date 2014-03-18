package stuffstuff.holidaystuff.worldgen.biome.halloween;

import net.minecraft.world.biome.BiomeGenBase;
import stuffstuff.holidaystuff.blocks.BlocksHolidayStuff;
import stuffstuff.stuffstuff.blocks.items.ItemBiomeTeleporter;

public class BiomeGenHalloweenForest extends BiomeGenBase
{

	public BiomeGenHalloweenForest(int id)
    {
	    super(id);
	    setBiomeName("Halloween Forest");
	    
	    enableRain = false;
	    
		topBlock = BlocksHolidayStuff.blockHalloweenGrass;
		fillerBlock = BlocksHolidayStuff.blockHalloweenDirt;

		worldGeneratorTrees = new WorldGenHalloweenTrees(false);
//		theBiomeDecorator.treesPerChunk = 1;
		ItemBiomeTeleporter.addBiome(this);
    }
	
	@Override
	public int getSkyColorByTemp(float par1)
	{
		return 0;
	}
	
	@Override
	public int getBiomeGrassColor(int x, int y, int z)
	{
		return 0;
	}

}
