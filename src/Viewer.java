import javax.naming.ldap.Control;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Viewer {

    Controller controller = new Controller(this);
    JTextField field;
    JTextArea area;

    Viewer(){
        JFrame frame = new JFrame("ICQ ver0.1");
        frame.setSize(440,700);

        field = new JTextField();
        field.setBounds(10,10,400,40);

        area = new JTextArea();
        //area.setBounds(10,60,400,200);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(10,60,400,200);

        JButton button1 = new JButton("Send");
        button1.setBounds(310,270,100,40);
        button1.addActionListener(controller);
        button1.setActionCommand("Send");

        JTextArea area2 = new JTextArea();
        area2.setBounds(10,320,400,200);

        JButton button2 = new JButton("Clear");
        button2.setBounds(310,530,100,40);

        frame.add(field);
        frame.add(scroll);
        frame.add(button1);
        frame.add(area2);
        frame.add(button2);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void updateState(){

    }

    public String getMessage(){
        String text=field.getText();
        area.setText(area.getText()+'\n'+text);
        field.setText("");
        return text;
    }
}
