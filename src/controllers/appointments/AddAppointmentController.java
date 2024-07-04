package controllers.appointments;

import handlers.appointments.AddAppointmentHandler;
import models.Appointment;

import java.security.spec.ECField;

public class AddAppointmentController {

    public static String addAppointment(Appointment app) {
        try {
            AddAppointmentHandler aah = new AddAppointmentHandler();
            aah.addAppointment(app);
            return "Success";
        }
        catch(Exception e) {
            System.out.println(e);
            return "Some error occurred";
        }
    }
}
