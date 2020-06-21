package rickwang577.mcaerial.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import rickwang577.mcaerial.Main;
import rickwang577.mcaerial.init.ModItems;
import rickwang577.mcaerial.util.IHasModel;

public class ItemBase extends Item implements IHasModel{

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModItems.TUTORIALMODTAB);
		
		ModItems.ITEMS.add(this);
		
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

	
}