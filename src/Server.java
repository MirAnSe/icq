import java.io.IOException;
//import java.util.Scanner;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
//import java.net.InetAddress;
//import java.net.UnknownHostException;

public class Server  extends Thread{

    private DatagramSocket socket=null;
    private Viewer viewer;
    private boolean moreQuotes = true;

    public Server(String portNumber,Viewer viewer){
        this.viewer=viewer;

        try {
            socket = new DatagramSocket(Integer.parseInt(portNumber));
        }catch (SocketException se){
            System.out.println("SE "+se);
            socket = null;
        }
        start();
    }

    public void run(){

        while (moreQuotes) {

            try {
                byte[] buf = new byte[500];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                buf = packet.getData();

                //socket.reseive(packet);
                socket.receive(packet);
                System.out.println("WAIT");
                String recived = new String(packet.getData(), 0, packet.getLength());
                System.out.println("/" + recived + "/");
                viewer.setText(recived + '\n');
                System.out.println("END");
            } catch (IOException ioe) {
                System.out.println("IOE " + ioe);
                moreQuotes=false;
            }
            //return null;
        }
        socket.close();
    }
/*
    public static void main(String[] args) {
        Server server = new Server("8855");
        server.inMessage();
        //String out=server.inMessage();
        //System.out.println(out);
    }*/
}
