package stuffstuff.helper;

import java.util.Comparator;

public class PQNodeComparitor implements Comparator<PQNode>
{
	@Override
    public int compare(PQNode o1, PQNode o2)
    {
	    return o2.priority - o1.priority;
    }
}
