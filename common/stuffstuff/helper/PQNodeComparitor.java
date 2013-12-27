package stuffstuff.helper;

import java.util.Comparator;

public class PQNodeComparitor implements Comparator<PQNode>
{
	@Override
	public int compare(PQNode o1, PQNode o2)
	{
		if (o1 == null || o2 == null)
		{
			// return 0;
		}
		return o1.priority - o2.priority;
	}
}
