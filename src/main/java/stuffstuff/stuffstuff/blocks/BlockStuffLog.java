package stuffstuff.stuffstuff.blocks;

import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.StuffStuff;

public abstract class BlockStuffLog extends BlockLog
{
	protected IIcon topIcon, sideIcon;
	
	public BlockStuffLog()
	{
		setHardness(2F);
		setStepSound(soundTypeWood);
		setCreativeTab(StuffStuff.tabStuffStuff);
	}

	@Override
	public abstract void registerBlockIcons(IIconRegister register);

	@Override
	public abstract String getUnlocalizedName();

	@Override
	public IIcon getTopIcon(int meta)
	{
		return topIcon;
	}

	@Override
	public IIcon getSideIcon(int meta)
	{
		return sideIcon;
	}

	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 20;
	}

	@Override
	public int damageDropped(int meta)
	{
		return super.damageDropped(meta);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return Item.getItemFromBlock(this);
	}

	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
}
