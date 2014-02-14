package stuffstuff.stuffstuff.recipe;

import java.util.Arrays;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class Smelt
{
	public static void register(ItemStack input, ItemStack output)
	{
		register(input, output, 1);
	}

	public static void register(ItemStack input, ItemStack output, float chance)
	{
		register(input, new ItemStack[] {output}, new float[] {chance});
	}

	public static void register(ItemStack input, ItemStack[] output, float[] outputChance)
	{
		registerVanillaFurnace(input, output[0], .1f);
	}

	public static void register(ItemStack input, ItemStack[] output)
	{
		float[] chances = new float[output.length];
		Arrays.fill(chances, 1);
		register(input, output, chances);
	}

	public static void registerVanillaFurnace(ItemStack input, ItemStack output, float xp)
	{
		// func_151396_a -> addSmelting
		FurnaceRecipes.smelting().func_151396_a(input.getItem(), output, xp);
	}
}
