package game.domain.models;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private Queue<Card> cards;

    public Deck() {
        this.cards = new LinkedList<>();
    }

    public Deck(Card[] content) {
        this.cards = new LinkedList<>();
        Collections.addAll(this.cards, content);
    }

    public Card[] getCards() {
        return cards.toArray(new Card[] {});
    }

    public void addCardsOnTop(Card card) {
        this.cards.add(card);
    }

    public void addCardsOnTop(Card[] cards) {
        for (Card card : cards) {
            this.cards.add(card);
        }
    }

    public Card takeCardsFromBottom() {
        return this.cards.poll();
    }

    public Card[] takeCardsFromBottom(int quantity) {
        List<Card> buffer = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            buffer.add(this.cards.poll());
        }

        return buffer.toArray(new Card[] {});
    }

    public void shuffle() {
        List<Card> buffer = new ArrayList<>(this.cards);
        Collections.shuffle(buffer);
        this.cards = new LinkedList<>(buffer);
    }
}
