package game.presentation.components.labels;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PlayerDeckLabel extends JLabel {
    public PlayerDeckLabel(ImageIcon icon) {
        super(icon);
        this.setHorizontalAlignment(SwingConstants.CENTER);

    }
}
