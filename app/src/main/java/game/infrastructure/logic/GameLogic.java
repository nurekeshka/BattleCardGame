package game.infrastructure.logic;

import game.domain.models.Game;

public interface GameLogic {
    public void start();

    public void next();

    public void close();

    public Game getGameObject();

    public void setGameObject(Game gameObject);

    public int getPlayerOneDeckCardsCount();

    public int getPlayerTwoDeckCardsCount();
}
