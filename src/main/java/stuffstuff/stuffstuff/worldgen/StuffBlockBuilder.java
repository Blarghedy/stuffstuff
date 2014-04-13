package stuffstuff.stuffstuff.worldgen;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import cpw.mods.fml.common.registry.GameRegistry;

public abstract class StuffBlockBuilder
{
	private JsonObject jsonObject;
	private Block targetBlock;
	private String targetBlockName;
	private int[] arr;

	public StuffBlockBuilder(JsonObject obj)
	{
		this.jsonObject = obj;
		parseObject();
	}

	public void build(World world, int x, int y, int z)
	{
		int xdif, ydif, zdif;
		int meta;

		for (int i = 0; i < arr.length; i += 4)
		{
			xdif = arr[i];
			ydif = arr[i + 1];
			zdif = arr[i + 2];
			meta = arr[i + 3];

			if (canReplace(world, x + xdif, y + ydif, z + zdif))
			{
				world.setBlock(x + xdif, y + ydif, z + zdif, targetBlock, meta, 2);
			}
		}
	}

	public abstract boolean canReplace(IBlockAccess world, int x, int y, int z);

	public void validate()
	{
		if (!checkIsValid())
		{
			parseObject();
			if (!checkIsValid())
			{
				throw new RuntimeException("JsonObject is invalid - " + jsonObject);
			}
		}
	}

	private boolean checkIsValid()
	{
		if (arr == null || targetBlock == null || targetBlockName == null)
		{
			if (arr == null) System.out.print("Parsed array is null.  ");
			else if (arr.length % 4 != 0) System.out.print("Parsed array is invalid size: " + arr.length);
			if (targetBlock == null) System.out.print("Target block is null.  ");
			if (targetBlockName == null) System.out.print("Target block name is null.  ");
			return false;
		}
		return true;
	}

	private void parseObject()
	{
		targetBlockName = jsonObject.get("target").getAsString();
		String[] names = targetBlockName.split(":");
		targetBlock = GameRegistry.findBlock(names[0], names[1]);
		arr = flattenJsonArray(jsonObject.get("points").getAsJsonArray());
	}

	/**
	 * 
	 * @param arr must be two-dimensional json array of ints
	 * @return
	 */
	private int[] flattenJsonArray(JsonArray arr)
	{
		ArrayList<Integer> arraylist = new ArrayList<Integer>();

		for (JsonElement element : arr)
		{
			for (JsonElement arrayElement : element.getAsJsonArray())
			{
				int tmp = arrayElement.getAsInt();
				arraylist.add(tmp);
			}
		}

		Integer[] integerArray = arraylist.toArray(new Integer[]{});
		int[] ret = new int[integerArray.length];
		for (int i = 0; i < integerArray.length; i++)
		{
			ret[i] = integerArray[i].intValue();
		}

		return ret;
	}
}
