package stuffstuff.stuffstuff.blocks;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidGravel extends BlockPlaidSand
{
	public BlockPlaidGravel()
	{
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(.6F);
		setStepSound(Blocks.gravel.stepSound);
		setBlockName(BlockInfo.PLAID_GRAVEL_UNLOCALIZED_NAME);
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return blockIcon;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_GRAVEL_TEXTURE);
	}


}
