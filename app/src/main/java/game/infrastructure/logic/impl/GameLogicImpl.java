package game.infrastructure.logic.impl;

import game.domain.models.Card;
import game.domain.models.Game;
import game.infrastructure.logic.GameLogic;
import game.infrastructure.progress.GameProgress;

public class GameLogicImpl implements GameLogic {
    private Game gameObject;
    private final GameProgress gameProgress;

    private Card battlingCardLeft;
    private Card battlingCardRight;

    public GameLogicImpl(GameProgress gameProgress) {
        this.gameProgress = gameProgress;
    }

    public Game getGameObject() {
        return gameObject;
    }

    public void setGameObject(Game gameObject) {
        this.gameObject = gameObject;
    }

    public int getPlayerOneDeckCardsCount() {
        return this.gameObject.getPlayerOneDeck().size();
    }

    public int getPlayerTwoDeckCardsCount() {
        return this.gameObject.getPlayerTwoDeck().size();
    }

    @Override
    public void newGame() {
        this.setGameObject(this.gameProgress.newGame());
    }

    @Override
    public void loadGame() {
        this.setGameObject(this.gameProgress.loadGame());
    }

    public Card getBattlingCardLeft() {
        if (this.battlingCardLeft == null) {
            return new Card(null, null);
        }

        return battlingCardLeft;
    }

    public Card getBattlingCardRight() {
        if (this.battlingCardRight == null) {
            return new Card(null, null);
        }

        return battlingCardRight;
    }

    public void setBattlingCardLeft(Card battlingCardLeft) {
        this.battlingCardLeft = battlingCardLeft;
    }

    public void setBattlingCardRight(Card battlingCardRight) {
        this.battlingCardRight = battlingCardRight;
    }

    @Override
    public void next() {
        if (this.battlingCardLeft == null || this.battlingCardRight == null) {
            this.setBattlingCardLeft(this.gameObject.getPlayerOneDeck().takeCardsFromBottom());
            this.setBattlingCardRight(this.gameObject.getPlayerTwoDeck().takeCardsFromBottom());
        } else {
            if (this.battlingCardLeft.getRank().getInt() > this.battlingCardRight.getRank().getInt()) {
                this.getGameObject().getPlayerOneDeck().addCardsOnTop(this.battlingCardLeft);
                this.getGameObject().getPlayerOneDeck().addCardsOnTop(this.battlingCardRight);
                this.getGameObject().getPlayerOneDeck().addCardsOnTop(this.gameObject.getBuffer().getCards());
                this.resetBattleField();
            } else if (this.battlingCardLeft.getRank().getInt() < this.battlingCardRight.getRank().getInt()) {
                this.getGameObject().getPlayerTwoDeck().addCardsOnTop(this.battlingCardLeft);
                this.getGameObject().getPlayerTwoDeck().addCardsOnTop(this.battlingCardRight);
                this.getGameObject().getPlayerTwoDeck().addCardsOnTop(this.gameObject.getBuffer().getCards());
                this.resetBattleField();
            } else {
                // anjlsdkfalsdjf
            }
        }
    }

    public void resetBattleField() {
        this.setBattlingCardLeft(null);
        this.setBattlingCardRight(null);
    }
}
