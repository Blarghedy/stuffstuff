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

public abstract class BlockStuffGrass extends Block
{
	protected Block dirtBlock;
	protected IIcon sideIcon, topIcon;
	
	public BlockStuffGrass()
	{
		super(Material.grass);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setStepSound(soundTypeGrass);
		setHardness(.7F);
		setTickRandomly(true);
		dirtBlock = Blocks.dirt;
	}
	
	@Override
	public abstract String getUnlocalizedName();
	
	@Override
	public abstract void registerBlockIcons(IIconRegister register);
	
	@Override
	public abstract IIcon getIcon(int side, int meta);
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		return getIcon(side, 0);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (!world.isRemote)
		{
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
			{
				world.setBlock(x, y, z, dirtBlock);
			}
			else if (world.getBlockLightValue(x, y + 1, z) > 9)
			{
				int newx = x, newy = y, newz = z;

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

				newy = y + rand.nextInt(3) - 1;

				if ((world.getBlock(newx, newy, newz) == Blocks.dirt || world.getBlock(newx, newy, newz) instanceof BlockStuffDirt) && world.getBlockLightValue(newx, newy + 1, newz) > 3 && world.getBlockLightOpacity(newx, newy + 1, newz) < 3)
				{
					world.setBlock(newx, newy, newz, this);
				}
			}
		}
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
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return Item.getItemFromBlock(dirtBlock);
	}

	@Override
	public void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ)
	{
		world.setBlock(x, y, z, dirtBlock);
	}

	@Override
	public int tickRate(World world)
	{
		return super.tickRate(world);
	}
}
