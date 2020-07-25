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
