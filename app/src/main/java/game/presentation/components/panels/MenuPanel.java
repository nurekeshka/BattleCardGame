package game.presentation.components.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton startButton = new JButton("Start new game");
        JButton contgameButton = new JButton("Continue existing game");
        JButton exitButton = new JButton("Quit the game");

        panel.add(startButton);
        panel.add(contgameButton);
        panel.add(exitButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Starting the Game...");
            }
        });

        contgameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to show options
                JOptionPane.showMessageDialog(null, "Last game is opening...");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to exit the game
                System.exit(0);
            }
        });

        add(panel);
        setVisible(true);
    }
}
