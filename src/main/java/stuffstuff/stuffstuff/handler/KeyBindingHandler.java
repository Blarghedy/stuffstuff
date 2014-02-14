package stuffstuff.stuffstuff.handler;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import stuffstuff.stuffstuff.handler.helper.KeyBindingHelper;
import stuffstuff.stuffstuff.items.interfaces.IKeyBound;
import stuffstuff.stuffstuff.network.StuffPacketHandler;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyBindingHandler
{
	KeyBinding[] bindings;

	public KeyBindingHandler()
	{
		bindings = KeyBindingHelper.gatherKeyBindings();
		boolean[] isRepeating = KeyBindingHelper.gatherIsRepeating(); // TODO do I need this?

		for (KeyBinding binding : bindings)
		{
			ClientRegistry.registerKeyBinding(binding);
		}
	}

	public void keyDown(KeyInputEvent e)
	{
		// TODO check to see if we can make this only operate on tick ends.  Probably not.
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
						for (KeyBinding key : bindings)
						{
							if (key.isPressed())
							{
								StuffPacketHandler.sendKeyPacket(key.getKeyDescription());
							}
						}
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
