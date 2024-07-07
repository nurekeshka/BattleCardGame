//classes should implement the Serializable interface so they can be serialized by ObjectOutputStream to save the game progress.

package game.infrastructure.progress.impl;
import game.infrastructure.progress.GameSaver;

import java.io.*;

public class GameSave {
    public static void saveGame(Deck deck1, Deck deck2, Deck deck3, String progressFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(progress))) {
            out.writeObject(Deck);
        }
    }

    public static Deck loadGame(String progressFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(progress))) {
            return (Deck) in.readObject();
        }
    }
}
