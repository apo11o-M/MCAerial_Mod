package rickwang577.mcaerial.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import rickwang577.mcaerial.init.ItemInit;

public class EntityCentaur extends EntityCow {

	public EntityCentaur(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 2.8F);

	}
	
	@Override
	public EntityCow createChild(EntityAgeable ageable) {
		return new EntityCentaur(world);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return super.getAmbientSound();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return super.getHurtSound(source);
	}
	
	@Override 
	protected SoundEvent getDeathSound() {
		return super.getDeathSound();		
	}

	
}
