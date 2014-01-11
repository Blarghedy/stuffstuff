package stuffstuff.blocks;

import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockFineFluixBrick extends Block
{
	public BlockFineFluixBrick(int id)
    {
	    super(id, Material.rock);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(BlockInfo.FINE_FLUIX_BRICK_UNLOCALIZED_NAME);
    }
	
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.FINE_FLUIX_BRICK_TEXTURE);
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
	{
		return blockIcon;
	}
}
