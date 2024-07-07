package game.domain.enums;

public enum PlayerNames {
    PLAYER_ONE("Player One"),
    PLAYER_TWO("Player Two"),
    COMPUTER("Computer");

    private final String name;

    private PlayerNames(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
