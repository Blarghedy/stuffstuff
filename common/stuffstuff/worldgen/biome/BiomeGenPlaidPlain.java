package stuffstuff.worldgen.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenerator;
import stuffstuff.blocks.Blocks;
import stuffstuff.fluid.Fluids;
import stuffstuff.worldgen.WorldGenPlaidTrees;

public class BiomeGenPlaidPlain extends BiomeGenPlains
{

	public BiomeGenPlaidPlain(int id)
	{
		super(id);
		setBiomeName("Plaid Plain");
		//
		topBlock = (byte)Blocks.blockPlaidGrass.blockID;
		fillerBlock = (byte)Blocks.blockPlaidDirt.blockID;

		// this.field_76754_C = 5169201; // what
		// this.minHeight = 0.1F;
		// this.maxHeight = 0.3F;
		// this.temperature = 0.5F;
		// this.rainfall = 0.5F;
		// this.waterColorMultiplier = 16777215;
		//
		worldGeneratorTrees = new WorldGenPlaidTrees(false);
		theBiomeDecorator.treesPerChunk = 1;
		// this.worldGeneratorBigTree = new WorldGenBigTree(false);
		// // this.worldGeneratorForest = new WorldGenForest(false);
		// // this.worldGeneratorSwamp = new WorldGenSwamp();
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
			new WorldGenLiquids(Fluids.blockFluidPlaidWater.blockID).generate(world, rand, x, y, z);
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
						if (world.getBlockId(x, y, z) == Block.stone.blockID)
						{
							world.setBlock(x, y, z, Blocks.blockPlaidStone.blockID, 0, 2); // 2 so it doesn't update but sends to client
						}
						else if (world.getBlockId(x, y, z) == Block.waterMoving.blockID || world.getBlockId(x, y, z) == Block.waterStill.blockID)
						{
							world.setBlock(x, y, z, Fluids.blockFluidPlaidWater.blockID, 0, 3);
						}

					}
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
		return worldGeneratorTrees;
	}

	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	{
		return super.getRandomWorldGenForGrass(par1Random);
	}
}
