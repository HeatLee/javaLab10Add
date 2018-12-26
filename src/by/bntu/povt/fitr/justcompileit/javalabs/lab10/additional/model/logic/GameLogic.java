package by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.model.logic;

import by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.util.UserInput;
import by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.view.Printer;

import java.util.Random;
public class GameLogic {
    private static int ATTEMPT = 0;
    private static int FIRST_LIMIT = 0;
    private static int SECOND_LIMIT = 0;
    public static  Random random = new Random();


    public static void setLimits(int[] setup) {
        FIRST_LIMIT = setup[0];
        SECOND_LIMIT = setup[1];
    }

    private static void incAttempt() {
        ATTEMPT++;
    }

    public static void gameInit() {
        ATTEMPT = 0;
    }

    public static int showAttempts() {
        return ATTEMPT;
    }

    public static void showLimits(Printer printer) {
        printer.print("Guess number from " + FIRST_LIMIT + " to " + SECOND_LIMIT + "\n");
    }

    private static int tryRandomGuess() {
        return random.nextInt(SECOND_LIMIT - FIRST_LIMIT) + FIRST_LIMIT + 1;
    }

    public static void PlayRandom(UserInput userInput, Printer printer) {
        boolean run = true;
        while (run) {
            int guess = tryRandomGuess();
            printer.print("My guess is " + guess + "\n");
            char tip = getTip(userInput, printer);
            switch (tip) {
                case '<':
                    SECOND_LIMIT = guess;
                    break;
                case '>':
                    FIRST_LIMIT = guess;
                    break;
                case '=':
                    printer.print("\nYour number is " + guess + "\n");
                    run = false;
                    break;
            }
            incAttempt();
        }
    }

    private static int tryGuess() {
        return (SECOND_LIMIT + FIRST_LIMIT)/2;
    }

    public static void PlayBinary(UserInput userInput, Printer printer) {
        boolean run = true;
        while (run) {
            int guess = tryGuess();
            printer.print("My guess is " + guess + "\n");
            char tip = getTip(userInput, printer);
            switch (tip) {
                case '<':
                    SECOND_LIMIT = guess;
                    break;
                case '>':
                    FIRST_LIMIT = guess;
                    break;
                case '=':
                    printer.print("Your number is " + guess + "\n");
                    run = false;
                    break;
            }
            incAttempt();
        }
    }

    private static char getTip(UserInput userInput, Printer printer) {
        char tip = userInput.nextChar("< or > or = : ", printer);
        if (tip != '<' && tip != '>' && tip != '=') {
            printer.print("I can not understand such tip. Try again...");
            return getTip(userInput, printer);
        }
        return tip;
    }
}

