package game.infrastructure.logic.impl;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;
import game.domain.models.Card;
import game.domain.models.Deck;
import game.infrastructure.logic.GameLogic;

public class GameLogicImpl implements GameLogic {

    public Deck deckP1;
    public Deck deckP2;
    public Deck deckBuffer;

    @Override
    public void start() {

        deckP1 = new Deck(true); //we put all the cards here
        deckP2 = new Deck(); //after we will shuffle and give half the cards here
        deckBuffer = new Deck();

        deckP1.shuffle();
        for (int i = 0; i < 26; i++) {
            Card movingCard = deckP1.takeCardsFromBottom();
            deckP2.addCardsOnTop(movingCard);
        }
        /* //printing for debugging
        System.out.println("\nDECK1:");
        deckP1.printDeck();/*
        System.out.println("\nDECK2:");
        deckP2.printDeck();*/


        System.out.print("-----TEST 1 - ");
        deckP1.printDeckSize();

    }

    @Override
    public void next() {

        //Take cards
        System.out.print("-----TEST 2 - ");
        deckP1.printDeckSize();
        System.out.println("TEST IN NEXT():");
        System.out.println("-----TEST - " + deckP1.takeCardsFromBottom().toText());
        Card activeP1 = deckP1.takeCardsFromBottom();
        Card activeP2 = deckP2.takeCardsFromBottom();
        deckBuffer.addCardsOnTop(new Card[]{activeP1, activeP2});

        //Compare, add to the winning player if there is one
        if (activeP1.getValue().getNumValue() > activeP2.getValue().getNumValue()) {
            deckP1.addCardsOnTop(deckBuffer);
            deckBuffer.clearDeck(); //clear buffer
            logMsg("P1 wins with " + activeP1.toText());
        } else if (activeP1.getValue().getNumValue() < activeP2.getValue().getNumValue()) {
            logMsg("P2 wins with " + activeP2.toText());
            deckP2.addCardsOnTop(deckBuffer);
            deckBuffer.clearDeck(); //clear buffer
        }
        else {
            logMsg("War with " + activeP1.toText() + " VS " + activeP2.toText());
        }
    }

    public void gameEnd() {} //triggers when one player runs out of cards

    //message to be displayed in logs frame
    public void logMsg(String msg) {
        System.out.println(msg);
    }

}
