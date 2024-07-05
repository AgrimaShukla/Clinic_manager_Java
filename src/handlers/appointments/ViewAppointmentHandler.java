package handlers.appointments;

import handlers.UserHandler;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewAppointmentHandler {

    private static final Connection conn = DatabaseConnection.getInstance().conn;
    private static final String GET_DOCTOR_QUERY = "SELECT a.date_time, d.name, d.mobile_number, d.email, d.specialization, d.gender, d.did FROM appointments a INNER JOIN doctor d WHERE a.doctor_id = d.did AND patient_id = ?";

    public ResultSet viewAppointment() throws Exception{
        PreparedStatement pstmt = conn.prepareStatement(GET_DOCTOR_QUERY);
        String p_id = UserHandler.getUserId();
        pstmt.setObject(1, p_id);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

}
