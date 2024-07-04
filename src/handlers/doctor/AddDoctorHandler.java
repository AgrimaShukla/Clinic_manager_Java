package handlers.doctor;

import models.Doctor;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

public class AddDoctorHandler {
    private static final Connection conn = DatabaseConnection.getInstance().conn;
    private static final String ADD_DOCTOR_QUERY = "INSERT INTO doctor VALUES(?,?,?,?,?,?,?)";

    public void addDoctor(Doctor doc) throws Exception{
        String user_id = UUID.randomUUID().toString();

        PreparedStatement pstmt = conn.prepareStatement(ADD_DOCTOR_QUERY);
        pstmt.setObject(1, user_id);
        pstmt.setObject(2, doc.getName());
        pstmt.setObject(3, doc.getMobile_number());
        pstmt.setObject(4, doc.getEmail());
        pstmt.setObject(5, doc.getAge());
        pstmt.setObject(6, doc.getGender());
        pstmt.setObject(7, doc.getSpecialization());

        pstmt.execute();
    }
}
