package stuffstuff.stuffstuff.blocks;

import stuffstuff.stuffstuff.StuffStuff;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public abstract class BlockStuffDirt extends Block
{
	
	public BlockStuffDirt()
    {
	    super(Material.ground);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(.5F);
		setStepSound(soundTypeGravel);
    }
	
	@Override
	public abstract String getUnlocalizedName();
	
	@Override
	public abstract IIcon getIcon(int side, int meta);
	
	@Override
	public abstract void registerBlockIcons(IIconRegister register);

}
