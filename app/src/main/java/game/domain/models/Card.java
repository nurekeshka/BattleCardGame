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

    public String toText() {
        String text = "";
        text += this.getValue().toString();
        text += " of ";
        text += this.getSuit().toString();
        return text;
    }
}
