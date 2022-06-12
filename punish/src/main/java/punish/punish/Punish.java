package punish.punish;

import org.bukkit.plugin.java.JavaPlugin;

public final class Punish extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("punish").setExecutor(new PunishCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
