import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel containerHalaman;
    private Portofolio portofolioPanel;
    private Detail detailKeahlianPanel;

    public Main() {
        super("Portofolio Saya");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 560);
        setLocationRelativeTo(null);

        // CardLayout: dua "kartu" halaman, hanya satu yang tampil
        cardLayout = new CardLayout();
        containerHalaman = new JPanel(cardLayout);

        portofolioPanel = new Portofolio(this);        // "membuat" (komposisi)
        detailKeahlianPanel = new Detail(this);

        containerHalaman.add(portofolioPanel, "PORTOFOLIO");
        containerHalaman.add(detailKeahlianPanel, "DETAIL");

        getContentPane().add(containerHalaman);
        cardLayout.show(containerHalaman, "PORTOFOLIO");
    }

    public void bukaDetailKeahlian(String judul, String deskripsi) {
        detailKeahlianPanel.setDataKeahlian(judul, deskripsi);
        cardLayout.show(containerHalaman, "DETAIL");
    }

    public void bukaPortofolio() {
        cardLayout.show(containerHalaman, "PORTOFOLIO");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}