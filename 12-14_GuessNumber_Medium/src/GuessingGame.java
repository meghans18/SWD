import javax.swing.*;

/**
 * Class that is the main driver for the guessing a number game.
 */
public class GuessingGame {
    /**
     * Main method of this class and module in general. Creates a new instance of the GuessNumberFrame class.
     * Declares a size for the instance and also sets it to visible.
     * @param args Arguments taken from command line.
     */
    public static void main(String[] args) {
        GuessNumberFrame guessGame = new GuessNumberFrame();
        guessGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guessGame.setSize(500, 150);
        guessGame.setVisible(true);
    }
}
