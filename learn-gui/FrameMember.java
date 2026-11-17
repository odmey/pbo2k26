import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameMember extends JFrame{
    private CardLayout cardLayout;
    private JPanel panelDetail;

   private Member[] daftarMember = {
        new Member("Meisya", "ENTP", "Eldest"),
        new Member("Alin", "INFJ", "Mom"),
        new Member("Kadiva", "ISTJ", "Calmness"),
        new Member("Tania", "INFP", "Cat"),
        new Member("Samara", "ENFP", "Firecracker"),
        new Member("Raissa", "INFJ", "Baby"),
        new Member("Jasmine", "ENFP", "Mood-Maker"),
        new Member("Kanaya", "INTP", "Wildcard")
    };

    public FrameMember(){
        super("Biodata Moju");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel lbljudul = new JLabel("Click this card to see a bio", SwingConstants.CENTER);
        lbljudul.setFont(new Font("Arial", Font.BOLD, 16));

        cardLayout = new CardLayout();
        panelDetail = new JPanel(cardLayout);
        panelDetail.add(new JLabel("There's no member choosen yet", SwingConstants.CENTER), "first");

        JPanel cardPanel = new JPanel(new GridLayout(1, daftarMember.length, 10, 0));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        KartuMember.PilihListener pilihListener = new KartuMember.PilihListener() {
            @Override
            public void choosen(Member member) {
                cardLayout.show(panelDetail, member.getName());
            }
        };

        for (int i = 0; i < daftarMember.length; i++) {
            panelDetail.add(new PanelDetail(daftarMember[i]), daftarMember[i].getName());
            cardPanel.add(new KartuMember(daftarMember[i], pilihListener));
        }

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelDetail, "first");
            }
        });

        JPanel bottomP = new JPanel(new FlowLayout());
        bottomP.add(btnReset);

        JPanel middleP = new JPanel(new BorderLayout(5, 10));
        middleP.add(cardPanel, BorderLayout.NORTH);
        middleP.add(panelDetail, BorderLayout.CENTER);

        add(lbljudul, BorderLayout.NORTH);
        add(middleP, BorderLayout.CENTER);
        add(bottomP, BorderLayout.SOUTH);






    }
}
