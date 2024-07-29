package top.dragonte.playtimer;

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
                logs.getParentFile().mkdirs();
                logs.createNewFile();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        String logContent=player.getName()+" "+player.stayMinutes()+" "+" "+sdf.format(player.loginTime)+" "+sdf.format(player.logoutTime)+" "+player.getIP()+"\n";
        try{
            java.io.FileWriter fw=new java.io.FileWriter(dir,true);
            fw.write(logContent);
            fw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
