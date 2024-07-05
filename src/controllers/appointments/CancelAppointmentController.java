package controllers.appointments;

import handlers.appointments.CancelAppointmentHandler;

public class CancelAppointmentController {

    public static String cancelAppointment(String did) {
        try {
            CancelAppointmentHandler cancel = new CancelAppointmentHandler();
            cancel.cancelAppointment(did);
            return "Success";
        }
        catch (Exception e) {
            return "Some error occurred";
        }
    }
}
