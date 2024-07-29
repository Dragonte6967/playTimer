package top.dragonte.playtimer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class Tlistener implements Listener {
    HashMap<Player, Tplayer> playerMap = new HashMap<>();
    @EventHandler
    public void onPlayerLogin(org.bukkit.event.player.PlayerLoginEvent event) {
        Tplayer tplayer = new Tplayer(event.getPlayer());
        playerMap.put(tplayer.player, tplayer);
        tplayer.login();
    }
    @EventHandler
    public void onPlayerLogout(org.bukkit.event.player.PlayerQuitEvent event) {
        Tplayer tplayer = playerMap.get(event.getPlayer());
        if (tplayer != null) {
            tplayer.logout();
            Tlog tlog = new Tlog(tplayer);
            tlog.log();
            playerMap.remove(event.getPlayer());
        }
    }
}
