package game.presentation.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setTitle("Title Upcoming");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnNextTurn = new JButton("Next Turn");
		btnNextTurn.setBounds(325, 325, 150, 50);
		btnNextTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
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
		ImageIcon imgJ = new ImageIcon("PLACEHOLDER_CARD_IMAGE.png"); // Full Size - Deck
		Image imgTemp = imgJ.getImage().getScaledInstance(imgJ.getIconWidth() / 2, imgJ.getIconHeight() / 2,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon imgJS = new ImageIcon(imgTemp); // Half Size - War

		JLabel lblDeck_P1 = new JLabel("");
		lblDeck_P1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeck_P1.setBounds(150, 80, 150, 200);
		lblDeck_P1.setIcon(imgJ);
		contentPane.add(lblDeck_P1);

		JLabel lblDeck_P2 = new JLabel("");
		lblDeck_P2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeck_P2.setBounds(500, 80, 150, 200);
		lblDeck_P2.setIcon(imgJ);
		contentPane.add(lblDeck_P2);

		JLabel lblTotal_P1 = new JLabel("Total Cards Count");
		lblTotal_P1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblTotal_P1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal_P1.setBounds(20, 180, 100, 20);
		contentPane.add(lblTotal_P1);

		JLabel lblTotal_P2 = new JLabel("Total Cards Count");
		lblTotal_P2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal_P2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblTotal_P2.setBounds(680, 180, 100, 20);
		contentPane.add(lblTotal_P2);

		JLabel lblTotalN_P1 = new JLabel("N");
		lblTotalN_P1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalN_P1.setBounds(20, 200, 100, 20);
		contentPane.add(lblTotalN_P1);

		JLabel lblTotalN_P2 = new JLabel("N");
		lblTotalN_P2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalN_P2.setBounds(680, 200, 100, 20);
		contentPane.add(lblTotalN_P2);

		JLabel lblWar_P1 = new JLabel("");
		lblWar_P1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWar_P1.setBounds(310, 130, 75, 100);
		lblWar_P1.setIcon(imgJS);
		contentPane.add(lblWar_P1);

		JLabel lblWar_P2 = new JLabel("");
		lblWar_P2.setHorizontalAlignment(SwingConstants.CENTER);
		lblWar_P2.setBounds(415, 130, 75, 100);
		lblWar_P2.setIcon(imgJS);
		contentPane.add(lblWar_P2);

		JLabel lblLogs = new JLabel(
				"Logs: This shows the most recent action taken for better clarity and debug purposes");
		lblLogs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogs.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblLogs.setBounds(475, 35, 300, 20);
		contentPane.add(lblLogs);
	}
}