package game.domain.models;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;

public class Card {
    private final CardSuit suit;
    private final CardValue value;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }
}
