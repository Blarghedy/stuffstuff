package stuffstuff.stuffstuff.worldgen;

import java.util.LinkedList;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class StuffTreeGenBase
{
	private LinkedList<Integer> list;
	protected int x, y, z;
	protected int startx, starty, startz;
	protected ForgeDirection orientation;
	protected ForgeDirection lean;
	protected int depth, maxDepth;
	protected int branchRatio;
	protected World world;

	public StuffTreeGenBase(World world, int x, int y, int z, int maxDepth)
	{
		list = new LinkedList<Integer>();
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		startx = x;
		starty = y;
		startz = z;
		this.maxDepth = maxDepth;
		depth = 0;
		lean = ForgeDirection.EAST;
	}

	public int getDepth()
	{
		return depth;
	}

	public void setDepth(int depth)
	{
		this.depth = depth;
	}

	public int getMaxDepth()
	{
		return maxDepth;
	}

	public abstract void genTree();

	protected void enQueue()
	{
		push(x);
		push(y);
		push(z);
		push(depth);
		push(orientation.ordinal());
	}

	protected void deQueue()
	{
		x = pop();
		y = pop();
		z = pop();
		depth = pop();
		orientation = ForgeDirection.getOrientation(pop());
	}

	protected void push(int n)
	{
		list.add(n);
	}

	protected int pop()
	{
		return list.poll();
	}

	protected int peek()
	{
		return list.peek();
	}

	protected boolean stackIsEmpty()
	{
		return list.isEmpty();
	}
}
