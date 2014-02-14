package stuffstuff.aestuff.gridblocks;

import java.util.EnumSet;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import appeng.api.AEApi;
import appeng.api.networking.GridFlags;
import appeng.api.networking.GridNotification;
import appeng.api.networking.IGrid;
import appeng.api.networking.IGridBlock;
import appeng.api.networking.IGridHost;
import appeng.api.networking.IGridNode;
import appeng.api.util.AEColor;
import appeng.api.util.DimensionalCoord;

public class StuffGridBlock implements IGridBlock
{
	private int x, y, z;
	private World world;
	private AEColor color;
	private IGrid grid;
	private int channelsInUse;
	private IGridHost gridHost;
	private ItemStack renderItemStack;
	private EnumSet<GridFlags> gridFlags;

	private double idlePower;

	public StuffGridBlock(int x, int y, int z, IGridHost gridHost)
	{
		this.gridHost = gridHost;
		this.x = x;
		this.y = y;
		this.z = z;

		idlePower = 1;
		renderItemStack = null;
		gridFlags = EnumSet.of(GridFlags.REQUIRE_CHANNEL);
	}

	public void onReady()
	{
		// TODO this whole thing, apparently
		IGridNode node = AEApi.instance().createGridNode(this);

		//		if (node != null && data != null)
		//		{
		//			node.loadFromNBT(nbtName, data);
		//			data = null;
		//		}
		//		else if (node != null && owner != null)
		//		{
		//			node.setPlayerID(WorldSettings.getInstance().getPlayerID(owner.getCommandSenderName()));
		//			owner = null;
		//		}

		node.updateState();
	}

	public StuffGridBlock setMachineRepresentation(ItemStack itemstack)
	{
		this.renderItemStack = itemstack;
		return this;
	}

	public StuffGridBlock setPower(double power)
	{
		this.idlePower = power;
		return this;
	}

	/**
	 * {@link IGridBlock} implementation
	 */

	@Override
	public double getIdlePowerUsage()
	{
		return idlePower;
	}

	@Override
	public EnumSet<GridFlags> getFlags()
	{
		return gridFlags;
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
		return gridHost;
	}

	@Override
	public void gridChanged()
	{

	}

	@Override
	public ItemStack getMachineRepresentation()
	{
		return renderItemStack;
	}

}
