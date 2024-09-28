import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ScientificActionListener implements ActionListener {
    private Scientific scientific;
    private JTextArea area;
    private JTextArea smallArea;
    private String currentInput = "";
    
    public ScientificActionListener(Scientific scientific) {
        this.scientific = scientific;
        this.area = scientific.area;
        this.smallArea = scientific.smallArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        try {
            if (source == scientific.buttonSqrt) {
                double value = Double.parseDouble(currentInput);
                double result = Math.sqrt(value);
                area.setText(String.valueOf(result));
                smallArea.setText("√" + currentInput);
            } else if (source == scientific.buttonSquare) {
                double value = Double.parseDouble(currentInput);
                double result = Math.pow(value, 2);
                area.setText(String.valueOf(result));
                smallArea.setText(currentInput + "²");
            } else if (source == scientific.buttonSign) {
                double value = Double.parseDouble(currentInput);
                double result = value * -1;
                area.setText(String.valueOf(result));
                smallArea.setText("(-)" + currentInput);
            } else if (source == scientific.buttonFraction) {
                double value = Double.parseDouble(currentInput);
                double result = 1 / value;
                area.setText(String.valueOf(result));
                smallArea.setText("1/" + currentInput);
            } else if (source == scientific.buttonCE) {
                currentInput = "";
                area.setText("");
                smallArea.setText("");
            } else if (source == scientific.buttonLog) {
                double value = Double.parseDouble(currentInput);
                double result = Math.log10(value);
                area.setText(String.valueOf(result));
                smallArea.setText("log(" + currentInput + ")");
            } else if (source == scientific.buttonExp) {
                double value = Double.parseDouble(currentInput);
                double result = Math.exp(value);
                area.setText(String.valueOf(result));
                smallArea.setText("exp(" + currentInput + ")");
            } else if (source == scientific.buttonSin) {
                double value = Double.parseDouble(currentInput);
                double result = Math.sin(Math.toRadians(value));
                area.setText(String.valueOf(result));
                smallArea.setText("sin(" + currentInput + ")");
            } else if (source == scientific.buttonCos) {
                double value = Double.parseDouble(currentInput);
                double result = Math.cos(Math.toRadians(value));
                area.setText(String.valueOf(result));
                smallArea.setText("cos(" + currentInput + ")");
            } else if (source == scientific.buttonTan) {
                double value = Double.parseDouble(currentInput);
                double result = Math.tan(Math.toRadians(value));
                area.setText(String.valueOf(result));
                smallArea.setText("tan(" + currentInput + ")");
            }
        } catch (NumberFormatException ex) {
            area.setText("Error");
            smallArea.setText("");
        }
    }

    public void setCurrentInput(String input) {
        this.currentInput = input;
    }
}
