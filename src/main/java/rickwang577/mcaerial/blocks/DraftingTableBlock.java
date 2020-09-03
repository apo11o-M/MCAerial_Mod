package rickwang577.mcaerial.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rickwang577.mcaerial.Main;

public class DraftingTableBlock extends BlockBase 
{

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public DraftingTableBlock(String name, Material material) 
	{
		super(name, material);
		
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, 
    								EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if (!worldIn.isRemote) 
		{
			//DEBUG
	        System.out.println("BlockDeconstructor onBlockActivated");
	        playerIn.openGui(Main.instance, Main.GUI_ENUM.DRAFTING_TABLE.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
        return true;
    }
	
	
	
	

    
	

	
	

}
