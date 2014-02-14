package stuffstuff.stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidStoneBrick extends Block
{

	public BlockPlaidStoneBrick()
	{
		super(Material.rock);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundTypeStone);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.PLAID_STONE_BRICK_UNLOCALIZED_NAME;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_STONE_BRICK_TEXTURE);
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return blockIcon;
	}
}
