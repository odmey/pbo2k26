package ui;

import java.awt.*;
import javax.swing.*;

public class HeaderPanel extends JPanel {
    public HeaderPanel() {
        setLayout(new GridLayout(2, 1));
        setBackground(Theme.WHITE);
        setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        JLabel labelTitle = new JLabel("TaskFlow", SwingConstants.CENTER);
        labelTitle.setFont(Theme.FONT_TITLE);
        labelTitle.setForeground(Theme.DARK);

        JLabel labelSubtitle = new JLabel("Your personal productivity space", SwingConstants.CENTER);
        labelSubtitle.setFont(Theme.FONT_TEXT);
        labelSubtitle.setForeground(Theme.GRAY);

        add(labelTitle);
        add(labelSubtitle);
    }
}