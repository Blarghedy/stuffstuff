package stuffstuff.stuffstuff.potions;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import stuffstuff.stuffstuff.info.PotionInfo;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Potions
{
	public static Potion potionPlaid;
	public static ResourceLocation textures;
	public static ResourceLocation[] potionCubes;

	public static void init()
	{
		modifyAccess();
		textures = new ResourceLocation(PotionInfo.ICON_TEXTURE_LOCATION);
		potionCubes = new ResourceLocation[PotionInfo.PLAID_CUBE_TEXTURES.length];

		for (int i = 0; i < PotionInfo.PLAID_CUBE_TEXTURES.length; i++)
		{
			potionCubes[i] = new ResourceLocation(PotionInfo.PLAID_CUBE_TEXTURES[i]);
		}

		potionPlaid = new PotionPlaid(PotionInfo.PLAID_ID);
	}

	public static void addNames()
	{
//		LanguageRegistry.addName(potionPlaid, PotionInfo.PLAID_NAME);
	}

	private static void modifyAccess()
	{
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields())
		{
			f.setAccessible(true);
			try
			{
				if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a"))
				{
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

					potionTypes = (Potion[])f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
				}
			}
			catch (Exception e)
			{
				System.err.println("[Stuff Stuff] Severe error.  Please report this to the mod author:");
				System.err.println(e);
			}
		}
	}

}
