package stuffstuff.aestuff.parts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.nbt.NBTTagCompound;
import appeng.api.parts.IPartCollsionHelper;
import appeng.api.parts.IPartRenderHelper;

public class PartBufferedExport extends PartStuff
{

	@Override
    public void renderInventory(IPartRenderHelper rh, RenderBlocks renderer)
    {
	    
    }

	@Override
    public void renderStatic(int x, int y, int z, IPartRenderHelper rh, RenderBlocks renderer)
    {
	    
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
	    
    }

	@Override
    public int cableConnectionRenderTo()
    {
	    return 0;
    }

}
