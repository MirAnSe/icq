import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Viewer {
    Viewer(){
        JFrame frame = new JFrame("ICQ ver0.1");
        frame.setSize(440,700);

        JTextField field = new JTextField();
        field.setBounds(10,10,400,40);

        JTextArea area = new JTextArea();
        //area.setBounds(10,60,400,200);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(10,60,400,200);

        JButton button1 = new JButton("Send");
        button1.setBounds(310,270,100,40);

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
}
