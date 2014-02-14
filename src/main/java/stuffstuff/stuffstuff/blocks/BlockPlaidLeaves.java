package stuffstuff.stuffstuff.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlaidLeaves extends BlockLeaves
{
	private IIcon[] icons;
	private IIcon[] opaqueIcons;

	public BlockPlaidLeaves()
	{
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setLightOpacity(1);
		setStepSound(soundTypeGrass);
		setHardness(.2F);
	}

	@Override
	public String[] func_150125_e()
	{
		// TODO this
		// get texture name?  Seems to be used in ItemLeaves
		return new String[] {"naughtyleaves"};
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return Blocks.leaves.getFlammability(world, x, y, z, face);
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return Blocks.leaves.getFireSpreadSpeed(world, x, y, z, face);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return Blocks.leaves.isOpaqueCube();
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		return !isOpaqueCube() || super.shouldSideBeRendered(blockAccess, x, y, z, side);
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		icons = new IIcon[BlockInfo.PLAID_LEAVES_TEXTURES.length];
		opaqueIcons = new IIcon[BlockInfo.PLAID_OPAQUE_LEAVES_TEXTURES.length];

		for (int i = 0; i < BlockInfo.PLAID_LEAVES_TEXTURES.length; i++)
		{
			icons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_LEAVES_TEXTURES[i]);
			opaqueIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_OPAQUE_LEAVES_TEXTURES[i]);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return isOpaqueCube() ? opaqueIcons[meta & 3] : icons[meta & 3];
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs tab, List list)
	{
		for (int i = 0; i < BlockInfo.PLAID_LEAVES_TEXTURES.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta)
	{
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public boolean isLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z)
	{
		super.beginLeavesDecay(world, x, y, z);
	}

	@Override
	public int damageDropped(int meta)
	{
		return meta & 3;
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int a)
	{
		return Item.getItemFromBlock(BlocksStuff.blockPlaidSapling);
	}

	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(20) > 1 ? 0 : 1;
	}

	@Override
	public void dropBlockAsItemWithChance(World world, int x, int y, int z, int meta, float chance, int par7)
	{
		if (!world.isRemote)
		{
			ArrayList<ItemStack> items = getDrops(world, x, y, z, meta, par7);

			for (ItemStack item : items)
			{
				if (world.rand.nextFloat() <= chance)
				{
					dropBlockAsItem(world, x, y, z, item);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getBlockColor()
	{
		// what even is this?
		return 16777215;
	}

	@Override
	public int getRenderColor(int par1)
	{
		return getBlockColor();
	}

	@Override
	public int colorMultiplier(IBlockAccess par1iBlockAccess, int par2, int par3, int par4)
	{
		return getBlockColor();
	}
}
