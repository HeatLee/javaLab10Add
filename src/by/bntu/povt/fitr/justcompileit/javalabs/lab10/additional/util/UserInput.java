package by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.util;

import by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.view.Printer;

import java.util.Scanner;
public class UserInput {
    public Scanner scanner;
    public final String ERROR_MESSAGE = "Wrong type of data. Please input integer value...\n";

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public int nextInt(String msg, Printer printer){
        printer.print(msg);
        if (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print(ERROR_MESSAGE);
            return nextInt(msg, printer);
        }
        return scanner.nextInt();
    }

    public char nextChar(String msg, Printer printer){
        printer.print(msg);
        return scanner.next().charAt(0);
    }
}
