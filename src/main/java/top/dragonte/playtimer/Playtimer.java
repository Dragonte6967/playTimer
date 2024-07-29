package top.dragonte.playtimer;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Playtimer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        regLis(new Tlistener());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void regLis(Listener ... listeners){

        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }
}
