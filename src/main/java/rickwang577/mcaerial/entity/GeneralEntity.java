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

public class GeneralEntity extends Entity {
	
	public GameSettings settings = Minecraft.getMinecraft().gameSettings;
	public float renderYawOffset;
	public float prevRenderYawOffset;
	public float renderPitchOffset;
	public float prevRenderPitchOffset;
	public float renderRollOffset;
	public float prevRenderRollOffset;
	
	/** Entity rotation roll, similar to rotation pitch/ yaw */
	public float rotationRoll;
	protected boolean inputForward = false;
	protected boolean inputRight = false;
	protected boolean inputBack = false;
	protected boolean inputLeft = false;
	protected boolean inputSpace = false;
	//public boolean inputCargo = false;
		
	public GeneralEntity(World worldIn) {
		super(worldIn);
	}
	
	/**
	 * Update the entity every ticks
	 */
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		this.prevRenderYawOffset = this.renderYawOffset;
		this.renderYawOffset = this.rotationYaw;
		this.prevRenderPitchOffset = this.renderPitchOffset;
		this.renderPitchOffset = this.rotationPitch;
		this.prevRenderRollOffset = this.renderRollOffset;
		this.renderRollOffset = this.rotationRoll;
		
	}
	
	/**
	 * Updates the entity's position and logic
	 */
	@Override
	public void onUpdate() {
		super.onUpdate();
		if (this.world.isRemote) {
			this.updateInput();
			this.updateMotion();
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			
		}
    }
	
	/**
	 * Update the entity's motion every tick
	 */
	protected void updateMotion() {
	
	}
	
	/**
	 * Update the user's input every tick
	 */
	protected void updateInput() {
		if (this.getControllingPassenger() instanceof EntityPlayer) {
			this.inputForward = settings.keyBindForward.isKeyDown();
			this.inputRight = settings.keyBindRight.isKeyDown();
			this.inputBack = settings.keyBindBack.isKeyDown();
			this.inputLeft = settings.keyBindLeft.isKeyDown();
			this.inputSpace = settings.keyBindJump.isKeyDown();
		} else {
			this.inputForward = false;
			this.inputRight = false;
			this.inputBack = false;
			this.inputLeft = false;
			this.inputSpace = false;
			
		}
	}
	
	/**
	 * Return the X component of rotationYaw
	 */
	public static float getXVectorComp(float rotationYaw) {
			// the number 0.017453292F is equal to pi/180, which represents one degree angle in radians		
		return -MathHelper.sin(rotationYaw * 0.017453292F);
	}
	
	/**
	 * Return the Z component of rotationYaw
	 */
	public static float getZVectorComp(float rotationYaw) {
		return MathHelper.cos(rotationYaw * 0.017453292F);
	}
	
	/**
	 * Return the Y component of rotationPitch
	 */
	public static float getYVectorComp(float rotationPitch) {
		return -MathHelper.sin(rotationPitch * 0.017453292F);
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}
	
	@Override
	public boolean canBePushed() {
		return false;
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
		return this.getEntityBoundingBox();
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
