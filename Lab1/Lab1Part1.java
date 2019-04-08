import javax.swing.*;
import java.awt.*;
/*
    need to work out how to properly implement all the code in the main method, into the class 'Lab1.Lab1Part1'
 */
public class Lab1Part1 extends JFrame {

    private JFrame window;
    private Container mainPanel;
    private JButton submit = new JButton("Submit");
    private JButton cancel = new JButton("Cancel");
    private JTextField text = new JTextField(20);
    private Container flow;

    Lab1Part1(String title) {
        run(title);
    }

    void run(String title) {
        window = new JFrame(title);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel = window.getContentPane();
        mainPanel.setLayout(new BorderLayout());
        flow = new Container();

        //can't use grid layout as component will stretch to fill grid which we don't want
        mainPanel.add(text, BorderLayout.NORTH);
        mainPanel.add(flow, BorderLayout.CENTER);
        flow.setLayout(new FlowLayout());

        flow.add(submit);
        flow.add(cancel);

        window.setSize(400,200);
        window.setVisible(true);
    }

    public static void main(String[] args) {

        Lab1Part1 part1 = new Lab1Part1("Simple Submit Cancel Form");

    }

}
