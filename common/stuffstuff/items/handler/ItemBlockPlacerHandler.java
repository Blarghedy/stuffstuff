package stuffstuff.items.handler;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import stuffstuff.helper.PQNode;
import stuffstuff.helper.PQNodeComparitor;
import stuffstuff.helper.Point;
import stuffstuff.info.ModInfo;
import stuffstuff.items.ItemBlockPlacer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ItemBlockPlacerHandler implements ITickHandler
{
	private HashMap<EntityPlayer, LinkedList<Tuple>> map;
	private PriorityQueue<PQNode> queue;
	
	public ItemBlockPlacerHandler()
	{
		queue = new PriorityQueue<PQNode>(100, new PQNodeComparitor());
		map = new HashMap<EntityPlayer, LinkedList<Tuple>>();
		// TODO probably unrelated to the constructor but we should probably just have things mapped to the ItemStack.  The player doesn't really matter, yeah?
	}
	
	// TODO this might need some refactoring for efficiency, depending on the performance hit from doing it this way
	public void addPoint(EntityPlayer player, ItemStack itemstack, Point p)
	{
		LinkedList<Tuple> list = null;
		if (map.containsKey(player))
		{
			list = map.get(player);
		}
		if (list == null)
		{
			list = new LinkedList<Tuple>();
			map.put(player, list);
		}
		if (itemstack.getItem() instanceof ItemBlockPlacer)
		{
			list.add(new Tuple(itemstack, p));
		}
	}
	
	public void addPoints(EntityPlayer player, ItemStack itemstack, Collection<Point> points)
	{
		for (Point p : points)
		{
			addPoint(player, itemstack, p);
		}
	}
	
	public void addRegion(EntityPlayer player, ItemStack itemstack, Point p1, Point p2, Point p3, Point face)
	{
		if (p1.dimID != p2.dimID || p2.dimID != p3.dimID)
		{
			return;
		}
		
	}
	
	public void stuff(Point p1, Point p2, Point start)
	{
		int minx, maxx, miny, maxy, minz, maxz;
		int dimID = start.dimID;
		int priority;
		int depth;
		
		if (start.dimID != p1.dimID || p1.dimID != p2.dimID)
		{
			// TODO probably an error message for the user although 
			// I think this should be prevented before this function is called
			return;
		}
		
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

		for (int inDepth = 0; inDepth < 10; inDepth++)
		{
			for (int i = minx; i < maxx; i++)
			{
				for (int j = miny; j < maxy; j++)
				{
					for (int k = minz; k < maxz; k++)
					{
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
							priority += inDepth * 100;
						}
						queue.add(new PQNode(priority, new Point(i, j, k, dimID)));
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
	    // TODO Auto-generated method stub
	    
    }

	@Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.SERVER);	
    }

	@Override
    public String getLabel()
    {
        return ModInfo.ID + ": " + this.getClass().getSimpleName();
    }
	
}
