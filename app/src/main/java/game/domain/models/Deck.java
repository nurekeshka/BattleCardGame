package game.domain.models;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;

import java.io.Serializable;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements Serializable {
    private Queue<Card> cards;

    public Deck() {
        this.cards = new LinkedList<>();
    }

    public Deck(Boolean standardDeck) {
        this.cards = new LinkedList<>();
        for (int s = 0; s < 4; s++) { //suits
            for (int v = 2; v <= 14; v++) { //values
                Card cardToAdd = new Card(CardSuit.values()[s], CardValue.valueOf(CardValue.getName(v)));
                this.addCardsOnTop(cardToAdd);
            }
        }
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

    //Specifically for adding war deck to any of player's decks
    public void addCardsOnTop(Deck deck) {
        Card[] cards = deck.getCards();
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

    public void printDeck() {
        Card[] copies = getCards();
        for (int i = 0; i < copies.length; i++) {
            System.out.print(copies[i].toText() + "\n");
        }
    }

    public void printDeckSize() {
        System.out.println(getCards().length);
    }

    public void clearDeck() {
        this.takeCardsFromBottom(getCards().length);
    }

}
