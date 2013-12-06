package stuffstuff.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import stuffstuff.info.ModInfo;
import stuffstuff.inventory.ContainerItemBlockPlacer;
import stuffstuff.items.BlockPlaceMode;
import stuffstuff.items.ItemBlockPlacer;
import stuffstuff.items.Items;
import stuffstuff.items.interfaces.IKeyBound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{

	private static String CHANNEL = ModInfo.CHANNEL;
	private static final byte KEYPRESS_KEY = 0; 
	private static final byte SOUND_KEY = 1;
	private static final byte GUI_KEY = 2;
	
	@Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
    {
		ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);
		EntityPlayer entityPlayer = (EntityPlayer)player;
		byte packetID = reader.readByte();

		switch(packetID)
		{
			case KEYPRESS_KEY:
				String key = reader.readUTF();
				if (entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem().getItem() instanceof IKeyBound) {
					((IKeyBound) entityPlayer.getCurrentEquippedItem().getItem()).doKeyBindingAction(entityPlayer, entityPlayer.getCurrentEquippedItem(), key);
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
					byte index = reader.readByte();
					byte value = reader.readByte();
					if (index >= 0)
					{
						Items.itemBlockPlacer.setBlockPlaceMode(cont.getItemStack(), BlockPlaceMode.fromInt(index));
					}
					else
					{
						Items.itemBlockPlacer.setCharge(cont.getItemStack(), value);
					}
				}
				break;
		}
    }

	public static void sendKeyPacket(String key)
	{
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);
		
		try
		{
			dataStream.writeByte(KEYPRESS_KEY);
			dataStream.writeUTF(key);
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(ModInfo.CHANNEL, byteStream.toByteArray()));
		}
		catch (IOException e)
		{
			System.err.append("Failed to send keypress packet");
		}
	}
	
	public static void sendSoundPacket(String sound)
	{

		// TODO do stuff

//        data.writeUTF(playerName);
//        data.writeUTF(soundName);
//        data.writeDouble(x);
//        data.writeDouble(y);
//        data.writeDouble(z);
//        data.writeFloat(volume);
//        data.writeFloat(pitch);
	}
	
	/**
	 * Gui packets: anything from buttons to clicking on sliders to move them
	 * @param index
	 * @param val
	 */
	public static void sendGuiPacket(byte index, byte val)
    {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);
		
		try
		{
			dataStream.writeByte(GUI_KEY);
			dataStream.writeByte(index);
			dataStream.writeByte(val);
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(ModInfo.CHANNEL, byteStream.toByteArray()));
		}
		catch (IOException e)
		{
			System.err.append("Failed to send gui packet");
		}
	    
    }

}
