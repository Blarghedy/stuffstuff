package stuffstuff.holidaystuff.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler
{
	public static void init(File file)
	{
		Configuration config = null;
		try
		{
			config = new Configuration(file);
			config.load();

			
		}
		finally
		{
			if (config != null)
			{
				config.save();
			}
		}
	}

}
