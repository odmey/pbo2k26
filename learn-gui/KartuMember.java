import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KartuMember extends JPanel {
    public interface PilihListener {
        void choosen(Member member);
    }

    private final Color basicColor = new Color(235, 240, 250);
    private final Color hoverColor = new Color(200, 215, 245);

    public KartuMember(Member member, PilihListener listener){
        setLayout(new BorderLayout());
        setBackground(basicColor);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel lblname = new JLabel(member.getName(), SwingConstants.CENTER);
        lblname.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblname, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.choosen(member);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                KartuMember.this.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                KartuMember.this.setBackground(basicColor);
            }
        });
    }
    
}
