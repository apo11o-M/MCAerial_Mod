package rickwang577.mcaerial.gui.draftingtableblock;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import rickwang577.mcaerial.items.ItemPlane;

/**
 * GuiContainer(Client side): This class specifies the layout of the gui, render the background images,
 * retrieves items and progress bars for display, and more. 
 */
public class GuiContainerDrafting extends GuiContainer {
	
	private static final ResourceLocation DRAFTING_TABLE_TEXTURES = new ResourceLocation("mcaerial:textures/gui/drafting_table.png");
	public ContainerDraftingTable container;
	private final String blockName;
	private int page;
	
	public GuiContainerDrafting(InventoryPlayer playerInventory, World worldIn, String blockName, int parX, int parY, int parZ) {
		super(new ContainerDraftingTable(playerInventory, worldIn, parX, parY, parZ));
		container = (ContainerDraftingTable) inventorySlots;
		this.blockName = blockName;
		this.xSize = 284;
		this.ySize = 213;
		System.out.println("GuiContainerDrafting Constructor");
		
	}    
	
	/**
	 * Initialize the gui buttons.
	 * the gui button position have to be calculated related to the gui texture, not the absolute position related to the screen
	 * or else if the screen resizes, the button position will be all over the place.
	 */
	@Override
	public void initGui() {
		super.initGui();
		this.buttonList.add(new GuiButton(1, this.guiLeft + 65, this.guiTop + 82, 28, 20, "<<"));
		this.buttonList.add(new GuiButton(2, this.guiLeft + 95, this.guiTop + 82, 28, 20, ">>"));
		this.buttonList.add(new GuiButton(3, this.guiLeft + 171, this.guiTop + 82, 45, 20, "create"));
		
	}
	
	@Override
    protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 1) {
			// if the button is "<<"
			// do nothing for now
			page = 1;
			
		} else if (button.id == 2) {
			// if the button is ">>"
			// do nothing for now
			page = 2;
			
		} else {
			// if the button is "create"
			System.out.println("actionPerformed");
			// check if the player have enough materials for crafting that item
			// check the current page
			
			//container.putStackInSlot(container.outputSlotID, new ItemStack(new ItemPlane()));
			// if true
				// fill the drafting result slot (outputInventory) with the selected item.
				// and reduce the player's inventory.
			// if false, do nothing
			
			
			
			
		}
	}
	
	@Override
    public void drawScreen(int par1, int par2, float par3) {
		// make the background dimmer
		this.drawDefaultBackground();
        super.drawScreen(par1, par2, par3);
        
    }

	/**
	 * Render the background of the gui.
	 * there are multiple draw gui methods in the gui class, and each of them have different usages/ parameters.
	 * i'm using the drawModalRectWithCustomSizedTexture() method is because my texture size is not 176x166 
	 * (the minecraft default texture size) and if i use the default draw gui methods the texture will look broken.
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {		
		int j = width / 2 - xSize / 2;
		int k = height / 2 - ySize / 2;
			//mc.renderEngine.bindTexture(DRAFTING_TABLE_TEXTURES);
		this.mc.getTextureManager().bindTexture(DRAFTING_TABLE_TEXTURES);
			//drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
		this.drawModalRectWithCustomSizedTexture(j, k, 0, 0, xSize, ySize, 512, 512);
	
	}
	

}
