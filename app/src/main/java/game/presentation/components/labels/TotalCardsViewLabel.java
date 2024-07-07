package game.presentation.components.labels;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TotalCardsViewLabel extends JLabel {
    public TotalCardsViewLabel(int count) {
        super(String.format("%d", count));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
