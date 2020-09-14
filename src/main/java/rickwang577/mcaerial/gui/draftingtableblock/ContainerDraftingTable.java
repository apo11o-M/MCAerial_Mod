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
    public InventoryPlayer playerInventory;
    public World worldIn;

    public ContainerDraftingTable(InventoryPlayer parPlayerInventory, World worldIn, int parX, int parY, int parZ) {
    	
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
        
        playerInventory = parPlayerInventory;
        this.worldIn = worldIn;
        
    }

    /**
     * This method is called when the player wants moves an itemstack from one slot to another. This includes all types 
     * of clicks(left clicks, right clicks, shift-clicks, and more). Failure to consider all the possibilities would result
     * in weird inventory behaviors such as itemstacks dissapearing or even mc stuck in a infinite for loop.
     * 
     * mergeItemStack() is a method that merges the itemstack from the initial slot to the target slot. It returns true 
     * if it successfully merge the items, and returns false if it does not(maybe the player's inventory is full, etc).
     * 
     * @return The itemstack that goes into the target slot 
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer parPlayer, int parSlotIndex) {
    	ItemStack itemstack = ItemStack.EMPTY;
    	Slot slot = this.inventorySlots.get(parSlotIndex);
    	
    	// if there is stuff in this slot
    	if (slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
			itemstack = current.copy();
			
			// if the slot is the drafting table result
			if (slot.slotNumber == outputSlotID) {
				// merge the itemstack from the custom slot to the player inventory
				if (!this.mergeItemStack(current, 1, this.inventorySlots.size(), true)) {
					// when you get here, it means you shift-clicked the empty drafting table slot u dum dum
					System.out.println("hit first");
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(current, 0, 1, false)){
			// if the selected slot is the player's inventory
				System.out.println("hit second");
				return ItemStack.EMPTY;
			}
			
			if (current.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return itemstack;
		
    }
    
    /**
     * Drop the items if the container still have itemstacks in it.
     */
    @Override
    public void onContainerClosed(EntityPlayer player) {	
    }

    @Override
    public boolean canMergeSlot(ItemStack parItemStack, Slot parSlot) {
        return !parSlot.inventory.equals(outputInventory);
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.outputInventory.isUsableByPlayer(player);
    }

    
    @Override
    public Slot getSlot(int parSlotIndex) {
        if(parSlotIndex >= inventorySlots.size())
            parSlotIndex = inventorySlots.size() - 1;
        return super.getSlot(parSlotIndex);
    }
    
}
