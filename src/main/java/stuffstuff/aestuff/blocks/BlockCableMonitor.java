package stuffstuff.aestuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ForgeDirection;
import appeng.api.networking.IGridHost;
import appeng.api.networking.IGridNode;
import appeng.api.util.AECableType;

public class BlockCableMonitor extends Block implements IGridHost
{

	public BlockCableMonitor(int par1, Material par2Material)
    {
	    super(par1, par2Material);
	    // TODO Auto-generated constructor stub
    }
	
	/**
	 * {@link IGridHost} implementation
	 */

	@Override
    public IGridNode getGridNode(ForgeDirection dir)
    {
//	    return AEApi.instance().createGridNode(MyIGridBlock);
		return null;
    }

	@Override
    public AECableType getCableConnectionType(ForgeDirection dir)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public void securityBreak()
    {
	    // TODO Auto-generated method stub
	    
    }

}
