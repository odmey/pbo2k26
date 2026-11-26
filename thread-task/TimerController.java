import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import db.SessionDAO;

public class TimerController {
    private String sessionName = "FOCUS SESSION";
    private int minutes = 25;
    private int remainingTime = 25 * 60;
    private Thread thread;

    private JLabel labelTimer;
    private JButton buttonStart;
    private SessionDAO dao = new SessionDAO();

    public TimerController(JLabel labelTimer, JButton buttonStart) {
        this.labelTimer = labelTimer;
        this.buttonStart = buttonStart;
    }

    public boolean isRunning() {
        return thread != null;
    }

    public void start() {
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

    private void saveSession() {
        try {
            dao.insert(sessionName, minutes);
            JOptionPane.showMessageDialog(null, "Sesi selesai dan tersimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan: " + e.getMessage());
        }
    }

    private void updateLabel() {
        int min = remainingTime / 60;
        int sec = remainingTime % 60;
        labelTimer.setText(String.format("%02d:%02d", min, sec));
    }
}