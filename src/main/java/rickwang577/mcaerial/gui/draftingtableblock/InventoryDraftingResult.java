package rickwang577.mcaerial.gui.draftingtableblock;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

/**
 * This class is the actual list that holds the contends in the block
 *
 */
public class InventoryDraftingResult extends InventoryCraftResult 
{
	@Override
    public int getInventoryStackLimit() {
        return 1;
    }
	
	
}
