package stuffstuff.blocks;

import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;

public class BlockPlaidSand extends BlockSand
{

	public BlockPlaidSand(int id)
	{
		super(id);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setHardness(.5F);
		setStepSound(soundSandFootstep);
		setUnlocalizedName(BlockInfo.PLAID_SAND_UNLOCALIZED_NAME);
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return blockIcon;
	}

	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_SAND_TEXTURE);
	}
	
    public void onBlockAdded(World world, int x, int y, int z)
    {
        world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
    }

    public static boolean canFallBelow(World world, int x, int y, int z)
    {
    	return BlockSand.canFallBelow(world, x, y, z);
    }
    
    @Override
    public int tickRate(World world)
    {
    	return super.tickRate(world);
    }

    
}
