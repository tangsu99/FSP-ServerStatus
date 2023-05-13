package cn.tangsu99.fspServerStatus.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {
    private ConfigStorage cfg;
    private final Path filePath = FabricLoader.getInstance().getConfigDir().resolve("FSP-ServerStatus.json");

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public Config() {
        try {
            Files.createFile(filePath);
            Files.write(filePath, gson.toJson(new ConfigStorage()).getBytes(StandardCharsets.UTF_8));
        } catch (IOException ignored) {
        }
        loadFile();
    }

    public String getServerName() {
        return cfg.serverName;
    }

    public String getAddress() {
        return cfg.address;
    }

    public int getPort() {
        return cfg.port;
    }



    public void reLoadConfig() {
        loadFile();
    }

    private void loadFile() {
        String configStr;
        try {
            configStr = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cfg = gson.fromJson(configStr, ConfigStorage.class);
        saveFile();
    }

    private void saveFile() {
        try {
            Files.write(filePath, gson.toJson(cfg).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

