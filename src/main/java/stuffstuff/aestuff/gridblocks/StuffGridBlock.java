package stuffstuff.aestuff.gridblocks;

import java.util.EnumSet;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import stuffstuff.aestuff.parts.PartStuff;
import appeng.api.networking.GridFlags;
import appeng.api.networking.GridNotification;
import appeng.api.networking.IGrid;
import appeng.api.networking.IGridBlock;
import appeng.api.networking.IGridHost;
import appeng.api.parts.PartItemStack;
import appeng.api.util.AEColor;
import appeng.api.util.DimensionalCoord;

public class StuffGridBlock implements IGridBlock
{
	private PartStuff part;
	private int x, y, z;
	private World world;
	private AEColor color;
	private IGrid grid;
	private int channelsInUse;
	
	public StuffGridBlock(int x, int y, int z, PartStuff part)
	{
		this.part = part;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
    public double getIdlePowerUsage()
    {
		return part.idlePower();
    }

	@Override
    public EnumSet<GridFlags> getFlags()
    {
		return EnumSet.of(GridFlags.REQUIRE_CHANNEL);
    }

	@Override
    public boolean isWorldAccessable()
    {
		return false;
    }

	@Override
    public DimensionalCoord getLocation()
    {
		return new DimensionalCoord(world, x, y, z);
    }

	@Override
    public AEColor getGridColor()
    {
		return color;
    }

	@Override
    public void onGridNotification(GridNotification notification)
    {
	    
    }

	@Override
    public void setNetworkStatus(IGrid grid, int channelsInUse)
    {
		this.grid = grid;
		this.channelsInUse = channelsInUse;
    }

	@Override
    public EnumSet<ForgeDirection> getConnectableSides()
    {
	    return EnumSet.of(ForgeDirection.DOWN, ForgeDirection.UP, ForgeDirection.NORTH, ForgeDirection.SOUTH, ForgeDirection.EAST, ForgeDirection.WEST);
    }

	@Override
    public IGridHost getMachine()
    {
		return part;
    }

	@Override
    public void gridChanged()
    {
	    
    }

	@Override
    public ItemStack getMachineRepresentation()
    {
		// TODO this is weird maybe
	    return part.getItemStack(PartItemStack.Network);
    }

}
