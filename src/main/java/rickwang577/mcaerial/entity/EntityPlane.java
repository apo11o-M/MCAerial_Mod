package rickwang577.mcaerial.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent.CameraSetup;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import rickwang577.mcaerial.util.Reference;

@EventBusSubscriber
public class EntityPlane extends GeneralEntity {	
	
	public boolean inAir = false;
	public double speed = 0;
	protected double speedIncrement = 0.007;
	protected double speedTakeoff = 0.4;
	protected double speedMax = 1.5;
	protected float defaultMouseSen;
	
	/** The x, y, and z looking vector components */
	protected double rotX, rotZ, rotY;
	/** The interpolated angle for rendering */
	public float fRoll, fPitch, fYaw;

	public EntityPlane(World worldIn) {
		super(worldIn);
		this.setSize(1F, 0.6F);
		this.stepHeight = 0.6F;
		if (settings.mouseSensitivity < 0) {
			defaultMouseSen = 1.0F;
		} else {
			defaultMouseSen = settings.mouseSensitivity;
		}

	}
	
    public EntityPlane(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if (isBeingRidden()) {
			if (speed < speedTakeoff) {
				// on ground, the player can't control their rotation using the mouse
				settings.mouseSensitivity = -0.35F;
				this.getControllingPassenger().rotationPitch = this.rotationPitch;
				this.getControllingPassenger().rotationYaw = this.rotationYaw;
			} else {
				// in air, lower the player's rotation rate
				settings.mouseSensitivity = 0.0012F;
				this.rotationPitch = this.getControllingPassenger().rotationPitch;
				this.rotationYaw = this.getControllingPassenger().rotationYaw;
				
			}
		} else {
			settings.mouseSensitivity = defaultMouseSen;
		}
	}
	
	@Override
	public void updateMotion() {	
		rotX = GeneralEntity.getXVectorComp(this.rotationYaw);
		rotZ = GeneralEntity.getZVectorComp(this.rotationYaw);
		rotY = GeneralEntity.getYVectorComp(this.rotationPitch);
		
		if (speed < speedTakeoff) {
			if (inputRight) {
				this.rotationYaw += 1.5;
			} else if (inputLeft) {
				this.rotationYaw -= 1.5;
			}			
			if (inputForward) {
				speed += speedIncrement;
			} else if (inputBack && speed > 0) {
				speed -= speedIncrement;
				if (speed < 0) {
					speed = 0;
				}
			}
			this.motionX = speed * rotX;
			this.motionZ = speed * rotZ;
			
			// simulate gravity
			this.motionY -= 0.007;
			
			if (this.rotationRoll != 0) {
				this.rotationRoll = 0.0F; 
			}
			this.inAir = false;
			
		} else {		
			if (speed < speedMax) {
				if (inputForward) {
					speed += speedIncrement;
				} else if (inputBack && speed > 0) {
					speed -= speedIncrement;
				}
			} else {
				if (inputBack) {
					speed -= speedIncrement;
				}
			}
			
			if (inputLeft) {
				rotationRoll -= 0.7F;
			} else if(inputRight) {
				rotationRoll += 0.7F;
			}
			
			this.motionX = speed * rotX;
			this.motionZ = speed * rotZ;
			this.motionY = speed * rotY;
			// simulate gravity
			this.motionY -= 0.01;
			this.inAir = true;
		
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
	
	
	
}
