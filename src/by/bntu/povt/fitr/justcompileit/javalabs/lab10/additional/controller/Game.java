package by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.controller;

import by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.util.Choise;
import by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.util.UserInput;
import by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.view.Printer;
import by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.model.logic.GameLogic;
public class Game {
    public static final String[] MENU_ITEMS = {"EASY", "NORMAL", "DIFFICULT", "INSANE"};
    public static final String MENU_TITLE = "Choose difficulty:";
    public static final String[] METHODS = {"Random", "Binary"};
    public static final String SUBMENU_TITLE = "Choose methods that i should use: ";
    public static final String EXITING_MESSAGE = "Do you want to play more? (y/n)\n";
    private static final int[] EASY = {0, 50};
    private static final int[] NORMAL = {0, 100};
    private static final int[] DIFFICULT = {20, 100};
    private static final int[] INSANE = {1000, 9999};
    private static final int[][] LVLS = {EASY, NORMAL, DIFFICULT, INSANE};
    private static final boolean DEFAULT_RUN = true;
    public static Printer printer = new Printer();
    public static UserInput userInput = new UserInput();

    public static void main(String[] args) {
        boolean run = DEFAULT_RUN;
        while (run) {
            printer.showMenu(MENU_ITEMS, MENU_TITLE);
            int item = Choise.chooseMenuItem(MENU_ITEMS.length, printer, userInput);
            GameLogic.setLimits(LVLS[item]);
            GameLogic.gameInit();
            printer.showMenu(METHODS, SUBMENU_TITLE);
            int method = Choise.chooseMenuItem(METHODS.length, printer, userInput);
            GameLogic.showLimits(printer);
            switch (method) {
                case 0:
                    GameLogic.PlayRandom(userInput, printer);
                    break;
                case 1:
                    GameLogic.PlayBinary(userInput, printer);
                    break;
            }
            printer.print("I used " + GameLogic.showAttempts() + " attempts...\n");
            run = Choise.exiting(EXITING_MESSAGE, printer, userInput);
        }
    }
}
