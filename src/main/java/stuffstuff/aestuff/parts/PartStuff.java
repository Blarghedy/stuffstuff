package stuffstuff.aestuff.parts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import stuffstuff.aestuff.gridblocks.StuffGridBlock;
import stuffstuff.aestuff.items.ItemStuffPart;
import stuffstuff.aestuff.items.ItemsAEStuff;
import appeng.api.AEApi;
import appeng.api.networking.IGridHost;
import appeng.api.networking.IGridNode;
import appeng.api.networking.security.IActionHost;
import appeng.api.parts.BusSupport;
import appeng.api.parts.IPart;
import appeng.api.parts.IPartCollsionHelper;
import appeng.api.parts.IPartHost;
import appeng.api.parts.IPartRenderHelper;
import appeng.api.parts.PartItemStack;
import appeng.api.util.AECableType;

public abstract class PartStuff implements IPart, IGridHost, IActionHost
{
	private ForgeDirection side;
	private IPartHost host;
	private TileEntity tile;
	private StuffGridBlock gridBlock;
	private IGridNode node;

	public double idlePower()
	{
		return 1;
	}

	/**
	 * {@link IPart} implementation
	 */

	@Override
	public ItemStack getItemStack(PartItemStack type)
	{
		return new ItemStack(ItemsAEStuff.itemStuffPart, 1, ItemStuffPart.getID(getClass()));
	}

	@Override
	public abstract void renderInventory(IPartRenderHelper rh, RenderBlocks renderer);

	@Override
	public abstract void renderStatic(int x, int y, int z, IPartRenderHelper rh, RenderBlocks renderer);

	@Override
	public void renderDynamic(double x, double y, double z, IPartRenderHelper rh, RenderBlocks renderer)
	{

	}

	@Override
	public boolean isSolid()
	{
		return false;
	}

	@Override
	public boolean canConnectRedstone()
	{
		return false;
	}

	@Override
	public abstract void writeToNBT(NBTTagCompound data);

	@Override
	public abstract void readFromNBT(NBTTagCompound data);

	@Override
	public int getLightLevel()
	{
		return 0;
	}

	@Override
	public boolean isLadder(EntityLivingBase entity)
	{
		return false;
	}

	@Override
	public void onNeighborChanged()
	{

	}

	@Override
	public int isProvidingStrongPower()
	{
		return 0;
	}

	@Override
	public int isProvidingWeakPower()
	{
		return 0;
	}

	@Override
	public abstract void writeToStream(DataOutputStream data) throws IOException;

	@Override
	public abstract boolean readFromStream(DataInputStream data) throws IOException;

	@Override
	public IGridNode getGridNode()
	{
		return node;
	}

	@Override
	public void onEntityCollision(Entity entity)
	{

	}

	@Override
	public void removeFromWorld()
	{

	}

	@Override
	public void addToWorld()
	{
		gridBlock = new StuffGridBlock(tile.xCoord, tile.yCoord, tile.zCoord, this);
		gridBlock.setMachineRepresentation(this.getItemStack(PartItemStack.Network));
		node = AEApi.instance().createGridNode(gridBlock);
		onNeighborChanged();
	}

	@Override
	public IGridNode getExternalFacingNode()
	{
		return null;
	}

	@Override
	public void setPartHostInfo(ForgeDirection side, IPartHost host, TileEntity tile)
	{
		this.side = side;
		this.host = host;
		this.tile = tile;
	}

	@Override
	public abstract void getBoxes(IPartCollsionHelper helper);

	@Override
	public boolean onActivate(EntityPlayer player, Vec3 pos)
	{
		return false;
	}

	@Override
	public boolean onShiftActivate(EntityPlayer player, Vec3 pos)
	{
		return false;
	}

	@Override
	public void getDrops(List<ItemStack> drops, boolean wrenched)
	{

	}

	@Override
	public abstract int cableConnectionRenderTo();

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random r)
	{

	}

	@Override
	public void onPlacement(EntityPlayer player, ItemStack held, ForgeDirection side)
	{

	}

	@Override
	public boolean canBePlacedOn(BusSupport what)
	{
		return what != BusSupport.NO_PARTS;
	}

	/**
	 * {@link IGridHost} implementation
	 */

	@Override
	public IGridNode getGridNode(ForgeDirection dir)
	{
		return node;
	}

	@Override
	public AECableType getCableConnectionType(ForgeDirection dir)
	{
		return AECableType.SMART;
	}

	@Override
	public void securityBreak()
	{

	}

	/**
	 * {@link IActionHost} implementation
	 */

	@Override
	public IGridNode getActionableNode()
	{
		return node;
	}
}
