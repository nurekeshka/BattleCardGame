package game.infrastructure.logic.impl;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;
import game.domain.models.Card;
import game.domain.models.Deck;
import game.infrastructure.logic.GameLogic;

public class GameLogicImpl implements GameLogic {

    @Override
    public void start() {
        Deck deckP1 = new Deck(); //we put all the cards here
        Deck deckP2 = new Deck(); //after we will shuffle and give half the cards here
        for (int s = 0; s <= 4; s++) { //suits
            for (int v = 2; v <= 14; v++) { //values
                Card cardToAdd = new Card(CardSuit.values()[s], CardValue.valueOf(CardValue.getName(v)));
                deckP1.addCardsOnTop(cardToAdd);
            }
        }
        //System.out.println(deckP1); //DEBUG - PRINT DECK
        deckP1.shuffle();
        for (int i = 0; i < 52; i++) {
            Card movingCard = deckP1.takeCardsFromBottom();
            deckP2.addCardsOnTop(movingCard);
        }
        //System.out.println(deckP1); //DEBUG - PRINT DECK
        //System.out.println(deckP2); //DEBUG - PRINT DECK
    }

    @Override
    public void next() {
        //what happens when you press text turn button
    }

}
