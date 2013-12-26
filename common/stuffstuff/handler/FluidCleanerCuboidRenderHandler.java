package stuffstuff.handler;

import java.util.EnumSet;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeDirection;
import stuffstuff.handler.helper.QuadHelper;
import stuffstuff.info.ItemInfo;
import stuffstuff.info.ModInfo;
import stuffstuff.items.FluidCleanerBase;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class FluidCleanerCuboidRenderHandler implements ITickHandler
{
	// Thanks Pahimar!

	@Override
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {
	    
    }

	@Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
		
	    Minecraft minecraft = FMLClientHandler.instance().getClient();
	    EntityPlayer player = minecraft.thePlayer;
	    ItemStack itemStack = null;
	    if (type.contains(TickType.RENDER))
	    {
	    	if (player != null)
	    	{
	    		itemStack = player.inventory.getCurrentItem();
	    		if (Minecraft.isGuiEnabled() && minecraft.inGameHasFocus){
	    			if (itemStack != null && itemStack.getItem() instanceof FluidCleanerBase)
	    			{
	    				FluidCleanerBase cleaner = (FluidCleanerBase)(itemStack.getItem());
	    				int charge = cleaner.getCharge(itemStack);
	    				float partialTicks = (float)tickData[0];
	    				renderCleanerCuboid(minecraft, player, itemStack, partialTicks, charge); // TODO look into partialTicks
	    			}
	    		}
	    	}
	    }
    }
	
	private static void renderCleanerCuboid(Minecraft minecraft, EntityPlayer player, ItemStack stack, float partialTicks, int charge)
	{
        double x = Math.floor(player.posX) + 0.5F;
        double y = Math.floor(player.posY) + 0.5F;
        double z = Math.floor(player.posZ) + 0.5F;
        double iPX = player.prevPosX + (player.posX - player.prevPosX) * partialTicks;
        double iPY = player.prevPosY + (player.posY - player.prevPosY) * partialTicks;
        double iPZ = player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks;

        float xScale = 100;
        float yScale = 100;
        float zScale = 100;
        float xShift = 0.01F;
        float yShift = 0.01F;
        float zShift = 0.01F;
        
        charge = 11;
        
        
        GL11.glDepthMask(false);
        GL11.glDisable(GL11.GL_CULL_FACE);

        for (int i = 0; i < 6; i++) {
            ForgeDirection forgeDir = ForgeDirection.getOrientation(i);
            int zCorrection = i == 2 ? -1 : 1;
            GL11.glPushMatrix();
            GL11.glTranslated(-iPX + x + xShift, -iPY + y + yShift, -iPZ + z + zShift);
            GL11.glScalef(1F * xScale, 1F * yScale, 1F * zScale);
            GL11.glRotatef(90, forgeDir.offsetX, forgeDir.offsetY, forgeDir.offsetZ);
            GL11.glTranslated(0, 0, 0.5f * zCorrection);
            GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
            ResourceLocation rloc = new ResourceLocation(ItemInfo.TEXTURE_LOCATION, "textures/effects/placer_overlay.png");
            QuadHelper.renderQuad(rloc, 1, false);
            GL11.glPopMatrix();
        }

        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDepthMask(true);
	}

	@Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.CLIENT, TickType.RENDER);
    }

	@Override
    public String getLabel()
    {
	    return ModInfo.NAME + ": " + this.getClass().getSimpleName();
    }
    
}
