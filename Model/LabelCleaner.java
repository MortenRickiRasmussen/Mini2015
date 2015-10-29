package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Jakob Ferdinandsen
 */
public class LabelCleaner {
    private JLabel label;
    private int waitSeconds;
    private Timer timer;
    

    public LabelCleaner(int waitSeconds, final JLabel label) {
        this.label = label;
        this.waitSeconds = waitSeconds;
        timer = new Timer(waitSeconds * 1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setVisible(false);
            }
        });
    }

    public void restartCountDown() {
        timer.restart();
    }
//    
//    public void stopCountdown(){
//        timer.stop();
//    }
}
