package rickwang577.mcaerial.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import rickwang577.mcaerial.entity.EntityCart;
import rickwang577.mcaerial.entity.EntityCentaur;
import rickwang577.mcaerial.entity.EntityVehicle;
import rickwang577.mcaerial.entity.model.ModelVehicle;
import rickwang577.mcaerial.entity.render.RenderCart;
import rickwang577.mcaerial.entity.render.RenderCentaur;
import rickwang577.mcaerial.entity.render.RenderVehicle;

public class RenderHandler {
	
	public static void registerEntityRenders() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityVehicle.class, new IRenderFactory<EntityVehicle>() {
			@Override
			public Render<? super EntityVehicle> createRenderFor(RenderManager manager) {
				return new RenderVehicle(manager, new ModelVehicle(), 0.5F);
			}
		
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCentaur.class, new IRenderFactory<EntityCentaur>() {
			@Override
			public Render<? super EntityCentaur> createRenderFor(RenderManager manager) {
				return new RenderCentaur(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCart.class, new IRenderFactory<EntityCart>() {
			@Override
			public Render<? super EntityCart> createRenderFor(RenderManager manager) {
				return new RenderCart(manager);
			}
			
		});
			
		
	}
	

}
