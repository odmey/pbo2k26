import java.awt.*;
import java.awt.event.*;

public class TestEventDasar {
    private Frame f;
    private Button b;

    public TestEventDasar(){
        f = new Frame("Test");
        b = new Button("Click me");
        b.setActionCommand("Click here!");
    }

    public void launchFrame(){
        b.addActionListener(new PenangkapKlik());
        f.add(b, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args){
        
    }
}
