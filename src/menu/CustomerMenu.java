package menu;

import controllers.authentication.Signup;

import java.util.Scanner;

public class CustomerMenu {

    public static void displayMenu() {
        System.out.println("Choose one of the options:\n1) Doctors list\n2)Appointment Menu\n3) Exit");

        while(true) {
            System.out.println("Enter: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    appointmentMenu();
                    break;
                case 3:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice");
                    continue;
            }
            return;
        }
    }

    public static void appointmentMenu() {
        System.out.println("Choose one of the options:\n1) Book Appointment\n2)Cancel appointment\n3) View Appointments\n4) Back\n5) Exit");

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
                case 4:
                    return;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            return;
        }
    }

    public static void signup() {

        System.out.println("Fill the details");
        System.out.println("Name: ");
        Scanner s1 = new Scanner(System.in);
        String name = s1.nextLine();
        System.out.println("Mobile Number: ");
        Scanner s2 = new Scanner(System.in);
        String mobileNumber = s2.nextLine();
        System.out.println("Age: ");
        Scanner s3 = new Scanner(System.in);
        int age = s3.nextInt();
        System.out.println("Gender: ");
        Scanner s4 = new Scanner(System.in);
        String gender = s4.nextLine();
        System.out.println("Email: ");
        Scanner s5 = new Scanner(System.in);
        String email = s5.nextLine();
        System.out.println("Username: ");
        Scanner s6 = new Scanner(System.in);
        String username = s5.nextLine();
        System.out.println("Password: ");
        Scanner s7 = new Scanner(System.in);
        String password = s5.nextLine();
        Signup sign = new Signup(username, password, name, mobileNumber, gender, age, email);
        sign.signup();
    }
}
