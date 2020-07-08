package rickwang577.mcaerial.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import rickwang577.mcaerial.Main;
import rickwang577.mcaerial.entity.EntityGoKart;
import rickwang577.mcaerial.entity.EntityPlane;
import rickwang577.mcaerial.util.Reference;

public class EntityInit {
	
	public static void registerEntities() {
		registerEntity("go_kart", EntityGoKart.class, Reference.ENTITY_GO_KART, 50);
		registerEntity("plane", EntityPlane.class, Reference.ENTITY_PLANE, 50);
	}
	
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true);
	}
	
	private static void registerEntityEgg(String name, Class<? extends Entity> entity, int id, int range, int i, int j) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, i, j);
		
	}


}
