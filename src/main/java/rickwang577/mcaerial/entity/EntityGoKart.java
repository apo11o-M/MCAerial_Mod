package rickwang577.mcaerial.entity;

import net.minecraft.world.World;

public class EntityGoKart extends GeneralEntity {
	
	protected double turningAngle = 3.5;
	protected double speed = 0.15;
	
	public EntityGoKart(World worldIn) {
		super(worldIn);
		this.setSize(1F, 0.6F);
		this.setSilent(true);
		this.stepHeight = 0.6F;

	}
	
	@Override
	public void updateMotion() {
		double rotX = GeneralEntity.getXVectorComp(this.rotationYaw);
		double rotZ	= GeneralEntity.getZVectorComp(this.rotationYaw);
		
		if ((inputRight && inputForward) || (inputLeft && inputBack)) {
			this.rotationYaw += turningAngle;
		} else if ((inputLeft && inputForward) || (inputRight && inputBack)) {
			this.rotationYaw -= turningAngle;
		} 			
		if (inputForward) {
			this.motionX += speed * rotX;
			this.motionZ += speed * rotZ;
		} else if (inputBack) {
			this.motionX -= speed * rotX * 0.3;
			this.motionZ -= speed * rotZ * 0.3;
		}
		
		// simulate gravity
		this.motionY -= 0.07;
		
		// add terrain resistance
		this.motionX *= 0.75;
		this.motionZ *= 0.75;

	}
	
	@Override
	protected void entityInit() {
		
	}
	
}
