package controllers.appointments;

import handlers.appointments.ViewAppointmentHandler;

import java.sql.ResultSet;

public class ViewAppointmentController {

    public static void viewAppointment() {
        try {
            ViewAppointmentHandler vah = new ViewAppointmentHandler();
            ResultSet rs = vah.viewAppointment();
            while (rs.next()) {
                System.out.println("Doctor ID: "+rs.getString(7)+", Doctor name: " + rs.getString(2) + ", Doctor's email: " + rs.getString(4) + ", Doctor's mobile_number: " + rs.getString(3) + ", Specialization: "+rs.getString(5)+", Date-time: " + rs.getString(1));
            }
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("Some error occurred");
        }
    }
}
