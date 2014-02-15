package stuffstuff.stuffstuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import stuffstuff.stuffstuff.StuffStuff;

public abstract class BlockStuffGrass extends Block
{
	public BlockStuffGrass()
	{
		super(Material.grass);
		setCreativeTab(StuffStuff.tabStuffStuff);
		setStepSound(soundTypeGrass);
		setHardness(.7F);
		setTickRandomly(true);
	}
}
