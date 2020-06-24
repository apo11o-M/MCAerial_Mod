package rickwang577.mcaerial.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import rickwang577.mcaerial.entity.EntityCentaur;
import rickwang577.mcaerial.entity.model.ModelCentaur;
import rickwang577.mcaerial.util.Reference;

public class RenderCentaur extends RenderLiving<EntityCentaur> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entities/centaur.png");
	
	public RenderCentaur(RenderManager manager) {
		super(manager, new ModelCentaur() , 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCentaur entity) {
		return TEXTURES;
		
	}
	
	@Override
	protected void applyRotations(EntityCentaur entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
		
	}

}
