package stuffstuff.aestuff.parts;

import stuffstuff.aestuff.items.ItemStuffPart;

public class Parts
{
	PartStuff partBufferedExport;
	
	public static void init()
	{
		ItemStuffPart.registerPart(PartBufferedExport.class);
	}
}
