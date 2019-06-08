import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class unoServer {
    public static void main(String[] args) {
        int portNumber = 4445;
        try{
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true){

                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket);

                MTClient client = new MTClient(clientSocket);
                client.getThread().start();
                //ClientEcho client = new ClientEcho(clientSocket);
                //client.sendMessage("Hello, from server Anton.");
                System.out.println("sendMessage");
            }
        }catch (IOException ioe){
            System.out.println("IOE "+ioe);
        }
    }
}
