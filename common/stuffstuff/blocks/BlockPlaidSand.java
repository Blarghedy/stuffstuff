package stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidSand extends Block
{

	public BlockPlaidSand(int id)
	{
		super(id, Material.sand);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(.5F);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(BlockInfo.PLAID_SAND_UNLOCALIZED_NAME);
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return blockIcon;
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_SAND_TEXTURE);
	}

}
