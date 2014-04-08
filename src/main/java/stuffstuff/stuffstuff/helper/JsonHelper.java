package stuffstuff.stuffstuff.helper;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// TODO:  make this code not awful

public class JsonHelper
{
	public static void prettyPrint(JsonElement element)
	{
		prettyPrintElement(element, 0);
		System.out.print("\n");
	}

	public static void prettyPrintElement(JsonElement element, int indentationLevel)
	{
		if (element.isJsonPrimitive())
		{
			System.out.print(element.getAsJsonPrimitive());
		}
		else if (element.isJsonArray())
		{
			prettyPrintArray(element.getAsJsonArray(), indentationLevel);
		}
		else if (element.isJsonObject())
		{
			prettyPrintObject(element.getAsJsonObject(), indentationLevel);
		}
		else if (element.isJsonNull())
		{
			System.out.print(element.getAsJsonNull());
		}
	}

	public static void prettyPrintObject(JsonObject obj, int indentationLevel)
	{
		boolean printComma = false;
		String indent = "";
		for (int i = 0; i < indentationLevel; i++)
		{
			indent += "\t";
		}

		System.out.print(indent + "{");

		for (Map.Entry<String, JsonElement> entry : obj.entrySet())
		{
			String key = entry.getKey();
			JsonElement value = entry.getValue();

			System.out.print((printComma ? "," : "") + "\n" + indent + key + ": ");
			printComma = true;

			prettyPrintElement(value, indentationLevel + 1);
		}
		System.out.print("\n" + indent + "}");
	}

	public static void prettyPrintArray(JsonArray array, int indentationLevel)
	{
		if (array.size() == 0)
		{
			System.out.print("[ ]");
		}
		else if (arrayIsAllPrimitives(array))
		{
			System.out.print("[ ");
			System.out.print(array.get(0).getAsJsonPrimitive());

			for (int i = 1; i < array.size(); i++)
			{
				System.out.print(", " + array.get(i).getAsJsonPrimitive());
			}

			System.out.print(" ]");
		}
		else
		{
			System.out.print("\n");
			String indent = "";
			for (int i = 0; i < indentationLevel; i++)
			{
				indent += "\t";
			}
			String newline = "\n\t" + indent;

			boolean printComma = false;
			System.out.println(indent + "[");

			for (JsonElement element : array)
			{
				if (printComma) 
				{
					System.out.print(",");
					System.out.print(newline);
				}
				else
				{
					System.out.print(indent + "\t");
				}
				printComma = true;
				prettyPrintElement(element, indentationLevel + 1);
			}
			System.out.print("\n" + indent + "]");
		}
	}

	public static boolean arrayIsAllPrimitives(JsonArray arr)
	{
		for (JsonElement element : arr)
		{
			if (!element.isJsonPrimitive())
			{
				return false;
			}
		}
		return true;
	}
}
