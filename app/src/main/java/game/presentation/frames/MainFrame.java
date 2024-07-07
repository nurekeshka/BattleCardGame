package game.presentation.frames;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Font;

import game.domain.enums.GamePanels;
import game.domain.enums.PlayerNames;
import game.presentation.components.panels.FinalPanel;
import game.presentation.components.panels.GamePanel;
import game.presentation.components.panels.MenuPanel;

public class MainFrame extends JFrame {
    private static int windowWidth = 800;
    private static int windowHeight = 480;

    private static String windowTitle = "Battle Card Game";

    private static Font mainFont = new Font("Serif", Font.BOLD, 18);

    private final MenuPanel menuPanel;
    private final GamePanel gamePanel;
    private final FinalPanel finalPanel;

    private PlayerNames winner;

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

    public PlayerNames getWinner() {
        return winner;
    }

    public void setWinner(PlayerNames winner) {
        this.winner = winner;
    }

    public int getWindowWidth() {
        return MainFrame.windowWidth;
    }

    public int getWindowHeight() {
        return MainFrame.windowHeight;
    }

    public Font getMainFont() {
        return MainFrame.mainFont;
    }
}
