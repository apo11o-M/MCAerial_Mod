	package rickwang577.mcaerial.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityPlane extends GeneralEntity {

	public double speed;
	public double speedIncrement = 0.05;
	public double maxSpeed = 0.6;
	
	private float defaultMouseSen;
	private double rotX;
	private double rotZ;
	private double rotY;
	
	
	public EntityPlane(World worldIn) {
		super(worldIn);
		this.setSize(1F, 0.6F);
		this.stepHeight = 1;
		defaultMouseSen = settings.mouseSensitivity;
		
	}
	
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if (isBeingRidden()) {
			settings.mouseSensitivity = 0.15F;
			this.rotationPitch = this.getControllingPassenger().rotationPitch;
			this.rotationYaw = this.getControllingPassenger().rotationYaw;
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
		
		if (inputForward && speed < 0.3) {
			this.motionX += (speed + speedIncrement) * rotX;
			this.motionZ += (speed + speedIncrement) * rotZ;
			this.motionY += (speed + speedIncrement) * rotY;

			
		} else if (0.3 <= speed || speed < maxSpeed) {
			
		}
		
		//this.motionY -= 0.07;
		
		this.motionX *= 0.85;
		this.motionZ *= 0.85;
		this.motionY *= 0.75;

	}


	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
