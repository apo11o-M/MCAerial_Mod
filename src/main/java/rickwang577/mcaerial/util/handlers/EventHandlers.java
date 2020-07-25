package rickwang577.mcaerial.util.handlers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.EntityViewRenderEvent.CameraSetup;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import rickwang577.mcaerial.entity.EntityPlane;
import rickwang577.mcaerial.entity.GeneralEntity;
import rickwang577.mcaerial.entity.render.RenderPlane;
import rickwang577.mcaerial.util.Reference;

//@EventBusSubscriber
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventHandlers {
	
	private static boolean needToPop = false;
	
	/**
	 * Set the player's camera roll angle when riding on entity plane
	 */
	@SubscribeEvent
	public static void entityPlaneRollEvent(CameraSetup event) {
		if (event.getEntity().getRidingEntity() instanceof EntityPlane) {
			EntityPlane temp = (EntityPlane)event.getEntity().getRidingEntity();
			event.setRoll(temp.fRoll);
			if (!temp.inAir) {
				event.setYaw(temp.fYaw + 180);
			}	
		}
	}
	
	/**
	 * Rotate the player's model roll angle when riding on entity plane.
	 * Seems to be called only when the player's model is actually rendered. (3rd person view/ multiplayer)
	 */
	@SubscribeEvent
	public static void onPlayerRideRender(RenderPlayerEvent.Pre event) {
		if (event.getEntity().getRidingEntity() instanceof EntityPlane) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			EntityPlane plane = (EntityPlane) event.getEntity().getRidingEntity();
			GlStateManager.pushMatrix();
			
	        // rotate in the yaw direction for the virtual axis
	        GlStateManager.rotate(-plane.fYaw, 0.0F, 1.0F, 0.0F);
	        
	        // rotate in the pitch direction
	        GlStateManager.rotate(plane.fPitch, 1.0F, 0.0F, 0.0F);	        
	        // rotate in the roll direction
	        GlStateManager.rotate(plane.fRoll, 0.0F, 0.0F, 1.0F);
	        
	        // rotate back to undo the yaw rotation
	        GlStateManager.rotate(plane.fYaw, 0.0F, 1.0F, 0.0F);

			needToPop = true;
		}
	}
	
	/**
	 * Pop the matrix if needed
	 */
	@SubscribeEvent
	public static void onPlayerRender(RenderPlayerEvent.Post event) {
		if (needToPop) {
			GlStateManager.popMatrix();
			needToPop = false;
		}
	}

	
	
}
