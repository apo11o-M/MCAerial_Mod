package rickwang577.mcaerial.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import rickwang577.mcaerial.entity.EntityCentaur;
import rickwang577.mcaerial.entity.EntityVehicle;
import rickwang577.mcaerial.entity.model.ModelVehicle;
import rickwang577.mcaerial.util.Reference;

public class RenderVehicle<T extends EntityVehicle> extends Render {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entities/vehicle.png");
	private ModelBase mainModel;
	
	public RenderVehicle(RenderManager manager, ModelBase modelBaseIn, float shadowSizeIn) {
		super(manager);
		this.mainModel = modelBaseIn;
		this.shadowSize = shadowSizeIn;
	}
	
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
		
	}
	
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return TEXTURES;
	}
	
}
