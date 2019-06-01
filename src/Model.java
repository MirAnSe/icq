import java.io.IOException;
import java.net.UnknownHostException;

public class Model {
    Viewer viewer;

    Client client;


    Model(Viewer viewer) {
        this.viewer = viewer;
        client = new Client();


    }

    public void doAction(String value) {

        if (value.equals("Send")) {
            /*Scanner ob = new Scanner(System.in);
            String message = ob.nextLine();*/


            //Client client = new Client();
            try{
                client.sendMessage("project-g31","4445", viewer.getMessage());
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
                viewer.updateState();
            }
        }
    }
}