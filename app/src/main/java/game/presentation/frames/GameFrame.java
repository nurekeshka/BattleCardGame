package game.presentation.frames;

import game.domain.enums.CardSuit;
import game.domain.enums.PlayerNames;
import game.domain.enums.CardRank;
import game.domain.models.Card;
import game.domain.models.Game;
import game.domain.models.Player;
import game.domain.repositories.CardsRepository;
import game.infrastructure.logic.GameLogic;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class GameFrame extends JFrame {
	private static final Font mainFont = new Font("Tahoma", Font.PLAIN, 8);
	private static final Font loggerFont = new Font("Tahoma", Font.PLAIN, 7);
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private final GameLogic gameLogic;
	private final CardsRepository cardsRepository;

	public GameFrame(GameLogic gameLogic, CardsRepository cardsRepository) {
		this.gameLogic = gameLogic;
		this.cardsRepository = cardsRepository;
	}

	public void init() {
		setTitle("Title Upcoming");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnNextTurn = new JButton("Next Turn");
		btnNextTurn.setBounds(325, 325, 150, 50);
		btnNextTurn.addActionListener((ActionEvent e) -> {
			gameLogic.next();
		});
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 786, 25);
		contentPane.add(menuBar);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		JMenuItem mntmMenuItem1 = new JMenuItem("Code: Name(s)");
		mnAbout.add(mntmMenuItem1);

		JMenuItem mntmMenuItem2 = new JMenuItem("UI: Name(s)");
		mnAbout.add(mntmMenuItem2);

		JMenuItem mntmMenuItem3 = new JMenuItem("Images: Name(s)");
		mnAbout.add(mntmMenuItem3);
		contentPane.add(btnNextTurn);

		// IMPORTING IMAGES HERE
		Card card = new Card(CardSuit.HEARTS, CardRank.ACE);
		Path path = cardsRepository.getImagePath(card);

		ImageIcon img1 = new ImageIcon(path.toString()); // Full Size - Deck
		Image imgTemp;
		imgTemp = img1.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
		img1 = new ImageIcon(imgTemp);
		imgTemp = img1.getImage().getScaledInstance(img1.getIconWidth() / 2, img1.getIconHeight() / 2,
				Image.SCALE_SMOOTH);
		ImageIcon img1Small = new ImageIcon(imgTemp); // Half Size - War

		JLabel playerOneDeckLabel = new JLabel("");
		playerOneDeckLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerOneDeckLabel.setBounds(150, 80, 150, 200);
		playerOneDeckLabel.setIcon(img1);
		contentPane.add(playerOneDeckLabel);

		JLabel playerTwoDeckLabel = new JLabel("");
		playerTwoDeckLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerTwoDeckLabel.setBounds(500, 80, 150, 200);
		playerTwoDeckLabel.setIcon(img1);
		contentPane.add(playerTwoDeckLabel);

		JLabel playerOneTotalLabel = new JLabel("Total Cards Count");
		playerOneTotalLabel.setFont(mainFont);
		playerOneTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerOneTotalLabel.setBounds(20, 180, 100, 20);
		contentPane.add(playerOneTotalLabel);

		JLabel playerTwoTotalLabel = new JLabel("Total Cards Count");
		playerTwoTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerTwoTotalLabel.setFont(mainFont);
		playerTwoTotalLabel.setBounds(680, 180, 100, 20);
		contentPane.add(playerTwoTotalLabel);

		JLabel playerOneCardsLabel = new JLabel("N");
		playerOneCardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerOneCardsLabel.setBounds(20, 200, 100, 20);
		contentPane.add(playerOneCardsLabel);

		JLabel playerTwoCardsLabel = new JLabel("N");
		playerTwoCardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerTwoCardsLabel.setBounds(680, 200, 100, 20);
		contentPane.add(playerTwoCardsLabel);

		JLabel warLabel = new JLabel("");
		warLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warLabel.setBounds(362, 130, 75, 100);
		warLabel.setIcon(img1Small);
		contentPane.add(warLabel);

		JLabel lblLogs = new JLabel(
				"Logs: This shows the most recent action taken for better clarity and debug purposes");
		lblLogs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogs.setFont(loggerFont);
		lblLogs.setBounds(475, 35, 300, 20);
		contentPane.add(lblLogs);
		setVisible(true);
	}

	private void startGame() {
		Player[] players = new Player[] {
				new Player(PlayerNames.PLAYER_ONE.toString(), null),
				new Player(PlayerNames.PLAYER_TWO.toString(), null)
		};
		this.gameLogic.setGameObject((new Game(players)));
		this.gameLogic.start();
	}
}