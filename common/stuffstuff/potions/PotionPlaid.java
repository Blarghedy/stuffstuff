package stuffstuff.potions;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import stuffstuff.info.PotionInfo;

public class PotionPlaid extends Potion
{

	public PotionPlaid(int id)
	{
		super(id, true, 055555);
		setIconIndex(0, 0);
		setPotionName(PotionInfo.PLAID_POTION_NAME);
	}

	@Override
	public boolean isReady(int par1, int par2)
	{
		// not sure what this is really
		return par1 >= 1;
	}

	@Override
	public int getStatusIconIndex()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(PotionInfo.ICON_TEXTURE_LOCATION));
		return super.getStatusIconIndex();
	}

}
