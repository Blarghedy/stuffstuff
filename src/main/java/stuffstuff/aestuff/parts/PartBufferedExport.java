package stuffstuff.aestuff.parts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.nbt.NBTTagCompound;
import stuffstuff.aestuff.blocks.BlocksAEStuff;
import appeng.api.networking.IGridNode;
import appeng.api.networking.ticking.IGridTickable;
import appeng.api.networking.ticking.TickRateModulation;
import appeng.api.networking.ticking.TickingRequest;
import appeng.api.parts.IPartCollsionHelper;
import appeng.api.parts.IPartRenderHelper;

public class PartBufferedExport extends PartStuff implements IGridTickable
{


	public PartBufferedExport()
	{

	}

	@Override
	public void renderInventory(IPartRenderHelper rh, RenderBlocks renderer)
	{
		rh.setTexture(BlocksAEStuff.blockFunFluix.getIcon(0, 1));

		rh.setBounds(4, 4, 11, 12, 12, 13);
		rh.renderInventoryBox(renderer);

		rh.setBounds(5, 5, 13, 11, 11, 14);
		rh.renderInventoryBox(renderer);

		rh.setBounds(6, 6, 14, 10, 10, 15);
		rh.renderInventoryBox(renderer);
	}

	@Override
	public void renderStatic(int x, int y, int z, IPartRenderHelper rh, RenderBlocks renderer)
	{
		rh.setTexture(BlocksAEStuff.blockFunFluix.getIcon(0, 1));
		rh.useSimpliedRendering(x, y, z, this);

		rh.setBounds(4, 4, 12, 12, 12, 14);
		rh.renderBlock(x, y, z, renderer);

		rh.setBounds(5, 5, 14, 11, 11, 15);
		rh.renderBlock(x, y, z, renderer);

		rh.setBounds(6, 6, 15, 10, 10, 16);
		rh.renderBlock(x, y, z, renderer);
	}

	@Override
	public void writeToNBT(NBTTagCompound data)
	{

	}

	@Override
	public void readFromNBT(NBTTagCompound data)
	{

	}

	@Override
	public void writeToStream(DataOutputStream data) throws IOException
	{

	}

	@Override
	public boolean readFromStream(DataInputStream data) throws IOException
	{
		return false;
	}

	@Override
	public void getBoxes(IPartCollsionHelper helper)
	{
		helper.addBox(4, 4, 12, 12, 12, 14);
		helper.addBox(5, 5, 14, 11, 11, 15);
		helper.addBox(6, 6, 15, 10, 10, 16);
	}

	@Override
	public int cableConnectionRenderTo()
	{
		return 4;
	}

	/**
	 * {@link IGridTickable} implementation
	 */

	@Override
	public TickingRequest getTickingRequest(IGridNode node)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TickRateModulation tickingRequest(IGridNode node, int TicksSinceLastCall)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
