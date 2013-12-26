package stuffstuff.worldgen.biome;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GRAVEL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.REDSTONE;
import stuffstuff.blocks.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorPlaidPlain extends BiomeDecorator
{
	private WorldGenMinable plaidStoneGen;
	
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
        this.generateLakes = false;
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
	protected void decorate()
	{
	    super.decorate();
	}

	@Override
	protected void generateOres()
	{
    	MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
    	if (TerrainGen.generateOre(currentWorld, randomGenerator, dirtGen, chunk_X, chunk_Z, DIRT))
    		this.genStandardOre1(20, this.dirtGen, 0, 128);
    	if (TerrainGen.generateOre(currentWorld, randomGenerator, gravelGen, chunk_X, chunk_Z, GRAVEL))
    		this.genStandardOre1(10, this.gravelGen, 0, 128);
    	if (TerrainGen.generateOre(currentWorld, randomGenerator, coalGen, chunk_X, chunk_Z, COAL))
    		this.genStandardOre1(20, this.coalGen, 0, 128);
    	if (TerrainGen.generateOre(currentWorld, randomGenerator, ironGen, chunk_X, chunk_Z, IRON))
    		this.genStandardOre1(20, this.ironGen, 0, 64);
    	if (TerrainGen.generateOre(currentWorld, randomGenerator, goldGen, chunk_X, chunk_Z, GOLD))
    		this.genStandardOre1(2, this.goldGen, 0, 32);
    	if (TerrainGen.generateOre(currentWorld, randomGenerator, redstoneGen, chunk_X, chunk_Z, REDSTONE))
    		this.genStandardOre1(8, this.redstoneGen, 0, 16);
    	if (TerrainGen.generateOre(currentWorld, randomGenerator, diamondGen, chunk_X, chunk_Z, DIAMOND))
    		this.genStandardOre1(1, this.diamondGen, 0, 16);
    	if (TerrainGen.generateOre(currentWorld, randomGenerator, lapisGen, chunk_X, chunk_Z, LAPIS))
    		this.genStandardOre2(1, this.lapisGen, 16, 16);
    	MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
//	    super.generateOres();
	}
}
