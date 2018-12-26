package by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.util;


import by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.view.Printer;

public class Choise {
    public static final String INPUT_ITEM = "Input menu item:";
    public static final String WRONG_TYPE_ERROR = "Wong type of answer. Try again...\n";
    public static final String NO_ITEM_ERROR = "Thar's no such menu item. Try again...\n";
    public static final char POSITIVE_ANSWER = 'y';
    public static final char NEGATIVE_ANSWER = 'n';

    public static int chooseMenuItem(int amountOfItems, Printer printer, UserInput userInput) {
        int item = userInput.nextInt(INPUT_ITEM, printer) - 1;
        if (item >= amountOfItems || item < 0) {
            System.out.print(NO_ITEM_ERROR);
            return chooseMenuItem(amountOfItems, printer, userInput);
        }
        return item;
    }
    public static boolean exiting(String msg, Printer printer, UserInput userInput) {
        char answer = userInput.nextChar(msg, printer);
        if (answer == POSITIVE_ANSWER) {
            return true;
        } else if (answer == NEGATIVE_ANSWER) {
            return false;
        } else {
            printer.print(WRONG_TYPE_ERROR);
            return exiting(msg, printer, userInput);
        }
    }
}
