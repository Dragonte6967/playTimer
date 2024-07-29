package top.dragonte.playtimer;

import org.bukkit.entity.Player;

import java.util.Objects;

public  class Tplayer {
    public Player player;
    public long loginTime;
    public long logoutTime;
    public long stayTime;

    public Tplayer(Player player) {
        this.player = player;
    }

    public void login() {
        loginTime = System.currentTimeMillis();
    }

    public void logout() {
        logoutTime = System.currentTimeMillis();
        stayTime = logoutTime - loginTime;
    }

    public long stayMinutes() {
        return Math.round((float) stayTime / 1000 / 60) ;
    }
    public String getName() {
        return player.getName();
    }
    public String getIP() {
        return Objects.requireNonNull(player.getAddress()).toString();
    }
}
