package view.customer;

import controllers.appointments.CancelAppointmentController;
import controllers.appointments.ViewAppointmentController;
import controllers.doctor.DeleteDoctorController;
import controllers.doctor.ViewAllDoctorController;

import java.util.Scanner;

public class DeleteAppointment {

    public static void deleteAppointment(){
        ViewAppointment.ViewAppointment();
        System.out.println("Enter Doctor Id: ");
        Scanner sc = new Scanner(System.in);
        String did = sc.next();
        String message = CancelAppointmentController.cancelAppointment(did);
        System.out.println(message);
    }
}
