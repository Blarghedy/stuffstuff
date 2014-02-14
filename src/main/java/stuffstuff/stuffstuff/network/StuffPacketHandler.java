package stuffstuff.stuffstuff.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.NetHandlerPlayServer;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.ModInfo;
import stuffstuff.stuffstuff.inventory.ContainerItemBlockPlacer;
import stuffstuff.stuffstuff.items.BlockPlaceMode;
import stuffstuff.stuffstuff.items.ItemsStuff;
import stuffstuff.stuffstuff.items.interfaces.IKeyBound;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;

public class StuffPacketHandler
{
	private static String CHANNEL = ModInfo.CHANNEL;
	private static final byte KEYPRESS_KEY = 0;
	private static final byte SOUND_KEY = 1;
	private static final byte GUI_KEY = 2;

	@SubscribeEvent
	public void onServerPacket(ServerCustomPacketEvent e)
	{
		FMLProxyPacket packet = e.packet;
		NetHandlerPlayServer srv = (NetHandlerPlayServer)packet.handler();
		EntityPlayer entityPlayer = srv.playerEntity;

		ByteBuf payload = packet.payload();

		byte packetID = payload.readByte();

		switch (packetID)
		{
			case KEYPRESS_KEY:
				String key = ByteBufUtils.readUTF8String(payload);

				if (entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem().getItem() instanceof IKeyBound)
				{
					((IKeyBound)entityPlayer.getCurrentEquippedItem().getItem()).doKeyBindingAction(entityPlayer, entityPlayer.getCurrentEquippedItem(), key);
				}
				break;
			case SOUND_KEY:
				// TODO do stuff, probably involving the notification helper
				break;
			case GUI_KEY:
				Container container = entityPlayer.openContainer;
				if (container instanceof ContainerItemBlockPlacer)
				{
					ContainerItemBlockPlacer cont = (ContainerItemBlockPlacer)container;
					byte index = payload.readByte();
					byte value = payload.readByte();
					if (index >= 0)
					{
						ItemsStuff.itemBlockPlacer.setBlockPlaceMode(cont.getItemStack(), BlockPlaceMode.fromInt(index));
					}
					else
					{
						ItemsStuff.itemBlockPlacer.setCharge(cont.getItemStack(), value);
					}
				}
				break;
		}
	}

	@SubscribeEvent
	public void onClientPacket(ClientCustomPacketEvent e)
	{

	}

	public static void sendKeyPacket(String key)
	{
		ByteBuf payload = Unpooled.buffer();
		payload.writeByte(KEYPRESS_KEY);
		ByteBufUtils.writeUTF8String(payload, key);
		processAndSend(payload, Side.SERVER);
	}

	/**
	 * Gui packets: anything from buttons to clicking on sliders to move them
	 * 
	 * @param index
	 * @param val
	 */
	public static void sendGuiPacket(byte index, byte val)
	{
		ByteBuf payload = Unpooled.buffer();
		payload.writeByte(GUI_KEY);
		payload.writeByte(index);
		payload.writeByte(val);
		processAndSend(payload, Side.SERVER);
	}

	public static void processAndSend(ByteBuf payload, Side side, FMLEventChannel chan, String channel)
	{
		FMLProxyPacket packet = new FMLProxyPacket(payload, CHANNEL);
		packet.setTarget(Side.SERVER);
		StuffStuff.channel.sendToServer(packet);
	}

	public static void processAndSend(ByteBuf payload, Side side)
	{
		processAndSend(payload, side, StuffStuff.channel, CHANNEL);
	}
}
