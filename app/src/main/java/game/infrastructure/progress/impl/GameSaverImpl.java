//classes should implement the Serializable interface so they can be serialized by ObjectOutputStream to save the game progress.
//we are not using json files we just using the serialization. 

package game.infrastructure.progress.impl;
import game.infrastructure.progress.GameSaver;
import java.io.*;

// This class provides static methods to save and load the game state to and from a file.
public class GameSaverImpl {

  // Method to save the game state to a file
  public static void saveGame(Game game, String filename) throws IOException {
    // Ensure the directory exists where the file will be saved
    File file = new File(filename);
    File parentDir = file.getParentFile();
    if (parentDir != null && !parentDir.exists()) {
      parentDir.mkdirs(); // Create the directory if it doesn't exist
    }

    // Try-with-resources statement to automatically close the stream after use
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
      // Write the game object to the file
      out.writeObject(game);
    }
  }

  // Method to load the game state from a file
  public static Game loadGame(String filename) throws IOException, ClassNotFoundException {
    // Try-with-resources statement to automatically close the stream after use
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
      // Read the game object from the file and return it
      return (Game) in.readObject();
    }
  }
}
