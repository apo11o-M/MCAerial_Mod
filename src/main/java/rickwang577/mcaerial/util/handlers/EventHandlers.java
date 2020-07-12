package rickwang577.mcaerial.util.handlers;

import net.minecraftforge.client.event.EntityViewRenderEvent.CameraSetup;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import rickwang577.mcaerial.entity.EntityPlane;

@EventBusSubscriber
public class EventHandlers {
	
	@SubscribeEvent
	public static void entityPlaneRollEvent(CameraSetup event) {
		if (event.getEntity().getRidingEntity() instanceof EntityPlane) {
			event.setRoll(((EntityPlane)event.getEntity().getRidingEntity()).getRollAngle());

		}		
	}
	
	
}
