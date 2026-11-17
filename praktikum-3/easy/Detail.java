import java.awt.*;
import javax.swing.*;

public class Detail extends JPanel{
    private Main mainApp;

    private JPanel panelJudul;
    private JPanel panelDeskripsi;
    private JPanel panelBack;

    private JLabel labelJudul;
    private JLabel labelDeskripsi;
    private JButton btnBack;

    public Detail(Main mainApp){
        this.mainApp = mainApp;

        labelJudul = new JLabel("Detail", SwingConstants.CENTER);
        labelJudul.setFont(Theme.JUDUL);
        labelJudul.setForeground(Theme.BIRU);

        labelDeskripsi = new JLabel("", SwingConstants.CENTER);
        labelDeskripsi.setFont(Theme.NORMAL);
        labelDeskripsi.setForeground(Theme.HITAM);

        btnBack = new JButton("Back");
        btnBack.setFont(Theme.TOMBOL);
        btnBack.setBackground(Theme.BIRU);
        btnBack.setForeground(Theme.PUTIH);
        btnBack.setFocusPainted(false);
        btnBack.setPreferredSize(new Dimension(100, 40));
        btnBack.addActionListener(e -> this.mainApp.bukaPortofolio());   // lambda

        // Tiga panel pembungkus
        panelJudul = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelJudul.setBackground(Theme.PUTIH);
        panelJudul.add(labelJudul);

        panelDeskripsi = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelDeskripsi.setBackground(Theme.PUTIH);
        panelDeskripsi.add(labelDeskripsi);

        panelBack = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBack.setBackground(Theme.PUTIH);
        panelBack.add(btnBack);

        // GridBagLayout: tiga baris, weighty hanya di baris terakhir
        // supaya semua isi menempel ke atas.
        setBackground(Theme.PUTIH);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;

        c.gridy = 0;
        c.weighty = 0;
        c.insets = new Insets(40, 20, 10, 20);
        add(panelJudul, c);

        c.gridy = 1;
        c.insets = new Insets(10, 20, 20, 20);
        add(panelDeskripsi, c);

        c.gridy = 2;
        c.weighty = 1.0;                    // sisa ruang vertikal untuk baris ini
        c.anchor = GridBagConstraints.NORTH; // isi tetap di atas sel
        c.insets = new Insets(10, 20, 10, 20);
        add(panelBack, c);
    }

    // Dipanggil Main setiap kali halaman detail akan dibuka
    public void setDataKeahlian(String judul, String deskripsi) {
        labelJudul.setText("Detail: " + judul);
        // HTML dipakai agar teks panjang otomatis turun baris dan rata tengah
        labelDeskripsi.setText("<html><div style='text-align:center; width:520px;'>"
                + deskripsi + "</div></html>");
    }
}
