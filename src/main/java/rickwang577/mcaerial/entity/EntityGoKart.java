package rickwang577.mcaerial.entity;

import net.minecraft.world.World;

public class EntityGoKart extends GeneralEntity {
	
	protected double turningAngle = 3.5;
	/** the top speed of the vehicle */
	protected double speedMax = 0.15;
	
	public EntityGoKart(World worldIn) {
		super(worldIn);
		this.setSize(1F, 0.6F);
		this.setSilent(true);
		this.stepHeight = 0.6F;

	}
	
	@Override
	public void updateMotion() {
		double rotX = GeneralEntity.getXVectorComp(this.rotationYaw, 0);
		double rotZ	= GeneralEntity.getZVectorComp(this.rotationYaw, 0);
		
		if ((inputRight && inputForward) || (inputLeft && inputBack)) {
			this.rotationYaw += turningAngle;
		} else if ((inputLeft && inputForward) || (inputRight && inputBack)) {
			this.rotationYaw -= turningAngle;
		} 			
		if (inputForward) {
			this.motionX += speedMax * rotX;
			this.motionZ += speedMax * rotZ;
		} else if (inputBack) {
			this.motionX -= speedMax * rotX * 0.3;
			this.motionZ -= speedMax * rotZ * 0.3;
		}
		
		// simulate gravity
		this.motionY -= 0.07;
		
		// add terrain resistance
		this.motionX *= 0.75;
		this.motionZ *= 0.75;

	}
	
	@Override
	protected void entityInit() { }
	
}
