import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    
    public App() {
        // Set up the frame
        setTitle("Game Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        
        // Create a panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        
        // Create the buttons
        JButton startButton = new JButton("Start new game");
        JButton contgameButton = new JButton("Continue existing game");
        JButton exitButton = new JButton("Quit the game");
        
        // Add buttons to the panel
        panel.add(startButton);
        panel.add(contgameButton);
        panel.add(exitButton);
        
        // Add action listeners for buttons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to start the game
                JOptionPane.showMessageDialog(null, "Starting the Game...");
            }
        });
        
        contgameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to show options
                JOptionPane.showMessageDialog(null, "Last game is opening...");
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to exit the game
                System.exit(0);
            }
        });
        
        // Add the panel to the frame
        add(panel);
        
        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of the main menu
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}
