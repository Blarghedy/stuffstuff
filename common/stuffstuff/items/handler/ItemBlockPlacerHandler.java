package stuffstuff.items.handler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.PriorityQueue;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ForgeDirection;
import stuffstuff.helper.PQNode;
import stuffstuff.helper.PQNodeComparitor;
import stuffstuff.helper.Point;
import stuffstuff.info.ItemInfo;
import stuffstuff.info.ModInfo;
import stuffstuff.items.BlockPlaceMode;
import stuffstuff.items.ItemBlockPlacer;
import stuffstuff.items.Items;
import stuffstuff.player.NotificationHelper;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ItemBlockPlacerHandler implements ITickHandler
{
	private HashMap<ItemStack, PriorityQueue<PQNode>> map;

	public ItemBlockPlacerHandler()
	{
		map = new HashMap<ItemStack, PriorityQueue<PQNode>>();
	}

	private PriorityQueue<PQNode> getQueue(ItemStack itemstack)
	{
		if (itemstack.getItem() instanceof ItemBlockPlacer)
		{
			if (map.containsKey(itemstack))
			{
				return map.get(itemstack);
			}
			else
			{
				PriorityQueue<PQNode> queue = new PriorityQueue<PQNode>(50, new PQNodeComparitor());
				map.put(itemstack, queue);
				return queue;
			}
		}
		else
		{
			return null;
		}
	}

	//	public void event(Point clicked, int sideClicked, ItemStack itemstack)
	//	{
	//		PriorityQueue<PQNode> queue = getQueue(itemstack);
	//		if (queue == null) return; // it isn't a block placer
	//		
	//		ItemBlockPlacer item = (ItemBlockPlacer)itemstack.getItem();
	//		BlockPlaceMode mode = item.getBlockPlaceMode(itemstack);
	//		int charge = item.getCharge(itemstack);
	//		
	//		switch(mode)
	//		{
	//			// CREATION, EXTENSION, PILLAR, REPLACE, PROJECTION
	//			case EXTENSION:
	//				
	//				break;
	//			case PILLAR:
	//				
	//				break;
	//			case REPLACE:
	//				
	//				break;
	//			case PROJECTION:
	//				
	//				break;
	//			case CREATION:
	//			default:
	//					
	//		}
	//	}

	public void addRegion(Point p1, Point p2, Point start, int depth, ForgeDirection direction, ItemStack itemstack)
	{
		int minx, maxx, miny, maxy, minz, maxz;
		int dimID = start.dimID;
		int priority;
		int offsetX, offsetY, offsetZ;
		PriorityQueue<PQNode> queue = getQueue(itemstack);
//		System.out.printf("Adding region (p1, p2, start), (" + p1 + " " + p2 + " " + start + "), depth %d direction %s item %s\n", depth, direction.name(), itemstack.getItem().getUnlocalizedName());

		if (start.dimID != p1.dimID || p1.dimID != p2.dimID)
		{
			// TODO probably an error message for the user although 
			// I think this should be prevented before this function is called
			System.out.printf("dimension IDs do not match %d %d %d\n", start.dimID, p1.dimID, p2.dimID);
			return;
		}

		if (direction == ForgeDirection.UNKNOWN)
		{
			// Is this possible?  I doubt it.
			System.out.println("Returning: direction is UNKNOWN");
			return;
		}

		offsetX = direction.offsetX;
		offsetY = direction.offsetY;
		offsetZ = direction.offsetZ;

		if (p1.x < p2.x) 
		{
			minx = p1.x;
			maxx = p2.x;
		}
		else
		{
			minx = p2.x;
			maxx = p1.x;
		}

		if (p1.y < p2.y) 
		{
			miny = p1.y;
			maxy = p2.y;
		}
		else
		{
			miny = p2.y;
			maxy = p1.y;
		}

		if (p1.z < p2.z) 
		{
			minz = p1.z;
			maxz = p2.z;
		}
		else
		{
			minz = p2.z;
			maxz = p1.z;
		}

//		System.out.printf("min(x,y,z): (%d,%d,%d), max(x,y,z): (%d,%d,%d), start: (%d,%d,%d)", minx, miny, minz, maxx, maxy, maxz, start.x, start.y, start.z);

		for (int inDepth = 0; inDepth < depth; inDepth++)
		{
			for (int i = minx; i <= maxx; i++)
			{
				for (int j = miny; j <= maxy; j++)
				{
					for (int k = minz; k <= maxz; k++)
					{
//						System.out.printf("(i,j,k) (%d,%d,%d)\n", i, j, k);
						
						priority = start.distanceSquared(i, j, k, dimID);
						if ((i == start.x && (j == start.y || k == start.z)) || 
								(j == start.y && (k == start.z)))
						{
							// if one of these cases is true, it means we are in a row/column 
							// with start, in which case we want to use a low priority
							priority += inDepth * 10;
						}
						else
						{
							priority += inDepth * 15;
						}
						queue.add(new PQNode(priority, new Point(i + offsetX * inDepth, j + offsetY * inDepth, k + offsetZ * inDepth, dimID), Items.itemBlockPlacer.getBlockPlaceMode(itemstack)));
//						NotificationHelper.notifySelf("Added to queue");
					}
				}
			}
		}
	}

	/**
	 * {@link ITickHandler} implementation
	 */
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		ArrayList<ItemStack> delQueue = new ArrayList<ItemStack>();
		World world;
		
		for (ItemStack itemstack : map.keySet())
		{
			PriorityQueue<PQNode> queue = map.get(itemstack);
//			System.out.println("itemstack, queue: " + itemstack + " - " + queue);
			int i = 0;
			while (i < ItemInfo.BLOCK_PLACER_MAX_PER_TICK && !queue.isEmpty())
			{
				PQNode node = queue.poll();
				world = DimensionManager.getWorld(node.point.dimID);
//				System.out.println("Got world for " + node.point.dimID + " " + world);
				
				BlockPlaceMode mode = BlockPlaceMode.CREATION;

				if (node.args.length > 0 && node.args[0] instanceof BlockPlaceMode)
				{
					mode = (BlockPlaceMode) node.args[0];
				}
//				System.out.println("" + i + " " + mode + " " + node);

				switch(mode)
				{
					case CREATION:
					case PROJECTION:
					case PILLAR:
					case EXTENSION:
						int blockID = world.getBlockId(node.point.x, node.point.y, node.point.z);
						if (blockID == 0) 
							world.setBlock(node.point.x, node.point.y, node.point.z, 1);
						break;
					case REPLACE:
						//	    				int blockID = world.getBlockId(node.point.x, node.point.y, node.point.z);
						//	    				if (blockID == 0) 
						world.setBlock(node.point.x, node.point.y, node.point.z, 1);

				}
				i++;
			}
//			if (queue.size() == 0) delQueue.add(itemstack);
		}

		for (ItemStack itemstack : delQueue)
		{
			map.remove(itemstack);
		}
	}

@Override
public EnumSet<TickType> ticks()
{
	// TODO server this nonsense
	return EnumSet.of(TickType.CLIENT);	
}

@Override
public String getLabel()
{
	return ModInfo.ID + ": " + this.getClass().getSimpleName();
}

}
