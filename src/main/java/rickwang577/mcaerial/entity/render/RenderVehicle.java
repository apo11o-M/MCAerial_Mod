package rickwang577.mcaerial.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import rickwang577.mcaerial.entity.EntityGoKart;
import rickwang577.mcaerial.util.Reference;

public class RenderVehicle extends Render<EntityGoKart> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entities/go_kart.png");
	private ModelBase mainModel;
	
	public RenderVehicle(RenderManager manager, ModelBase modelBaseIn, float shadowSizeIn) {
		super(manager);
		this.mainModel = modelBaseIn;
		this.shadowSize = shadowSizeIn;
	}
	
	
	@Override
    public void doRender(EntityGoKart entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        
        float f = this.interpolateRotation(entity.prevRenderYawOffset, entity.renderYawOffset, partialTicks);
        
        this.translatePosition(x, y, z);
        this.applyRotations(entity, f, partialTicks);
				
		bindTexture(TEXTURES);
		bindEntityTexture(entity);

		mainModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.13F);		
        GlStateManager.popMatrix();

	}
	
	
	protected void translatePosition(double x, double y, double z) {
		GlStateManager.translate(x, y + 3.15F, z);
	}
	
	
	protected float interpolateRotation(float prevYawOffset, float yawOffset, float partialTicks) {
        float f = yawOffset - prevYawOffset;
        return prevYawOffset + partialTicks * f;
    }
	
    
    protected void applyRotations(Entity entity, float rotationYaw, float partialTicks) {
		GlStateManager.rotate(180F, 1, 0, 0);
        GlStateManager.rotate(rotationYaw, 0.0F, 1.0F, 0.0F);

    }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGoKart entity) {
		return TEXTURES;
	}

	
}
