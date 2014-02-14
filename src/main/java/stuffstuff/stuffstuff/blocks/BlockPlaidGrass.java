package stuffstuff.stuffstuff.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidGrass extends Block
{
	private IIcon[] sideIcons;
	private IIcon[] topIcons;
	private IIcon sideSnowIcon;

	public BlockPlaidGrass()
	{
		super(Material.grass);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setStepSound(soundTypeGrass);
		setHardness(.7F);
		setBlockName(BlockInfo.PLAID_GRASS_UNLOCALIZED_NAME);
		setTickRandomly(true);
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		sideIcons = new IIcon[BlockInfo.PLAID_GRASS_SIDE_TEXTURES.length];
		topIcons = new IIcon[BlockInfo.PLAID_GRASS_TOP_TEXTURES.length];

		sideSnowIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_GRASS_SIDE_SNOW_TEXTURE);

		for (int i = 0; i < sideIcons.length; i++)
		{
			sideIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_GRASS_SIDE_TEXTURES[i]);
		}

		for (int i = 0; i < topIcons.length; i++)
		{
			topIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_GRASS_TOP_TEXTURES[i]);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		ForgeDirection face = ForgeDirection.getOrientation(side);
		if (face == ForgeDirection.UP)
			return topIcons[0];
		else
			return sideIcons[0];
	}

	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		ForgeDirection face = ForgeDirection.getOrientation(side);
		PlaidColor color = PlaidColor.getPlaidColorFromPos(x, y, z);

		switch (face)
		{
			case UP:
				return topIcons[color.ordinal()];
			case DOWN: // just need vanilla dirt texture
				return Blocks.grass.getIcon(blockAccess, x, y, z, side);
			default: // all 4 sides
				Material mat = blockAccess.getBlock(x, y + 1, z).getMaterial();
				if (mat == Material.snow || mat == Material.craftedSnow)
					return sideSnowIcon;
				else
					return sideIcons[color.ordinal()];
		}
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (!world.isRemote)
		{
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
			{
				world.setBlock(x, y, z, BlocksStuff.blockPlaidDirt);
			}
			else if (world.getBlockLightValue(x, y + 1, z) > 9)
			{
				int newx = x, newy = y, newz = z;

				// Just for the heck of it, and because it is plaid, after all, let's
				// encourage it to spread in a straight line instead of completely randomly
				// The end effect of this should be diamond-shaped patches of plad grass.
				switch (rand.nextInt(4))
				{
					case 0:
						newx = x - 1;
						break;
					case 1:
						newx = x + 1;
						break;
					case 2:
						newz = z - 1;
						break;
					default:
						newz = z + 1;
				}

				// We really need a way to encourage it to grow up/down, so this does that.
				newy = y + rand.nextInt(3) - 1;

				if ((world.getBlock(newx, newy, newz) == Blocks.dirt || world.getBlock(newx, newy, newz) == BlocksStuff.blockPlaidDirt) && world.getBlockLightValue(newx, newy + 1, newz) > 3 && world.getBlockLightOpacity(newx, newy + 1, newz) < 3)
				{
					world.setBlock(newx, newy, newz, BlocksStuff.blockPlaidGrass);
				}
			}
		}
	}

	@Override
	public Item getItemDropped(int par1, Random rand, int par3)
	{
		return Item.getItemFromBlock(BlocksStuff.blockPlaidDirt);
	}

	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
	{
		EnumPlantType plantType = plant.getPlantType(world, x, y + 1, z);

		if (plantType == EnumPlantType.Plains)
			return true;

		return super.canSustainPlant(world, x, y, z, direction, plant);
	}

	@Override
	public int tickRate(World world)
	{
		return super.tickRate(world);
	}

	@Override
	public void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ)
	{
		world.setBlock(x, y, z, BlocksStuff.blockPlaidDirt);
	}
}
