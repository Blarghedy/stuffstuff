package stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidDirt extends Block
{
	public BlockPlaidDirt(int id)
	{
		super(id, Material.ground);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(.5F);
		setStepSound(soundGravelFootstep);
		setUnlocalizedName(BlockInfo.PLAID_DIRT_UNLOCALIZED_NAME);
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
	{
		return blockIcon;
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_DIRT_TEXTURE);
	}
}
