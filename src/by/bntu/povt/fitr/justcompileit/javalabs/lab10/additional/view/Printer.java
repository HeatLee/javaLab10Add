package by.bntu.povt.fitr.justcompileit.javalabs.lab10.additional.view;

public class Printer {

    public void showMenu(String[] items, String menuTitle) {
        System.out.print(menuTitle + "\n");
        for (int i = 0; i < items.length; i++) {
            System.out.print(String.format("%d. " + items[i] + ";\n", (i+1)));
        }
    }
    public void print(String msg) {
        System.out.print(msg);
    }
}
