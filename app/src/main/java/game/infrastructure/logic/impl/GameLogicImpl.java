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
    public void next() { //when the button is pressed
        if (this.getGameObject().getPlayers()[0].getBattleCard() == null //if the cards are not revealed
                || this.getGameObject().getPlayers()[1].getBattleCard() == null) {
            this.setBattlingCardLeft(this.gameObject.getPlayerOneDeck().takeCardsFromBottom()); //reveal P1 card
            this.setBattlingCardRight(this.gameObject.getPlayerTwoDeck().takeCardsFromBottom()); //reveal P2 card
        } else { //if the cards are revealed - find the winner and give them the cards they won
            if (this.getBattlingCardLeft().getRank().getInt() > this.getBattlingCardRight().getRank().getInt()) { //if first card wins
                this.getGameObject().getPlayerOneDeck().addCardsOnTop(this.getBattlingCardLeft()); //P1 gets the card back
                this.getGameObject().getPlayerOneDeck().addCardsOnTop(this.getBattlingCardRight()); //P1 wins P2's card
                this.getGameObject().getPlayerOneDeck().addCardsOnTop(
                        this.gameObject.getBuffer().takeCardsFromBottom(this.gameObject.getBuffer().size())); //P1 takes all the war cards if there are any
            } else if (this.getBattlingCardLeft().getRank().getInt() < this.getBattlingCardRight().getRank().getInt()) { //same for P2 win
                this.getGameObject().getPlayerTwoDeck().addCardsOnTop(this.getBattlingCardLeft());
                this.getGameObject().getPlayerTwoDeck().addCardsOnTop(this.getBattlingCardRight());
                this.getGameObject().getPlayerTwoDeck().addCardsOnTop(
                        this.gameObject.getBuffer().takeCardsFromBottom(this.gameObject.getBuffer().size()));
            } else { //if noone won = if there is war
                this.getGameObject().getBuffer().addCardsOnTop(this.getBattlingCardLeft()); //add P1's card to buffer
                this.getGameObject().getBuffer().addCardsOnTop(this.getBattlingCardRight()); //add P2's card to buffer

                //"Both players place the next 2 cards from their pile face down and then another card face-up"
                //the "another card face-up" will be the card revealed the next time "next turn" is pressed
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
