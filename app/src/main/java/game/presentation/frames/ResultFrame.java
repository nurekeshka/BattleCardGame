import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {
    public ResultFrame(int userScore, int pcScore) {
        // Set up the frame
        setTitle("Game Result");
        setSize(300, 150);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel to hold components
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(2, 1));

        // Label to show the result
        JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Serif", Font.BOLD, 18));

        // Determine the result and set the label text
        if (userScore > pcScore) {
            resultLabel.setText("User wins!");
        } else if (pcScore > userScore) {
            resultLabel.setText("PC wins!");
        } else {
            resultLabel.setText("It's a tie!");
        }
        resultPanel.add(resultLabel);

        // Label to show the scores
        JLabel scoreLabel = new JLabel("User card: " + userScore + ", PC card: " + pcScore, SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        resultPanel.add(scoreLabel);

        // Add panel to the frame
        add(resultPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Example usage
        SwingUtilities.invokeLater(() -> new ResultFrame(10, 5)); // Change the scores as needed for testing
    }
}
