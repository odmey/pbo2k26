import java.awt.*;
import javax.swing.*;
public class Contoh10 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh Grid Bag Layout");
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        frame.getContentPane().setLayout(layout);
        c.fill = GridBagConstraints.HORIZONTAL;

        JButton btn1 = new JButton("Tombol 1");
        c.gridx = 0; c.gridy = 0;
        layout.setConstraints(btn1, c);
        frame.getContentPane().add(btn1);

        JButton btn2 = new JButton("Tombol 2");
        c.gridx = 1; c.gridy = 0;
        layout.setConstraints(btn2, c);
        frame.getContentPane().add(btn2);

        JButton btn3 = new JButton("Tombol 3");
        c.ipady = 30;          // tinggi ditambah 30 px
        c.gridwidth = 2;       // menempati 2 kolom
        c.gridx = 0; c.gridy = 1;
        layout.setConstraints(btn3, c);
        frame.getContentPane().add(btn3);

        JButton btn4 = new JButton("Tombol 4");
        c.ipady = 50;          // tinggi ditambah 50 px
        c.gridwidth = 1;       // kembali 1 kolom
        c.gridx = 0; c.gridy = 2;
        layout.setConstraints(btn4, c);
        frame.getContentPane().add(btn4);

        JButton btn5 = new JButton("Tombol 5");
        c.ipady = 0;           // tinggi normal
        c.gridwidth = 1;
        c.gridx = 1; c.gridy = 2;
        c.insets = new Insets(10, 0, 0, 0);       // top, left, bottom, right
        c.anchor = GridBagConstraints.SOUTH;      // menempel di bawah
        layout.setConstraints(btn5, c);
        frame.getContentPane().add(btn5);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}