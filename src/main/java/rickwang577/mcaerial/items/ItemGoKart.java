package rickwang577.mcaerial.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import rickwang577.mcaerial.entity.EntityGoKart;
import rickwang577.mcaerial.entity.EntityPlane;

public class ItemGoKart extends ItemBase {

	public ItemGoKart(String name) {
		super(name);		
		maxStackSize = 1;

	}
	
	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, 
    								  EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
	        ItemStack itemstack = player.getHeldItem(hand);
	        EntityGoKart goKart = new EntityGoKart(worldIn, (double)pos.getX() + 0.5, (double)pos.getY() + 1, (double)pos.getZ() + 0.5);
	        worldIn.spawnEntity(goKart);
	        itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.FAIL;
	}
}
