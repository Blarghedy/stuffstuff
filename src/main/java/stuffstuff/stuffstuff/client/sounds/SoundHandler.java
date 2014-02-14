package stuffstuff.stuffstuff.client.sounds;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SoundHandler
{

	@SubscribeEvent
	public void onSoundLoad(SoundLoadEvent event)
	{

		// For each custom sound file we have defined in Sounds
		for (Sounds sound : Sounds.values())
		{
			// Try to add the custom sound file to the pool of sounds
			try
			{
				addSound(event, sound);
			}
			// If we cannot add the custom sound file to the pool, log the exception
			catch (Exception e)
			{
				// LogHelper.warning("Failed loading sound file: " + soundFile);
				System.err.append("Failed loading sound file: " + sound);
			}
		}
	}

	private void addSound(SoundLoadEvent e, Sounds s)
	{
		// TODO add sounds back
//		e.manager.soundPoolSounds.addSound(Sounds.SOUNDS_LOCATION + s.getName() + ".ogg");
	}
}
