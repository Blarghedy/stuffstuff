package stuffstuff.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidCobblestone extends BlockPlaidStone
{

	public BlockPlaidCobblestone(int id)
	{
		super(id);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(BlockInfo.PLAID_COBBLESTONE_UNLOCALIZED_NAME);
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return blockIcon;
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_COBBLESTONE_TEXTURE);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return blockID;
	}

	
}
