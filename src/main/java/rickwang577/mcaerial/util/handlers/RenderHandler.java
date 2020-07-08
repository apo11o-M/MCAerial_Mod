package rickwang577.mcaerial.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import rickwang577.mcaerial.entity.EntityGoKart;
import rickwang577.mcaerial.entity.model.ModelGoKart;
import rickwang577.mcaerial.entity.render.RenderVehicle;

public class RenderHandler {
	
	public static void registerEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGoKart.class, new IRenderFactory<EntityGoKart>() {
			@Override
			public Render<? super EntityGoKart> createRenderFor(RenderManager manager) {
				return new RenderVehicle(manager, new ModelGoKart(), 0.5F);
			}
		
		});
		
			
		
	}
	

}
