import view.menu.MainMenu;
import utils.DatabaseConnection;

import java.io.IOException;
import java.util.logging.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

            DatabaseConnection conn = DatabaseConnection.getInstance();        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
            MainMenu.showMainMenu();
            DatabaseConnection.destroyInstance();

    }
}