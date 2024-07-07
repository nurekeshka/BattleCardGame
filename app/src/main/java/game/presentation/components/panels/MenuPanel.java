package game.presentation.components.panels;

import game.domain.enums.GamePanels;
import game.presentation.frames.MainFrame;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {
    String[] buttons = new String[] { "Play", "Exit" };

    public MenuPanel init(MainFrame main) {
        setLayout(new GridLayout(this.buttons.length, 1, 10, 10));

        JButton playButton = new JButton(buttons[0]);
        JButton exitButton = new JButton(buttons[1]);

        playButton.addActionListener((ActionEvent e) -> main.switchToPanel(GamePanels.GAME));
        exitButton.addActionListener((ActionEvent e) -> System.exit(0));

        this.add(playButton);
        this.add(exitButton);

        return this;
    }
}
