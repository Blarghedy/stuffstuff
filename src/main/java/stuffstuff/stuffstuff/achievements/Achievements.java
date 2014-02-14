package stuffstuff.stuffstuff.achievements;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.event.entity.EntityEvent;
import stuffstuff.stuffstuff.blocks.BlocksStuff;
import stuffstuff.stuffstuff.info.AchievementInfo;
import stuffstuff.stuffstuff.worldgen.biome.BiomeGenPlaidPlain;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Achievements
{
	public static Achievement plaidBiome; 
	public static Achievement plaidBiome2;

	private static Achievement[] achievements;
	private static AchievementPage page;

	public static void init()
	{
		plaidBiome = new Achievement(AchievementInfo.PLAID_BIOME_ID, AchievementInfo.PLAID_BIOME_NAME, 0, 0, BlocksStuff.blockPlaidLog, null).registerStat();
		plaidBiome2 = new Achievement(AchievementInfo.PLAID_BIOME2_ID, AchievementInfo.PLAID_BIOME2_NAME, 0, 1, BlocksStuff.blockPlaidGrass, plaidBiome).registerStat();

		achievements = new Achievement[] {plaidBiome, plaidBiome2};
		page = new AchievementPage("Stuff Stuff", achievements);

		AchievementPage.registerAchievementPage(page);
	}

	@SubscribeEvent
	public void chunkEntered(EntityEvent.EnteringChunk event)
	{
		if (event.entity != null && event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			World world = player.worldObj;
			BiomeGenBase biome = world.getBiomeGenForCoords((int)player.posX, (int)player.posZ);
			if (biome instanceof BiomeGenPlaidPlain)
			{
				player.addStat(plaidBiome, 1);
			}
		}
	}
}
