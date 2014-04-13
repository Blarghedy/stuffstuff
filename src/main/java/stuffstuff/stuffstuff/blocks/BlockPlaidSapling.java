package stuffstuff.stuffstuff.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;
import stuffstuff.stuffstuff.worldgen.trees.WorldGenPlaidTrees;

public class BlockPlaidSapling extends BlockSapling
{
	private IIcon[] icons;

	public BlockPlaidSapling()
	{
		this.setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(0.0F);
		setStepSound(soundTypeGrass);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.PLAID_SAPLING_UNLOCALIZED_NAME;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		if (meta >= icons.length)
			return icons[0];
		else
			return icons[meta];
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		icons = new IIcon[BlockInfo.PLAID_SAPLING_TEXTURES.length];

		for (int i = 0; i < BlockInfo.PLAID_SAPLING_TEXTURES.length; i++)
		{
			icons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_SAPLING_TEXTURES[i]);
		}
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		for (int i = 0; i < BlockInfo.PLAID_SAPLING_TEXTURES.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}

	@Override
	public void func_149878_d(World world, int x, int y, int z, Random rand)
	{
		// was growTree
		if (world.isRemote)
			return;

		world.setBlockToAir(x, y, z);
		boolean grew = new WorldGenPlaidTrees().growTree(world, rand, x, y, z);
		if (!grew)
		{
			world.setBlock(x, y, z, this, 0, 4);
		}
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return EnumPlantType.Plains;
	}

}
