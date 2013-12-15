package stuffstuff.blocks;

import java.util.Random;

import stuffstuff.StuffStuff;
import stuffstuff.info.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.entity.EntityEvent.CanUpdate;

public class BlockPlaidGrass extends Block
{
	private Icon[] sideIcons;
	private Icon[] topIcons;
	
	public BlockPlaidGrass(int id)
	{
		super(id, Material.grass);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setStepSound(soundGrassFootstep);
		setHardness(.7F);
		setUnlocalizedName(BlockInfo.BLOCK_PLAID_GRASS_UNLOCALIZED_NAME);
		setTickRandomly(true);
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		sideIcons = new Icon[BlockInfo.BLOCK_PLAID_GRASS_SIDE_TEXTURES.length];
		topIcons = new Icon[BlockInfo.BLOCK_PLAID_GRASS_TOP_TEXTURES.length];

		for (int i = 0; i < sideIcons.length; i++)
		{
			sideIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_PLAID_GRASS_SIDE_TEXTURES[i]);
		}

		for (int i = 0; i < topIcons.length; i++)
		{
			topIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_PLAID_GRASS_TOP_TEXTURES[i]);
		}
	}
	
	@Override
	public Icon getIcon(int side, int meta)
	{
	    ForgeDirection face = ForgeDirection.getOrientation(side);
	    if (face == ForgeDirection.UP) return topIcons[0];
	    else return sideIcons[0]; 
	}
	
	@Override
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
	    ForgeDirection face = ForgeDirection.getOrientation(side);
		PlaidColor color = PlaidColor.getPlaidColorFromPos(x, y, z);
		
	    switch(face)
	    {
	    	case UP:
	    		return topIcons[color.ordinal()];
	    	case DOWN: // just need vanilla dirt texture
	    		return Block.grass.getBlockTexture(blockAccess, x, y, z, side);
	    	default: // all 4 sides
	    		Material mat = blockAccess.getBlockMaterial(x, y + 1, z);
	    		if (mat == Material.snow || mat == Material.craftedSnow)
	    		{
	    			return Block.dirt.getBlockTexture(blockAccess, x, y, z, side);
	    		}
	    		else
	    		{
	    			return sideIcons[color.ordinal()];
	    		}
	    }
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (!world.isRemote)
		{
			if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
			{
				world.setBlock(x, y, z, Block.dirt.blockID);
			}
			else if (world.getBlockLightValue(x, y + 1, z) > 9)
			{
				int newx = x, newy = y, newz = z;
				
				// Just for the heck of it, and because it is plaid, after all, let's
				// encourage it to spread in a straight line instead of completely randomly
				// The end effect of this should be diamond-shaped patches of plad grass.
				switch(rand.nextInt(4))
				{
					case 0:
						newx = x - 1;
						break;
					case 1:
						newx = x + 1;
						break;
					case 2:
						newz = z - 1;
						break;
					default:
						newz = z + 1;
				}
				
				// We really need a way to encourage it to grow up/down, so this does that.
				newy = y + rand.nextInt(3) - 1;
				
				if (world.getBlockId(newx, newy, newz) == Block.dirt.blockID && world.getBlockLightValue(newx,  newy + 1, newz) > 3 && world.getBlockLightOpacity(newx, newy + 1, newz) < 3)
				{
					world.setBlock(newx, newy, newz, Blocks.blockPlaidGrass.blockID);
				}
			}
		}
	}
	
	@Override
	public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant)
	{
        int plantID = plant.getPlantID(world, x, y + 1, z);
        EnumPlantType plantType = plant.getPlantType(world, x, y + 1, z);
        
        if (plantType == EnumPlantType.Plains) return true;
        
	    return super.canSustainPlant(world, x, y, z, direction, plant);
	}
	
	@Override
	public int tickRate(World world)
	{
	    return super.tickRate(world);
	}
}
