package view.menu;

import controllers.authentication.Signup;
import view.admin.ViewAllDoctor;
import view.customer.AddAppointment;
import view.customer.DeleteAppointment;
import view.customer.ViewAppointment;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerMenu {

    public static void displayMenu() {

        System.out.println("Choose one of the options:\n1) Doctors list\n2) Appointment Details\n3) Exit");

        while(true) {
            System.out.println("Enter: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ViewAllDoctor.ViewDoctor();
                    break;
                case 2:
                    appointmentMenu();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void appointmentMenu() {
        System.out.println("Choose one of the options:\n1) Book Appointment\n2) Cancel appointment\n3) View Appointments\n4) Back\n5) Exit");

        while (true) {
            System.out.println("Enter: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    AddAppointment.addAppointment();
                    break;
                case 2:
                    DeleteAppointment.deleteAppointment();
                    break;
                case 3:
                    ViewAppointment.ViewAppointment();
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void signup() {

        System.out.println("Fill the details");
        Scanner s1 = new Scanner(System.in);
        System.out.println("Name: ");
        String name = s1.next();
        System.out.println("Mobile Number: ");
        String mobileNumber = s1.next();
        System.out.println("Age: ");
        int age = s1.nextInt();
        System.out.println("Gender: ");
        String gender = s1.next();
        System.out.println("Email: ");
        String email = s1.next();
        System.out.println("Username: ");
        String username = s1.next();
        System.out.println("Password: ");
        String password = s1.next();
        Signup sign = new Signup(username, password, name, mobileNumber, gender, age, email);

        sign.signup();
    }
}
