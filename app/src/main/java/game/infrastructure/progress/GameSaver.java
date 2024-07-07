package game.infrastructure.progress;

import game.domain.models.Deck;

import java.io.IOException;

public interface GameSaver {

    public void saveGame(Deck[] gameDecks) throws IOException;
    public Deck[] loadGame(String filename) throws IOException, ClassNotFoundException;
    public String dateAndTimeAsString();
}
