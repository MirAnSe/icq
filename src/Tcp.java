import java.io.*;
import java.net.*;

public class Tcp{

    //Viewer viewer;
    //String hostName;
    //int port;

    Tcp(int port,String hostName, Viewer viewer){
        //this.viewer = viewer;
        //this.hostName = hostName;
        //this.port = port;
        //inMsg();
        //start();
        //sendMsg();
        try(
                Socket echoSocket = new Socket(hostName,port);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))

        ){
            String userInput;
            viewer.setText(in.readLine());
            while((userInput = stdIn.readLine()) != null){
                out.println(userInput);
                viewer.setText(in.readLine());
                System.out.println(in.readLine());
            }
        }catch (UnknownHostException uhe){
            System.out.println("UHE "+uhe);
        }catch (IOException ioe){
            System.out.println("ioe "+ioe);
        }
    }

    public void sendMsg(){

    }
/*
    public void run() {
        //while (true){
            try(
                    Socket echoSocket = new Socket(hostName,port);
                    PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))

            ){
                String userInput;
                //viewer.setText(in.readLine());
                while((userInput = stdIn.readLine()) != null){
                    out.println(userInput);
                    viewer.setText(in.readLine());
                    System.out.println(in.readLine());
                }
            }catch (UnknownHostException uhe){
                System.out.println("UHE "+uhe);
            }catch (IOException ioe){
                System.out.println("ioe "+ioe);
            }
        //}
    }*/
}