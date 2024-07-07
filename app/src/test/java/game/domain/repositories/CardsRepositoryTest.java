package game.domain.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import game.application.controls.Guice;
import game.application.controls.Injector;
import game.application.initialization.BasicModule;
import game.domain.enums.CardRank;
import game.domain.enums.CardSuit;
import game.domain.models.Card;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CardsRepositoryTest {
    private Injector injector;
    private CardsRepository cardsRepository;

    @BeforeAll
    public void init() {
        this.injector = Guice.createInjector(new BasicModule());
        this.cardsRepository = this.injector.getInstance(CardsRepository.class);
    }

    @Test
    void getCardFromStringTest() {
        Card card = this.cardsRepository.getCard("HEARTS", "ACE");
        assertEquals(CardRank.ACE, card.getRank());
        assertEquals(CardSuit.HEARTS, card.getSuit());
    }
}
