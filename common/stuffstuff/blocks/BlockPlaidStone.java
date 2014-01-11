package stuffstuff.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidStone extends Block
{
	public BlockPlaidStone(int id)
	{
		super(id, Material.rock);
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(BlockInfo.PLAID_STONE_UNLOCALIZED_NAME);
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return blockIcon;
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_STONE_TEXTURE);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return Blocks.blockPlaidCobble.idDropped(0, par2Random, par3);
	}
}
