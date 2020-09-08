package rickwang577.mcaerial.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ShieldBlock extends BlockBase {
	
	public ShieldBlock(String name, Material material) {
		super(name, material);
		setHarvestLevel("pickaxe", 3);
		setResistance(2000F);
		setHardness(50);
		
	}

	
}
