package rickwang577.mcaerial.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import rickwang577.mcaerial.entity.EntityCentaur;
import rickwang577.mcaerial.entity.render.RenderCentaur;

public class RenderHandler {
	
	public static void registerEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCentaur.class, new IRenderFactory<EntityCentaur>() {
			
			@Override
			public Render<? super EntityCentaur> createRenderFor(RenderManager manager) {
				return new RenderCentaur(manager);
			}
		});
		
	}
	

}
