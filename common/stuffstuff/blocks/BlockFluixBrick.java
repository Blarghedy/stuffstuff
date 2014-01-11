package stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockFluixBrick extends Block
{
	public BlockFluixBrick(int id)
    {
	    super(id, Material.rock);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(BlockInfo.FLUIX_BRICK_UNLOCALIZED_NAME);
    }
	
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.FLUIX_BRICK_TEXTURE);
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
	{
		return blockIcon;
	}

}
