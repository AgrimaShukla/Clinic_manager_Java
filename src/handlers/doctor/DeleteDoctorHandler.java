package handlers.doctor;

import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDoctorHandler {
    private static final Connection conn = DatabaseConnection.getInstance().conn;
    private static final String DELETE_DOCTOR_QUERY = "DELETE FROM doctor WHERE did = ?";

    public void deleteDoctor(String did) throws Exception{
        PreparedStatement pstmt = conn.prepareStatement(DELETE_DOCTOR_QUERY);
        pstmt.setObject(1, did);
        pstmt.execute();
    }
}
