package game.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;

class DeckTest {
    Card cardMock = new Card(CardSuit.CLUBS, CardValue.ACE);
    Card[] cardsArrayMock = new Card[] { cardMock };

    @Test
    void initializationTest() {
        Deck deck = new Deck(this.cardsArrayMock);
        assertEquals(1, deck.getCards().length);
    }

    @Test
    void addingCardOnTopTest() {
        Deck deck = new Deck(this.cardsArrayMock);
        deck.addCardOnTop(cardMock);
        assertEquals(2, deck.getCards().length);
    }

    @Test
    void takingCardFromBottomTest() {
        Deck deck = new Deck(this.cardsArrayMock);
        Card card = deck.takeCardFromBottom();
        assertNotNull(card);
        assertEquals(0, deck.getCards().length);
    }
}