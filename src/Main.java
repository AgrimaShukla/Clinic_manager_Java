import view.menu.MainMenu;
import utils.DatabaseConnection;

import java.io.IOException;
import java.util.logging.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {

        FileHandler fh;

        try {

            fh = new FileHandler("C:/UserS/ashukla/Desktop/Java/mini-project/Clinic_manager_Java/MyLogFile.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            LOGGER.addHandler(fh);
            LOGGER.log(Level.INFO, "Start of application");

            DatabaseConnection conn = DatabaseConnection.getInstance();        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
            MainMenu.showMainMenu();
            DatabaseConnection.destroyInstance();

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}