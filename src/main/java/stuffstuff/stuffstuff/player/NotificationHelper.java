package stuffstuff.stuffstuff.player;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.network.Player;

public class NotificationHelper
{
	// TODO add color coding and something like a "StuffStuff: " prefix
	public static void notifySelf(String message)
	{
		Minecraft.getMinecraft().thePlayer.addChatMessage(message);
	}

	// TODO this whole module I guess
	public static void notifyPlayer(String message, Player player)
	{

	}

	public static void notifyPlayer(String message, String player)
	{

	}

	public static void notifyPlayersNearLocation(String message, int dimID, double x, double y, double z)
	{

	}

	public static void notifyPlayersInRangeOfLocation(String message, int dimID, double x, double y, double z, int range)
	{

	}

	public static void notifyPlayersInDimension(String message, int dimID)
	{

	}
}
