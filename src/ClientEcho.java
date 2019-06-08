import java.net.Socket;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ClientEcho extends Thread {
    PrintWriter out;
    BufferedReader in;
    Socket clientSocket;

    public  ClientEcho (Socket clientSocket){
        this.clientSocket=clientSocket;
        start();
    }

    public void sendMessage(String message){
        try{
            String text = in.readLine();
            System.out.println("Message: "+text);
            out.println(message + " "+text);
        }catch (IOException ioe){

        }
    }

    public void run() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
            in = new BufferedReader(inputStreamReader);
            out = new PrintWriter(clientSocket.getOutputStream(),true);
        }catch (IOException ioe){
            System.out.println("IOE "+ioe);
        }
    }
}