package view.menu;

import controllers.doctor.AddDoctorController;
import view.admin.AddDoctor;
import view.admin.DeleteDoctor;
import view.admin.ViewAllDoctor;

import java.util.Scanner;

public class AdminMenu {
    public static void displayMenu() {
        System.out.println("Choose one of the options:\n1) Add a doctor\n2) View all doctors\n3) Delete a doctor\n4) Exit");
        while (true) {
            System.out.println("Enter: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    AddDoctor.addDoctor();
                    break;
                case 2:
                    ViewAllDoctor.ViewDoctor();
                    break;
                case 3:
                    DeleteDoctor.deleteDoctor();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter a valid choice");

            }
        }
    }
}
