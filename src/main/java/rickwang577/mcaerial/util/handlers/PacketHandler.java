package rickwang577.mcaerial.util.handlers;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import rickwang577.mcaerial.networks.MCAerialMessage;
import rickwang577.mcaerial.networks.MCAerialMessage.MCAerialIMessageHandler;
import rickwang577.mcaerial.util.Reference;


public class PacketHandler {
	
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toUpperCase());

	public static void initPackets() {
		registerMessage(MCAerialMessage.class, MCAerialMessage.MCAerialIMessageHandler.class);
		
	}
	
	private static int nextPacketId = 0;
	
	private static void registerMessage(Class message, Class packet) {
		INSTANCE.registerMessage(packet, message, nextPacketId, Side.CLIENT);
		INSTANCE.registerMessage(packet, message, nextPacketId, Side.SERVER);
		nextPacketId++;
		
	}
	
	
}
