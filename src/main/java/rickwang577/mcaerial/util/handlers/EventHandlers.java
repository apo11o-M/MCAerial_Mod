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
			EntityPlane plane = (EntityPlane)event.getEntity().getRidingEntity();
			event.setRoll(plane.fRoll);
			if (!plane.inAir) {
				event.setYaw(plane.fYaw + 180);
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
			EntityPlane plane = (EntityPlane) event.getEntity().getRidingEntity();
			GlStateManager.pushMatrix();
			
			float x = (float) event.getX();
			float y = (float) event.getY();
			float z = (float) event.getZ();
			
	        // rotate in the yaw direction for the virtual axis
	        GlStateManager.rotate(-plane.fYaw, 0.0F, 1.0F, 0.0F);
	        
	        // translate the player's model to fit the riding position
	        GlStateManager.translate(x, y + 0.2F, z);
	        
	        // translate the model to change its pivot position to the player's eye position
			GlStateManager.translate(x, y + 1.47F, z);
				//GlStateManager.translate(x, y + 0.6F, z);
			
	        // rotate in the pitch direction
	        GlStateManager.rotate(plane.fPitch, 1.0F, 0.0F, 0.0F);	        
	        // rotate in the roll direction
	        GlStateManager.rotate(plane.fRoll, 0.0F, 0.0F, 1.0F);
	        
	        // translate the model back to its original position
			GlStateManager.translate(x, y - 1.47F, z);
	
	        // rotate back to undo the yaw rotation
	        GlStateManager.rotate(plane.fYaw, 0.0F, 1.0F, 0.0F);
	        	// shoutout to this dude on this post: shorturl.at/cgvwO
	        
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
