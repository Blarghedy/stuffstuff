package stuffstuff.stuffstuff.worldgen.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import stuffstuff.stuffstuff.blocks.BlocksStuff;
import stuffstuff.stuffstuff.blocks.items.ItemBiomeTeleporter;
import stuffstuff.stuffstuff.fluid.Fluids;
import stuffstuff.stuffstuff.worldgen.WorldGenPlaidTrees;

public class BiomeGenPlaidPlain extends BiomeGenPlains
{

	public BiomeGenPlaidPlain(int id)
	{
		super(id);
		setBiomeName("Plaid Plain");

		topBlock = BlocksStuff.blockPlaidGrass;
		fillerBlock = BlocksStuff.blockPlaidDirt;

		worldGeneratorTrees = new WorldGenPlaidTrees(false);
		theBiomeDecorator.treesPerChunk = 1;
		ItemBiomeTeleporter.addBiome(this);
	}

	@Override
	public void decorate(World world, Random rand, int chunk_X, int chunk_Z)
	{
		super.decorate(world, rand, chunk_X, chunk_Z);
		int x, y, z;
		for (int j = 0; j < 50; ++j)
		{
			x = chunk_X + rand.nextInt(16) + 8;
			y = rand.nextInt(rand.nextInt(120) + 8);
			z = chunk_Z + rand.nextInt(16) + 8;
			new WorldGenLiquids(Fluids.blockFluidPlaidWater).generate(world, rand, x, y, z);
		}
		for (x = chunk_X; x < chunk_X + 16; x++)
		{
			for (z = chunk_Z; z < chunk_Z + 16; z++)
			{
				if (world.getBiomeGenForCoords(x, z) instanceof BiomeGenPlaidPlain)
				{
					int ytop = 255;
					while (!world.isAirBlock(x, ytop--, z))
					{
						;
					}
					for (y = ytop; y > 0; y--)
					{
						if (world.getBlock(x, y, z) == Blocks.stone)
						{
							world.setBlock(x, y, z, BlocksStuff.blockPlaidStone, 0, 2); // 2 so it doesn't update but sends to client
						}
						else if (world.getBlock(x, y, z) == Blocks.flowing_water || world.getBlock(x, y, z) == Blocks.water)
						{
							world.setBlock(x, y, z, Fluids.blockFluidPlaidWater, 0, 3);
						}

					}
				}
			}
		}
	}

	@Override
	public BiomeDecorator createBiomeDecorator()
	{
		return new BiomeDecoratorPlaidPlain();
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random rand)
	{
		// was getRandomWorldGenForTrees I think
		return worldGeneratorTrees;
	}

	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand)
	{
		return new WorldGenTallGrass(BlocksStuff.blockPlaidTallGrass, 0);
	}
}
