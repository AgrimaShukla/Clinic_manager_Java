package handlers.appointments;

import handlers.UserHandler;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CancelAppointmentHandler {
    private static final Connection conn = DatabaseConnection.getInstance().conn;
    private static final String DELETE_DOCTOR_QUERY = "DELETE FROM APPOINTMENTS WHERE patient_id = ? AND doctor_id = ?";

    public void cancelAppointment(String doctor_id) throws Exception{

        PreparedStatement pstmt = conn.prepareStatement(DELETE_DOCTOR_QUERY);
        String userId = UserHandler.getUserId();
        pstmt.setObject(1, userId);
        pstmt.setObject(2, doctor_id);
        pstmt.execute();
    }

}
