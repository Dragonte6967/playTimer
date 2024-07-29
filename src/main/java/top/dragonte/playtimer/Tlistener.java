package top.dragonte.playtimer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Tlistener implements Listener {
    Tplayer player;
    @EventHandler
    public void onPlayerLogin(org.bukkit.event.player.PlayerLoginEvent event) {
        player = new Tplayer(event.getPlayer());
        player.login();
    }
    @EventHandler
    public void onPlayerLogout(org.bukkit.event.player.PlayerQuitEvent event) {
        player.logout();
        Tlog log = new Tlog(player);
        log.log();
    }
}
