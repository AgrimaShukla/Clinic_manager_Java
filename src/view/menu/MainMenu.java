package view.menu;

import java.sql.SQLException;
import java.util.*;
import java.io.Console;
import java.util.logging.Level;
import java.util.logging.Logger;

import controllers.authentication.Login;
import utils.GetRole;

public class MainMenu {
    private static final Logger logger = Logger.getLogger("MainMenu");

    public static void showMainMenu() {
        logger.log(Level.INFO, "Main menu");
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Clinic");
        System.out.println("--------------------------");
        try {
            while (true) {
                System.out.println("1) Login\n2) Register\n3) Exit");
                System.out.println("Enter: ");

                int userChoice = sc.nextInt();

                switch (userChoice) {
                    case 1:
                        System.out.println("Enter your credentials");
                        System.out.println("Username: ");
                        Scanner s = new Scanner(System.in);
                        String username = s.nextLine();
                        Console console = System.console();
                        char[] passwordArray = console.readPassword("Password: ");
                        String password = new String(passwordArray);
                        Login l = new Login();
                        String message = l.login(username, password);
                        System.out.println(message);
                        break;
                    case 2:
                        CustomerMenu.signup();
                        break;
                    case 3: return;
                    default:
                        System.out.println("Enter a valid choice");
                }

            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        finally {
            sc.close();
        }
    }

    public static void roleBasedMenu(Map<String, String> user) {
        String role = GetRole.fetchRole(user);
        System.out.println(role);
        if(role.equals("admin")) {
            AdminMenu.displayMenu();
        }
        else {
            CustomerMenu.displayMenu();
        }
    }
}
