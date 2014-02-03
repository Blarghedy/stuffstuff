package stuffstuff.stuffstuff.handler;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import stuffstuff.stuffstuff.handler.helper.KeyBindingHelper;
import stuffstuff.stuffstuff.info.ModInfo;
import stuffstuff.stuffstuff.items.interfaces.IKeyBound;
import stuffstuff.stuffstuff.network.PacketHandler;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;

public class KeyBindingHandler extends KeyBindingRegistry.KeyHandler
{
	public KeyBindingHandler()
	{
		super(KeyBindingHelper.gatherKeyBindings(), KeyBindingHelper.gatherIsRepeating());
	}

	@Override
	public String getLabel()
	{
		return ModInfo.NAME + ": " + this.getClass().getSimpleName();
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
	{
		// Only operate at the end of the tick
		if (tickEnd)
		{
			// If we are not in a GUI of any kind, continue execution
			if (FMLClientHandler.instance().getClient().inGameHasFocus)
			{
				EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
				if (player != null)
				{
					ItemStack currentItem = FMLClientHandler.instance().getClient().thePlayer.getCurrentEquippedItem();

					if (currentItem != null)
					{
						if (currentItem.getItem() instanceof IKeyBound)
						{
							// TODO Pahimar had the client sided stuff, but I'm not sure I want to. Look into that.
							// if (!KeyBindingHelper.isClientSided(kb.keyDescription)) {
							// // TODO networking stuff yay... gotta tell the server to increase charge and stuff here
							// // PacketDispatcher.sendPacketToServer(PacketTypeHandler.populatePacket(new PacketKeyPressed(kb.keyDescription)));
							PacketHandler.sendKeyPacket(kb.keyDescription);
							// }
							// else {
							// ((IKeyBound) currentItem.getItem()).doKeyBindingAction(player, currentItem, kb.keyDescription);
							// }
						}
					}
				}
			}
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
	{

	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.CLIENT);
	}
}
