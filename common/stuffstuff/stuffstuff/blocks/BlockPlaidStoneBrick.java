package stuffstuff.stuffstuff.blocks;

import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockPlaidStoneBrick extends Block
{

	public BlockPlaidStoneBrick(int id)
	{
		super(id, Material.rock);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(BlockInfo.PLAID_STONE_BRICK_UNLOCALIZED_NAME);
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_STONE_BRICK_TEXTURE);
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
	{
		return blockIcon;
	}
}
