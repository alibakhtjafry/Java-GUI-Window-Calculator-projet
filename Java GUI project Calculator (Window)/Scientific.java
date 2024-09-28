import javax.swing.*;
import java.awt.*;

public class Scientific extends JFrame {
    JButton buttonSqrt, buttonSquare, buttonSign, buttonFraction, buttonCE, buttonLog, buttonExp, buttonSin, buttonCos, buttonTan;
    JPanel panel;
    JTextArea area;
    JTextArea smallArea;

    Scientific() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 900);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        // Text areas
        area = new JTextArea();
        area.setEditable(false);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setBackground(Color.black);
        area.setForeground(Color.LIGHT_GRAY);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        add(area);
        area.setBounds(620, 35, 340, 740);

        smallArea = new JTextArea();
        smallArea.setEditable(false);
        smallArea.setBackground(Color.black);
        smallArea.setForeground(Color.LIGHT_GRAY);
        smallArea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        add(smallArea);
        smallArea.setBounds(50, 30, 400, 30);

        // Initialize buttons
        initializeButtons();

        // Panel setup
        panel = new JPanel();
        panel.setBounds(50, 200, 550, 600);
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        panel.setBackground(Color.BLACK);
        add(panel);

        // Display scientific functions
        showScientificFunctions();

        setVisible(true);
    }

    private void initializeButtons() {
        buttonSqrt = new JButton("√");
        buttonSquare = new JButton("x^2");
        buttonSign = new JButton("+/-");
        buttonFraction = new JButton("1/x");
        buttonCE = new JButton("CE");
        buttonLog = new JButton("log");
        buttonExp = new JButton("exp");
        buttonSin = new JButton("sin");
        buttonCos = new JButton("cos");
        buttonTan = new JButton("tan");

        JButton[] scientificButtons = {buttonSqrt, buttonSquare, buttonSign, buttonFraction, buttonCE, buttonLog, buttonExp, buttonSin, buttonCos, buttonTan};

        for (JButton button : scientificButtons) {
            button.setFocusable(false);
            button.setPreferredSize(new Dimension(120, 120));
            button.setForeground(Color.WHITE);
            button.setBackground(Color.DARK_GRAY);
            button.setFont(new Font("Segoe UI", Font.PLAIN, 20));
            button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        }
    }

    public void showScientificFunctions() {
        panel.removeAll();
        panel.setLayout(new GridLayout(5, 4, 5, 5)); // Adjust layout as needed

        // Add scientific buttons
        panel.add(buttonSqrt);
        panel.add(buttonSquare);
        panel.add(buttonSign);
        panel.add(buttonFraction);
        panel.add(buttonLog);
        panel.add(buttonExp);
        panel.add(buttonSin);
        panel.add(buttonCos);
        panel.add(buttonTan);
        panel.add(buttonCE);

        panel.revalidate();
        panel.repaint();
    }
}
