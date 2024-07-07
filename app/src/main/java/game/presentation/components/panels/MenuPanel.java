package game.presentation.components.panels;

import javax.swing.*;

import game.domain.enums.GamePanels;
import game.presentation.frames.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {
    String[] buttons = new String[] { "Play", "Exit" };

    public MenuPanel(MainFrame main) {
        JPanel menuPanel = new JPanel();

        JButton playButton = new JButton(buttons[0]);
        JButton exitButton = new JButton(buttons[1]);

        menuPanel.setLayout(new GridLayout(this.buttons.length, 1, 10, 10));

        menuPanel.add(playButton);
        menuPanel.add(exitButton);

        playButton.addActionListener((ActionEvent e) -> main.switchToPanel(GamePanels.GAME));
        exitButton.addActionListener((ActionEvent e) -> System.exit(0));

        this.add(menuPanel);
    }
}
