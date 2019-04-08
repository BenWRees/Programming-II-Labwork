import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab2Part1 extends JFrame {
    private JFrame window;
    private Container mainPanel;
    private JTextField textField;
    private JButton increment;
    private JButton reset;
    private Container flow;
    private Integer counter =0;

    Lab2Part1(String title) {
        run(title);
    }

    public void run(String title) {
        window = new JFrame(title);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel = window.getContentPane();
        mainPanel.setLayout(new GridLayout(2, 1));
        flow = new Container();
        flow.setLayout(new FlowLayout());
        mainPanel.add(flow);

        textField = new JTextField();
        increment = new JButton("Increment");
        reset = new JButton("Reset");

        increment.addActionListener(new ButtonListener(increment, textField));
        reset.addActionListener(new ResetListener(reset, textField));

        flow.add(increment);
        flow.add(reset);
        mainPanel.add(textField);

        window.setSize(400, 150);
        window.setVisible(true);

    }

    public static void main(String[] args) {
        Lab2Part1 lab2Part1 = new Lab2Part1("Lab 2 Part 1");
    }


    class ButtonListener implements ActionListener {
        private JButton button;
        private JTextField textField;
        private int counter = 0;

        ButtonListener(JButton buttonToPass, JTextField textFieldToPass) {
            button = buttonToPass;
            textField = textFieldToPass;

        }

        /**
         * checks if the button
         *
         * @param e {@link ActionEvent} takes an actionListener
         */
        public void actionPerformed(ActionEvent e) {
            //button.addActionListener(new IncrementListener(button, textField, counter++));
            textField.setText(Integer.toString(counter));

        }

    }

    class IncrementListener implements ActionListener {
        private JButton button;
        private JTextField textField;
        private Integer counter;

        IncrementListener(JButton buttonToPass, JTextField textFieldToPass, int counterToPass) {
            button = buttonToPass;
            textField = textFieldToPass;
            counter = counterToPass;
        }

        public void actionPerformed(ActionEvent e) {
            button.addActionListener(new IncrementListener(button, textField, counter++));
            textField.setText(Integer.toString(counter));

        }
    }

    class ResetListener implements ActionListener {
        private JButton button;
        private JTextField textField;
        private int counter;

        ResetListener(JButton buttonToPass, JTextField textFieldToPass) {
            button = buttonToPass;
            textField = textFieldToPass;
            counter = 0;
        }

        public void actionPerformed(ActionEvent e) {
            textField.setText("0");
            counter = 0;

        }
    }
}
