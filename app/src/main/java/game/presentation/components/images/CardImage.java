package game.presentation.components.images;

import java.nio.file.Path;

import javax.swing.ImageIcon;

public class CardImage extends ImageIcon {
    public CardImage(Path path) {
        super(path.toString());
    }
}
