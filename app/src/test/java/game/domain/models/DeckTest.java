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
import game.domain.enums.CardRank;
import game.domain.repositories.CardsRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DeckTest {
    private Injector injector;
    private CardsRepository cardsRepository;

    Card cardMock = new Card(CardSuit.CLUBS, CardRank.ACE);

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
    void addingSingleCardOnTopTest() {
        Deck deck = this.cardsRepository.getFullDeck();
        deck.addCardsOnTop(this.cardMock);

        assertEquals(53, deck.getCards().length);
    }

    @Test
    void addingMultipleCardsOnTopTest() {
        Deck deck = this.cardsRepository.getFullDeck();
        deck.addCardsOnTop(new Card[] { this.cardMock, this.cardMock, this.cardMock });

        assertEquals(55, deck.getCards().length);
    }

    @Test
    void takingSingleCardFromBottomTest() {
        Deck deck = this.cardsRepository.getFullDeck();
        Card card = deck.takeCardsFromBottom();

        assertNotNull(card);
        assertEquals(51, deck.getCards().length);
    }

    @Test
    void takingMultipleCardsFromBottomTest() {
        Deck deck = this.cardsRepository.getFullDeck();
        Card[] cards = deck.takeCardsFromBottom(6);

        assertNotNull(cards);
        assertEquals(46, deck.getCards().length);
    }
}