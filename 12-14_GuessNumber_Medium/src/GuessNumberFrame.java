import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Class to handle the logic of the guess a number game.
 * Includes a textfield to enter guesses in, labels to provide descriptions of gameplay, and a button to restart the game.
 */
public class GuessNumberFrame extends JFrame {
    /**
     * Private variable to hold the current random number
     */
    private int randomNum;

    /**
     * Private variable to hold the previous guess
     */
    private int prevNum = 0;

    /**
     * Private variable to hold the textfield where guesses are entered
     */
    private final JTextField textField1;

    /**
     * Private variable that declares the label that holds the hint if guesses are too high or too low
     */
    private JLabel hint = new JLabel();

    /**
     * Constructor for the class that encompasses everything. Initializes the variables for the textfields and labels and adds them to layout.
     * Also generates a random number and adds event handlers to the textfield and play again button.
     */
    public GuessNumberFrame() {
        //title and layout
        super("Guess the Number Game");
        setLayout(new FlowLayout());

        //making a new random variable and storing it in class instance variable
        Random rand = new Random();
        this.randomNum = rand.nextInt(1000)+1;

        //initiates textfields with default text
        JLabel label1 = new JLabel("I have a number between 1 and 1000. Can you guess my number?");
        JLabel label2 = new JLabel("Please enter your guesses here: ");
        add(label1);
        add(label2);

        //adding textfield and hit label
        textField1 = new JTextField(20);
        add(textField1);

        add(hint);

        //adding handlers to the textfield and play again button
        GuessHandler handler = new GuessHandler();
        textField1.addActionListener(handler);

        JButton newGame = new JButton("Play Again");
        add(newGame);

        NewGameHandler ngh = new NewGameHandler();
        newGame.addActionListener(ngh);
    }

    /**
     * Method to reset the random number when a new game is started.
     */
    private void setRandomNum() {
        Random rand = new Random();
        this.randomNum = rand.nextInt(1000)+1;
    }

    /**
     * Class to handle the event when the enter key is pressed after entering a guess into the textfield.
     */
    private class GuessHandler implements ActionListener {

        /**
         * Method to manipulate the textfield and analyze the guess that was entered.
         * @param e The event that is thrown when enter key is pressed in textfield.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //getting number from the textfield
            int num = Integer.parseInt(e.getActionCommand());

            //the case when the number guessed is too high
            if (num > randomNum) {
                hint.setText("Too High!");
                //checks to see what color to set the background based on previous guess
                if (Math.abs(randomNum - num) <= Math.abs(randomNum - prevNum)) {
                    textField1.setBackground(Color.RED);
                } else {
                    textField1.setBackground(Color.CYAN);
                }
            }
            //the case when the number guessed is too low
            else if (num < randomNum) {
                hint.setText("Too Low!");
                if (Math.abs(randomNum - num) <= Math.abs(randomNum - prevNum)) {
                    textField1.setBackground(Color.RED);
                } else {
                    textField1.setBackground(Color.CYAN);
                }
            }
            //the case when the number guessed is correct
            else {
                hint.setText("Correct!");
                textField1.setBackground(Color.GRAY);
                textField1.setEditable(false);
            }

            //resets previous guess after each term
            prevNum = num;
        }
    }

    /**
     * Class that handles when the play again button is clicked.
     */
    private class NewGameHandler implements ActionListener {

        /**
         * Method that sets actions to take when play again button is clicked. Generates a new random number,
         * resets the textfield, resets the previous guess variable, and resets the hint label.
         * @param e Event that is fired when play again button is clicked.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            //resets random number
            setRandomNum();
            //resets background color and editable back to true
            textField1.setBackground(Color.WHITE);
            textField1.setEditable(true);
            //resets previous guess
            prevNum = 0;
            //resets text in textfield and hint label
            textField1.setText("");
            hint.setText("");
        }
    }
}
