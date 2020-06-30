package rickwang577.mcaerial.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import rickwang577.mcaerial.Main;
import rickwang577.mcaerial.entity.EntityCart;
import rickwang577.mcaerial.entity.EntityCentaur;
import rickwang577.mcaerial.entity.EntityVehicle;
import rickwang577.mcaerial.util.Reference;

public class EntityInit {
	
	public static void registerEntities() {
		registerEntity("centaur", EntityCentaur.class, Reference.ENTITY_CENTAUR, 50, 16777215, 16777215);
		registerEntity2("cart", EntityCart.class, Reference.ENTITY_CART, 10);
		registerEntity2("vehicle", EntityVehicle.class, Reference.ENTITY_VEHICLE, 50);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int i, int j) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, i, j);
		
	}
	
	private static void registerEntity2(String name, Class<? extends Entity> entity, int id, int range) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true);
	}
	

}
