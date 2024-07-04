package view.customer;

import controllers.appointments.AddAppointmentController;
import controllers.doctor.AddDoctorController;
import handlers.UserHandler;
import models.Appointment;
import view.admin.ViewAllDoctor;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

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
            Date sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse(dateStr+" "+timeStr);
            System.out.println("helloooo");
            System.out.println(sdf);
//            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//            Date date = sdf.parse(dateStr);
//            System.out.println(date);
            String dateTime = sdf.toString();
//              String dateTime="";

            String patientId = UserHandler.getUserId();
            Appointment app = new Appointment(patientId, did, dateTime);
            String message = AddAppointmentController.addAppointment(app);
            System.out.println(message);
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Invalid date format");
        }
    }
}
