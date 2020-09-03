package rickwang577.mcaerial.gui.draftingtableblock;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiContainerDrafting extends GuiContainer 
{
	public ContainerDraftingTable container;
	private final String blockName;
	
	public GuiContainerDrafting(InventoryPlayer playerInventory, World worldIn, String blockName, int parX, int parY, int parZ) 
	{
		super(new ContainerDraftingTable(playerInventory, worldIn, parX, parY, parZ));
		container = (ContainerDraftingTable) inventorySlots;
		this.blockName = blockName;
	}    
	
	@Override
    public void drawScreen(int par1, int par2, float par3)
    {
        super.drawScreen(par1, par2, par3);
    }

	/**
	 * Render the background of the gui.
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.pushMatrix();
		mc.renderEngine.bindTexture(new ResourceLocation("mcaerial:textures/gui/drafting_table.png"));
		int j = width / 2 - xSize / 2;
		int k = height / 2 - ySize / 2;
		drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
			System.out.println("ininin");
		GlStateManager.popMatrix();	
	}
	

}
