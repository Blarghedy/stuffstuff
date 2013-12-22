package stuffstuff.worldgen.biome;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM;
import stuffstuff.blocks.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorPlaidPlain extends BiomeDecorator
{
	public WorldGenMinable plaidStoneGen;
	
	public BiomeDecoratorPlaidPlain(BiomeGenBase biome)
    {
	    super(biome);
        // TODO need a custom sand generator
	    
//	    plaidStoneGen = new WorldGenMinable(Blocks.blockPlaidStone.blockID, 500, Block.stone.blockID);
	    
        this.sandGen = new WorldGenSand(7, Blocks.blockPlaidSand.blockID);
        this.gravelAsSandGen = new WorldGenSand(6, Blocks.blockPlaidGravel.blockID);
        this.dirtGen = new WorldGenMinable(Blocks.blockPlaidDirt.blockID, 32);
        this.gravelGen = new WorldGenMinable(Blocks.blockPlaidGravel.blockID, 32);
//        this.coalGen = new WorldGenMinable(Block.oreCoal.blockID, 16);
//        this.ironGen = new WorldGenMinable(Block.oreIron.blockID, 8);
//        this.goldGen = new WorldGenMinable(Block.oreGold.blockID, 8);
//        this.redstoneGen = new WorldGenMinable(Block.oreRedstone.blockID, 7);
//        this.diamondGen = new WorldGenMinable(Block.oreDiamond.blockID, 7);
//        this.lapisGen = new WorldGenMinable(Block.oreLapis.blockID, 6);
        this.generateLakes = true;
        this.biome = biome;
//        this.plantYellowGen = new WorldGenFlowers(Block.plantYellow.blockID);
//        this.plantRedGen = new WorldGenFlowers(Block.plantRed.blockID);
//        this.mushroomBrownGen = new WorldGenFlowers(Block.mushroomBrown.blockID);
//        this.mushroomRedGen = new WorldGenFlowers(Block.mushroomRed.blockID);
//        this.bigMushroomGen = new WorldGenBigMushroom();
//        this.reedGen = new WorldGenReed();
//        this.cactusGen = new WorldGenCactus();
//        this.waterlilyGen = new WorldGenWaterlily();
//        this.flowersPerChunk = 2;
//        this.grassPerChunk = 1;
//        this.sandPerChunk = 1;
//        this.sandPerChunk2 = 3;
//        this.clayPerChunk = 1;
    }

	@Override
	protected void generateOres()
	{
//    	MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
//    	if (TerrainGen.generateOre(currentWorld, randomGenerator, plaidStoneGen, chunk_X, chunk_Z, CUSTOM))
//    	{
//    		this.genStandardOre1(5, this.plaidStoneGen, 0, 128);
//    		System.out.println("Generating at " + chunk_X + " " + chunk_Z);
//    	}
//    	MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
	    super.generateOres();
	}
}
