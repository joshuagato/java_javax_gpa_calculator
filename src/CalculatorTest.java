import javax.swing.*;
import javax.swing.UIManager.*;

public class CalculatorTest {

    public static void main(String[] args) {

        try {
            //Set System l&F
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            for (LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }


        CalculatorFrame calculatorFrame = new CalculatorFrame();
        calculatorFrame.setSize(600,750);
        calculatorFrame.setVisible(true);
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
