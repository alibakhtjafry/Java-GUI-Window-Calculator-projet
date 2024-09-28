// // CalculatorActions.java
// // import javax.swing.*;
// import java.awt.event.*;
// import java.io.FileWriter;
// import java.io.IOException;

// public class CalculatorActions implements ActionListener {
//     CalculatorFrame frame;

//     CalculatorActions(CalculatorFrame frame) {
//         this.frame = frame;
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//       StringBuilder str=new StringBuilder();
//         for (int i = 0; i < 10; i++) {
//             if (e.getSource() == frame.numberButtons[i]) {
//                 frame.textfield.setText(frame.textfield.getText().concat(String.valueOf(i)));
//             }
//         }
//         if (e.getSource() == frame.decButton) {
//             frame.textfield.setText(frame.textfield.getText().concat("."));
//         }
//         if (e.getSource() == frame.buttonadd) {
//             frame.num1 = Double.parseDouble(frame.textfield.getText());
//             frame.operator = '+';
//             frame.textfield.setText("");
//         }
//         if (e.getSource() == frame.buttonSub) {
//             frame.num1 = Double.parseDouble(frame.textfield.getText());
//             frame.operator = '-';
//             frame.textfield.setText("");
//         }
//         if (e.getSource() == frame.buttonMul) {
//             frame.num1 = Double.parseDouble(frame.textfield.getText());
//             frame.operator = '*';
//             frame.textfield.setText("");
//         }
//         if (e.getSource() == frame.buttondivide) {
//             frame.num1 = Double.parseDouble(frame.textfield.getText());
//             frame.operator = '/';
//             frame.textfield.setText("");
//         }

//         if (e.getSource() == frame.equButton) {
//             frame.num2 = Double.parseDouble(frame.textfield.getText());

//             switch (frame.operator) {
//                 case '+':
//                     frame.result = frame.num1 + frame.num2;
//                     break;
//                 case '-':
//                     frame.result = frame.num1 - frame.num2;
//                     break;
//                 case '*':
//                     frame.result = frame.num1 * frame.num2;
//                     break;
//                 case '/':
//                     frame.result = frame.num1 / frame.num2;
//                     break;
//             }
//             frame.textfield.setText(String.valueOf(frame.result));
//             //writting the result along with the str in the file for memory 
//             try (FileWriter writer = new FileWriter("calculation_results.txt", true)) {
//                 writer.write(frame.num1 + " " + frame.operator + " " + frame.num2 + " = " + frame.result + "\n");
//             } catch (IOException ioException) {
//                 ioException.printStackTrace();
//             }
//             frame.num1 = frame.result;
//         }
//         if (e.getSource() == frame.clrButton) {
//             frame.textfield.setText("");
//         }
//         if (e.getSource() == frame.delButton) {
//             String string = frame.textfield.getText();
//             frame.textfield.setText("");
//             for (int i = 0; i < string.length() - 1; i++) {
//                 frame.textfield.setText(frame.textfield.getText() + string.charAt(i));
//             }
//         }
//         if (e.getSource() == frame.buttonCE) {
//             frame.textfield.setText(""); 
//         }        
//         if (e.getSource() == frame.negButton) {
//             double temp = Double.parseDouble(frame.textfield.getText());
//             temp *= -1;
//             frame.textfield.setText(String.valueOf(temp));
//         }
//         if (e.getSource() == frame.buttonPercent) {
//             double temp = Double.parseDouble(frame.textfield.getText());
//             frame.textfield.setText(String.valueOf(temp / 100));
//         }
//         if (e.getSource() == frame.buttonSqrt) {
//             double temp = Double.parseDouble(frame.textfield.getText());
//             frame.textfield.setText(String.valueOf(Math.sqrt(temp)));
//         }
//         if (e.getSource() == frame.buttonfraction) {
//             double temp = Double.parseDouble(frame.textfield.getText());
//             frame.textfield.setText(String.valueOf(1 / temp));
//         }
//         if (e.getSource() == frame.buttonSquare) {
//             double temp = Double.parseDouble(frame.textfield.getText());
//             frame.textfield.setText(String.valueOf(temp * temp));
//         }
//         if (e.getSource() == frame.buttonSign) {
//             double temp = Double.parseDouble(frame.textfield.getText());
//             frame.textfield.setText(String.valueOf(-temp));
//         }

//     }
// }

// CalculatorActions.java
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class CalculatorActions implements ActionListener {
    CalculatorFrame frame;
    StringBuilder str; // StringBuilder to store the str

    CalculatorActions(CalculatorFrame frame) {
        this.frame = frame;
        this.str = new StringBuilder(); // Initialize the StringBuilder
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == frame.numberButtons[i]) {
                frame.textfield.setText(frame.textfield.getText().concat(String.valueOf(i)));
                str.append(i); // Append the number to the str
                frame.smallArea.setText(str.toString());
            }
        }
        if (e.getSource() == frame.decButton) {
            frame.textfield.setText(frame.textfield.getText().concat("."));
            str.append("."); // Append the decimal point to the str

        }
        if (e.getSource() == frame.buttonadd) {
            frame.num1 = Double.parseDouble(frame.textfield.getText());
            frame.operator = '+';
            str.append(" + "); // Append the operator to the str
            frame.smallArea.setText(str.toString());
            frame.textfield.setText("");
        }
        if (e.getSource() == frame.buttonSub) {
            frame.num1 = Double.parseDouble(frame.textfield.getText());
            frame.operator = '-';
            str.append(" - "); // Append the operator to the str
            frame.smallArea.setText(str.toString());
            frame.textfield.setText("");
        }
        if (e.getSource() == frame.buttonMul) {
            frame.num1 = Double.parseDouble(frame.textfield.getText());
            frame.operator = '*';
            str.append(" * "); // Append the operator to the str
            frame.smallArea.setText(str.toString());
            frame.textfield.setText("");
        }
        if (e.getSource() == frame.buttondivide) {
            frame.num1 = Double.parseDouble(frame.textfield.getText());
            frame.operator = '/';
            str.append(" / "); // Append the operator to the str
            frame.smallArea.setText(str.toString());
            frame.textfield.setText("");
        }

        if (e.getSource() == frame.equButton) {
            frame.num2 = Double.parseDouble(frame.textfield.getText());

            switch (frame.operator) {
                case '+':
                    frame.result = frame.num1 + frame.num2;
                    break;
                case '-':
                    frame.result = frame.num1 - frame.num2;
                    break;
                case '*':
                    frame.result = frame.num1 * frame.num2;
                    break;
                case '/':
                    frame.result = frame.num1 / frame.num2;
                    break;
            }

            frame.textfield.setText(String.valueOf(frame.result));
            // Write the result along with the str to the file for memory
            try (FileWriter writer = new FileWriter("calculation_results.txt", true)) {
                writer.write(frame.num1 + " " + frame.operator + " " + frame.num2 + " = " + frame.result + "\n");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            frame.num1 = frame.result;
            str.setLength(0);
            str.append(frame.num1);
        }

        if (e.getSource() == frame.clrButton) {
            frame.textfield.setText("");
            str.setLength(0);
            frame.smallArea.setText(str.toString());
        }

        if (e.getSource() == frame.delButton) {
            String string = frame.textfield.getText();
            frame.textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                frame.textfield.setText(frame.textfield.getText() + string.charAt(i));
            }
            if (str.length() > 0) {
                str.setLength(str.length() - 1); // Remove the last character from the str
                frame.smallArea.setText(str.toString());
            }
        }

        if (e.getSource() == frame.buttonCE) {
            frame.textfield.setText("");
            str.setLength(0); // Clear the str when "CE" is pressed
            frame.smallArea.setText(str.toString());
        }

        if (e.getSource() == frame.negButton) {
            double temp = Double.parseDouble(frame.textfield.getText());
            temp *= -1;
            frame.textfield.setText(String.valueOf(temp));
        }

        if (e.getSource() == frame.buttonPercent) {
            double temp = Double.parseDouble(frame.textfield.getText());
            // str.append(temp).append("%");
            // frame.smallArea.setText(str.toString());
            frame.textfield.setText(String.valueOf(temp / 100));
        }

        if (e.getSource() == frame.buttonSqrt) {
            double temp = Double.parseDouble(frame.textfield.getText());
            frame.textfield.setText(String.valueOf(Math.sqrt(temp)));
        }

        if (e.getSource() == frame.buttonfraction) {
            double temp = Double.parseDouble(frame.textfield.getText());
            frame.textfield.setText(String.valueOf(1 / temp));
        }

        if (e.getSource() == frame.buttonSquare) {
            double temp = Double.parseDouble(frame.textfield.getText());
            frame.textfield.setText(String.valueOf(temp * temp));
        }

        if (e.getSource() == frame.buttonSign) {
            double temp = Double.parseDouble(frame.textfield.getText());
            frame.textfield.setText(String.valueOf(-temp));
        }
    }
}
