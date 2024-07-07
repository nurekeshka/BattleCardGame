package game.infrastructure.logic.impl;

import game.domain.models.Card;
import game.domain.models.Game;
import game.infrastructure.logic.GameLogic;
import game.infrastructure.progress.GameProgress;

public class GameLogicImpl implements GameLogic {
    private Game gameObject;
    private final GameProgress gameProgress;

    public GameLogicImpl(GameProgress gameProgress) {
        this.gameProgress = gameProgress;
    }

    @Override
    public Game getGameObject() {
        return gameObject;
    }

    @Override
    public void setGameObject(Game gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public int getPlayerOneDeckCardsCount() {
        return this.gameObject.getPlayerOneDeck().size();
    }

    @Override
    public int getPlayerTwoDeckCardsCount() {
        return this.gameObject.getPlayerTwoDeck().size();
    }

    @Override
    public int getWarBufferCardsCount() {
        return this.gameObject.getBuffer().size();
    }

    @Override
    public void newGame() {
        this.setGameObject(this.gameProgress.newGame());
    }

    @Override
    public void loadGame() {
        this.setGameObject(this.gameProgress.loadGame());
    }

    @Override
    public Card getBattlingCardLeft() {
        if (this.getGameObject().getPlayers()[0].getBattleCard() == null) {
            return new Card(null, null);
        }

        return this.getGameObject().getPlayers()[0].getBattleCard();
    }

    @Override
    public Card getBattlingCardRight() {
        if (this.getGameObject().getPlayers()[1].getBattleCard() == null) {
            return new Card(null, null);
        }

        return this.getGameObject().getPlayers()[1].getBattleCard();
    }

    @Override
    public void setBattlingCardLeft(Card battlingCardLeft) {
        this.getGameObject().getPlayers()[0].setBattleCard(battlingCardLeft);
    }

    @Override
    public void setBattlingCardRight(Card battlingCardRight) {
        this.getGameObject().getPlayers()[1].setBattleCard(battlingCardRight);
    }

    @Override
    public void next() {
        if (this.getGameObject().getPlayers()[0].getBattleCard() == null
                || this.getGameObject().getPlayers()[1].getBattleCard() == null) {
            this.setBattlingCardLeft(this.gameObject.getPlayerOneDeck().takeCardsFromBottom());
            this.setBattlingCardRight(this.gameObject.getPlayerTwoDeck().takeCardsFromBottom());
        } else {
            if (this.getBattlingCardLeft().getRank().getInt() > this.getBattlingCardRight().getRank().getInt()) {
                this.getGameObject().getPlayerOneDeck().addCardsOnTop(this.getBattlingCardLeft());
                this.getGameObject().getPlayerOneDeck().addCardsOnTop(this.getBattlingCardRight());
                this.getGameObject().getPlayerOneDeck().addCardsOnTop(
                        this.gameObject.getBuffer().takeCardsFromBottom(this.gameObject.getBuffer().size()));
            } else if (this.getBattlingCardLeft().getRank().getInt() < this.getBattlingCardRight().getRank().getInt()) {
                this.getGameObject().getPlayerTwoDeck().addCardsOnTop(this.getBattlingCardLeft());
                this.getGameObject().getPlayerTwoDeck().addCardsOnTop(this.getBattlingCardRight());
                this.getGameObject().getPlayerTwoDeck().addCardsOnTop(
                        this.gameObject.getBuffer().takeCardsFromBottom(this.gameObject.getBuffer().size()));
            } else {
                this.getGameObject().getBuffer().addCardsOnTop(this.getBattlingCardLeft());
                this.getGameObject().getBuffer().addCardsOnTop(this.getBattlingCardRight());

                this.getGameObject().getBuffer()
                        .addCardsOnTop(this.getGameObject().getPlayerOneDeck().takeCardsFromBottom(2));
                this.getGameObject().getBuffer()
                        .addCardsOnTop(this.getGameObject().getPlayerTwoDeck().takeCardsFromBottom(2));
            }

            this.resetBattleField();
        }
    }

    @Override
    public void resetBattleField() {
        this.setBattlingCardLeft(null);
        this.setBattlingCardRight(null);
    }
}
