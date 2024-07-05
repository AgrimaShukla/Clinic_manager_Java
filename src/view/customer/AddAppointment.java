package view.customer;

import controllers.appointments.AddAppointmentController;
import controllers.doctor.AddDoctorController;
import handlers.UserHandler;
import models.Appointment;
import view.admin.ViewAllDoctor;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;


public class AddAppointment {

    public static void addAppointment() {
        try {

            ViewAllDoctor.ViewDoctor();
            Scanner sc = new Scanner(System.in);
            System.out.println("Fill the details: ");
            System.out.println("Enter doctor id: ");
            String did = sc.next();

            System.out.println("Enter date (dd/mm/yyyy): ");
            String dateStr = sc.next();
            System.out.println("Enter time (hh:mm:ss): ");
            String timeStr = sc.next();
            Date date = new SimpleDateFormat("dd-M-yyyy").parse(dateStr);
            Date time = new SimpleDateFormat("hh:mm:ss").parse(timeStr);

            String dateString = date.toString();
            String timeString = time.toString();
            String dateTime = dateString + timeString;
            String[] parts = dateTime.split("\\s+");
            String dayOfWeek = parts[0];
            String month = parts[1];
            String dayOfMonth = parts[2];
            String year = parts[5];
            String timeForm = parts[8];

            String datePart = dayOfWeek + " " + month + " " + dayOfMonth + " " + year + " " +timeForm;


            String patientId = UserHandler.getUserId();
            Appointment app = new Appointment(patientId, did, datePart);
            String message = AddAppointmentController.addAppointment(app);
            System.out.println(message);
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Invalid date format");
        }
    }
}
