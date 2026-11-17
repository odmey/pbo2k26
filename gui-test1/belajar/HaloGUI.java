import java.awt.*;
import javax.swing.*;

public class HaloGUI {
        public static void main(String[] args) {
        JFrame frame = new JFrame("Demo Atomic");
        frame.setLayout(new FlowLayout());

        JButton tombol = new JButton("Save");
        tombol.setFont(new Font("Arial", Font.BOLD, 10));
        tombol.setForeground(Color.BLUE);

        JTextField text = new JTextField(10);
        text.setText("Halo");
        text.setEnabled(true);      // kolom tidak bisa diketik

        frame.add(tombol);
        frame.add(text);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
