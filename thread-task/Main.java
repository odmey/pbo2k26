import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TaskFlow - Focus Timer");
        frame.setSize(700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        frame.add(new HeaderPanel(), BorderLayout.NORTH);
        frame.add(new TimerPanel(), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}