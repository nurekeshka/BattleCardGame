package game.infrastructure.logic;

import game.domain.models.Game;

public interface GameLogic {
    public void newGame();

    public void loadGame();

    public void next();

    public Game getGameObject();

    public void setGameObject(Game gameObject);

    public int getPlayerOneDeckCardsCount();

    public int getPlayerTwoDeckCardsCount();
}
