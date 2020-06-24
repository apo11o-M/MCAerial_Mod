package rickwang577.mcaerial.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import rickwang577.mcaerial.Main;
import rickwang577.mcaerial.entity.EntityCentaur;
import rickwang577.mcaerial.util.Reference;

public class EntityInit {
	
	public static void registerEntities() {
		registerEntity("centaur", EntityCentaur.class, Reference.ENTITY_CENTAUR, 50, 16777215, 16777215);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
		
	}

}
