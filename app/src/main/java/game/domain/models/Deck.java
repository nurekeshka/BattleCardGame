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
}
