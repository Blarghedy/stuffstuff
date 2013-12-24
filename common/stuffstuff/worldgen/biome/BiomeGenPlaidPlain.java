package stuffstuff.worldgen.biome;

import java.util.ArrayList;
import java.util.Random;

import stuffstuff.blocks.Blocks;
import stuffstuff.worldgen.Biomes;
import stuffstuff.worldgen.WorldGenPlaidTrees;
import net.minecraft.block.Block;
import net.minecraft.world.World;
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
        this.theBiomeDecorator.treesPerChunk = 1;
//        this.worldGeneratorBigTree = new WorldGenBigTree(false);
////        this.worldGeneratorForest = new WorldGenForest(false);
////        this.worldGeneratorSwamp = new WorldGenSwamp();
    }
	
	@Override
	public void decorate(World world, Random rand, int startX, int startZ)
	{
//		System.out.println("DECORATING IN GENERATOR " + startX + " " + startZ + " ");
	    super.decorate(world, rand, startX, startZ);
	    for (int x = startX; x < startX + 16; x++)
	    {
	    	for (int z = startZ; z < startZ + 16; z++)
	    	{
	    		int ytop = 255;
	    		while (!world.isAirBlock(x, ytop--, z));
	    		for (int y = ytop; y > 0; y--)
	    		{
	    			if (world.getBlockId(x, y, z) == Block.stone.blockID && world.getBiomeGenForCoords(x, z) instanceof BiomeGenPlaidPlain)
	    				world.setBlock(x, y, z, Blocks.blockPlaidStone.blockID, 0, 2); // 2 so it doesn't update but sends to client
	    		}
	    	}
	    }
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator()
	{
		return new BiomeDecoratorPlaidPlain(this);
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		System.out.println("Got tree gen");
	    return worldGeneratorTrees;
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	{
	    return super.getRandomWorldGenForGrass(par1Random);
	}
}
