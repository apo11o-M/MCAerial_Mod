package rickwang577.mcaerial.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent.CameraSetup;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import rickwang577.mcaerial.util.Reference;

@EventBusSubscriber
public class EntityPlane extends GeneralEntity {

	public double speed = 0;
	protected double speedIncrement = 0.007;
		// check if the speed goes below 0 when substract from the speed increment
	
	protected double speedTakeoff = 0.4;
	protected double speedMax = 1.5;
	protected float defaultMouseSen;
	protected double rotX, rotZ, rotY;
	protected float rollAngle;
		// check the initialzation value??
	

	public EntityPlane(World worldIn) {
		super(worldIn);
		this.setSize(1F, 0.6F);
		this.stepHeight = 0.6F;
		if (settings.mouseSensitivity < 0) {
			defaultMouseSen = 1.0F;
		} else {
			defaultMouseSen = settings.mouseSensitivity;
		}
			// read/ write nbt data??
	}
	
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if (isBeingRidden()) {
			//settings.mouseSensitivity = 0.15F;
			if (speed < speedTakeoff) {
				// on ground, the player can't control their rotation using the mouse
				settings.mouseSensitivity = -0.35F;
				this.getControllingPassenger().rotationPitch = this.rotationPitch;
				this.getControllingPassenger().rotationYaw = this.rotationYaw;
			} else {
				// in air, lower the player's rotation rate
				settings.mouseSensitivity = 0.05F;
				this.rotationPitch = this.getControllingPassenger().rotationPitch;
				this.rotationYaw = this.getControllingPassenger().rotationYaw;
			}

		} else {
			settings.mouseSensitivity = defaultMouseSen;
		}
	}
	
	
	@Override
	public void updateMotion() {	
		// the number 0.017453292F is equal to pi/180, which represents one degree angle in radians
		rotX = -MathHelper.sin(this.rotationYaw * 0.017453292F);
		rotZ =  MathHelper.cos(this.rotationYaw * 0.017453292F);
		rotY = -MathHelper.sin(this.rotationPitch * 0.017453292F);
		
		if (speed < speedTakeoff) {
			// plane still on land
			// w key and s key determine the speed just like EntityGoKart
			// a key and d key determine the rotation, also like EntityGoKart
				// the player's rotation pitch and yaw has to be the same as the entity
			if (inputRight) {
				this.rotationYaw += 1.5;
			} else if (inputLeft) {
				this.rotationYaw -= 1.5;
			}			
			if (inputForward) {
				speed += speedIncrement;
			} else if (inputBack && speed > 0) {
				speed -= speedIncrement;
			}
			
			// update the x and z motion
			this.motionX = speed * rotX;
			this.motionZ = speed * rotZ;
			
			// simulate gravity
			this.motionY -= 0.007;
			
			if (this.rollAngle != 0) {
				this.rollAngle = 0.0F; 
			}
		
		} else if (speedTakeoff <= speed) {
			// just change it to else statement
			
			// plane take off and in air
			// the entity flies towards the player's crosshair
			// w key and s key determine the speed of the vehicle
			// a key and d key determine the roll of the plane
			if (speed < speedMax) {
				// the plane keeps accel based on the player's input
				if (inputForward) {
					speed += speedIncrement;
				} else if (inputBack && speed > 0) {
					speed -= speedIncrement;
				}
			} else {
				// plane reaches maximum speed
				// make sure the plane doesn't go over the max speed
				if (inputBack) {
					speed -= speedIncrement;
				}
			}
			
			if (inputLeft) {
				rollAngle -= 0.7F;
			} else if(inputRight) {
				rollAngle += 0.7F;
			}
			this.motionX = speed * rotX;
			this.motionZ = speed * rotZ;
			this.motionY = speed * rotY;
			
			// simulate gravity
			this.motionY -= 0.01;

		}

	}
	

	@Override
	protected void entityInit() {
		
	}


	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		
	}


	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		
	}
	

	public float getRollAngle() {
		return rollAngle;
	}
	
	
	
	
	
	
}
