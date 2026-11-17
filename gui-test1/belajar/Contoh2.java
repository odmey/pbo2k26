import javax.swing.*;
public class Contoh2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JOptionPane.showConfirmDialog(frame,
            "Contoh dialog konfirmasi ...",   // pesan
            "Judul Dialog",                   // judul
            JOptionPane.OK_CANCEL_OPTION,     // jenis tombol
            JOptionPane.QUESTION_MESSAGE);    // icon

        // int result = JOptionPane.showConfirmDialog(frame,
        //     "Contoh dialog konfirmasi ...", "Judul Dialog",
        //     JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        // String message;
        // if (result == JOptionPane.OK_OPTION){
        //     message = "Anda memilih ok";}
        // else if (result == JOptionPane.CANCEL_OPTION)
        //     message = "Anda memilih cancel";
        // else
        //     message = "Anda tidak memilih apapun";   // dialog ditutup lewat X

        // JOptionPane.showMessageDialog(frame, message, "Pilihan Anda",
        //         JOptionPane.INFORMATION_MESSAGE);
            
        }
}