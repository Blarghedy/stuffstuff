package stuffstuff.stuffstuff.worldgen.biome;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GRAVEL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.REDSTONE;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import stuffstuff.stuffstuff.blocks.BlocksStuff;

public class BiomeDecoratorPlaidPlain extends BiomeDecorator
{
	private WorldGenMinable plaidStoneGen;

	public BiomeDecoratorPlaidPlain()
	{
		super();
		// TODO need a custom sand generator

		// plaidStoneGen = new WorldGenMinable(Blocks.blockPlaidStone.blockID, 500, Block.stone.blockID);

		sandGen = new WorldGenSand(BlocksStuff.blockPlaidSand, 7);
		gravelAsSandGen = new WorldGenSand(BlocksStuff.blockPlaidGravel, 6);
		dirtGen = new WorldGenMinable(BlocksStuff.blockPlaidDirt, 32);
		gravelGen = new WorldGenMinable(BlocksStuff.blockPlaidGravel, 32);
		generateLakes = false;
		//		this.biome = biome;
	}

	//	@Override
	//	protected void decorate()
	//	{
	//		super.decorate();
	//	}

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
