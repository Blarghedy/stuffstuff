package stuffstuff.stuffstuff.blocks;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidCobblestone extends BlockPlaidStone
{

	public BlockPlaidCobblestone()
	{
		setCreativeTab(StuffStuff.tabPlaidStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundTypeStone);
	}
	
	@Override
	public String getUnlocalizedName()
	{
	    return BlockInfo.PLAID_COBBLESTONE_UNLOCALIZED_NAME;
	}

	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return blockIcon;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_COBBLESTONE_TEXTURE);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		return Item.getItemFromBlock(this);
	}

}
