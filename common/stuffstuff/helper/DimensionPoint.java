package stuffstuff.helper;

public class DimensionPoint
{
	private double x, y, z;
	private int dimID;
	
	public DimensionPoint(double x, double y, double z, int dimID)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.dimID = dimID;
	}
	
	public DimensionPoint(double x, double y, double z)
	{
		this(x, y, z, 0);
	}

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	public double getZ()
	{
		return z;
	}

	public void setZ(double z)
	{
		this.z = z;
	}

	public int getDimID()
	{
		return dimID;
	}

	public void setDimID(int dimID)
	{
		this.dimID = dimID;
	}
}
