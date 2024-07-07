package game.domain.models;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;

import java.io.Serializable;

public class Card implements Serializable {
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

    public String toString() {
        return String.format("%s of %s", this.getValue().toString(), this.getSuit().toString());
    }
}
