package rickwang577.mcaerial.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import rickwang577.mcaerial.Main;
import rickwang577.mcaerial.entity.EntityPlane;
import rickwang577.mcaerial.util.IHasModel;
import rickwang577.mcaerial.util.Reference;

public class ItemPlane extends ItemBase  {
	
	
	public ItemPlane(String name) {
		super(name);		
		maxStackSize = 1;
		recipeInit();
	}

	@Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, 
    								  EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
	        ItemStack itemstack = player.getHeldItem(hand);
	        EntityPlane entityPlane = new EntityPlane(worldIn, (double)pos.getX() + 0.5, (double)pos.getY() + 1, (double)pos.getZ() + 0.5);
	        worldIn.spawnEntity(entityPlane);
	        itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.FAIL;
		
	}
	
	private void recipeInit() {
		recipe[0] = null;
		recipe[1] = "minecraft:iron_ingot";
		recipe[2] = null;
		recipe[3] = "minecraft:iron_block";
		recipe[4] = "minecraft:diamond";
		recipe[5] = "minecraft:iron_block";
		recipe[6] = "minecraft:iron_ingot";
		recipe[7] = "minecraft:dispenser";
		recipe[8] = "minecraft:iron_ingot";
		
	}
	

	
}
