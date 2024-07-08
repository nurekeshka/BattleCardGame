package game.domain.repositories.impl;

import game.domain.enums.CardSuit;
import game.domain.enums.CardRank;
import game.domain.models.Card;
import game.domain.models.Deck;
import game.domain.repositories.CardsRepository;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CardsRepositoryImpl implements CardsRepository {
    @Override
    public Card getCard(CardSuit suit, CardRank rank) {
        return new Card(suit, rank);
    }

    @Override
    public Card getCard(String suit, String rank) {
        return new Card(CardSuit.valueOf(suit), CardRank.valueOf(rank));
    }

    @Override
    public Deck getFullDeck() {
        List<Card> cards = new ArrayList<>();

        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                cards.add(new Card(suit, rank));
            }
        }

        return new Deck(cards.toArray(new Card[0]));
    }

    @Override
    public Path getImagePath(Card card) { //user for displaying the card in GamePanel
        if (card.getRank() == null || card.getSuit() == null) {
            return Paths.get("src", "main", "resources", "common", "cover.png");
        }

        return Paths.get("src", "main", "resources", card.getSuit().toString().toLowerCase(),
                String.format("%d.png", card.getRank().getInt()));
    }
}
