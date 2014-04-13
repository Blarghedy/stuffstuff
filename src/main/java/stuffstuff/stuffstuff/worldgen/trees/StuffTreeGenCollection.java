package stuffstuff.stuffstuff.worldgen.trees;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class StuffTreeGenCollection
{
	private ArrayList<StuffTreeGen> treegens;
	
	public StuffTreeGenCollection()
	{
		treegens = new ArrayList<StuffTreeGen>();
	}
	
	public StuffTreeGenCollection(Collection<StuffTreeGen> gens)
	{
		treegens.addAll(gens);
	}
	
	public StuffTreeGenCollection(JsonArray array)
	{
		
	}
	
	public void addTreeGen(StuffTreeGen treegen)
	{
		treegens.add(treegen);
	}
	
	public void addTreeGen(JsonObject treegen)
	{
		StuffTreeGen gen = new StuffTreeGen(treegen);
		addTreeGen(gen);
	}
	
	public void addTreeGens(JsonArray gens)
	{
		for (JsonElement element : gens)
		{
			addTreeGen(element.getAsJsonObject());
		}
	}
	
	public void addTreeGens(Collection<StuffTreeGen> gens)
	{
		
	}
}
