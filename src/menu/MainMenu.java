package menu;

import java.util.Scanner;
import java.io.Console;

public class MainMenu {
    public static void showMainMenu() {
        System.out.println("Welcome to Clinic");
        System.out.println("--------------------------");
        System.out.println("1) Login\n2) Register");

        while(true) {

            System.out.println("Enter: ");
            Scanner sc = new Scanner(System.in);
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
                    System.out.println(password);
                    break;

                case 2:
                    CustomerMenu.signup();
                    break;
                default:
                        System.out.println("Enter a valid choice");
                        continue;
            }
            return;
        }
    }
}
