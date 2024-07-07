// //classes should implement the Serializable interface so they can be
// serialized by ObjectOutputStream to save the game progress.

// import game.domain.models.Deck;
// import game.infrastructure.progress.GameSaver;

// import java.io.*;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// public class GameSaverImpl implements GameSaver {
// // Method to save the game state to a file
// public void saveGame(Deck[] gameDecks) throws IOException {
// // Ensure the directory exists where the file will be saved
// String saveName = "save-" + dateAndTimeAsString();
// File file = new File(saveName);

// // Try-with-resources statement to automatically close the stream after use
// try (ObjectOutputStream out = new ObjectOutputStream(new
// FileOutputStream(file))) {
// // Write the game object to the file
// out.writeObject(gameDecks); //the 3 decks are deckP1, deckP2 and deckBuffer
// }
// System.out.println("---------------FUNCTION SAVEGAME
// CALLED-----------------------------------");
// }

// // Method to load the game state from a file
// public Deck[] loadGame(String filename) throws IOException,
// ClassNotFoundException {
// // Try-with-resources statement to automatically close the stream after use
// try (ObjectInputStream in = new ObjectInputStream(new
// FileInputStream(filename))) {
// // Read the game object from the file and return it
// return (Deck[]) in.readObject();
// }
// }

// public String dateAndTimeAsString() {
// return new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
// package game.infrastructure.progress.impl;
// import game.infrastructure.progress.GameSaver;

// import java.io.*;

// public class GameSave {
// public static void saveGame(Deck deck1, Deck deck2, Deck deck3, String
// progressFile) throws IOException {
// try (ObjectOutputStream out = new ObjectOutputStream(new
// FileOutputStream(progress))) {
// out.writeObject(Deck);
// }
// }

// public static Deck loadGame(String progressFile) throws IOException,
// ClassNotFoundException {
// try (ObjectInputStream in = new ObjectInputStream(new
// FileInputStream(progress))) {
// return (Deck) in.readObject();
// }
// }
// }
