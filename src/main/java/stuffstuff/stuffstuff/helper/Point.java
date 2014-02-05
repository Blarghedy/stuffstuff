package stuffstuff.stuffstuff.helper;

public class Point
{
	public final int x, y, z, dimID;

	public Point(int x, int y, int z, int dimID)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.dimID = dimID;
	}

	public Point(int x, int y, int z)
	{
		this(x, y, z, 0);
	}

	@Override
	public String toString()
	{
		return "Point at (" + x + " " + y + " " + z + ") in Dimension " + dimID;
	}

	public Point minus(Point p)
	{
		return new Point(x - p.x, y - p.y, z - p.y, dimID);
	}

	public Point minus(int n)
	{
		return new Point(x - n, y - n, z - n, dimID);
	}

	public Point plus(Point p)
	{
		return new Point(x + p.x, y + p.y, z + p.z, dimID);
	}

	public Point plus(int n)
	{
		return new Point(x + n, y + n, z + n, dimID);
	}

	public int distanceSquared(Point p)
	{
		return distanceSquared(p.x, p.y, p.z, p.dimID);
	}

	public int distanceSquared(int x2, int y2, int z2, int dimID)
	{
		if (this.dimID != dimID)
			return -1;

		double a = Math.pow(x2 - x, 2);
		double b = Math.pow(y2 - y, 2);
		double c = Math.pow(z2 - z, 2);

		return (int)(a + b + c);
	}
}
