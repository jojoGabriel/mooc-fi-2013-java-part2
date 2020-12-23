package clicker.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Calculator calc = new PersonalCalculator();
        UserInterface ui = new UserInterface(calc);
        SwingUtilities.invokeLater(ui);
    }
}
