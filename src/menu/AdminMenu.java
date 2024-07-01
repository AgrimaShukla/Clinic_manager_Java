package menu;

import java.util.Scanner;

public class AdminMenu {
    public void displayMenu() {
        System.out.println("Choose one of the options:\n1)Add a doctor\n2) View all doctors\n3) Delete a doctor\n4) Exit");
        while (true) {
            System.out.println("Enter: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4: break;
                default:
                    System.out.println("Enter a valid choice");
                    continue;
            }
            return;
        }
    }
}
