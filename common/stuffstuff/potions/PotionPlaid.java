package stuffstuff.potions;

import stuffstuff.info.PotionInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

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
		// TODO not sure what this is really
		return par1 >= 1; 
	}
	
	@Override
	public int getStatusIconIndex()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(PotionInfo.TEXTURE_LOCATION));
		return super.getStatusIconIndex();
	}

}
