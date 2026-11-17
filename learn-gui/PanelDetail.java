import java.awt.*;
import javax.swing.*;

public class PanelDetail extends JPanel{
    public PanelDetail(Member m){
        setLayout(new GridLayout(3, 2, 5, 8 ));
        setBorder(BorderFactory.createTitledBorder("Biodata " + m.getName()));
    
        add(new JLabel("Name")); add(new JLabel(": " + m.getName()));
        add(new JLabel("MBTI")); add(new JLabel(": " + m.getMbti()));
        add(new JLabel("Role")); add(new JLabel(": " + m.getRole()));
    }
}
