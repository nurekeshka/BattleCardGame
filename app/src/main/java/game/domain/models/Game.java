package game.domain.models;

import game.domain.enums.GameState;

public class Game {
    public final Player[] players;
    public GameState state;

    public Game(Player[] players) {
        this.players = players;
        this.state = GameState.RUNNING;
    }

    public void updateGameState() {
        // This class should check if any of the players update game state
    }
}
