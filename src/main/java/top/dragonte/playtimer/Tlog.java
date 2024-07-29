package top.dragonte.playtimer;

import org.bukkit.Bukkit;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Tlog {
    Tplayer player;
    public Tlog(Tplayer player) {
        this.player = player;
    }

    public void log(){
        String fileName=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir="./loginListener/"+"byDate/"+fileName+".log";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        File logs=new File(dir);

        if(!logs.exists()){
            try{
                if(!logs.getParentFile().mkdirs()){
                    Bukkit.getLogger().warning("Error: Can not create dir: "+logs.getParentFile());
                    return;
                }
                if (!logs.createNewFile()) {
                    Bukkit.getLogger().warning("Error: Can not create file: "+fileName+".log");
                    return;
                }
            }catch(Exception e){
                Bukkit.getLogger().warning("Error: "+e);
            }
        }

        StringBuilder logContent=new StringBuilder();


        logContent.append(player.getName()).append(" ")
                .append(player.stayMinutes()).append(" ")
                .append(sdf.format(player.loginTime)).append(" ")
                .append(sdf.format(player.logoutTime)).append(" ")
                .append(player.getIP()).append(" ")
                .append("\n");
        try{
            java.io.FileWriter fw=new java.io.FileWriter(dir,true);
            fw.write(logContent.toString());
            fw.close();
        }catch(Exception e){
            Bukkit.getLogger().warning("Error: "+e);
        }
    }
}
