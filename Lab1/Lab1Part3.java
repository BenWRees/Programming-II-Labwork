import javax.swing.*;
import java.awt.*;

public class Lab1Part3 {

    private JFrame window;
    private JToggleButton bold;
    private JToggleButton italic;
    private String[] font = {"Times", "Helvetica", "Courier"};
    private JComboBox<String> fonts;
    private JTextField text;
    private JButton ok;
    private Container mainPanel;
    private Container grid1;
    private Container grid2;
    private Container grid3;

    Lab1Part3(String title) {
        run(title);
    }

    public void run(String title) {
        window = new JFrame(title);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        bold = new JCheckBox("Bold");
        italic = new JCheckBox("Italic");

        fonts = new JComboBox<String>(font);
        fonts.setSelectedIndex(2);

        text = new JTextField(20);
        ok = new JButton("OK");

        mainPanel = window.getContentPane();
        grid1 = new Container();
        grid2 = new Container();
        grid3 = new Container();

        mainPanel.setLayout(new GridLayout(1, 3));

        grid1.setLayout(new GridLayout(2, 1));
        grid2.setLayout(new GridLayout(3, 1));
        grid3.setLayout(new FlowLayout());

        mainPanel.add(grid1);
        mainPanel.add(grid2);
        mainPanel.add(grid3);

        grid1.add(bold);
        grid1.add(italic);
        grid2.add(fonts);
        grid3.add(text);
        grid3.add(ok);

        window.setSize(300, 100);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        Lab1Part3 lab1Part3 = new Lab1Part3("Font Chooser");
    }
}
