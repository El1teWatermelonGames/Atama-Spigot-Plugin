package atama.atama;

import org.bukkit.plugin.java.JavaPlugin;

public final class AtamaMain extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Atama loaded...");
        getServer().getPluginManager().registerEvents(new PlayerDeathsListener(), this);
        getCommand("skull").setExecutor(new getSkullCommand());
        getCommand("redeem_skull").setExecutor(new redeem_skullCommand());
    }
}
