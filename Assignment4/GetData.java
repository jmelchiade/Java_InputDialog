import javax.swing.*;

public class GetData {
    public static String getWord(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    public static double getDouble(String prompt) {
        String input = JOptionPane.showInputDialog(prompt);
        return Double.parseDouble(input);
    }
}