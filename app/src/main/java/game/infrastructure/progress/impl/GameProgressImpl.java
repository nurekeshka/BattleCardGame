package game.infrastructure.progress.impl;

import game.domain.enums.PlayerNames;
import game.domain.models.Card;
import game.domain.models.Deck;
import game.domain.models.Game;
import game.domain.models.Player;
import game.domain.repositories.CardsRepository;
import game.infrastructure.progress.GameProgress;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;

public class GameProgressImpl implements GameProgress {
    private static Path gameSavePath = Paths.get("src", "main", "resources", "saves", "progress.json");

    private static String playersArrayName = "players";
    private static String battleCardName = "battle-card";
    private static String bufferName = "buffer";
    private static String suitName = "suit";
    private static String rankName = "rank";

    private final CardsRepository cardsRepository;

    public GameProgressImpl(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    public Game newGame() {
        Deck fullDeck = this.cardsRepository.getFullDeck();
        fullDeck.shuffle();

        Player[] players = new Player[] {
                new Player(PlayerNames.PLAYER_ONE.toString(), new Deck(fullDeck.takeCardsFromBottom(26))),
                new Player(PlayerNames.PLAYER_TWO.toString(), new Deck(fullDeck.takeCardsFromBottom(26))),
        };

        return new Game(players);
    }

    public Game loadGame() {
        try (InputStream is = new FileInputStream(GameProgressImpl.gameSavePath.toFile().toString()); //get the path to save file
                JsonReader reader = Json.createReader(is)) {
            JsonObject object = reader.readObject();
            Player[] players = this.getPlayers(object); //load player objects from json
            Deck bufferDeck = this.getBufferDeck(object); //load buffer deck from json

            return new Game(players, bufferDeck); //return the information as a Game object
        } catch (IOException e) {
            System.exit(0); //this was needed to prevent compiler being angry
        }

        return null;
    }

    //converting multiple players to json
    public Player[] getPlayers(JsonObject object) {
        List<Player> players = new ArrayList<>();

        for (JsonValue playerJsonValue : object.getJsonArray(playersArrayName)) {
            JsonObject player = playerJsonValue.asJsonObject();
            players.add(this.getPlayer(player));
        }

        return players.toArray(new Player[] {});
    }

    //convert one player to json, used in previous function
    public Player getPlayer(JsonObject object) {
        return new Player(object.getString("name"), this.getDeckFromJsonArray(object.getJsonArray("deck")),
                this.getCardFromJsonObject(object.getJsonObject(battleCardName)));
    }

    public Deck getBufferDeck(JsonObject object) {
        return this.getDeckFromJsonArray(object.getJsonArray(bufferName));
    }

    public Deck getDeckFromJsonArray(JsonArray array) {
        List<Card> cards = new ArrayList<>();

        for (JsonValue cardValue : array) {
            JsonObject cardObject = cardValue.asJsonObject();
            cards.add(this.getCardFromJsonObject(cardObject));
        }

        return new Deck(cards.toArray(new Card[] {}));
    }

    public Card getCardFromJsonObject(JsonObject object) {
        return this.cardsRepository.getCard(object.getString(suitName), object.getString(rankName));
    }

    //writing all the game information to json file
    public void saveGame(Game game) {
        JsonArrayBuilder players = this.savePlayers(game);
        JsonArrayBuilder buffer = this.saveBuffer(game);

        JsonObjectBuilder gameObject = Json.createObjectBuilder()
                .add("players", players)
                .add("buffer", buffer);

        try (OutputStream os = new FileOutputStream(gameSavePath.toString());
                JsonWriter jsonWriter = Json.createWriter(os)) {
            jsonWriter.writeObject(gameObject.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //used in saveGame()
    public JsonArrayBuilder savePlayers(Game game) {
        JsonArrayBuilder playersBuilder = Json.createArrayBuilder();
        Player[] players = game.getPlayers();

        for (Player player : players) {
            playersBuilder.add(this.savePlayer(player));
        }

        return playersBuilder;
    }

    //used in saveGame()
    public JsonObjectBuilder savePlayer(Player player) {
        JsonObjectBuilder playerBuilder = Json.createObjectBuilder();

        playerBuilder.add("name", player.getName());

        if (player.getBattleCard() == null) {
            playerBuilder.add(battleCardName, Json.createObjectBuilder().build());
        } else {
            playerBuilder.add(battleCardName, this.saveCard(player.getBattleCard()));

        }

        playerBuilder.add("deck", this.saveDeck(player.getDeck()));

        return playerBuilder;
    }

    //used in saveGame()
    public JsonArrayBuilder saveBuffer(Game game) {
        return this.saveDeck(game.getBuffer());
    }

    //used in saveGame()
    public JsonArrayBuilder saveDeck(Deck deck) {
        JsonArrayBuilder deckBuilder = Json.createArrayBuilder();

        for (Card card : deck.getCards()) {
            deckBuilder.add(this.saveCard(card));
        }

        return deckBuilder;
    }

    //used in saveGame()
    public JsonObjectBuilder saveCard(Card card) {
        JsonObjectBuilder cardBuilder = Json.createObjectBuilder();

        cardBuilder
                .add("suit", card.getSuit().toString())
                .add("rank", card.getRank().toString());

        return cardBuilder;
    }

    public boolean exists() {
        return GameProgressImpl.gameSavePath.toFile().exists();
    }
}
