package game.domain.models;

public class Player {
    private final String name;
    private final Deck deck;
    private Card battleCard; //the revealed card, which is compared to the other revealed card

    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    public Player(String name, Deck deck, Card battleCard) {
        this.name = name;
        this.deck = deck;
        this.battleCard = battleCard;
    }

    public Card getBattleCard() {
        return battleCard;
    }

    public void setBattleCard(Card battleCard) {
        this.battleCard = battleCard;
    }

    public String getName() {
        return name;
    }

    public Deck getDeck() {
        return deck;
    }
}
