package game.infrastructure.logic;

public interface GameLogic {
    // This method should initialize the game process
    public void start();

    public void next(); //upon pressing next turn button

    public void gameEnd(); //when one player runs out of cards, this triggers
}
