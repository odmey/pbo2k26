package ui;

import db.SessionDAO;
import java.sql.SQLException;
import javax.swing.*;

public class TimerController {
    private String sessionName = "FOCUS SESSION";
    private int minutes = 25;
    private int remainingTime = 25 * 60;
    private Thread thread;

    private JLabel labelTimer;
    private JButton buttonStart;
    private JLabel labelStatus;
    private SessionDAO dao = new SessionDAO();

    public TimerController(JLabel labelTimer, JButton buttonStart, JLabel labelStatus) {
        this.labelTimer = labelTimer;
        this.buttonStart = buttonStart;
        this.labelStatus = labelStatus;
    }

    public boolean isRunning() {
        return thread != null;
    }

    public void start() {
        if (remainingTime == 0) {
            reset();   // sesi sudah habis: mulai lagi dari durasi penuh
        }
        if (remainingTime > 0) {
            thread = new Thread(() -> {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        SwingUtilities.invokeLater(() -> countdown());
                    }
                } catch (InterruptedException e) {
                    // thread berhenti saat di-interrupt
                }
            });
            thread.start();
            buttonStart.setText("Pause");
        }
    }

    public void pause() {
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
        buttonStart.setText("Start");
    }

    public void reset() {
        pause();
        remainingTime = minutes * 60;
        updateLabel();
        labelStatus.setText(" ");
    }

    public void setDuration(String sessionName, int minutes) {
        this.sessionName = sessionName;
        this.minutes = minutes;
        reset();
    }

    private void countdown() {
        if (isRunning()) {
            remainingTime--;
            updateLabel();

            if (remainingTime == 0) {
                pause();
                saveSession();
            }
        }
    }

    // Pola: DB di thread -> invokeLater -> UI
    private void saveSession() {
        // 1) Di EDT: disable tombol dan tampilkan status
        buttonStart.setEnabled(false);
        labelStatus.setText("Saving…");

        final String name = sessionName;
        final int mins = minutes;

        // 2) Query DB di thread terpisah
        new Thread(() -> {
            Exception error = null;
            try {
                dao.insert(name, mins);
            } catch (SQLException e) {
                error = e;
            }
            final Exception err = error;

            // 3) Kembali ke EDT untuk update tampilan
            SwingUtilities.invokeLater(() -> {
                buttonStart.setEnabled(true);
                if (err == null) {
                    labelStatus.setText("Saved ✓");
                } else {
                    labelStatus.setText("Failed to save");
                    JOptionPane.showMessageDialog(null, "Gagal menyimpan: " + err.getMessage());
                }
            });
        }).start();
    }

    private void updateLabel() {
        int min = remainingTime / 60;
        int sec = remainingTime % 60;
        labelTimer.setText(String.format("%02d:%02d", min, sec));
    }
}
