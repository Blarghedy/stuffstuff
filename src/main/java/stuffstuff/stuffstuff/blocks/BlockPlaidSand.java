package stuffstuff.stuffstuff.blocks;

import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidSand extends BlockSand
{

	public BlockPlaidSand()
	{
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(.5F);
		setStepSound(soundTypeSand);
		setBlockName(BlockInfo.PLAID_SAND_UNLOCALIZED_NAME);
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return blockIcon;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_SAND_TEXTURE);
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		world.scheduleBlockUpdate(x, y, z, this, tickRate(world));
	}

	public static boolean func_149831_e(World world, int x, int y, int z)
	{
		// BlockSand.canFallBelow
		return BlockSand.func_149831_e(world, x, y, z);
	}

	@Override
	public int tickRate(World world)
	{
		return super.tickRate(world);
	}

}
