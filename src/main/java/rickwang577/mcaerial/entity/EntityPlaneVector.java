package rickwang577.mcaerial.entity;

import java.awt.event.MouseEvent;
import java.util.Arrays;

import org.lwjgl.input.Mouse;

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
import rickwang577.mcaerial.util.MatrixHelper;
import rickwang577.mcaerial.util.Reference;

@EventBusSubscriber
public class EntityPlaneVector extends GeneralEntity {	
	
	public boolean inAir = false;
	public double speed = 0;
	protected double speedIncrement = 0.007;
	protected double speedTakeoff = 0.05;
	protected double speedMax = 1.5;
	protected float defaultMouseSen;
	/** The rotation yaw angle per tick */
	protected float yawAngle = 1.5F;
	/** The rotation roll angle per tick */
	protected float rollAngle = 0.5F;
	
	/** The x, y, and z looking vector components */
	protected double rotX, rotZ, rotY;
	/** The interpolated angle for the rendering class */
	public float fRoll, fPitch, fYaw;
	
	public float theta, phi;
	
							  /** x    z    y*/
	private double[][] vector = {{1}, {0}, {0}};


	public EntityPlaneVector(World worldIn) {
		super(worldIn);
		this.setSize(1F, 0.7F);
		this.stepHeight = 0.6F;
		this.ignoreFrustumCheck = true;
		if (settings.mouseSensitivity < 0 || settings.mouseSensitivity >= 1.5F) {
			defaultMouseSen = 1.0F;
		} else {
			defaultMouseSen = settings.mouseSensitivity;
		}

	}
	
    public EntityPlaneVector(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }
	
    
    /*
     Using euler's angles and rotation matrices to match the user's mouse input with the current
     glider & camera roll
     
     There are two steps:
     First is to take the user's mouse input(inputYaw and inputPitch) and add another rotating
     axis(rotationRoll) onto it, using rotation matrices. 
     The second step is then convert the rotated, three dimensional vectors into two components:
     rotationYaw and rotationPitch to actually turn the glider.
         
     */
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if (isBeingRidden()) {
			if (speed < speedTakeoff) {
				// on ground, the player can't control their rotation using the mouse
				settings.mouseSensitivity = -0.35F;
				this.getControllingPassenger().rotationPitch = this.rotationPitch;
				this.getControllingPassenger().rotationYaw = this.rotationYaw;
				
				vector[0][0] = this.getXVectorComp(this.rotationYaw, 0);
				vector[1][0] = this.getZVectorComp(this.rotationYaw, 0);
				
				//System.out.println("vector: " + Arrays.deepToString(vector));
				
			} else {
				// in air, lower the player's rotation rate
				settings.mouseSensitivity = 0.0015F;
				
			
				float inputYaw = (this.getControllingPassenger().rotationYaw) * 0.017453292F;
				float inputPitch = (this.getControllingPassenger().rotationPitch) * 0.017453292F;					
				float inputRoll = (float)((this.rotationRoll) * 0.017453292F);
				
				double[][] rollMatrix = MatrixHelper.rotateXMatrix(inputRoll);
				double[][] yawMatrix = MatrixHelper.rotateYMatrix(inputYaw);
				double[][] pitchMatrix = MatrixHelper.rotateZMatrix(inputPitch);
					
				double[][] temp = MatrixHelper.multiplyMatrix(rollMatrix, vector);
				//double[][] temp2 = MatrixHelper.multiplyMatrix(pitchMatrix, temp);
				double[][] result = MatrixHelper.multiplyMatrix(yawMatrix, temp);
				
				
				phi = (float)((Math.atan(MatrixHelper.getZ(result) / MatrixHelper.getX(result))) * 180 / Math.PI);
				theta = (float)((Math.acos(MatrixHelper.getY(result))) * 180 / Math.PI) * -1 + 90;
				
				if (MatrixHelper.getX(result) < 0) {
					phi += 180;
				}	
				
				this.rotationYaw = phi;				
				this.rotationPitch = theta;

				System.out.println("result array: " + Arrays.deepToString(result));
				
					System.out.println("roll: " + this.rotationRoll);
					System.out.println("yaw/phi: " + this.rotationYaw);
					System.out.println("pitch/theta: " + this.rotationPitch);
					System.out.println();	
					
				
				this.rotationYaw = this.getControllingPassenger().rotationYaw;
				this.rotationPitch = this.getControllingPassenger().rotationPitch;

					
			}
		} else {
			settings.mouseSensitivity = defaultMouseSen;
		}
	}
	
	@Override
	public void updateMotion() {	
		rotX = GeneralEntity.getXVectorComp(this.rotationYaw, this.rotationPitch);
		rotZ = GeneralEntity.getZVectorComp(this.rotationYaw, this.rotationPitch);
		rotY = GeneralEntity.getYVectorComp(this.rotationPitch);
		
		if (speed < speedTakeoff) {
			if (inputRight) {
				this.rotationYaw += yawAngle;
			} else if (inputLeft) {
				this.rotationYaw -= yawAngle;
			}			
			if (inputForward) {
				speed += speedIncrement;
			} else if (inputBack && speed > 0) {
				speed -= speedIncrement;
				if (speed < 0) {
					speed = 0;
				}
			}
			//this.motionX = speed * rotX;
			//this.motionZ = speed * rotZ;
			
			// simulate gravity
			//this.motionY -= 0.007;
			
			if (this.rotationRoll != 0) {
				this.rotationRoll = 0.0F; 
			}
			if (this.rotationPitch != 0) {
				this.rotationPitch = 0;
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
				rotationRoll -= rollAngle;
			} else if(inputRight) {
				rotationRoll += rollAngle;
			}
			
			//this.motionX = speed * rotX;
			//this.motionZ = speed * rotZ;
			//this.motionY = speed * rotY;
			// simulate gravity
			//this.motionY -= 0.01;
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
