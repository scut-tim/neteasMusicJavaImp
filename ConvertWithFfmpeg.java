import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConvertWithFfmpeg {
    public static void convert(String ffmpegPath, String source, String dest) throws IOException {
        // 构建命令
        List<String> command = new ArrayList<>();
        command.add(ffmpegPath);
        command.add("-i");
        command.add(source);
        command.add(dest);
        // 执行操作
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();
        InputStream errorStream = process.getErrorStream();
        InputStreamReader isr = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
        }
        if (br != null) {
            br.close();
        }
        if (isr != null) {
            isr.close();
        }
        if (errorStream != null) {
            errorStream.close();
        }
    }


    public static void main(String[] args) throws IOException {

        // ConvertWithFfmpeg.videoConvert("D:\\cfys\\java\\code\\cmdmusicplayer\\lib\\fff\\bin\\ffmpeg.exe", 
        // "D:\\cfys\\java\\code\\cmdmusicplayer\\阿猫阿狗.m4a", 
        // "D:\\cfys\\java\\code\\cmdmusicplayer\\阿猫阿狗.mp3");

        ConvertWithFfmpeg.convert("lib/fff/bin/ffmpeg","阿猫阿狗", "阿猫阿狗.mp3");
        
        //ConvertWithFfmpeg.convert("D:\\cfys\\java\\code\\cmdmusicplayer\\阿猫阿狗.m4a", "D:\\cfys\\java\\code\\cmdmusicplayer\\阿猫阿狗.mp3");
    }
}
