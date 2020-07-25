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
		
        // Be sure to translate the entity's position first, and then do the rotation
		GlStateManager.translate(x, y + 3.15F, z);
        this.applyRotations(entity, entity.fYaw, entity.fPitch, entity.fRoll);
				
		bindTexture(TEXTURES);
		bindEntityTexture(entity);

		mainModel.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.13F);		
        GlStateManager.popMatrix();
        
	}
	
	/**
	 * Interpolate the angle of the model based on the previous offsets and partial ticks
	 */
	protected float interpolateRotation(float prevOffset, float offset, float partialTicks) {
        float f = offset - prevOffset;
        return prevOffset + partialTicks * f;
    }
	
	/**
	 * Apply the rotations to the plane model
	 */
    protected void applyRotations(EntityPlane entity, float rotationYaw, float rotationPitch, float rotationRoll) {
		GlStateManager.rotate(180F, 1, 0, 0);
        
        // rotate in the yaw direction
        GlStateManager.rotate(rotationYaw, 0.0F, 1.0F, 0.0F);
        // rotate in the pitch direction
        GlStateManager.rotate(rotationPitch, 1.0F, 0.0F, 0.0F);
        // rotate in the roll direction
        GlStateManager.rotate(-rotationRoll, 0.0F, 0.0F, 1.0F);

    }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityPlane entity) {
		return TEXTURES;
	}

	
}
