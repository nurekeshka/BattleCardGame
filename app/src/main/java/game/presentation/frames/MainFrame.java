package game.presentation.frames;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import game.domain.enums.GameWindows;
import game.presentation.components.panels.GamePanel;
import game.presentation.components.panels.MenuPanel;

public class MainFrame extends JFrame {
    private static int windowWidth = 600;
    private static int windowHeight = 400;
    private static String windowTitle = "Battle Card Game";

    public void init() {
        this.setWindowConfiguration();
        this.switchToWindow(GameWindows.MENU);
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
        setTitle(MainFrame.windowTitle);

        setSize(MainFrame.windowWidth, MainFrame.windowHeight);
        setMinimumSize(new Dimension(MainFrame.windowWidth, MainFrame.windowHeight));
        setMaximumSize(new Dimension(MainFrame.windowWidth, MainFrame.windowHeight));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
