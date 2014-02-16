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
import stuffstuff.stuffstuff.worldgen.Biomes;

public class ItemBiomeTeleporter extends Item
{
	public static ArrayList<BiomeGenBase> biomesToFind = new ArrayList<BiomeGenBase>();
	
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
			biomesToFind.add(Biomes.plaidPlainsBiome);
			ChunkPosition chunk = ((WorldServer)world).provider.worldChunkMgr.findBiomePosition(player.chunkCoordX, player.chunkCoordZ, 2048, biomesToFind, world.rand);
			NotificationHelper.notifySelf("Looking for " + biomesToFind);
			NotificationHelper.notifySelf("Found " + chunk);
			
			if (chunk == null) return itemstack;
			player.posX = chunk.chunkPosX;
			player.posY = 100;
			player.posZ = chunk.chunkPosZ;
		}
		return itemstack;
	}
}
