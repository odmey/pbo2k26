import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import db.SessionDAO;

public class TimerPanel extends JPanel {
    private JLabel labelSession = new JLabel("FOCUS SESSION");
    private JLabel labelTimer = new JLabel("25:00");
    private JLabel labelDescription = new JLabel("Time to focus on your task");

    private JButton buttonFocus = new JButton("Focus");
    private JButton buttonShortBreak = new JButton("Short Break");
    private JButton buttonLongBreak = new JButton("Long Break");
    private JButton buttonStart = new JButton("Start");
    private JButton buttonReset = new JButton("Reset");
    private JButton buttonHistory = new JButton("History");

    private TimerController controller = new TimerController(labelTimer, buttonStart);

    public TimerPanel() {
        setLayout(new GridBagLayout());
        setBackground(Theme.BACKGROUND);

        labelSession.setForeground(Theme.PURPLE);
        labelTimer.setFont(Theme.FONT_TIMER);
        labelTimer.setForeground(Theme.DARK);
        labelDescription.setForeground(Theme.GRAY);

        JPanel panelMode = new JPanel();
        panelMode.setBackground(Theme.WHITE);
        panelMode.add(buttonFocus);
        panelMode.add(buttonShortBreak);
        panelMode.add(buttonLongBreak);

        JPanel panelButton = new JPanel();
        panelButton.setBackground(Theme.WHITE);
        panelButton.add(buttonStart);
        panelButton.add(buttonReset);
        panelButton.add(buttonHistory);
        buttonHistory.addActionListener(e -> showHistory());

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Theme.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.insets = new Insets(8, 0, 8, 0);

        c.gridy = 0;
        card.add(labelSession, c);
        c.gridy = 1;
        card.add(panelMode, c);
        c.gridy = 2;
        card.add(labelTimer, c);
        c.gridy = 3;
        card.add(labelDescription, c);
        c.gridy = 4;
        card.add(panelButton, c);

        add(card);
        setActiveButton(buttonFocus);

        buttonStart.addActionListener(e -> {
            if (controller.isRunning()) {
                controller.pause();
            } else {
                controller.start();
            }
        });

        buttonReset.addActionListener(e -> controller.reset());

        buttonFocus.addActionListener(e ->
            changeMode(25, "FOCUS SESSION", "Time to focus on your task", buttonFocus));

        buttonShortBreak.addActionListener(e ->
            changeMode(5, "SHORT BREAK", "Take a short break and relax", buttonShortBreak));

        buttonLongBreak.addActionListener(e ->
            changeMode(15, "LONG BREAK", "Take a longer break and recharge", buttonLongBreak));
    }

    private void changeMode(int minutes, String session, String description, JButton activeButton) {
        controller.setDuration(session, minutes);
        labelSession.setText(session);
        labelDescription.setText(description);
        setActiveButton(activeButton);
    }

    private void setActiveButton(JButton activeButton) {
        JButton[] buttons = {buttonFocus, buttonShortBreak, buttonLongBreak};

        for (JButton button : buttons) {
            button.setBackground(Theme.LIGHT_GRAY);
            button.setForeground(Theme.GRAY);
        }

        activeButton.setBackground(Theme.PURPLE);
        activeButton.setForeground(Theme.WHITE);
    }

    private void showHistory() {
        try {
            SessionDAO dao = new SessionDAO();
            String text = "";

            for (String row : dao.getAll()) {
                text += row + "\n";
            }

            JOptionPane.showMessageDialog(this, text.isEmpty() ? "Belum ada riwayat" : text);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat: " + e.getMessage());
        }
    }
}