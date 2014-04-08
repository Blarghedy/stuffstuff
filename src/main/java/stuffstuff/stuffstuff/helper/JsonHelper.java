package stuffstuff.stuffstuff.helper;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// TODO:  make this code not awful

public class JsonHelper
{
	public static StringBuilder prettyPrint(JsonElement element)
	{
		StringBuilder ret = new StringBuilder();
		prettyPrintElement(element, 0, ret);
		ret.append('\n');
		return ret;
	}

	private static void prettyPrintElement(JsonElement element, int indentationLevel, StringBuilder sb)
	{
		if (element.isJsonPrimitive())
		{
			sb.append(element.getAsJsonPrimitive());
		}
		else if (element.isJsonArray())
		{
			prettyPrintArray(element.getAsJsonArray(), indentationLevel, sb);
		}
		else if (element.isJsonObject())
		{
			prettyPrintObject(element.getAsJsonObject(), indentationLevel, sb);
		}
		else if (element.isJsonNull())
		{
			sb.append(element.getAsJsonNull().toString());
		}
	}

	private static void prettyPrintObject(JsonObject obj, int indentationLevel, StringBuilder sb)
	{
		boolean printComma = false;
		String indent = "";
		String indent2;

		for (int i = 0; i < indentationLevel; i++)
		{
			indent += "\t";
		}
		indent2 = indent + "\t";

		sb.append(indent + "{");

		for (Map.Entry<String, JsonElement> entry : obj.entrySet())
		{
			String key = entry.getKey();
			JsonElement value = entry.getValue();

			sb.append((printComma ? "," : "") + "\n" + indent2 + key + ": ");
			printComma = true;

			prettyPrintElement(value, indentationLevel + 2, sb);
		}
		sb.append("\n" + indent + "}");
	}

	private static void prettyPrintArray(JsonArray array, int indentationLevel, StringBuilder sb)
	{
		if (array.size() == 0)
		{
			sb.append("[ ]");
		}
		else if (arrayIsAllPrimitives(array))
		{
			sb.append("[ ");
			sb.append(array.get(0).getAsJsonPrimitive());

			for (int i = 1; i < array.size(); i++)
			{
				sb.append(", " + array.get(i).getAsJsonPrimitive());
			}

			sb.append(" ]");
		}
		else
		{
			sb.append("\n");
			String indent = "";
			for (int i = 0; i < indentationLevel; i++)
			{
				indent += "\t";
			}
			String newline = "\n\t" + indent;

			boolean printComma = false;
			sb.append(indent + "[\n");

			for (JsonElement element : array)
			{
				if (printComma) 
				{
					sb.append(",");
					sb.append(newline);
				}
				else
				{
					sb.append(indent + "\t");
				}
				printComma = true;
				prettyPrintElement(element, indentationLevel + 1, sb);
			}
			sb.append("\n" + indent + "]");
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
