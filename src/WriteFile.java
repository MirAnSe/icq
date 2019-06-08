import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    public static synchronized boolean writeInto(String value){
        File fileName = new File("log/logfile.txt");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            for (int i = 0; i < value.length();i++){
                int c = value.charAt(i);
                out.write(c);
            }
            out.close();
        }catch (IOException ioe){
            return false;
        }

        return true;
    }
}
