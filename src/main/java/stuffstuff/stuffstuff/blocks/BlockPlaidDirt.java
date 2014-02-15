package stuffstuff.stuffstuff.blocks;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidDirt extends BlockStuffDirt
{
	public BlockPlaidDirt()
	{
		setCreativeTab(StuffStuff.tabPlaidStuff);
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
