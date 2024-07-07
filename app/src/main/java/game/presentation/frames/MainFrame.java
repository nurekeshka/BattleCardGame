package game.presentation.frames;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import game.domain.enums.GameWindows;
import game.presentation.components.panels.GamePanel;
import game.presentation.components.panels.MenuPanel;

public class MainFrame extends JFrame {
    public void init() {
        this.setWindowConfiguration();
    }

    public void switchToWindow(GameWindows window) {
        this.getContentPane().removeAll();

        if (window == GameWindows.MENU) {
            this.getContentPane().add(new MenuPanel());
        } else if (window == GameWindows.GAME) {
            this.getContentPane().add(new GamePanel());
        } else if (window == GameWindows.FINAL) {
            this.getContentPane().add(new FinalFrame());
        }
    }

    public void setWindowConfiguration() {
        setTitle("Battle Card Game");
        setSize(600, 400);
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
