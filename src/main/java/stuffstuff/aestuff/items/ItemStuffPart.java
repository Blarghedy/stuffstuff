package stuffstuff.aestuff.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stuffstuff.aestuff.AEStuff;
import stuffstuff.aestuff.parts.PartStuff;
import appeng.api.AEApi;
import appeng.api.parts.IPart;
import appeng.api.parts.IPartItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStuffPart extends Item implements IPartItem
{
	private static ArrayList<Class<? extends PartStuff>> parts;

	public static void registerPart(Class<? extends PartStuff> part)
	{
		parts.add(part);
	}

	public static int getID(Class<? extends PartStuff> part)
	{
		return parts.indexOf(part);
	}

	public ItemStuffPart(int id)
	{
		super(id);
		setCreativeTab(AEStuff.tabAEStuff);
		AEApi.instance().partHelper().setItemBusRenderer(this);
	}

	@Override
	public void getSubItems(int id, CreativeTabs tab, List list)
	{
		super.getSubItems(id, tab, list);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int dmg = itemstack.getItemDamage();
		dmg = dmg < 0 || dmg >= parts.size() ? 0 : dmg;

		return "stuffpart." + parts.get(dmg).getSimpleName();
	}

	/**
	 * {@link IPartItem} implementation
	 */

	@Override
	public IPart createPartFromItemStack(ItemStack itemstack)
	{
		int dmg = itemstack.getItemDamage();
		dmg = dmg < 0 || dmg >= parts.size() ? 0 : dmg;

		try
		{
			return parts.get(dmg).newInstance();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null; // TODO probably should return something else here

	}

	/**
	 * {@link IPartItem} required functionality - see interface documentation
	 */

	@Override
	@SideOnly(Side.CLIENT)
	public int getSpriteNumber()
	{
		return 0;
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		return AEApi.instance().partHelper().placeBus(is, x, y, z, side, player, world);
	}

}
