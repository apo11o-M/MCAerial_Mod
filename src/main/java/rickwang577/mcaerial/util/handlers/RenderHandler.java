package rickwang577.mcaerial.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import rickwang577.mcaerial.entity.EntityGoKart;
import rickwang577.mcaerial.entity.EntityPlane;
import rickwang577.mcaerial.entity.GeneralEntity;
import rickwang577.mcaerial.entity.model.ModelGoKart;
import rickwang577.mcaerial.entity.model.ModelPlane;
import rickwang577.mcaerial.entity.render.GeneralRender;
import rickwang577.mcaerial.entity.render.RenderGoKart;
import rickwang577.mcaerial.entity.render.RenderPlane;

public class RenderHandler {
	
	public static void registerEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGoKart.class, new IRenderFactory<GeneralEntity>() {
			@Override
			public Render<? super GeneralEntity> createRenderFor(RenderManager manager) {
				return new RenderGoKart(manager, new ModelGoKart(), 0.5F);
			}
		
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPlane.class, new IRenderFactory<EntityPlane>() {
			@Override
			public Render<? super EntityPlane> createRenderFor(RenderManager manager) {
				return new RenderPlane(manager, new ModelPlane(), 0.5F);
			}
		
		});
		
		
		
	}
	

}
