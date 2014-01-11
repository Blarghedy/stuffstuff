package stuffstuff.blocks;

import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockDecorativeFluix extends Block
{

	public BlockDecorativeFluix(int id)
    {
	    super(id, Material.rock);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(1.5F);
		setResistance(10);
		setStepSound(soundStoneFootstep);
		setUnlocalizedName(BlockInfo.DECORATIVE_FLUIX_UNLOCALIZED_NAME);
    }
	
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.DECORATIVE_FLUIX_TEXTURE);
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
	{
		return blockIcon;
	}
	
	

}
