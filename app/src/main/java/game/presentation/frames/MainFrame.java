package game.presentation.frames;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import game.domain.enums.GamePanels;
import game.presentation.components.panels.FinalPanel;
import game.presentation.components.panels.GamePanel;
import game.presentation.components.panels.MenuPanel;

public class MainFrame extends JFrame {
    private static int windowWidth = 600;
    private static int windowHeight = 400;

    private static String windowTitle = "Battle Card Game";

    private final MenuPanel menuPanel;
    private final GamePanel gamePanel;
    private final FinalPanel finalPanel;

    public MainFrame(MenuPanel menuPanel, GamePanel gamePanel, FinalPanel finalPanel) {
        this.menuPanel = menuPanel;
        this.gamePanel = gamePanel;
        this.finalPanel = finalPanel;
    }

    public void init() {
        this.setWindowConfiguration();
        this.switchToPanel(GamePanels.MENU);
    }

    public void switchToPanel(GamePanels panel) {
        this.getContentPane().removeAll();

        if (panel == GamePanels.MENU) {
            this.getContentPane().add(this.menuPanel.init(this));
        } else if (panel == GamePanels.GAME) {
            this.getContentPane().add(this.gamePanel.init(this));
        } else if (panel == GamePanels.FINAL) {
            this.getContentPane().add(this.finalPanel.init(this));
        }

        this.updateFrame();
    }

    public void setWindowConfiguration() {
        setTitle(MainFrame.windowTitle);

        setSize(MainFrame.windowWidth, MainFrame.windowHeight);
        setMinimumSize(new Dimension(MainFrame.windowWidth, MainFrame.windowHeight));
        setMaximumSize(new Dimension(MainFrame.windowWidth, MainFrame.windowHeight));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void updateFrame() {
        this.revalidate();
        this.repaint();
    }

    public int getWindowWidth() {
        return MainFrame.windowWidth;
    }

    public int getWindowHeight() {
        return MainFrame.windowHeight;
    }
}
