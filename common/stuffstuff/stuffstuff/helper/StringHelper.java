package stuffstuff.stuffstuff.helper;

public class StringHelper
{
	public static String upperFirst(String s)
	{
		return s == null ? null : s.substring(0, 1).toUpperCase() + s.substring(1);
	}
}
