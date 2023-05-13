package cn.tangsu99.fspServerStatus;

import cn.tangsu99.fspServerStatus.config.Config;
import cn.tangsu99.fspServerStatus.packet.Packet;
import net.fabricmc.api.DedicatedServerModInitializer;

public class FSPServerStatus implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        Config config = new Config();
        Packet.serverName = config.getServerName();
        Packet.serverAddress = config.getAddress();
        Packet.serverPort = config.getPort();
    }
}
