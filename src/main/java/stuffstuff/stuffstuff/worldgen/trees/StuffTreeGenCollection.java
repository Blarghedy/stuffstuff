package stuffstuff.stuffstuff.worldgen.trees;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import net.minecraftforge.common.config.Configuration;
import stuffstuff.stuffstuff.StuffStuff;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StuffTreeGenCollection
{
	private ArrayList<StuffTreeGen> treegens;

	public StuffTreeGenCollection()
	{
		treegens = new ArrayList<StuffTreeGen>();
	}

	/**
	 * Generate and return a {@link File} from a relative filename
	 * @param fname relative name of the file
	 * @return File stored in the tree config directory
	 */
	public static File getTreeConfigFile(String fname)
	{
		return new File(StuffStuff.treeConfigDirectory, fname);
	}

	/**
	 * Generates a {@link StuffTreeGenCollection} from json encoded in a file.
	 * @param fname Absolute path to the file to be read.  Use {@link StuffTreeGenCollection}{@link #getTreeConfigFile(String)} to generate an absolute path from a filename.
	 * @return
	 */
	public StuffTreeGenCollection genFromFile(String fname)
	{
		return genFromFile(getTreeConfigFile(fname));
	}

	/**
	 * Generates a {@link StuffTreeGenCollection} from json encoded in a file.
	 * @param file 
	 * @return this
	 */
	public StuffTreeGenCollection genFromFile(File file)
	{
		Configuration config = new Configuration(file);
		String treestring = config.get("trees", "trees", "").getString();
		JsonArray treearray = new JsonParser().parse(treestring).getAsJsonArray();

		addTreeGens(treearray);
		return this;
	}

	public StuffTreeGenCollection addTreeGen(StuffTreeGen treegen)
	{
		treegens.add(treegen);
		return this;
	}

	public StuffTreeGenCollection addTreeGen(JsonObject treegen)
	{
		StuffTreeGen gen = new StuffTreeGen(treegen);
		addTreeGen(gen);
		return this;
	}

	public StuffTreeGenCollection addTreeGens(JsonArray gens)
	{
		for (JsonElement element : gens)
		{
			addTreeGen(element.getAsJsonObject());
		}
		return this;
	}

	public StuffTreeGenCollection addTreeGens(Collection<StuffTreeGen> gens)
	{
		treegens.addAll(gens);
		return this;
	}

	public StuffTreeGen getRandomGen(Random rand)
	{
		int index = rand.nextInt(treegens.size());
		return treegens.get(index);
	}

	public int size()
	{
		return treegens.size();
	}

	public boolean removeTreeGen(StuffTreeGen gen)
	{
		return treegens.remove(gen);
	}
}
