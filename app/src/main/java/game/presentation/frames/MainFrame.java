package game.presentation.frames;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
    public void init() {
        this.setWindowConfiguration();
    }

    public void setWindowConfiguration() {
        setTitle("Battle Card Game");
        setSize(600, 400);
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
