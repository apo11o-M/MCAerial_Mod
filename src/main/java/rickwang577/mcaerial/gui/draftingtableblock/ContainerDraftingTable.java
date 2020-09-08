package rickwang577.mcaerial.gui.draftingtableblock;

import org.jline.reader.Widget;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * This class handles the interaction between the player(client) and the server(the target block).     
 * In the constructor, it creates slots using the addSlotToContainer() method and link the slot to the 
 * block's and player's inventory. Note that we also specify the on-screen position of the slot.
 * 
 */
public class ContainerDraftingTable extends Container {
	
    public InventoryDraftingResult outputInventory = new InventoryDraftingResult();
    public int outputSlotID;
    //public InventoryPlayer playerInventory;
    //private final World world;
    
    public ContainerDraftingTable(InventoryPlayer parPlayerInventory, World worldIn, int parX, int parY, int parZ) {
    	//DEBUG
		System.out.println("ContainerDraftingTable Constructor");
    	//this.world = worldIn;
		
		// initialize the slot for the crafting result
		outputSlotID = addSlotToContainer(new Slot(outputInventory, 0, 185, 44)).slotNumber;
		
		// initialize the slot for the player's inventory
		for(int playerSlotIndexY = 0; playerSlotIndexY < 3; ++playerSlotIndexY) {
			for(int playerSlotIndexX = 0; playerSlotIndexX < 9; ++playerSlotIndexX) {
				addSlotToContainer(new Slot(parPlayerInventory, playerSlotIndexX + playerSlotIndexY * 9 + 9, 
											62 + playerSlotIndexX * 18, 116 + playerSlotIndexY * 18));
			}
		}
        
    	// initialize the slots for the player's hotbar
        for(int hotbarSlotIndex = 0; hotbarSlotIndex < 9; ++hotbarSlotIndex) {
            addSlotToContainer(new Slot(parPlayerInventory, hotbarSlotIndex, 62 + hotbarSlotIndex * 18, 174));
        }     
    }

    @Override
    public void onCraftMatrixChanged(IInventory parInventory) {}

    /**
     * called when the player clicks the slot
     * super.slotClick handles the different types of drag events
     * The rest of the method handles what happen to the 
     */
    /*
    public ItemStack slotClick(int parSlotId, int parMouseButtonId, ClickType parClickMode, EntityPlayer parPlayer) {
        ItemStack clickItemStack = super.slotClick(parSlotId, parMouseButtonId, parClickMode, parPlayer);
        if(inventorySlots.size() > parSlotId && parSlotId >= 0) {
            if(inventorySlots.get(parSlotId) != null) {
                if(((Slot)inventorySlots.get(parSlotId)).inventory == inputInventory) {
                    onCraftMatrixChanged(inputInventory);
                }
            }
        }
        return clickItemStack;
        
    }
    */

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    /**
     * Called when a player shift-clicks on a slot.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer parPlayer, int parSlotIndex) {
    	
    	/*
        Slot slot = (Slot) inventorySlots.get(parSlotIndex);
        // If there is something in the stack to pick up
        if (slot != null && slot.getHasStack())
        {
            // If the slot is one of the custom slots
            if (slot.inventory.equals(inputInventory) || slot.inventory
                   .equals(outputInventory))
            {
                // try to move to player inventory
                if (!playerInventory.addItemStackToInventory(slot.getStack()))
                {
                    return null;
                }
                slot.putStack(null);
                slot.onSlotChanged();
            }
            // if the slot is a player inventory slot
            else if(slot.inventory.equals(playerInventory))
            {
                // DEBUG
                System.out.println("Shift-clicked on player inventory slot");
                // Try to transfer to input slot
                if (!((Slot)inventorySlots.get(inputSlotNumber)).getHasStack())
                {
                    ((Slot)inventorySlots.get(inputSlotNumber)).putStack(slot.getStack());
                    slot.putStack(null);
                    slot.onSlotChanged();
                }
                else
                {
                    // DEBUG
                    System.out.println("There is already something in the input slot");
                }
            }
        }
        return null;
        */
    	return null;
    }

    @Override
    public boolean canMergeSlot(ItemStack parItemStack, Slot parSlot) {
        return !parSlot.inventory.equals(outputInventory);
    }

    @Override
    public Slot getSlot(int parSlotIndex) {
        if(parSlotIndex >= inventorySlots.size())
            parSlotIndex = inventorySlots.size() - 1;
        return super.getSlot(parSlotIndex);
    }
}
