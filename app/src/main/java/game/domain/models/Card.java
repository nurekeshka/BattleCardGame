package game.domain.models;

import game.domain.enums.CardSuit;
import game.domain.enums.CardRank;

import java.io.Serializable;

public class Card implements Serializable {
    private final CardSuit suit;
    private final CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public String toString() {
        return String.format("%s of %s", this.getRank().toString(), this.getSuit().toString());
    }
}
