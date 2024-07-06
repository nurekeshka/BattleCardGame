package game.domain.repositories.impl;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;
import game.domain.models.Card;
import game.domain.models.Deck;
import game.domain.repositories.CardsRepository;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CardsRepositoryImpl implements CardsRepository {
    @Override
    public Card getCard(CardSuit suit, CardValue value) {
        return new Card(suit, value);
    }

    @Override
    public Deck getFullDeck() {
        List<Card> cards = new ArrayList<>();

        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                cards.add(new Card(suit, value));
            }
        }

        return new Deck(cards.toArray(new Card[0]));
    }

    @Override
    public Path getImagePath(Card card) {
        return Paths.get("src", "main", "resources", card.getSuit().toString().toLowerCase(),
                String.format("%d.png", card.getValue().getNumValue()));
    }
}
