package rickwang577.mcaerial.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import rickwang577.mcaerial.blocks.BlockBase;
import rickwang577.mcaerial.blocks.FireflyJarBlock;
import rickwang577.mcaerial.blocks.RubyBlock;
import rickwang577.mcaerial.blocks.ShieldBlock;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	// normal blocks
	public static final Block RUBY_BLOCK = new RubyBlock("ruby_block", Material.IRON);
	public static final Block SHIELD_BLOCK = new ShieldBlock("shield_block", Material.IRON);
	public static final Block FIREFLY_JAR_BLOCK = new FireflyJarBlock("firefly_jar_block", Material.GLASS);
	
	// tile entities
	//public static final Block  
		

}
