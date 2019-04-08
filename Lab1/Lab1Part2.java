
import javax.swing.*;
import java.awt.*;

/*
    need to fix text to ensure it has a full bar and okay button is not stretched, also get okay button and
    text bar on same line
 */
public class Lab1Part2 {
    private JFrame window;
    private JToggleButton bold;
    private JToggleButton italic;
    private JRadioButton times;
    private JRadioButton helvetica;
    private JRadioButton courier;
    private ButtonGroup fonts;
    private JTextField text;
    private JButton ok;
    private Container mainPanel;
    private Container grid1;
    private Container grid2;
    private Container grid3;

    Lab1Part2(String title) {
        run(title);
    }

    public void run(String title) {
        window = new JFrame(title);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

         bold = new JCheckBox("Bold");
         italic = new JCheckBox("Italic");

         times = new JRadioButton("Times");
         helvetica = new JRadioButton("Helvetica");
         courier = new JRadioButton("Courier");

         fonts = new ButtonGroup();
        fonts.add(times);
        fonts.add(helvetica);
        fonts.add(courier);

        text = new JTextField(20);
        ok = new JButton("OK");

         mainPanel = window.getContentPane();
         grid1 = new Container();
         grid2 =  new Container();
         grid3 = new Container();

        mainPanel.setLayout(new GridLayout(1,3));

        grid1.setLayout(new GridLayout(2,1));
        grid2.setLayout(new GridLayout(3,1));
        grid3.setLayout(new FlowLayout());

        mainPanel.add(grid1);
        mainPanel.add(grid2);
        mainPanel.add(grid3);

        grid1.add(bold);
        grid1.add(italic);
        grid2.add(times);
        grid2.add(helvetica);
        grid2.add(courier);
        grid3.add(text);
        grid3.add(ok);

        window.setSize(300,100);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        Lab1Part2 lab1Part2 = new Lab1Part2("Lab 1 Part 2");

    }
}
