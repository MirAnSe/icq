import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MTClient implements Runnable{

    private Thread thread;
    PrintWriter out;
    BufferedReader in;
    //Socket clientSocket;


    public MTClient(Socket clientSocket){
        thread = new Thread(this);

        //InputStreamReader inputStreamReader =null;
        try {
            //InputStreamReader inputStreamReader = ;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(),true);
        }catch (IOException ioe){
            System.out.println("IOE "+ioe);
        }
        //this.clientSocket=clientSocket;
    }

    public Thread getThread() {
        return thread;
    }

    public void run(){
        System.out.println("Start.");
        try{
            String text = in.readLine();
            WriteFile.writeInto(text);
            System.out.println("Message: "+text);
            out.println("Hello from Server Anton: "+text);
        }catch (IOException ioe){

        }finally {
            try{
                in.close();
                out.close();
                System.out.println("Close");
            }catch (IOException ioe){

            }
        }
        System.out.println("End.");
    }
}
