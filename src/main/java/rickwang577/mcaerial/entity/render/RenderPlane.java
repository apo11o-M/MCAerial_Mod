package rickwang577.mcaerial.entity.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import rickwang577.mcaerial.entity.EntityPlane;
import rickwang577.mcaerial.entity.GeneralEntity;
import rickwang577.mcaerial.util.Reference;

public class RenderPlane extends Render<EntityPlane> {
		
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entities/plane.png");
	private ModelBase mainModel;
	
	public RenderPlane(RenderManager manager, ModelBase modelBaseIn) {
		super(manager);
		this.mainModel = modelBaseIn;
		this.shadowSize = 0.5F;
	}
	
	/**
	 * Update the Entity's model and texture every frame
	 */
	@Override
    public void doRender(EntityPlane entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        
        entity.fYaw = interpolateRotation(entity.prevRenderYawOffset, entity.renderYawOffset, partialTicks);
        entity.fPitch = interpolateRotation(entity.prevRenderPitchOffset, entity.renderPitchOffset, partialTicks);
		entity.fRoll = interpolateRotation(entity.prevRenderRollOffset, entity.renderRollOffset, partialTicks);
		
		GlStateManager.translate(x, y + 3.82F, z);
		
		this.applyRotations(entity, x, y, z, entity.fYaw, entity.fPitch, entity.fRoll);
        
		bindTexture(TEXTURES);
		bindEntityTexture(entity);

		mainModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.15F);		
        GlStateManager.popMatrix();
        
	}
	
	/**
	 * Apply the rotations to the plane model
	 */
    protected void applyRotations(EntityPlane entity, double x, double y, double z, float rotationYaw, float rotationPitch, float rotationRoll) {
		GlStateManager.rotate(180F, 1, 0, 0);

        // translate the model to change its pivot position from feet to eyes
		GlStateManager.translate(0, 2.5F, 0);
			// GlStateManager.translate(0, 3.5F, 0);
		
        // rotate in the yaw direction
        GlStateManager.rotate(rotationYaw, 0.0F, 1.0F, 0.0F);
        // rotate in the pitch direction
        GlStateManager.rotate(rotationPitch, 1.0F, 0.0F, 0.0F);
        // rotate in the roll direction
        GlStateManager.rotate(-rotationRoll, 0.0F, 0.0F, 1.0F);
  		
        // translate the model back to its original position
        GlStateManager.translate(0, -2.5F, 0);
	
    }
    
	/**
	 * Interpolate the angle of the model based on the previous offsets and partial ticks
	 */
	protected float interpolateRotation(float prevOffset, float offset, float partialTicks) {
        float f = offset - prevOffset;
        return prevOffset + partialTicks * f;
    }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPlane entity) {
		return TEXTURES;
	}

	
}
