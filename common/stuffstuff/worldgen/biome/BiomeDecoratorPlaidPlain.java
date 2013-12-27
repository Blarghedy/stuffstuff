package stuffstuff.worldgen.biome;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GRAVEL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.REDSTONE;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import stuffstuff.blocks.Blocks;

public class BiomeDecoratorPlaidPlain extends BiomeDecorator
{
	private WorldGenMinable plaidStoneGen;

	public BiomeDecoratorPlaidPlain(BiomeGenBase biome)
	{
		super(biome);
		// TODO need a custom sand generator

		// plaidStoneGen = new WorldGenMinable(Blocks.blockPlaidStone.blockID, 500, Block.stone.blockID);

		sandGen = new WorldGenSand(7, Blocks.blockPlaidSand.blockID);
		gravelAsSandGen = new WorldGenSand(6, Blocks.blockPlaidGravel.blockID);
		dirtGen = new WorldGenMinable(Blocks.blockPlaidDirt.blockID, 32);
		gravelGen = new WorldGenMinable(Blocks.blockPlaidGravel.blockID, 32);
		// this.coalGen = new WorldGenMinable(Block.oreCoal.blockID, 16);
		// this.ironGen = new WorldGenMinable(Block.oreIron.blockID, 8);
		// this.goldGen = new WorldGenMinable(Block.oreGold.blockID, 8);
		// this.redstoneGen = new WorldGenMinable(Block.oreRedstone.blockID, 7);
		// this.diamondGen = new WorldGenMinable(Block.oreDiamond.blockID, 7);
		// this.lapisGen = new WorldGenMinable(Block.oreLapis.blockID, 6);
		generateLakes = false;
		this.biome = biome;
		// this.plantYellowGen = new WorldGenFlowers(Block.plantYellow.blockID);
		// this.plantRedGen = new WorldGenFlowers(Block.plantRed.blockID);
		// this.mushroomBrownGen = new WorldGenFlowers(Block.mushroomBrown.blockID);
		// this.mushroomRedGen = new WorldGenFlowers(Block.mushroomRed.blockID);
		// this.bigMushroomGen = new WorldGenBigMushroom();
		// this.reedGen = new WorldGenReed();
		// this.cactusGen = new WorldGenCactus();
		// this.waterlilyGen = new WorldGenWaterlily();
		// this.flowersPerChunk = 2;
		// this.grassPerChunk = 1;
		// this.sandPerChunk = 1;
		// this.sandPerChunk2 = 3;
		// this.clayPerChunk = 1;
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
		{
			this.genStandardOre1(20, dirtGen, 0, 128);
		}
		if (TerrainGen.generateOre(currentWorld, randomGenerator, gravelGen, chunk_X, chunk_Z, GRAVEL))
		{
			this.genStandardOre1(10, gravelGen, 0, 128);
		}
		if (TerrainGen.generateOre(currentWorld, randomGenerator, coalGen, chunk_X, chunk_Z, COAL))
		{
			this.genStandardOre1(20, coalGen, 0, 128);
		}
		if (TerrainGen.generateOre(currentWorld, randomGenerator, ironGen, chunk_X, chunk_Z, IRON))
		{
			this.genStandardOre1(20, ironGen, 0, 64);
		}
		if (TerrainGen.generateOre(currentWorld, randomGenerator, goldGen, chunk_X, chunk_Z, GOLD))
		{
			this.genStandardOre1(2, goldGen, 0, 32);
		}
		if (TerrainGen.generateOre(currentWorld, randomGenerator, redstoneGen, chunk_X, chunk_Z, REDSTONE))
		{
			this.genStandardOre1(8, redstoneGen, 0, 16);
		}
		if (TerrainGen.generateOre(currentWorld, randomGenerator, diamondGen, chunk_X, chunk_Z, DIAMOND))
		{
			this.genStandardOre1(1, diamondGen, 0, 16);
		}
		if (TerrainGen.generateOre(currentWorld, randomGenerator, lapisGen, chunk_X, chunk_Z, LAPIS))
		{
			this.genStandardOre2(1, lapisGen, 16, 16);
		}
		MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
		// super.generateOres();
	}
}
