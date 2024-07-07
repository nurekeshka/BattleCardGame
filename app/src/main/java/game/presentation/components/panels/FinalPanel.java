package game.presentation.components.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

import game.presentation.frames.MainFrame;

public class FinalPanel extends JPanel {
    public FinalPanel init(MainFrame main) {
        setSize(main.getWindowWidth(), main.getWindowHeight());
        setLayout(new GridLayout(1, 1));

        JLabel label = new JLabel(String.format("The winner is %s!", main.getWinner().toString()),
                SwingConstants.CENTER);
        label.setFont(main.getMainFont());

        this.add(label);
        return this;
    }
}
