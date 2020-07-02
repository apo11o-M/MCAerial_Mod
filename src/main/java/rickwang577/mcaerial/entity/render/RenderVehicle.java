package rickwang577.mcaerial.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import rickwang577.mcaerial.entity.EntityCentaur;
import rickwang577.mcaerial.entity.EntityVehicle;
import rickwang577.mcaerial.entity.model.ModelVehicle;
import rickwang577.mcaerial.util.Reference;

public class RenderVehicle extends Render<EntityVehicle> {

	public double count = 0;
	
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entities/vehicle.png");
	
	private ModelBase mainModel;
	
	public RenderVehicle(RenderManager manager, ModelBase modelBaseIn, float shadowSizeIn) {
		super(manager);
		this.mainModel = modelBaseIn;
		this.shadowSize = shadowSizeIn;
	}
	
	
	@Override
    public void doRender(EntityVehicle entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        
		GlStateManager.translate(x, y + 3.15F, z);
		GlStateManager.rotate(-entity.rotationYaw, 0, 1, 0);
		GlStateManager.rotate(180F, 1, 0, 0);

		bindTexture(TEXTURES);		
		bindEntityTexture(entity);
		        
		mainModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.13F);		
		
		count++;
		System.out.println("Render count: " + count);
		
        GlStateManager.popMatrix();
	}

	
	@Override
	protected ResourceLocation getEntityTexture(EntityVehicle entity) {
		return TEXTURES;
	}

	
}
