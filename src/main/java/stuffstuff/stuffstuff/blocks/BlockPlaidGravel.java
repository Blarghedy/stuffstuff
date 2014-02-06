package stuffstuff.stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidGravel extends BlockPlaidSand
{
	public BlockPlaidGravel(int id)
	{
		super(id);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(Block.gravel.blockHardness);
		setStepSound(Block.gravel.stepSound);
		setUnlocalizedName(BlockInfo.PLAID_GRAVEL_UNLOCALIZED_NAME);
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return blockIcon;
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_GRAVEL_TEXTURE);
	}
	
	
}