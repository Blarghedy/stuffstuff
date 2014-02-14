package stuffstuff.stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidDirt extends Block
{
	public BlockPlaidDirt()
	{
		super(Material.ground);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(.5F);
		setStepSound(soundTypeGravel);
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.PLAID_DIRT_UNLOCALIZED_NAME;
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return blockIcon;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_DIRT_TEXTURE);
	}
}
