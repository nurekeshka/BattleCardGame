package game.infrastructure.progress;

import game.domain.models.Game;

public interface GameProgress {
    public Game newGame();

    public Game loadGame();

    public boolean exists();
}
