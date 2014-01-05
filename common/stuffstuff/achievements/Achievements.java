package stuffstuff.achievements;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import stuffstuff.blocks.Blocks;
import stuffstuff.info.AchievementInfo;
import stuffstuff.worldgen.biome.BiomeGenPlaidPlain;

public class Achievements
{
	public static Achievement plaidBiome; 
	public static Achievement plaidBiome2;

	private static Achievement[] achievements;
	private static AchievementPage page;

	public static void init()
	{
		plaidBiome = new Achievement(AchievementInfo.PLAID_BIOME_ID, AchievementInfo.PLAID_BIOME_NAME, 0, 0, Blocks.blockPlaidLog, null).registerAchievement();
		plaidBiome2 = new Achievement(AchievementInfo.PLAID_BIOME2_ID, AchievementInfo.PLAID_BIOME2_NAME, 0, 1, Blocks.blockPlaidGrass, plaidBiome).registerAchievement();

		achievements = new Achievement[] {plaidBiome, plaidBiome2};
		page = new AchievementPage("Stuff Stuff", achievements);

		AchievementPage.registerAchievementPage(page);
	}

	@ForgeSubscribe
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
