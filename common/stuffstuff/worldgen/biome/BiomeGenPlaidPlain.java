package stuffstuff.worldgen.biome;

import stuffstuff.blocks.Blocks;
import net.minecraft.world.biome.BiomeGenBase;


public class BiomeGenPlaidPlain extends BiomeGenBase
{

	public BiomeGenPlaidPlain(int id)
    {
	    super(id);
	    this.topBlock = (byte)Blocks.blockPlaidGrass.blockID;
//        this.spawnableMonsterList.clear();
//        this.spawnableCreatureList.clear();
//        this.spawnableWaterCreatureList.clear();
//        this.spawnableCaveCreatureList.clear();
//        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
//        this.topBlock = (byte)Block.dirt.blockID;
//        this.fillerBlock = (byte)Block.dirt.blockID;
//        this.theBiomeDecorator = new BiomeEndDecorator(this);
    }

}
