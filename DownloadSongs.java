import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadSongs {

    private static String path = "songs/";

    public static void downloadByName(String name) {

        String url = NeteasMusicUrl.getNeteasMusicUrlByName(name);
        String realPath = path + name;

        URL urlo = null;
        try {
            urlo = new URL(url);
            DataInputStream dataInputStream = new DataInputStream(urlo.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(realPath));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }

            fileOutputStream.write(output.toByteArray());
            System.out.println("downloading song " + name + ".............");
            dataInputStream.close();
            fileOutputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ConvertWithFfmpeg.convert("lib/fff/bin/ffmpeg", realPath, realPath + ".mp3");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        DownloadSongs.downloadByName("so sick ");
    }
}
