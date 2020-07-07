package rickwang577.mcaerial.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import rickwang577.mcaerial.entity.EntityVehicle;
import rickwang577.mcaerial.entity.model.ModelVehicle;
import rickwang577.mcaerial.util.Reference;

public class RenderVehicle extends GeneralRender {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entities/vehicle.png");
	
	public RenderVehicle(RenderManager manager, ModelBase modelBaseIn, float shadowSizeIn) {
		super(manager);
		this.mainModel = modelBaseIn;
		this.shadowSize = shadowSizeIn;
		this.scale = 0.13F;
		this.verticalOffset = 3.15F;
		bindTexture(TEXTURES);
	}
	
	
    protected void applyRotations(Entity entity, float rotationYaw, float rotationPitch, float partialTicks) {
		GlStateManager.rotate(180F, 1, 0, 0);
        GlStateManager.rotate(rotationYaw, 0.0F, 1.0F, 0.0F);
        //GlStateManager.rotate(rotationPitch, 0.0F, 1.0F, 0.0F);
        // calculate the rotation pitch x and z based on the rotation yaw
        
    }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVehicle entity) {
		return TEXTURES;
	}

	
}
