package view.admin;

import controllers.doctor.DeleteDoctorController;

import java.util.Scanner;

public class DeleteDoctor {

    public static void deleteDoctor() {
        ViewAllDoctor.ViewDoctor();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Doctor ID: ");
        String uuid = sc.nextLine();
        String message = DeleteDoctorController.deleteDoctor(uuid);
        System.out.println(message);
    }
}
