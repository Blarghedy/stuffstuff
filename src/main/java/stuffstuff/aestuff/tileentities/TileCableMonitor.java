package stuffstuff.aestuff.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.aestuff.gridblocks.StuffGridBlock;
import appeng.api.networking.IGridHost;
import appeng.api.networking.IGridNode;
import appeng.api.util.AECableType;

public class TileCableMonitor extends TileEntity implements IGridHost
{
	StuffGridBlock gridBlock;

	@Override
	public IGridNode getGridNode(ForgeDirection dir)
	{
		// TODO this
		gridBlock = new StuffGridBlock(xCoord, yCoord, zCoord, this);
		//		gridBlock.setMachineRepresentation(this.getItemStack(PartItemStack.Network));
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
