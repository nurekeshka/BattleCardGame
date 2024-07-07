package game.presentation.components.panels;

import javax.swing.JPanel;

import game.infrastructure.progress.GameProgress;
import game.infrastructure.logic.GameLogic;
import game.domain.repositories.CardsRepository;
import game.domain.models.Card;

import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;

import game.presentation.components.images.CardImage;
import game.presentation.components.labels.PlayerDeckLabel;
import game.presentation.components.labels.TotalCardsLabel;
import game.presentation.components.labels.TotalCardsViewLabel;
import game.presentation.frames.MainFrame;

public class GamePanel extends JPanel {
    private static final Font mainFont = new Font("Tahoma", Font.PLAIN, 8);
    private static final long serialVersionUID = 1L;

    private final transient GameLogic gameLogic;
    private final transient GameProgress gameProgress;
    private final transient CardsRepository cardsRepository;

    public GamePanel(GameLogic gameLogic, CardsRepository cardsRepository, GameProgress gameProgress) {
        this.gameLogic = gameLogic;
        this.gameProgress = gameProgress;
        this.cardsRepository = cardsRepository;
    }

    public GamePanel init(MainFrame main) {
        this.setPanelConfiguration(main);

        if (this.gameProgress.exists()) {
            this.newGameOrLoad();
        } else {
            this.startNewGame();
        }

        return this;
    }

    public void newGameOrLoad() {
        this.setLayout(new GridLayout(2, 1, 10, 10));

        JButton continueButton = new JButton("Continue the Game?");
        JButton newGameButton = new JButton("New Game");

        newGameButton.addActionListener((ActionEvent e) -> this.startNewGame());
        continueButton.addActionListener((ActionEvent e) -> this.continueGame());

        this.add(continueButton);
        this.add(newGameButton);
    }

    public void startNewGame() {
        this.gameLogic.newGame();
        this.updateFromGameState();
    }

    public void continueGame() {
        this.gameLogic.loadGame();
        this.updateFromGameState();
    }

    public void updateFromGameState() {
        this.clearFrame();
        this.setNextTurnButton();
        this.setLayout(null);
        this.setTotalCardsLabels();
        this.setWarBattleLabel();
    }

    public void setPlayerDeckLabels() {
        JLabel playerOneDeckLabel = new PlayerDeckLabel(
                this.getCardImage(this.gameLogic.getBattlingCardLeft(), 150, 200));
        playerOneDeckLabel.setBounds(150, 80, 150, 200);

        JLabel playerTwoDeckLabel = new PlayerDeckLabel(
                this.getCardImage(this.gameLogic.getBattlingCardRight(), 150, 200));
        playerTwoDeckLabel.setBounds(500, 80, 150, 200);

        add(playerOneDeckLabel);
        add(playerTwoDeckLabel);
    }

    public void setNextTurnButton() {
        JButton nextTurnButton = new JButton("Next Turn");
        nextTurnButton.setBounds(325, 325, 150, 50);
        nextTurnButton.addActionListener((ActionEvent e) -> {
            gameLogic.next();
            this.updateFromGameState();
        });

        add(nextTurnButton);
    }

    public void setWarBattleLabel() {
        JLabel warLabel = new JLabel();
        ImageIcon cover = this.getCardImage(new Card(null, null), 150, 200);

        warLabel.setHorizontalAlignment(SwingConstants.CENTER);
        warLabel.setBounds(362, 130, 75, 100);
        warLabel.setIcon(cover);
        add(warLabel);
    }

    public void setTotalCardsLabels() {
        JLabel playerOneTotalLabel = new TotalCardsLabel(mainFont);
        playerOneTotalLabel.setBounds(20, 180, 100, 20);
        add(playerOneTotalLabel);

        JLabel playerTwoTotalLabel = new TotalCardsLabel(mainFont);
        playerTwoTotalLabel.setBounds(680, 180, 100, 20);
        add(playerTwoTotalLabel);

        JLabel playerOneCardsLabel = new TotalCardsViewLabel(this.gameLogic.getPlayerOneDeckCardsCount());
        playerOneCardsLabel.setBounds(20, 200, 100, 20);
        add(playerOneCardsLabel);

        JLabel playerTwoCardsLabel = new TotalCardsViewLabel(this.gameLogic.getPlayerTwoDeckCardsCount());
        playerTwoCardsLabel.setBounds(680, 200, 100, 20);
        add(playerTwoCardsLabel);
    }

    public void setMenuConfiguration() {
        String[] authorsList = new String[] { "Amirali", "Eslam", "Ulukbek", "Michael", "Miras", "Nurbek", "Omar" };

        JMenuBar menu = new JMenuBar();
        JMenu authors = new JMenu("Authors");

        for (String author : authorsList) {
            authors.add(new JMenuItem(author));
        }

        menu.setBounds(0, 0, 786, 25);
        menu.add(authors);
        this.add(menu);
    }

    public ImageIcon getCardImage(Card card) {
        return new CardImage(this.cardsRepository.getImagePath(card));
    }

    public ImageIcon getCardImage(Card card, int width, int height) {
        CardImage image = new CardImage(this.cardsRepository.getImagePath(card));
        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public void clearFrame() {
        this.removeAll();
        this.updatePanel();
    }

    public void updatePanel() {
        this.revalidate();
        this.repaint();
    }

    public void setPanelConfiguration(MainFrame main) {
        setBounds(100, 100, main.getWindowWidth(), main.getWindowHeight());
        setBorder(new EmptyBorder(5, 5, 5, 5));
    }
}
