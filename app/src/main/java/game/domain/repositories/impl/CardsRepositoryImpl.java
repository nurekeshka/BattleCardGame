package game.domain.repositories.impl;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;
import game.domain.models.Card;
import game.domain.models.Deck;
import game.domain.repositories.CardsRepository;

public class CardsRepositoryImpl implements CardsRepository {

    @Override
    public Card getCard(CardSuit suit, CardValue value) {
        throw new UnsupportedOperationException("Unimplemented method 'getCard'");
    }

    @Override
    public Deck getFullDeck() {
        throw new UnsupportedOperationException("Unimplemented method 'getFullDeck'");
    }

}
