import java.util.Scanner;

public class ShellMusicPlayer {
    

    public static void main(String[] args) {
        System.out.println("Welcome to ShellMusicePlayer!");
        System.out.println("if you want some helps, type \"help\".(no, you don't");

        
        
        // while(scanner.hasNext()){
        //     String str = scanner.nextLine();
        //     System.out.println(str);
        // }

        ConmanLine conmanLine = new ConmanLine();
        DealDispatch dealDispatch = new DealDispatch();
        
        Thread t1 = new Thread(conmanLine);
        Thread t2 = new Thread(dealDispatch);
        
        t1.start();
        t2.start();
        
        // if(t2.isInterrupted())System.out.println("whay");
        // if(t2.isAlive())System.err.println("fsdioa");

        // while(conmanLine.getInput() == null){
        //     System.out.println("fdjasi");
        // }
        // if(conmanLine.getInput() == null){
        //     System.out.println("???");
        // }

    }
}
