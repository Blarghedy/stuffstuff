package stuffstuff.helper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PQNodeComparitor implements Comparator<PQNode>
{
	@Override
    public int compare(PQNode o1, PQNode o2)
    {
	    return o1.priority - o2.priority;
    }
}
