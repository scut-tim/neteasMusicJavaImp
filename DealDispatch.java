import java.util.Set;

public class DealDispatch implements Runnable {
    
 
    private String[] processStr(String input){
        input.trim();
        String[] ret = input.split(" ");
        return ret;
    }

    @Override
    public void run() {
        System.out.println("going in ddispa class run method!");
        // TODO Auto-generated method stub
            MP3Player mp3 = null;
            while(true){
                if(!ConmandBuffer.conmandQueue.isEmpty()){
                    ConmandBuffer.conmand = ConmandBuffer.conmandQueue.poll();
                
                    
                    String[] words = processStr(ConmandBuffer.conmand);
                    if(words.length <= 1){
                        System.out.println("unaceptable input, type again plz.");
                        continue;
                    }
                    
                    switch(words[0]){
                        case "download":
                            DownloadSongs.downloadByName(ConmandBuffer.conmand.
                            substring(ConmandBuffer.conmand.indexOf(" ") + 1));
                        break;
                        case "add":
                            PlayList pl1 = new PlayList(words[words.length - 1]);
                            pl1.addSong(ConmandBuffer.conmand.substring(
                                ConmandBuffer.conmand.indexOf(" ")+1,
                                ConmandBuffer.conmand.lastIndexOf(" ")));
                        break;
                        case "play":
                            if(mp3 != null && mp3.isAlive())mp3.stop();
                            PlayList pl2 = new PlayList(ConmandBuffer.conmand.
                            substring(ConmandBuffer.conmand.indexOf(" ") + 1));
                            Set<String> songList = pl2.getSongList();
                            mp3 = new MP3Player(songList);
                            mp3.start();
                        break;
                        case "stop":
                            System.out.println("stop");
                            if(mp3 != null)mp3.stop();
                        break;

                        default:
                            System.out.println("check your spell");
                    }
                }
            }
        }

}

    

