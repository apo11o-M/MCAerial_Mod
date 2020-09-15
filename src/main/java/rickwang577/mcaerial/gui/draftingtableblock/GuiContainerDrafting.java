package rickwang577.mcaerial.gui.draftingtableblock;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import rickwang577.mcaerial.init.ItemInit;
import rickwang577.mcaerial.items.ItemPlane;
import rickwang577.mcaerial.networks.MCAerialMessage;
import rickwang577.mcaerial.util.handlers.PacketHandler;

/**
 * GuiContainer(Client side): This class specifies the layout of the gui, render the background images,
 * retrieves items and progress bars for display, and more. 
 */
public class GuiContainerDrafting extends GuiContainer {
	
	private static final ResourceLocation DRAFTING_TABLE_TEXTURES = new ResourceLocation("mcaerial:textures/gui/drafting_table.png");
	public ContainerDraftingTable container;
	public EntityPlayer player;
	private final String blockName;
	private BlockPos pos;
	private int page;
	
	public GuiContainerDrafting(InventoryPlayer playerInventory, World worldIn, String blockName, int parX, int parY, int parZ) {
		super(new ContainerDraftingTable(playerInventory, worldIn, parX, parY, parZ));
		container = (ContainerDraftingTable) inventorySlots;
		player = playerInventory.player;
		pos = new BlockPos(parX, parY, parZ);
		this.blockName = blockName;
		this.xSize = 284;
		this.ySize = 213;
		this.page = 1;
			
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
	
	/**
	 * This controls what do to when the buttons are activated
	 */
	@Override
    protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 1) {
			// if the button is "<<", previous page
			if (page > 1) {
				--page;
			}
		} else if (button.id == 2) {
			// if the button is ">>", next page
			page = 2;
			if (page < 2) {
				++page;
			}
		} else {
			// send a crafting request to the server 
			IMessage msg = new MCAerialMessage(page, pos);
			PacketHandler.INSTANCE.sendToServer(msg);	
	
		}
	}
	
	/**
	 * Actaully draw the screen
	 */
	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// make the background dimmer
		this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        // draw the item's name and tags when the mouse is hovering over the item
        this.renderHoveredToolTip(mouseX, mouseY);
        
    }

	/**
	 * Render the background of the gui.
	 * there are multiple draw gui methods in the gui class, and each of them have different usages/ parameters.
	 * i'm using the drawModalRectWithCustomSizedTexture() method is because my texture size is not 176x166 
	 * (the minecraft default texture size) and if i use the default draw gui methods the texture will look broken.
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {	
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		int j = width / 2 - xSize / 2;
		int k = height / 2 - ySize / 2;
			//mc.renderEngine.bindTexture(DRAFTING_TABLE_TEXTURES);
		this.mc.getTextureManager().bindTexture(DRAFTING_TABLE_TEXTURES);
			//drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
		this.drawModalRectWithCustomSizedTexture(j, k, 0, 0, xSize, ySize, 512, 512);
		
		RenderHelper.enableGUIStandardItemLighting();
		if (page == 1) {
			GuiContainerDrafting.DrawRecipes.drawGoKart(this, j, k);
		} else if (page == 2) {
			GuiContainerDrafting.DrawRecipes.drawMeve(this, j, k);
		} else {
			
		}

	}
	
	/**
	 * Draw the texts of the player's inventory and the drafting table.
	 */
	@Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		// this.fontRenderer.drawString(this.player.inventory.getDisplayName().getUnformattedText(), 8, 6, 4210752);
		// this.fontRenderer.drawString(this.container.outputInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
		
	}

	/**
	 * Draw the recipe and result on the crafting grid and result slot
	 */
	protected static class DrawRecipes {
		
		protected static void drawMeve(GuiContainerDrafting obj, int j, int k) {
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(ItemInit.MEVE), j + 130, k + 43);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.IRON_INGOT), j + 86, k + 25);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Blocks.IRON_BLOCK), j + 68, k + 43);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.DIAMOND), j + 86, k + 43);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Blocks.IRON_BLOCK), j + 104, k + 43);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.IRON_INGOT), j + 68, k + 61);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Blocks.DISPENSER), j + 86, k + 61);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.IRON_INGOT), j + 104, k + 61);
			
		}
		
		protected static void drawGoKart(GuiContainerDrafting obj, int j, int k) {
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(ItemInit.GO_KART), j + 130, k + 43);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Blocks.GLASS), j + 86, k + 25);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.IRON_INGOT), j + 68, k + 43);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.IRON_INGOT), j + 104, k + 43);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.REDSTONE), j + 68, k + 61);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.IRON_INGOT), j + 86, k + 61);
			obj.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.REDSTONE), j + 104, k + 61);
			
		}
		
		
	}
	
	

}

