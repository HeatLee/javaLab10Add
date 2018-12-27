package by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.model.logic;

import by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.util.UserInput;
import by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.view.Printer;

import java.util.Random;
public class GameLogic {
    private int attempts;
    private int firstLimit;
    private int secondLimit;
    private static final String WRONG_TIP = "I can not understand such tip. Try again...";
    private static final String GET_TIP_MSG = "< or > or = : ";
    private static final String SHOW_LIMITS_1 = "Guess number from ";
    private static final String SHOW_LIMITS_2 = " to ";
    private static final String SHOW_GUESS = "My guess is ";
    private static final String SHOW_NUMBER = "Your number is ";
    private static final char BIGGER = '>';
    private static final char LOWER = '<';
    private static final char EQUALS = '=';
    public static  Random random = new Random();

    public GameLogic() {

    }

    public GameLogic(int[] setup) {
        firstLimit = setup[0];
        secondLimit = setup[1];
    }

    private void incAttempt() {
        this.attempts++;
    }

    public int showAttempts() {
        return this.attempts;
    }

    public void showLimits(Printer printer) {
        printer.print(SHOW_LIMITS_1 + firstLimit + SHOW_LIMITS_2 + secondLimit + "\n");
    }

    private int tryRandomGuess() {
        return random.nextInt(secondLimit - firstLimit) + firstLimit + 1;
    }

    public void PlayRandom(UserInput userInput, Printer printer) {
        boolean run = true;
        while (run) {
            int guess = tryRandomGuess();
            printer.print(SHOW_GUESS + guess + "\n");
            char tip = getTip(userInput, printer);
            switch (tip) {
                case LOWER:
                    secondLimit = guess;
                    break;
                case BIGGER:
                    firstLimit = guess;
                    break;
                case EQUALS:
                    printer.print("\n" + SHOW_NUMBER + guess + "\n");
                    run = false;
                    break;
            }
            incAttempt();
        }
    }

    private int tryGuess() {
        return (secondLimit + firstLimit)/2;
    }

    public void PlayBinary(UserInput userInput, Printer printer) {
        boolean run = true;
        while (run) {
            int guess = tryGuess();
            printer.print(SHOW_GUESS + guess + "\n");
            char tip = getTip(userInput, printer);
            switch (tip) {
                case LOWER:
                    secondLimit = guess;
                    break;
                case BIGGER:
                    firstLimit = guess;
                    break;
                case EQUALS:
                    printer.print(SHOW_NUMBER + guess + "\n");
                    run = false;
                    break;
            }
            incAttempt();
        }
    }

    private char getTip(UserInput userInput, Printer printer) {
        char tip = userInput.nextChar(GET_TIP_MSG, printer);
        if (tip != LOWER && tip != BIGGER && tip != EQUALS) {
            printer.print(WRONG_TIP);
            return getTip(userInput, printer);
        }
        return tip;
    }
}

