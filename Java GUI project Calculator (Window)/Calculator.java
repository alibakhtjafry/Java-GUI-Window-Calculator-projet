// Calculator.java
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorFrame calcFrame = new CalculatorFrame();
            calcFrame.setVisible(true);
        });
    }
}
