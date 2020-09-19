package rickwang577.mcaerial.networks;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import rickwang577.mcaerial.blocks.BlockBase;
import rickwang577.mcaerial.blocks.DraftingTableBlock;
import rickwang577.mcaerial.gui.draftingtableblock.ContainerDraftingTable;
import rickwang577.mcaerial.init.BlockInit;
import rickwang577.mcaerial.init.ItemInit;
import rickwang577.mcaerial.items.ItemBase;
import rickwang577.mcaerial.items.ItemPlane;
import rickwang577.mcaerial.util.Reference;

public class MCAerialMessage implements IMessage {

	private int toSend;
	// the position of the block
	private int x, y, z;

	public MCAerialMessage() {}
	
	public MCAerialMessage(int toSend, BlockPos pos) {
		this.toSend = toSend;
		this.x = pos.getX();
		this.y = pos.getY();
		this.z = pos.getZ();

	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
	    // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
	    toSend = buf.getInt(0);   
	    x = buf.getInt(1);
	    y = buf.getInt(2);
	    z = buf.getInt(3);
	    
	}

	@Override
	public void toBytes(ByteBuf buf) {
	    // Writes the int into the buf
	    buf.writeInt(this.toSend);
	    buf.writeInt(this.x);
	    buf.writeInt(this.y);
	    buf.writeInt(this.z);
	    
	}
	
	
	public static class MCAerialIMessageHandler implements IMessageHandler<MCAerialMessage, IMessage> {
		
		public MCAerialIMessageHandler() {}
		
		@Override 
		public IMessage onMessage(MCAerialMessage message, MessageContext ctx) {
			// This is the player the packet was sent to the server from
			EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
	    	ContainerDraftingTable container = (ContainerDraftingTable)serverPlayer.openContainer;
			
		    int id = message.toSend;
		    ItemStack item;
		    switch (id) {
		    	case 1 :
		    	default :
		    		item = new ItemStack(ItemInit.GO_KART);
		    		//flag = hasMaterials(item);		    		
			    	//serverPlayer.inventory.hasItemStack(item);
		    		break;
		    	case 2 :
		    		item = new ItemStack(ItemInit.MEVE);
		    		break;
		    }
		    
		    // Execute the action on the main server thread by adding it as a scheduled task
		    Minecraft.getMinecraft().addScheduledTask(() -> {
		    	if (!container.getSlot(0).getHasStack()) {
			    	container.putStackInSlot(container.outputSlotID, item);
		    	}
		    	// if the button is "create",
				// check if the player have enough materials for crafting that item
				// check the page number, and spawn the corrosponding item in the output slot	
	
		    	// if true
		    		// fill the drafting result slot (outputInventory) with the selected item.
		    		// and reduce the player's inventory.
		    	// if false, print "not enough materials!"
		    	
		    });
		    
		    // No response packet
		    return null;
		}
		
		
		private boolean hasMaterials(ItemStack item) {
			String[] recipe = ((ItemBase)(item.getItem())).recipe;
			for (int i = 0; i < 9; i++) {
				for(int j = 0; j < 36; j++) {
					
					
				}
			}
			
			return true;
		}
		
		
		
		
		
	}
	
	
	
	
	
	
}
