package rickwang577.mcaerial.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import rickwang577.mcaerial.items.ItemBase;
import rickwang577.mcaerial.items.ItemGoKart;
import rickwang577.mcaerial.items.ItemPlane;
import rickwang577.mcaerial.items.tools.ToolSword;

public class ItemInit {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final CreativeTabs MCAERIALMODTAB = new CreativeTabs("mcaerial_mod_tab"){
		
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(RUBY);
		}
		
	};
	
	
	// Materials
	public static final ToolMaterial MATERIAL_OBSIDIAN_ORB = EnumHelper.addToolMaterial("material_obsidian_orb", 3, 2500, 10.0F, 4.0F, 14);
	
	// Items
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item OBSIDIAN_ORB = new ItemBase("obsidian_orb");
	public static final Item MEVE = new ItemPlane("meve");
	public static final Item GO_KART = new ItemGoKart("go_kart");
	
	// Tools
	public static final ItemSword OBSIDIAN_SWORD = new ToolSword("obsidian_sword", MATERIAL_OBSIDIAN_ORB);
	 
	
}
