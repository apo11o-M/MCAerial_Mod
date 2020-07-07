package rickwang577.mcaerial.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import rickwang577.mcaerial.Main;
import rickwang577.mcaerial.entity.EntityVehicle;
import rickwang577.mcaerial.util.Reference;

public class EntityInit {
	
	public static void registerEntities() {
		registerEntity("vehicle", EntityVehicle.class, Reference.ENTITY_VEHICLE, 50);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true);
	}
	
	private static void registerEntityEgg(String name, Class<? extends Entity> entity, int id, int range, int i, int j) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, i, j);
		
	}


}
