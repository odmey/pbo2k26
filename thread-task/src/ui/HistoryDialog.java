package ui;

import java.awt.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import db.Session;
import db.SessionDAO;

// Dialog riwayat sesi: lihat (Read), ubah (Update), hapus (Delete).
// Semua akses DB jalan di thread terpisah, lalu UI diperbarui lewat invokeLater.
public class HistoryDialog extends JDialog {
    private final SessionDAO dao = new SessionDAO();

    private final DefaultTableModel model = new DefaultTableModel(
            new String[] {"ID", "Sesi", "Menit", "Selesai"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable table = new JTable(model);

    private final JButton buttonEdit = new JButton("Edit");
    private final JButton buttonDelete = new JButton("Delete");
    private final JButton buttonRefresh = new JButton("Refresh");
    private final JLabel labelStatus = new JLabel(" ");

    // Satu aksi DB (update / delete) yang dijalankan di thread
    private interface DbAction {
        void run() throws SQLException;
    }

    public HistoryDialog(JFrame owner) {
        super(owner, "Riwayat Sesi", true);   // true = modal
        setSize(560, 380);
        setLocationRelativeTo(owner);

        labelStatus.setForeground(Theme.GRAY);
        labelStatus.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        JPanel panelButton = new JPanel();
        panelButton.add(buttonEdit);
        panelButton.add(buttonDelete);
        panelButton.add(buttonRefresh);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(labelStatus, BorderLayout.WEST);
        bottom.add(panelButton, BorderLayout.EAST);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        buttonEdit.addActionListener(e -> editSelected());
        buttonDelete.addActionListener(e -> deleteSelected());
        buttonRefresh.addActionListener(e -> loadData(" "));

        loadData(" ");
    }

    // Disable/enable tombol dan tampilkan status
    private void setBusy(boolean busy, String status) {
        buttonEdit.setEnabled(!busy);
        buttonDelete.setEnabled(!busy);
        buttonRefresh.setEnabled(!busy);
        labelStatus.setText(status);
    }

    // READ: ambil data di thread, isi tabel di EDT
    private void loadData(String doneStatus) {
        setBusy(true, "Loading…");

        new Thread(() -> {
            List<Session> data = null;
            Exception error = null;
            try {
                data = dao.getRecent(50);
            } catch (SQLException e) {
                error = e;
            }
            final List<Session> result = data;
            final Exception err = error;

            SwingUtilities.invokeLater(() -> {
                if (err != null) {
                    setBusy(false, "Failed to load");
                    JOptionPane.showMessageDialog(this, "Gagal memuat: " + err.getMessage());
                    return;
                }
                model.setRowCount(0);
                for (Session s : result) {
                    model.addRow(new Object[] {
                        s.getId(), s.getName(), s.getMinutes(), s.getFinishedAt()
                    });
                }
                setBusy(false, result.isEmpty() ? "Belum ada riwayat" : doneStatus);
            });
        }).start();
    }

    // UPDATE / DELETE: jalankan aksi di thread, lalu muat ulang tabel
    private void runInThread(String busyText, DbAction action, String doneText) {
        setBusy(true, busyText);

        new Thread(() -> {
            Exception error = null;
            try {
                action.run();
            } catch (SQLException e) {
                error = e;
            }
            final Exception err = error;

            SwingUtilities.invokeLater(() -> {
                if (err != null) {
                    setBusy(false, "Failed");
                    JOptionPane.showMessageDialog(this, "Gagal: " + err.getMessage());
                } else {
                    loadData(doneText);
                }
            });
        }).start();
    }

    private void editSelected() {
        int[] rows = table.getSelectedRows();
        if (rows.length != 1) {
            JOptionPane.showMessageDialog(this, "Pilih satu baris untuk diedit");
            return;
        }
        int row = rows[0];
        final int id = (Integer) model.getValueAt(row, 0);

        // Form kecil: dua JTextField di dalam JPanel, ditampilkan dengan showConfirmDialog
        JTextField tfName = new JTextField(String.valueOf(model.getValueAt(row, 1)), 15);
        JTextField tfMinutes = new JTextField(String.valueOf(model.getValueAt(row, 2)), 5);
        JPanel form = new JPanel(new GridLayout(2, 2, 5, 5));
        form.add(new JLabel("Nama sesi:"));
        form.add(tfName);
        form.add(new JLabel("Durasi (menit):"));
        form.add(tfMinutes);

        int ok = JOptionPane.showConfirmDialog(this, form, "Edit Sesi", JOptionPane.OK_CANCEL_OPTION);
        if (ok != JOptionPane.OK_OPTION) {
            return;
        }
        String name = tfName.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama sesi tidak boleh kosong");
            return;
        }

        int parsed;
        try {
            parsed = Integer.parseInt(tfMinutes.getText().trim());
            if (parsed <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Durasi harus berupa angka positif");
            return;
        }

        final String newName = name;
        final int newMinutes = parsed;
        runInThread("Saving…", () -> dao.update(id, newName, newMinutes), "Saved ✓");
    }

    // Satu baris = delete, banyak baris = deleteMany (transaction)
    private void deleteSelected() {
        int[] rows = table.getSelectedRows();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Hapus " + rows.length + " riwayat?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        final List<Integer> ids = new ArrayList<>();
        for (int r : rows) {
            ids.add((Integer) model.getValueAt(r, 0));
        }

        if (ids.size() == 1) {
            runInThread("Deleting…", () -> dao.delete(ids.get(0)), "Deleted ✓");
        } else {
            runInThread("Deleting…", () -> dao.deleteMany(ids), "Deleted ✓");
        }
    }
}
