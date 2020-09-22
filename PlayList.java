import java.io.*;
import java.util.*;

public class PlayList {

    
    private String path = "playlists/";
    private File playListFile;
    private BufferedWriter bw;
    private Set<String> nameList;

    public PlayList(String name) {
        
        playListFile = new File(path + name + ".txt");
        
        nameList = new HashSet<>();
        BufferedReader br = null;
        try {
            if(!playListFile.exists())playListFile.createNewFile();
            //Thread.sleep(5000);
            FileReader fr = new FileReader(playListFile);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                nameList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
            //bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(playListFile)));
    }

    public void addSong(String name){
        try{
            bw = new BufferedWriter(new FileWriter(playListFile,true));
            if(!nameList.contains(name)){
                bw.append(name);
                bw.newLine();
                bw.flush();
                nameList.add(name);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    public void removeSong(String name){
        if(!nameList.contains(name)){
            System.out.println("song not found");
            return;
        }
        try{
            nameList.remove(name);
            bw = new BufferedWriter(new FileWriter(playListFile));  
            for(String song:nameList){                                                     
                bw.append(song);
                bw.newLine();
                bw.flush();
            }
                    
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public Set<String> getSongList(){
        return nameList;
    }
    public static void main(String[] args) {
        PlayList pl = new PlayList("new 1");
        pl.addSong("wori");
        pl.addSong("wk");
        
        pl.removeSong("wk");

    }
    
}
