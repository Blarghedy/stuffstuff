package stuffstuff.stuffstuff.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import stuffstuff.stuffstuff.StuffStuff;
import stuffstuff.stuffstuff.info.BlockInfo;

public class BlockPlaidGrass extends BlockStuffGrass
{
	private IIcon[] sideIcons;
	private IIcon[] topIcons;
	private IIcon sideSnowIcon;

	public BlockPlaidGrass()
	{
		setCreativeTab(StuffStuff.tabPlaidStuff);
		dirtBlock = BlocksStuff.blockPlaidDirt;
	}

	@Override
	public String getUnlocalizedName()
	{
		return BlockInfo.PLAID_GRASS_UNLOCALIZED_NAME;
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		sideIcons = new IIcon[BlockInfo.PLAID_GRASS_SIDE_TEXTURES.length];
		topIcons = new IIcon[BlockInfo.PLAID_GRASS_TOP_TEXTURES.length];

		sideSnowIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_GRASS_SIDE_SNOW_TEXTURE);

		for (int i = 0; i < sideIcons.length; i++)
		{
			sideIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_GRASS_SIDE_TEXTURES[i]);
		}

		for (int i = 0; i < topIcons.length; i++)
		{
			topIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.PLAID_GRASS_TOP_TEXTURES[i]);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		ForgeDirection face = ForgeDirection.getOrientation(side);
		if (face == ForgeDirection.UP)
			return topIcons[0];
		else
			return sideIcons[0];
	}

	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		ForgeDirection face = ForgeDirection.getOrientation(side);
		PlaidColor color = PlaidColor.getPlaidColorFromPos(x, y, z);

		switch (face)
		{
			case UP:
				return topIcons[color.ordinal()];
			case DOWN: // just need vanilla dirt texture
				return Blocks.grass.getIcon(blockAccess, x, y, z, side);
			default: // all 4 sides
				Material mat = blockAccess.getBlock(x, y + 1, z).getMaterial();
				if (mat == Material.snow || mat == Material.craftedSnow)
					return sideSnowIcon;
				else
					return sideIcons[color.ordinal()];
		}
	}
}
