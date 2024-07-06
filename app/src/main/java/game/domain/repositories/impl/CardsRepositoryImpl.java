package game.domain.repositories.impl;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;
import game.domain.models.Card;
import game.domain.models.Deck;
import game.domain.repositories.CardsRepository;

import java.util.ArrayList;
import java.util.List;

public class CardsRepositoryImpl implements CardsRepository {

    private static final String IMAGE_PATH_TEMPLATE = "path/to/images/%s_%s.png";

    @Override
    public Card getCard(CardSuit suit, CardValue value) {
        Card card = new Card(suit, value);
        String imagePath = getImagePath(card);
        System.out.println("Image path for card: " + imagePath);
        return card;
    }

    @Override
    public Deck getFullDeck() {
        List<Card> cards = new ArrayList<>();

        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                Card card = new Card(suit, value);
                String imagePath = getImagePath(card);
                System.out.println("Image path for card: " + imagePath);
                cards.add(card);
            }
        }

        return new Deck(cards.toArray(new Card[0]));
    }

    public String getImagePath(Card card) {
        return String.format(IMAGE_PATH_TEMPLATE, card.getSuit().toString().toLowerCase(), card.getValue().toString().toLowerCase());
    }
}

