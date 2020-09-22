import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class ConmandBuffer {
    public static volatile String conmand = null;
    public static Queue<String> conmandQueue = new ArrayBlockingQueue<>(1);

}
