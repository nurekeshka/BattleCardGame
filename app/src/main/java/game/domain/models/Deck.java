package game.domain.models;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class Deck {
    private Queue<Card> cards;

    public Deck(Card[] content) {
        this.cards = new LinkedList<>();
        Collections.addAll(this.cards, content);
    }

    public Card[] getCards() {
        return cards.toArray(new Card[] {});
    }

    public void addCardOnTop(Card card) {
        this.cards.add(card);
    }

    public Card takeCardFromBottom() {
        return this.cards.poll();
    }

    public void shuffle() {
        // Method to shuffle the deck
    }
}
