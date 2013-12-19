package stuffstuff.blocks;

import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBlockPlacer extends BlockContainer
{

	public BlockBlockPlacer(int id)
    {
	    super(id, Material.iron);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(BlockInfo.PLACER_UNLOCALIZED_NAME);
    }

	/**
	 * ITileEntityProvider Implementation
	 */
	@Override
    public TileEntity createNewTileEntity(World world)
    {
	    return null;
    }

}
