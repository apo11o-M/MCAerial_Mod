package rickwang577.mcaerial.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import rickwang577.mcaerial.Main;
import rickwang577.mcaerial.init.BlockInit;
import rickwang577.mcaerial.init.ItemInit;
import rickwang577.mcaerial.util.IHasModel;

public class BlockBase extends Block implements IHasModel
{
	
	public BlockBase(String name, Material material) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ItemInit.MCAERIALMODTAB);
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	
}
