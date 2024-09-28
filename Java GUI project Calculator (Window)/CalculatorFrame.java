import javax.swing.*;
// import javax.swing.border.Border;
// import javax.swing.plaf.ButtonUI;

import java.awt.*;

public class CalculatorFrame extends JFrame {
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[15];
    JButton buttonadd, buttonSub, buttonMul, buttondivide;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JButton buttonPercent, buttonfraction, buttonSqrt, buttonSquare, buttonSign,buttonCE;
    JPanel panel;
    //for menue bar
    JMenuBar menuBar;
    JMenu history,scientificOptions;
    JMenuItem viewHistory,showScientific;
    JTextArea area;
    JTextArea smallArea;
    
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    
    CalculatorFrame() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 900);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        //test area
        area=new JTextArea();
        area.setEditable(false);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setBackground(Color.black);
        area.setForeground(Color.LIGHT_GRAY);
        area.setFont(new Font("Segoe UI", Font.PLAIN,20));
        add(area);
        area.setBounds(620, 35, 340, 740);
        setVisible(true);

        textfield = new JTextField();
        textfield.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        textfield.setBounds(50, 60, 550, 130);
        textfield.setEditable(false);
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.WHITE);
        textfield.setFont(new Font("SansSerif", Font.BOLD, 45));
        String text=textfield.getText();
        textfield.setText("  "+text);
        //for menu bar at the top
        menuBar=new JMenuBar();
        history=new JMenu("History");
        viewHistory=new JMenuItem("View History");
        scientificOptions=new JMenu("Scientific Functions");
        showScientific=new JMenuItem("Show Funtions");

        //For smaller text area
        smallArea=new JTextArea();
        smallArea.setEditable(false);
        smallArea.setBackground(Color.black);
        smallArea.setForeground(Color.LIGHT_GRAY);
        smallArea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        add(smallArea);
        smallArea.setBounds(50, 30, 400, 30);

        

        buttonadd = new JButton("+");
        buttonSub = new JButton("-");
        buttonMul = new JButton("x");
        buttondivide = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("\u00D7");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");
        buttonPercent = new JButton("%");
        buttonSqrt = new JButton("√ ");
        buttonfraction = new JButton("1/x");
        buttonSquare = new JButton("x^2");
        buttonSign = new JButton("+/-");
        buttonCE=new JButton("CE");


        functionButtons[0] = buttonadd;
        functionButtons[1] = buttonSub;
        functionButtons[2] = buttonMul;
        functionButtons[3] = buttondivide;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = buttonPercent;
        functionButtons[10] = buttonSqrt;
        functionButtons[11] = buttonfraction;
        functionButtons[12] = buttonSquare;
        functionButtons[13] = buttonSign;
        functionButtons[14] = buttonCE;

        //for menue adding in frame
        menuBar.add(history);
        menuBar.add(scientificOptions);
        history.add(viewHistory);
        scientificOptions.add(showScientific);
        setJMenuBar(menuBar);
        history.setFont(new Font("Segoe UI", Font.BOLD, 15));
        viewHistory.setFont(new Font("Segoe UI", Font.BOLD, 15));
        scientificOptions.setFont(new Font("Segoe UI", Font.BOLD, 15));
        showScientific.setFont(new Font("Segoe UI", Font.BOLD, 15));
        setVisible(true);

        CalculatorActions actionHandler = new CalculatorActions(this);
        viewHistory.addActionListener(new viewHistoryListener(area));

        for (int i = 0; i < 15; i++) {
            functionButtons[i].addActionListener(actionHandler);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setPreferredSize(new Dimension(160,160));
            functionButtons[i].setForeground(Color.WHITE);
            functionButtons[i].setBackground(Color.DARK_GRAY);
            functionButtons[i].setFont(new Font("Segoe UI", Font.PLAIN, 23));
            functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            if(i==5){
            functionButtons[i].setFont(new Font("Segoe UI", Font.PLAIN, 35));
            functionButtons[i].setBackground(new Color(100, 149, 237));  
            functionButtons[i].setForeground(Color.BLACK);
            functionButtons[i].setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237)));
            }
        }
        
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(actionHandler);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(new Font("SansSerif", Font.BOLD, 20));
            numberButtons[i].setBackground(Color.gray);
        }
        
        panel = new JPanel();
        panel.setBounds(50, 200, 550, 600);
        panel.setLayout(new GridLayout(6, 5, 5, 5));
        panel.setBackground(Color.BLACK);
        panel.add(buttonPercent);
        panel.add(buttonCE);
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(buttonfraction);
        panel.add(buttonSqrt);
        panel.add(buttonSquare);
        panel.add(buttondivide);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(buttonMul);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(buttonSub);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(buttonadd);
        panel.add(buttonSign);
       panel.add(numberButtons[0]);
       panel.add(decButton);
        panel.add(equButton);
        
        add(panel);
        add(textfield);

    }
}
// import javax.swing.*;
// import java.awt.*;

// public class CalculatorFrame extends JFrame {
//     JTextField textfield;
//     JButton[] numberButtons = new JButton[10];
//     JButton[] functionButtons = new JButton[15];
//     JButton buttonadd, buttonSub, buttonMul, buttondivide;
//     JButton decButton, equButton, delButton, clrButton, negButton;
//     JButton buttonPercent, buttonfraction, buttonSqrt, buttonSquare, buttonSign, buttonCE;
//     JPanel panel;
//     JMenuBar menuBar;
//     JMenu history, scientificOptions;
//     JMenuItem viewHistory, showScientific;
//     JTextArea area;
//     JTextArea smallArea;
    
//     double num1 = 0, num2 = 0, result = 0;
//     char operator;
    
//     private Scientific scientificCalculator; // Instance of the Scientific calculator
//     private boolean isScientific = false;    // Flag to track if the scientific calculator is displayed

//     CalculatorFrame() {
//         setTitle("Calculator");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setSize(1000, 900);
//         setLayout(null);
//         getContentPane().setBackground(Color.BLACK);

//         // Test area
//         area = new JTextArea();
//         area.setEditable(false);
//         area.setWrapStyleWord(true);
//         area.setLineWrap(true);
//         area.setBackground(Color.black);
//         area.setForeground(Color.LIGHT_GRAY);
//         area.setFont(new Font("Segoe UI", Font.PLAIN, 20));
//         add(area);
//         area.setBounds(620, 35, 340, 740);
        
//         // Smaller text area
//         smallArea = new JTextArea();
//         smallArea.setEditable(false);
//         smallArea.setBackground(Color.black);
//         smallArea.setForeground(Color.LIGHT_GRAY);
//         smallArea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
//         add(smallArea);
//         smallArea.setBounds(50, 30, 400, 30);

//         // Textfield setup
//         textfield = new JTextField();
//         textfield.setBorder(BorderFactory.createLineBorder(Color.WHITE));
//         textfield.setBounds(50, 60, 550, 130);
//         textfield.setEditable(false);
//         textfield.setBackground(Color.BLACK);
//         textfield.setForeground(Color.WHITE);
//         textfield.setFont(new Font("SansSerif", Font.BOLD, 45));
//         String text = textfield.getText();
//         textfield.setText("  " + text);

//         // Initialize buttons
//         initializeButtons();

//         // Set up the panel
//         panel = new JPanel();
//         panel.setBounds(50, 200, 550, 600);
//         panel.setLayout(new GridLayout(6, 5, 5, 5));
//         panel.setBackground(Color.BLACK);
//         addBasicButtonsToPanel();

//         add(panel);
//         add(textfield);

//         // Initialize menu bar
//         initializeMenuBar();

//         // Set the default visibility
//         setVisible(true);
//     }

//     private void initializeButtons() {
//         buttonadd = new JButton("+");
//         buttonSub = new JButton("-");
//         buttonMul = new JButton("x");
//         buttondivide = new JButton("÷");
//         decButton = new JButton(".");
//         equButton = new JButton("=");
//         delButton = new JButton("\u00D7");
//         clrButton = new JButton("C");
//         negButton = new JButton("(-)");
//         buttonPercent = new JButton("%");
//         buttonSqrt = new JButton("√ ");
//         buttonfraction = new JButton("1/x");
//         buttonSquare = new JButton("x^2");
//         buttonSign = new JButton("+/-");
//         buttonCE = new JButton("CE");

//         functionButtons[0] = buttonadd;
//         functionButtons[1] = buttonSub;
//         functionButtons[2] = buttonMul;
//         functionButtons[3] = buttondivide;
//         functionButtons[4] = decButton;
//         functionButtons[5] = equButton;
//         functionButtons[6] = delButton;
//         functionButtons[7] = clrButton;
//         functionButtons[8] = negButton;
//         functionButtons[9] = buttonPercent;
//         functionButtons[10] = buttonSqrt;
//         functionButtons[11] = buttonfraction;
//         functionButtons[12] = buttonSquare;
//         functionButtons[13] = buttonSign;
//         functionButtons[14] = buttonCE;

//         for (int i = 0; i < 15; i++) {
//             functionButtons[i].setFocusable(false);
//             functionButtons[i].setPreferredSize(new Dimension(160, 160));
//             functionButtons[i].setForeground(Color.WHITE);
//             functionButtons[i].setBackground(Color.DARK_GRAY);
//             functionButtons[i].setFont(new Font("Segoe UI", Font.PLAIN, 23));
//             functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//             if (i == 5) {
//                 functionButtons[i].setFont(new Font("Segoe UI", Font.PLAIN, 35));
//                 functionButtons[i].setBackground(new Color(100, 149, 237));
//                 functionButtons[i].setForeground(Color.BLACK);
//                 functionButtons[i].setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237)));
//             }
//         }

//         for (int i = 0; i < 10; i++) {
//             numberButtons[i] = new JButton(String.valueOf(i));
//             numberButtons[i].setFocusable(false);
//             numberButtons[i].setFont(new Font("SansSerif", Font.BOLD, 20));
//             numberButtons[i].setBackground(Color.gray);
//         }
//     }

//     private void addBasicButtonsToPanel() {
//         panel.removeAll();
//         panel.add(buttonPercent);
//         panel.add(buttonCE);
//         panel.add(clrButton);
//         panel.add(delButton);
//         panel.add(buttonfraction);
//         panel.add(buttonSqrt);
//         panel.add(buttonSquare);
//         panel.add(buttondivide);
//         panel.add(numberButtons[7]);
//         panel.add(numberButtons[8]);
//         panel.add(numberButtons[9]);
//         panel.add(buttonMul);
//         panel.add(numberButtons[4]);
//         panel.add(numberButtons[5]);
//         panel.add(numberButtons[6]);
//         panel.add(buttonSub);
//         panel.add(numberButtons[1]);
//         panel.add(numberButtons[2]);
//         panel.add(numberButtons[3]);
//         panel.add(buttonadd);
//         panel.add(buttonSign);
//         panel.add(numberButtons[0]);
//         panel.add(decButton);
//         panel.add(equButton);
//         panel.revalidate();
//         panel.repaint();
//     }

//     private void initializeMenuBar() {
//         menuBar = new JMenuBar();
//         history = new JMenu("History");
//         viewHistory = new JMenuItem("View History");
//         scientificOptions = new JMenu("Scientific Functions");
//         showScientific = new JMenuItem("Show Functions");

//         menuBar.add(history);
//         menuBar.add(scientificOptions);
//         history.add(viewHistory);
//         scientificOptions.add(showScientific);
//         setJMenuBar(menuBar);

//         // Set font for menu items
//         history.setFont(new Font("Segoe UI", Font.BOLD, 15));
//         viewHistory.setFont(new Font("Segoe UI", Font.BOLD, 15));
//         scientificOptions.setFont(new Font("Segoe UI", Font.BOLD, 15));
//         showScientific.setFont(new Font("Segoe UI", Font.BOLD, 15));

//         // Add action listeners
//         viewHistory.addActionListener(new viewHistoryListener(area));
//         showScientific.addActionListener(e -> {
//             if (!isScientific) {
//                 if (scientificCalculator == null) {
//                     scientificCalculator = new Scientific(); // Create the scientific calculator instance
//                 }
//                 scientificCalculator.setVisible(true);  // Show the scientific calculator
//                 this.setVisible(false); // Hide the basic calculator
//                 isScientific = true; // Update the flag
//             }
//         });
//     }
// }
