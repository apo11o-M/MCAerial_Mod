package rickwang577.mcaerial.entity;

import net.minecraft.entity.item.EntityBoat;
import net.minecraft.world.World;

public class EntityCart extends EntityBoat {

	public EntityCart(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 2.8F);
		
	}
	
	@Override
	public float getBoatGlide() {
		return 0.9F;
	}

}
