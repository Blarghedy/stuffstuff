package stuffstuff.client.sounds;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import stuffstuff.info.ModInfo;

public enum Sounds
{
	UNKNOWN("no"), CHARGE_DOWN("kow"), CHARGE_UP("kowslow"), SHOCK("zzh");

	public static final String SOUNDS_LOCATION = ModInfo.ID + ":";
	private static ArrayList<Sounds> list = new ArrayList<Sounds>();
	private static int counter = 0;

	private String name;
	private int index;

	Sounds(String name)
	{
		this.name = name;
		this.setIndex();
		this.addToList();
	}

	public String getName()
	{
		return name;
	}

	public static void play(int index, double x, double y, double z, float volume, float pitch)
	{
		Sounds s = get(index);
		if (s != null)
		{
			s.play(x, y, z, volume, pitch);
		}
	}

	public void play(double x, double y, double z, float volume, float pitch)
	{
		Minecraft.getMinecraft().sndManager.playSound(SOUNDS_LOCATION + name, (float)x, (float)y, (float)z, volume, pitch);
	}

	@Override
	public String toString()
	{
		return "stuffstuff " + this.getClass().getSimpleName() + " " + this.getName();
	}

	public static Sounds get(int index)
	{
		return index < counter && index >= 0 ? list.get(index) : null;
	}

	private void addToList()
	{
		if (list == null)
		{
			list = new ArrayList<Sounds>();
		}
		list.add(this);
	}

	private void setIndex()
	{
		index = counter++;
	}

	/**
	 * Quite frankly I would prefer to use the ordinal but
	 * 
	 * @return
	 */
	public int index()
	{
		return index;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
