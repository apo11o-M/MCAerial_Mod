package rickwang577.mcaerial.entity.render;

import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import rickwang577.mcaerial.entity.EntityCart;
import rickwang577.mcaerial.entity.EntityCentaur;
import rickwang577.mcaerial.util.Reference;

public class RenderCart extends RenderBoat {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entities/cart.png");
	
	public RenderCart(RenderManager manager) {
		super(manager);
	}
	
	protected ResourceLocation getEntityTexture(EntityCentaur entity) {
		return TEXTURES;
	}


	

}
