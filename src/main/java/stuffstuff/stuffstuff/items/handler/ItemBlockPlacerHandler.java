package stuffstuff.stuffstuff.items.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.helper.PQNode;
import stuffstuff.stuffstuff.helper.PQNodeComparitor;
import stuffstuff.stuffstuff.helper.Point;
import stuffstuff.stuffstuff.info.ItemInfo;
import stuffstuff.stuffstuff.items.BlockPlaceMode;
import stuffstuff.stuffstuff.items.ItemBlockPlacer;
import stuffstuff.stuffstuff.items.ItemsStuff;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class ItemBlockPlacerHandler
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
			System.out.println("Itemstack not instance of ItemBlockPlacer: ");
			System.out.println(itemstack.getItem());
			return null;
		}
	}

	public void addRegion(Point p1, Point p2, Point start, int depth, ForgeDirection direction, ItemStack itemstack)
	{
		int minx, maxx, miny, maxy, minz, maxz;
		int dimID = start.dimID;
		int priority;
		int offsetX, offsetY, offsetZ;
		PriorityQueue<PQNode> queue = getQueue(itemstack);

		if (queue == null)
		{
			return;
		}

		if (start.dimID != p1.dimID || p1.dimID != p2.dimID)
		{
			// TODO probably an error message for the user although
			// I think this should be prevented before this function is called
			System.out.printf("dimension IDs do not match %d %d %d\n", start.dimID, p1.dimID, p2.dimID);
			return;
		}

		if (direction == ForgeDirection.UNKNOWN)
		{
			// Is this possible? I doubt it.
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

		for (int inDepth = 0; inDepth < depth; inDepth++)
		{
			for (int i = minx; i <= maxx; i++)
			{
				for (int j = miny; j <= maxy; j++)
				{
					for (int k = minz; k <= maxz; k++)
					{
						priority = start.distanceSquared(i, j, k, dimID);
						if (i == start.x && (j == start.y || k == start.z) || j == start.y && k == start.z)
						{
							// if one of these cases is true, it means we are in a row/column
							// with start, in which case we want to use a low priority
							priority += inDepth * 10;
						}
						else
						{
							priority += inDepth * 15;
						}
						queue.add(new PQNode(priority, new Point(i + offsetX * inDepth, j + offsetY * inDepth, k + offsetZ * inDepth, dimID), ItemsStuff.itemBlockPlacer.getBlockPlaceMode(itemstack)));
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void tickEnd(TickEvent.ClientTickEvent e)
	//	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		ArrayList<ItemStack> delQueue = new ArrayList<ItemStack>();
		World world;
		// TODO Figure out why this is necessary at all, because all I can tell
		// so far is that it magically gets rid of the ConcurrentModificationExceptions.
		Object[] arr = map.keySet().toArray();
		for (Object stack : arr)
		{
			ItemStack itemstack = (ItemStack)stack;

			PriorityQueue<PQNode> queue = map.get(itemstack);
			int i = 0;
			PQNode node;

			while (i < ItemInfo.BLOCK_PLACER_MAX_PER_TICK && !queue.isEmpty() && (node = queue.poll()) != null)
			{
				world = DimensionManager.getWorld(node.point.dimID);

				BlockPlaceMode mode = BlockPlaceMode.CREATION;

				if (node.args.length > 0 && node.args[0] instanceof BlockPlaceMode)
				{
					mode = (BlockPlaceMode)node.args[0];
				}

				switch (mode)
				{
					case CREATION:
					case PROJECTION:
					case PILLAR:
					case EXTENSION:
						Block block = world.getBlock(node.point.x, node.point.y, node.point.z);
						if (block == null || block == Blocks.air)
						{
							world.setBlock(node.point.x, node.point.y, node.point.z, Blocks.stone, 0, 2);
						}
						break;
					case REPLACE:
						// int blockID = world.getBlockId(node.point.x, node.point.y, node.point.z);
						// if (blockID == 0)
						world.setBlock(node.point.x, node.point.y, node.point.z, Blocks.stone, 0, 2);

				}
				i++;
			}
			if (queue.size() == 0) delQueue.add(itemstack);
		}

		for (ItemStack itemstack : delQueue)
		{
			map.remove(itemstack);
		}
	}
}
