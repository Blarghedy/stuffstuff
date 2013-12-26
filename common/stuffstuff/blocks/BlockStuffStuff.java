package stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import stuffstuff.StuffStuff;

public class BlockStuffStuff extends BlockContainer implements IDirectionHaver
{
	public BlockStuffStuff(int id, Material mat)
	{
	    super(id, mat);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(2F);
		setStepSound(Block.soundMetalFootstep);
	}
	
	public BlockStuffStuff(int id)
    {
	    this(id, Material.iron);
    }

	/**
	 * ITileEntityProvider Implementation
	 */
	@Override
    public TileEntity createNewTileEntity(World world)
    {
		
	    return null;
    }

	public void setOrientation(ForgeDirection direction)
	{
		
	}
	
	/**
	 * IDirectionHaver implementation
	 */
	@Override
    public ForgeDirection setDirection(ForgeDirection direction, ItemStack itemstack)
    {
		NBTTagCompound tag = itemstack.stackTagCompound;
		if (tag == null)
		{
			itemstack.stackTagCompound = tag = new NBTTagCompound();
		}
		// TODO this
//		tag.setString(IDirectionHaver.KEY, par2Str);
		return ForgeDirection.UNKNOWN;
    }

	@Override
    public ForgeDirection getDirection(ItemStack itemstack)
    {
	    // TODO Auto-generated method stub
	    return null;
    }
}
