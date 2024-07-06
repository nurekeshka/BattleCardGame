package game.domain.models;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;

import java.nio.file.Path;

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

    public String toText() {
        String text = "";
        text += this.getValue().toString();
        text += " of ";
        text += this.getSuit().toString();
        return text;
    }
}
