package game.presentation.components.labels;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TotalCardsLabel extends JLabel {
    public TotalCardsLabel(Font font) {
        super("Total Cards Count");
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(font);
    }
}
