package stuffstuff.holidaystuff.blocks.halloween;

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
import stuffstuff.holidaystuff.HolidayStuff;
import stuffstuff.holidaystuff.info.BlockInfo;
import stuffstuff.holidaystuff.worldgen.biome.halloween.HalloweenTreeGen;

public class BlockHalloweenSapling extends BlockSapling
{
	public BlockHalloweenSapling()
	{
		this.setCreativeTab(HolidayStuff.tabHolidayStuff);
		setHardness(0.0F);
		setStepSound(soundTypeGrass);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.HALLOWEEN_SAPLING_UNLOCALIZED_NAME;
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return blockIcon;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.HALLOWEEN_SAPLING_TEXTURE);
	}

	@Override
	public void func_149878_d(World world, int x, int y, int z, Random rand)
	{
		// was growTree
		HalloweenTreeGen treeGen = new HalloweenTreeGen(world, x, y, z, 18, 6);
		treeGen.genTree();
	}

	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(item, 1, 0));
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return EnumPlantType.Plains;
	}
}
