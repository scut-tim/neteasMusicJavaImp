import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2017-10-30
 * Time: 15:33
 */
public class BiliiiiiiliantCode {
    enum Command{
        ADD,SUBTRACT
    }
    private static AtomicInteger val = new AtomicInteger(0);

    private static volatile Command state = Command.ADD;

    static Queue<Command> commandQueue = new ArrayBlockingQueue<>(1);

    static Thread commandThread = new Thread(new Runnable() {
        @Override
        public void run() {
            BufferedReader br = null;

            try {
                br = new BufferedReader(new InputStreamReader(System.in));

                while (true) {

                    System.out.print("Enter something");
                    String input = br.readLine();
                    switch (input){
                        case "add":
                            commandQueue.add(Command.ADD);
                            break;
                        case "subtract":
                            commandQueue.add(Command.SUBTRACT);
                    }
                    System.out.println("input: " + input);
                    System.out.println("-----------\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    });

    static Thread outputThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true) {
                if (!commandQueue.isEmpty()) {
                    state = commandQueue.poll();
                }
                switch (state) {
                    case ADD:
                        System.out.println(val.addAndGet(1));
                        break;
                    case SUBTRACT:
                        System.out.println(val.addAndGet(-1));
                        break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    });

    public static void main(String[] args) {
        commandThread.start();
        outputThread.start();
    }
}
