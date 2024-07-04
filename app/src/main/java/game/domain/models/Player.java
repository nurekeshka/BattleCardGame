package game.domain.models;

public class Player {
    public final String name;
    private final Deck deck;

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }
}
