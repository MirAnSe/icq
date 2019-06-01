import java.io.IOException;
import java.util.Scanner;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.InetAddress;
import java.net.UnknownHostException;

//import java.net.SocketException;
public class Client {

    private DatagramSocket socket;
    //private String portt;


    public Client(){

        //this.portt=portt;

        try{
            socket = new DatagramSocket();}
        catch (SocketException e){
            System.out.println("Error socket "+e);
            socket = null;
        }
    }

    public  boolean sendMessage(String hostname, String portNum, String message) throws NumberFormatException,UnknownHostException,IOException{

        try {
            if (socket != null) {

                int port = Integer.parseInt(portNum);

                byte[] buf = message.getBytes();

                InetAddress address = InetAddress.getByName(hostname);
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
                socket.send(packet);
                System.out.println(socket);
            } else {
                return false;
            }
        }finally {
            socket.close();

        }
        /*}catch (NumberFormatException nfe){
            System.out.println("NFE "+nfe);
            return false;
        }catch (UnknownHostException uhe){
            System.out.println("UHE " + uhe);
            return false;
        }catch (IOException ioe){
            System.out.println("IOE "+ioe);
            return false;
        }*/
        return true;
    }
/*
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        String message = ob.nextLine();


        Client client = new Client();
        try{
            client.sendMessage("project-g31","4445", message);
        }catch (NumberFormatException nfe){
            System.out.println("NFE "+nfe);
            //return false;
        }catch (UnknownHostException uhe){
            System.out.println("UHE " + uhe);
            //return false;
        }catch (IOException ioe){
            System.out.println("IOE "+ioe);
            //return false;
        }
    }*/
}
