package game.domain.models;

import game.domain.enums.GameState;

public class Game {
    private final Player[] players;
    private Deck buffer;
    private GameState state;

    public Game(Player[] players, Deck buffer) {
        this.players = players;
        this.state = GameState.RUNNING;
        this.buffer = buffer;
    }

    public Deck getBuffer() {
        return buffer;
    }

    public void setBuffer(Deck buffer) {
        this.buffer = buffer;
    }

    public void updateGameState(GameState state) {
        this.state = state;
    }

    public Deck getPlayerOneDeck() {
        return this.players[0].getDeck();
    }

    public Deck getPlayerTwoDeck() {
        return this.players[1].getDeck();
    }

    public Player[] getPlayers() {
        return players;
    }

    public GameState getState() {
        return state;
    }
}
