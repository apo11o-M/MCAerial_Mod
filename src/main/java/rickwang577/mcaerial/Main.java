package rickwang577.mcaerial;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import rickwang577.mcaerial.init.ItemInit;
import rickwang577.mcaerial.items.ItemPlane;
import rickwang577.mcaerial.proxy.CommonProxy;
import rickwang577.mcaerial.util.Reference;
import rickwang577.mcaerial.util.handlers.GuiHandler;
import rickwang577.mcaerial.util.handlers.PacketHandler;
import rickwang577.mcaerial.util.handlers.RegistryHandler;
import rickwang577.mcaerial.util.handlers.RenderHandler;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		//OBJLoader.INSTANCE.addDomain(Reference.MOD_ID);
		RegistryHandler.preInitRegistries(event);
		RenderHandler.registerEntityRenders();
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());  
		PacketHandler.initPackets();

	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) { }
	
	public enum GUI_ENUM {
		DRAFTING_TABLE
	}
	
}
