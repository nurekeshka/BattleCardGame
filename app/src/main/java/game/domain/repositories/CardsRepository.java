package game.domain.repositories;

import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;
import game.domain.models.Card;
import game.domain.models.Deck;

import java.nio.file.Path;

public interface CardsRepository {
    public Card getCard(CardSuit suit, CardValue value);

    public Deck getFullDeck();

    public Path getImagePath(Card card);
}
