package stuffstuff.helper;

public class PQNode
{
	public final int priority;
	public final Point point;
	public final Object[] args;
	
	public PQNode(int priority, Point point, Object ... args)
	{
		this.priority = priority;
		this.point = point;
		this.args = args;
	}
	
	public String toString()
	{
		return "Node at " + point + " with args " + args;
	}
}
