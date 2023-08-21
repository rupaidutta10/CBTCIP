import javax.swing.JOptionPane;
import java.util.Random;

public class numguessing {

    public static void game() {
        Random random = new Random();
        int ans = random.nextInt(100) + 1;
        int i , trial = 5;
        int count = 0;
        int score = 500;

        JOptionPane.showMessageDialog(null, "You have to guess a number within five trials\nHint: The number is between 1 to 100");

        for ( i = 0; i < trial; i++) {
            String input = JOptionPane.showInputDialog("Guess the number:");
            int yourGuess = Integer.parseInt(input);

            if (ans == yourGuess) {
                JOptionPane.showMessageDialog(null, "You win! You have guessed the correct number\nYour score is " + score);
                break;
            } else if (ans > yourGuess && i != trial - 1) {
                count++;
                score -= 100;
                JOptionPane.showMessageDialog(null, "The correct number is greater than : " + yourGuess + "\nYou have " + (trial - count) + " trials left");
            } else if (ans < yourGuess && i != trial - 1) {
                count++;
                score -= 100;
                JOptionPane.showMessageDialog(null, "The correct number is lesser than : " + yourGuess + "\nYou have " + (trial - count) + " trials left");
            }
        }

        if (i == trial) {
            JOptionPane.showMessageDialog(null, "You ran out of five trials. Your score is 0\nThe number was " + ans);
        }
    }

    public static void main(String[] args) {
        boolean tryAgain;

        do {
            game();

            int choice = JOptionPane.showConfirmDialog(null, "Want to try again?", "Play Again", JOptionPane.YES_NO_OPTION);
            tryAgain = choice == JOptionPane.YES_OPTION;
        } while (tryAgain);

        JOptionPane.showMessageDialog(null, "Thanks for playing");
    }
}
