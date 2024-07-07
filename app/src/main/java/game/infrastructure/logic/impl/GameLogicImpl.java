package game.infrastructure.logic.impl;

import game.domain.enums.CardSuit;
import game.domain.enums.CardRank;
import game.domain.models.Card;
import game.domain.models.Deck;
import game.domain.models.Game;
import game.domain.repositories.CardsRepository;
import game.infrastructure.logic.GameLogic;

public class GameLogicImpl implements GameLogic {
    private Game gameObject;
    private CardsRepository cardsRepository;

    public GameLogicImpl(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
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
    public void start() {
        this.gameObject.setBuffer(this.cardsRepository.getFullDeck());
        this.gameObject.getBuffer().shuffle();
        this.gameObject.getPlayerOneDeck().addCardsOnTop(this.gameObject.getBuffer().takeCardsFromBottom(26));
        this.gameObject.getPlayerTwoDeck().addCardsOnTop(this.gameObject.getBuffer().takeCardsFromBottom(26));

        System.out.println(this.gameObject.getPlayerOneDeck().toString());
        System.out.println(this.gameObject.getPlayerTwoDeck().toString());
    }

    @Override
    public void next() {
        // System.out.print("-----TEST 2 - ");
        // this.deckP1.printDeckSize();
        // System.out.println("TEST IN NEXT():");
        // System.out.println("-----TEST - " + deckP1.takeCardsFromBottom().toString());
        // Card activeP1 = deckP1.takeCardsFromBottom();
        // Card activeP2 = deckP2.takeCardsFromBottom();
        // deckBuffer.addCardsOnTop(new Card[] { activeP1, activeP2 });

        // // Compare, add to the winning player if there is one
        // if (activeP1.getValue().getNumValue() > activeP2.getValue().getNumValue()) {
        // deckP1.addCardsOnTop(deckBuffer);
        // deckBuffer.clear(); // clear buffer
        // logMsg("P1 wins with " + activeP1.toString());
        // } else if (activeP1.getValue().getNumValue() <
        // activeP2.getValue().getNumValue()) {
        // logMsg("P2 wins with " + activeP2.toString());
        // deckP2.addCardsOnTop(deckBuffer);
        // deckBuffer.clear(); // clear buffer
        // } else {
        // logMsg("War with " + activeP1.toString() + " VS " + activeP2.toString());
        // }
    }

    public void close() {
    } // triggers when one player runs out of cards

    // message to be displayed in logs frame
    public void logMsg(String msg) {
        System.out.println(msg);
    }

}
