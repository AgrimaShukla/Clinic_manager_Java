package handlers.appointments;

import models.Appointment;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddAppointmentHandler {
    private static final Connection conn = DatabaseConnection.getInstance().conn;
    private static final String ADD_DOCTOR_QUERY = "INSERT INTO appointments VALUES(?,?,?)";

    public void addAppointment(Appointment app) throws Exception{
        PreparedStatement pstmt = conn.prepareStatement(ADD_DOCTOR_QUERY);
        pstmt.setObject(1, app.getPatientId());
        pstmt.setObject(2, app.getDid());
        pstmt.setObject(3, app.getDateTime());
        pstmt.execute();
    }
}
