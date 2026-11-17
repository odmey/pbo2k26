import java.awt.*;
import javax.swing.*;

public class Portofolio extends JPanel {
    private Main mainApp;

    private JPanel panelWelcome;
    private JPanel panelKeahlian;
    private JPanel panelRowKeahlian;
    private JPanel panelContact;

    private JLabel labelWelcome;
    private JLabel labelSubjudul;

    private JButton btnCoding;
    private JButton btnPM;
    private JButton btnWriting;
    private JButton btnContact;

    public Portofolio(Main mainApp) {
        this.mainApp = mainApp;

        setLayout(new BorderLayout(0, 10));
        setBackground(Theme.PUTIH);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 20, 30));

        // --- NORTH: judul sambutan
        labelWelcome = new JLabel("Selamat Datang di Portofolio Saya", SwingConstants.CENTER);
        labelWelcome.setFont(Theme.JUDUL);
        labelWelcome.setForeground(Theme.BIRU);
        panelWelcome = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelWelcome.setBackground(Theme.PUTIH);
        panelWelcome.add(labelWelcome);

        // --- CENTER: subjudul + tiga kotak keahlian
        labelSubjudul = new JLabel("Daftar Keahlian", SwingConstants.CENTER);
        labelSubjudul.setFont(Theme.SUBJUDUL);
        labelSubjudul.setForeground(Theme.HITAM);

        btnCoding  = buatTombolKeahlian("Coding");
        btnPM      = buatTombolKeahlian("Project Management");
        btnWriting = buatTombolKeahlian("Writing");

        btnCoding.addActionListener(e -> this.mainApp.bukaDetailKeahlian("Coding",
                "Terbiasa membangun aplikasi dengan Java, termasuk antarmuka Swing dan penerapan konsep OOP."));
        btnPM.addActionListener(e -> this.mainApp.bukaDetailKeahlian("Management",
                "Berpengalaman merencanakan sprint, membagi tugas tim, dan memantau progres proyek perangkat lunak."));
        btnWriting.addActionListener(e -> this.mainApp.bukaDetailKeahlian("Writing",
                "Mampu menulis dokumentasi teknis dan laporan praktikum yang ringkas serta mudah dipahami."));

        panelRowKeahlian = new JPanel(new GridLayout(1, 3, 15, 0));
        panelRowKeahlian.setBackground(Theme.PUTIH);
        panelRowKeahlian.add(btnCoding);
        panelRowKeahlian.add(btnPM);
        panelRowKeahlian.add(btnWriting);

        panelKeahlian = new JPanel(new BorderLayout(0, 10));
        panelKeahlian.setBackground(Theme.PUTIH);
        panelKeahlian.add(labelSubjudul, BorderLayout.NORTH);
        panelKeahlian.add(panelRowKeahlian, BorderLayout.CENTER);

        // --- SOUTH: tombol kontak
        btnContact = new JButton("Contact Me");
        btnContact.setFont(Theme.TOMBOL);
        btnContact.setBackground(Theme.BIRU);
        btnContact.setForeground(Theme.PUTIH);
        btnContact.setFocusPainted(false);
        btnContact.setPreferredSize(new Dimension(165, 40));
        btnContact.addActionListener(e -> tampilkanDialogKontak());

        panelContact = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelContact.setBackground(Theme.PUTIH);
        panelContact.add(btnContact);

        add(panelWelcome, BorderLayout.NORTH);
        add(panelKeahlian, BorderLayout.CENTER);
        add(panelContact, BorderLayout.SOUTH);
    }

    // Tombol kotak: latar putih, garis tepi biru tebal, teks biru
    private JButton buatTombolKeahlian(String teks) {
        JButton b = new JButton(teks);
        b.setFont(Theme.TOMBOL);
        b.setBackground(Theme.PUTIH);
        b.setForeground(Theme.BIRU);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(Theme.BIRU, 3));
        return b;
    }

    // Dialog modal "Kontak" (JDialog buatan sendiri)
    private void tampilkanDialogKontak() {
        JDialog dialog = new JDialog(mainApp, "Kontak", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel pesan = new JLabel("Nomor Kontak: +62 812-3456-7890", SwingConstants.CENTER);
        pesan.setFont(Theme.NORMAL);

        JButton ok = new JButton("OK");
        ok.setFont(Theme.TOMBOL);
        ok.setBackground(Theme.BIRU);
        ok.setForeground(Theme.PUTIH);
        ok.setPreferredSize(new Dimension(80, 40));
        ok.addActionListener(e -> dialog.dispose());

        JPanel panelOk = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelOk.setBackground(Theme.PUTIH);
        panelOk.add(ok);

        JPanel isi = new JPanel(new BorderLayout(0, 20));
        isi.setBackground(Theme.PUTIH);
        isi.setBorder(BorderFactory.createEmptyBorder(35, 30, 20, 30));
        isi.add(pesan, BorderLayout.CENTER);
        isi.add(panelOk, BorderLayout.SOUTH);

        dialog.getContentPane().add(isi);
        dialog.setSize(430, 230);
        dialog.setLocationRelativeTo(mainApp);
        dialog.setVisible(true);   // modal: program menunggu sampai dialog ditutup
    }
}
