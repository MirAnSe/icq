import java.io.IOException;
import java.net.UnknownHostException;

public class Model {
    Viewer viewer;
    Server server;



    Model(Viewer viewer) {
        this.viewer = viewer;
        server = new Server("8855");

    }

    public void doAction(String value) {

        if (value.equals("Send")) {
            Client client = new Client();
            /*Scanner ob = new Scanner(System.in);
            String message = ob.nextLine();*/


            //Client client = new Client();
            try{
                client.sendMessage("g31-11","8855", viewer.getMessage());
            }catch (NumberFormatException nfe){
                System.out.println("NFE "+nfe);
                //return false;
            }catch (UnknownHostException uhe){
                System.out.println("UHE " + uhe);
                //return false;
            }catch (IOException ioe){
                System.out.println("IOE "+ioe);
                //return false;
            }finally {
               // viewer.updateState();
            }
        }
    }
}