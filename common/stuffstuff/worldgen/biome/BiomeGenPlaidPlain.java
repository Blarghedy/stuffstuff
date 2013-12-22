package stuffstuff.worldgen.biome;

import java.util.ArrayList;
import java.util.Random;

import stuffstuff.blocks.Blocks;
import stuffstuff.worldgen.PlaidWorldGen;
import stuffstuff.worldgen.WorldGenPlaidTrees;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenSwamp;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;


public class BiomeGenPlaidPlain extends BiomeGenPlains
{

	public BiomeGenPlaidPlain(int id)
    {
	    super(id);
	    setBiomeName("Plaid Plain");
//	    
	    System.out.println("Trying to use plaid grass blockID: " + (byte)Blocks.blockPlaidGrass.blockID + " should be " + Blocks.blockPlaidGrass.blockID);
	    this.topBlock = (byte)Blocks.blockPlaidGrass.blockID;
        this.fillerBlock = (byte)Blocks.blockPlaidDirt.blockID;
        
//        this.field_76754_C = 5169201; // what
//        this.minHeight = 0.1F;
//        this.maxHeight = 0.3F;
//        this.temperature = 0.5F;
//        this.rainfall = 0.5F;
//        this.waterColorMultiplier = 16777215;
//        
        this.worldGeneratorTrees = new WorldGenPlaidTrees(false);
//        this.worldGeneratorBigTree = new WorldGenBigTree(false);
////        this.worldGeneratorForest = new WorldGenForest(false);
////        this.worldGeneratorSwamp = new WorldGenSwamp();
    }
	
	@Override
	public BiomeDecorator createBiomeDecorator()
	{
		System.out.println("BIOME DECORATED");
		return new BiomeDecoratorPlaidPlain(this);
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
	    return new WorldGenPlaidTrees(false);
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	{
	    return super.getRandomWorldGenForGrass(par1Random);
	}
}
