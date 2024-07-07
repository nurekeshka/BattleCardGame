package game.presentation.components.panels;

import javax.swing.JPanel;

import game.domain.enums.CardSuit;
import game.domain.enums.CardRank;
import game.domain.models.Card;
import game.domain.repositories.CardsRepository;
import game.infrastructure.logic.GameLogic;
import game.infrastructure.progress.GameProgress;

import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.nio.file.Path;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import game.presentation.components.labels.PlayerDeckLabel;
import game.presentation.components.labels.TotalCardsLabel;
import game.presentation.frames.MainFrame;

public class GamePanel extends JPanel {
    private static final Font mainFont = new Font("Tahoma", Font.PLAIN, 8);
    private static final Font loggerFont = new Font("Tahoma", Font.PLAIN, 7);
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
            this.foo();
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
    }

    public void continueGame() {
        this.gameLogic.loadGame();
    }

    public void foo() {
        JButton btnNextTurn = new JButton("Next Turn");
        btnNextTurn.setBounds(325, 325, 150, 50);
        btnNextTurn.addActionListener((ActionEvent e) -> gameLogic.next());
        setLayout(null);
        add(btnNextTurn);

        Card card = new Card(CardSuit.HEARTS, CardRank.ACE);
        Path path = cardsRepository.getImagePath(card);

        ImageIcon img1 = new ImageIcon(path.toString()); // Full Size - Deck
        Image imgTemp;
        imgTemp = img1.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        img1 = new ImageIcon(imgTemp);
        imgTemp = img1.getImage().getScaledInstance(img1.getIconWidth() / 2, img1.getIconHeight() / 2,
                Image.SCALE_SMOOTH);
        ImageIcon img1Small = new ImageIcon(imgTemp); // Half Size - War

        JLabel playerOneDeckLabel = new PlayerDeckLabel(img1);
        playerOneDeckLabel.setBounds(150, 80, 150, 200);
        add(playerOneDeckLabel);

        JLabel playerTwoDeckLabel = new PlayerDeckLabel(img1);
        playerTwoDeckLabel.setBounds(500, 80, 150, 200);
        add(playerTwoDeckLabel);

        JLabel playerOneTotalLabel = new TotalCardsLabel(mainFont);
        playerOneTotalLabel.setBounds(20, 180, 100, 20);
        add(playerOneTotalLabel);

        JLabel playerTwoTotalLabel = new TotalCardsLabel(mainFont);
        playerTwoTotalLabel.setBounds(680, 180, 100, 20);
        add(playerTwoTotalLabel);

        JLabel playerOneCardsLabel = new JLabel("N");
        playerOneCardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerOneCardsLabel.setBounds(20, 200, 100, 20);
        add(playerOneCardsLabel);

        JLabel playerTwoCardsLabel = new JLabel("N");
        playerTwoCardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerTwoCardsLabel.setBounds(680, 200, 100, 20);
        add(playerTwoCardsLabel);

        JLabel warLabel = new JLabel("");
        warLabel.setHorizontalAlignment(SwingConstants.CENTER);
        warLabel.setBounds(362, 130, 75, 100);
        warLabel.setIcon(img1Small);
        add(warLabel);

        JLabel lblLogs = new JLabel(
                "Logs: This shows the most recent action taken for better clarity and debug purposes");
        lblLogs.setHorizontalAlignment(SwingConstants.RIGHT);
        lblLogs.setFont(loggerFont);
        lblLogs.setBounds(475, 35, 300, 20);
        add(lblLogs);
        setVisible(true);
    }

    public ImageIcon getImage(Card card) {
        return new ImageIcon(this.cardsRepository.getImagePath(card).toString());
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

    public void setPanelConfiguration(MainFrame main) {
        setBounds(100, 100, main.getWindowWidth(), main.getWindowHeight());
        setBorder(new EmptyBorder(5, 5, 5, 5));
    }
}
