import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;



public class ConmanLine implements Runnable {

    private String input = null;

    


    @Override
    public void run() {
        System.out.println("going in cml class run method!");

        // TODO Auto-generated method stub
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                //if(scanner.hasNext()){
                //String line = scanner.nextLine();
                String line = br.readLine();
                ConmandBuffer.conmandQueue.add(line);
                //}
            
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(br != null){
                try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

        
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
    


}
