package rickwang577.mcaerial.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import rickwang577.mcaerial.entity.EntityGoKart;
import rickwang577.mcaerial.entity.GeneralEntity;
import rickwang577.mcaerial.entity.model.ModelGoKart;
import rickwang577.mcaerial.util.Reference;

public class GeneralRender extends Render<GeneralEntity> {
		
	protected ModelBase mainModel;
	protected float scale;
	protected float verticalOffset;
	
	public GeneralRender(RenderManager manager) {
		super(manager);
		
	}
	
	
    public void doRender(EntityGoKart entity, double x, double y, double z, float entityYaw, float partialTicks) {
		// documentations about the partial ticks and more
        GlStateManager.pushMatrix();
        
        float fYaw = this.interpolateRotation(entity.prevRenderYawOffset, entity.renderYawOffset, partialTicks);
        float fPitch = this.interpolateRotation(entity.prevRenderPitchOffset, entity.renderPitchOffset, partialTicks);
        
        this.translatePosition(x, y, z);
        this.applyRotations(entity, fYaw, fPitch, partialTicks);
        
		bindEntityTexture(entity);
		mainModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, scale);
			// use those para for the turning wheels
		
        GlStateManager.popMatrix();
	}
	
	
	/**
	 * Translate the model to a certain height
	 */
	protected void translatePosition(double x, double y, double z) {
		GlStateManager.translate(x, y + verticalOffset, z);
	}
	

	/**
	 * Returns a rotation angle that is inbetween two other rotation angles based on the partial ticks minecraft is in rn
	 */
	protected float interpolateRotation(float prevOffset, float offset, float partialTicks) {
        float f = offset - prevOffset;
        return prevOffset + partialTicks * f;
    }
	
    
	/**
	 * Apply certain rotations to the model
	 */
    protected void applyRotations(Entity entity, float rotationYaw, float rotationPitch, float partialTicks) {

    }
	
    
	protected ResourceLocation getEntityTexture(EntityGoKart entity) {
		return null;
	}


	protected ResourceLocation getEntityTexture(GeneralEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
