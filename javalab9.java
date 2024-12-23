import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class javalab9 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Division Calculator");
        JTextField num1Field = new JTextField(10);
        JTextField num2Field = new JTextField(10);
        JTextField resultField = new JTextField(10);
        resultField.setEditable(false);
        JButton divideButton = new JButton("Divide");

        divideButton.addActionListener((ActionEvent e) -> {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());
                int result = num1 / num2;
                resultField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(frame, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Num1:"));
        frame.add(num1Field);
        frame.add(new JLabel("Num2:"));
        frame.add(num2Field);
        frame.add(divideButton);
        frame.add(new JLabel("Result:"));
        frame.add(resultField);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
