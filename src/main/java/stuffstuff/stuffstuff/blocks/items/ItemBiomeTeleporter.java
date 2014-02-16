package stuffstuff.stuffstuff.blocks.items;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.player.NotificationHelper;

public class ItemBiomeTeleporter extends Item
{
	private static ArrayList<BiomeGenBase> biomesToFind = new ArrayList<BiomeGenBase>();

	public static void addBiome(BiomeGenBase biome)
	{
		if (!biomesToFind.contains(biome)) biomesToFind.add(biome);
	}

	public static void removeBiome(BiomeGenBase biome)
	{
		if (biomesToFind.contains(biome)) biomesToFind.remove(biome);
	}

	public ItemBiomeTeleporter()
	{
		setUnlocalizedName("biomeTeleporter");
		setCreativeTab(StuffStuff.tabStuffStuff);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			ChunkPosition chunk = ((WorldServer)world).provider.worldChunkMgr.findBiomePosition(player.chunkCoordX, player.chunkCoordZ, 2048, biomesToFind, world.rand);
			NotificationHelper.notifySelf("Looking for " + biomesToFind);
			NotificationHelper.notifySelf("Found " + chunk.chunkPosX + " " + chunk.chunkPosZ);

			if (chunk == null) return itemstack;
			player.setPositionAndUpdate(chunk.chunkPosX, 100, chunk.chunkPosZ);
		}
		return itemstack;
	}
}
