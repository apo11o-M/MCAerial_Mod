package rickwang577.mcaerial.entity;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityVehicle extends Entity {
	
	public boolean inputForward = false;
	public boolean inputRight = false;
	public boolean inputBack = false;
	public boolean inputLeft = false;
	
	float rad = this.rotationYaw;

	public EntityVehicle(World worldIn) {
		super(worldIn);
		setSize(1F, 0.5F);

	}
	

	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (this.world.isRemote) {
			if (this.getControllingPassenger() instanceof EntityPlayer) {
				GameSettings settings = Minecraft.getMinecraft().gameSettings;
				
				this.inputForward = settings.keyBindForward.isKeyDown();
				this.inputRight = settings.keyBindRight.isKeyDown();
				this.inputBack = settings.keyBindBack.isKeyDown();
				this.inputLeft = settings.keyBindLeft.isKeyDown();
				
			} else {
				this.inputForward = false;
				this.inputRight = false;
				this.inputBack = false;
				this.inputLeft = false;
				
			}
			
			this.updateMotion();
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		}
    }
	
	
	public void updateMotion() {
		double rotX;
		double rotZ;		
		double speed = 0.05;
		
		// rotate the entity by a small amount
		if ((inputRight && inputForward) || (inputLeft && inputBack)) {
			rad += 3.5;
		} else if ((inputLeft && inputForward) || (inputRight && inputBack)) {
			rad -= 3.5;
		} 
		
		// the number 0.017453292F is equal to pi/180, which represents one degree angle in radians
		rotX  = -MathHelper.sin(rad * 0.017453292F);
		rotZ  =  MathHelper.cos(rad * 0.017453292F);
		
		// move forward/ backward
		if (inputForward) {
			this.motionX += speed * rotX;
			this.motionZ += speed * rotZ;
		} else if (inputBack) {
			this.motionX -= speed * rotX;
			this.motionZ -= speed * rotZ;
		}
		
		// add terrain resistance
		this.motionX *= 0.90;
		this.motionZ *= 0.90;

	}
	
	
	@Override
	protected void entityInit() {
		
	}
	
	
	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}
	
	
	@Override
	public boolean canBePushed() {
		return true;
	}
	
	
	@Override
	protected boolean canBeRidden(Entity entityIn) {
		return true;
	}
	
	
	@Override
	public boolean canRiderInteract() {
		return true;
	}
	
	
	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return false;
	}
	
	
	@Override
	public double getMountedYOffset() {
		return 0.0d;
	}
	
	
	@Override
	public boolean canPassengerSteer() {
		return getControllingPassenger() instanceof EntityPlayer;
	}
	
	
	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand) {
		if (player.isSneaking()) {
			return false;
		} else {
			if (!this.world.isRemote) {
				player.startRiding(this);
			}
			return true;
		}
	}
	
	
	@Override
	public AxisAlignedBB getCollisionBox(Entity entityIn) {
		return getEntityBoundingBox();
	}
	
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getTrueSource() instanceof EntityPlayer) {
			this.setDead();
			return true;
		}
		return false;
	}
	
	
	@Override
	public Entity getControllingPassenger() {
		List<Entity> list = this.getPassengers();
		return list.isEmpty() ? null : (Entity) list.get(0);
	}
	
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox() {
		return null;
	}
	
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		
	}
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		
	}
	
}
