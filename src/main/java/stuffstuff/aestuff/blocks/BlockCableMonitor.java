package stuffstuff.aestuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCableMonitor extends Block implements ITileEntityProvider
{

	public BlockCableMonitor(Material material)
	{
		super(material);
	}

	/**
	 * {@link ITileEntityProvider} implementation
	 */

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
