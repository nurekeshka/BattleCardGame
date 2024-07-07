package game.infrastructure.progress.impl;

import game.domain.enums.PlayerNames;
import game.domain.models.Deck;
import game.domain.models.Game;
import game.domain.models.Player;
import game.domain.repositories.CardsRepository;
import game.infrastructure.progress.GameProgress;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameProgressImpl implements GameProgress {
    private static Path gameSavePath = Paths.get("src", "main", "resources", "saves", "progress.json");

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
        GameProgressImpl.gameSavePath.toFile().toString();
        return null;
    }

    public boolean exists() {
        return GameProgressImpl.gameSavePath.toFile().exists();
    }
}
