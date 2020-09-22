import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Set;

import javazoom.jl.decoder.JavaLayerError;
import javazoom.jl.player.Player;

public class MP3Player extends Thread{
    private String filename;
    private Player player;
    private Set<String> songList;
    

    public MP3Player(String filename) {
        this.filename = filename;
    }

    public MP3Player(Set<String> songList){
        this.songList = songList;
    }

    @Override
    public void run(){
        super.run();

        try{
            playSongList(songList);
        }catch(JavaLayerError e){
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
            player = new Player(buffer);
            player.play();
            
            

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        MP3Player mp3 = new MP3Player("阿猫阿狗.mp3");
        //mp3.play(); 
        mp3.run();
        
        if(!mp3.isAlive()){
            System.out.println("die die die");
        }
        
    }

    public void playSongList(Set<String> songList){
        for(String song:songList){
            MP3Player player = new MP3Player("songs/"+ song + ".mp3");
            player.play();
        }
    }
}

