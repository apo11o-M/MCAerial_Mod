package rickwang577.mcaerial.util.handlers;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import rickwang577.mcaerial.Main;
import rickwang577.mcaerial.gui.draftingtableblock.ContainerDraftingTable;
import rickwang577.mcaerial.gui.draftingtableblock.GuiContainerDrafting;

/**
 * This class provides the synchronization of the slot contents between the server and client and lets 
 * you avoid having to create custom packets. Basically it provides an association between the Container
 * on the server side and the GuiScreen on the client side.
 * 
 * The class check the enumerated ID that is passed into the methods and return the associated element
 * (Container on server side, or GuiScreen on client side).
 * 
 */
public class GuiHandler implements IGuiHandler 
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World worldIn, int x, int y, int z) 
	{
		System.out.println("getserverguielement");

		if (ID == Main.GUI_ENUM.DRAFTING_TABLE.ordinal()) 
		{
            return new ContainerDraftingTable(player.inventory, worldIn, x, y, z);
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		System.out.println("getclientguielement");
		if (ID == Main.GUI_ENUM.DRAFTING_TABLE.ordinal()) 
		{
			return new GuiContainerDrafting(player.inventory, world,I18n.format("tile.draftingtable.name"), x, y, z);
		}
		return null;
	}


}
