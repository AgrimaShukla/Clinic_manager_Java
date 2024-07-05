package handlers.doctor;

import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Formatter;

public class ViewAllDoctorHandler {
    private static final Connection conn = DatabaseConnection.getInstance().conn;

    private static final String VIEW_DOCTOR_QUERY= "SELECT a.date_time, d.name, d.mobile_number, d.email, d.specialization, d.gender FROM appointments a INNER JOIN doctor d WHERE a.doctor_id = d.did AND patient_id = ?";

    public ResultSet viewDoctor() throws Exception{
        PreparedStatement pstmt = conn.prepareStatement(VIEW_DOCTOR_QUERY);
        ResultSet rst = pstmt.executeQuery();
        return rst;
    }


}
