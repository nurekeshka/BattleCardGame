package game.application.initialization;

import game.application.controls.Guice;
import game.application.controls.Injector;
import game.domain.enums.CardSuit;
import game.domain.enums.CardRank;
import game.domain.models.Card;
import game.domain.models.Deck;
import game.infrastructure.progress.GameSaver;
import game.presentation.frames.GameFrame;
import org.checkerframework.checker.units.qual.C;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Injector injector = Guice.createInjector(new BasicModule());
        GameFrame frame = injector.getInstance(GameFrame.class);
        frame.init();
        // GameLogic glogic = injector.getInstance(GameLogic.class);
        // glogic.start();
        GameSaver gsaver = injector.getInstance(GameSaver.class);
        String filename = "src/main/java/game/infrastructure/progress/saves/testsave.json";
        Deck testDeck = new Deck();
        testDeck.addCardsOnTop(new Card(CardSuit.DIAMONDS, CardRank.KING));
        gsaver.saveGame(new Deck[] { new Deck(true), testDeck }, filename);
        Deck[] read = gsaver.loadGame(filename);
        read[0].printDeck();
        System.out.println(); // blank space
        read[1].printDeck();
    }
}
