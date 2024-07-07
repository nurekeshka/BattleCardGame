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
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import java.io.StringReader;

public class GameProgressImpl implements GameProgress {
    private static Path gameSavePath = Paths.get("src", "main", "resources", "saves", "progress.json");

    private static String playersArrayName = "players";
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
        JsonReader reader = Json.createReader(new StringReader(GameProgressImpl.gameSavePath.toFile().toString()));
        JsonObject object = reader.readObject();
        reader.close();

        Player[] players = this.getPlayers(object);

        return null;
    }

    public Player[] getPlayers(JsonObject object) {
        List<Player> players = new ArrayList<>();

        for (JsonValue playerJsonValue : object.getJsonArray(playersArrayName)) {
            JsonObject player = playerJsonValue.asJsonObject();
            players.add(this.getPlayer(player));
        }

        return players.toArray(new Player[] {});
    }

    public Player getPlayer(JsonObject object) {
        return new Player(object.getString("name"), this.getPlayerDeck(object.getJsonArray("deck")));
    }

    public Deck getPlayerDeck(JsonArray array) {
        List<Card> cards = new ArrayList<>();

        for (JsonValue cardValue : array) {
            JsonObject cardObject = cardValue.asJsonObject();
            cards.add(this.cardsRepository.getCard(cardObject.getString(suitName), cardObject.getString(rankName)));
        }

        return new Deck(cards.toArray(new Card[] {}));
    }

    public boolean exists() {
        return GameProgressImpl.gameSavePath.toFile().exists();
    }
}
