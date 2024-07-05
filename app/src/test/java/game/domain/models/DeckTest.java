package game.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import game.application.controls.Guice;
import game.application.controls.Injector;
import game.application.initialization.BasicModule;
import game.domain.enums.CardSuit;
import game.domain.enums.CardValue;
import game.domain.repositories.CardsRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DeckTest {
    private Injector injector;
    private CardsRepository cardsRepository;

    Card cardMock = new Card(CardSuit.CLUBS, CardValue.ACE);
    Card[] cardsArrayMock = new Card[] { cardMock };

    @BeforeAll
    public void init() {
        this.injector = Guice.createInjector(new BasicModule());
        this.cardsRepository = this.injector.getInstance(CardsRepository.class);
    }

    @Test
    void initializationTest() {
        Deck deck = new Deck(new Card[] {});
        assertEquals(0, deck.getCards().length);
    }

    @Test
    void addingCardOnTopTest() {
        Deck deck = this.cardsRepository.getFullDeck();
        assertEquals(52, deck.getCards().length);
    }

    @Test
    void takingCardFromBottomTest() {
        Deck deck = new Deck(this.cardsArrayMock);
        Card card = deck.takeCardsFromBottom();
        assertNotNull(card);
        assertEquals(0, deck.getCards().length);
    }
}