import java.awt.*;
import javax.swing.*;

import ui.HeaderPanel;
import ui.TimerPanel;

public class Main {
    public static void main(String[] args) {
        // GUI dibuat di EDT
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("TaskFlow - Focus Timer");
            frame.setSize(700, 550);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            frame.add(new HeaderPanel(), BorderLayout.NORTH);
            frame.add(new TimerPanel(frame), BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}