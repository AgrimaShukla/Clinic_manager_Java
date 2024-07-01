package handlers;

import utils.DatabaseConnection;
import utils.PasswordHash;

import java.sql.*;
import java.util.UUID;

public class UserHandler {

    private static final Connection conn = DatabaseConnection.getInstance().conn;
    private static final String LOGIN_QUERY = "SELECT * FROM credentials WHERE username = ?";
    private static final String SIGNUP_CREDENTIAL_QUERY = "INSERT INTO credentials VALUES(?, ?, ?, ?, ?)";
    private static final String SIGNUP_USER_QUERY = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?)";
    private static final String PROFILE_QUERY = "SELECT * FROM user";

    public static String login(String username, String password) throws Exception{
        PreparedStatement stmt = conn.prepareStatement(LOGIN_QUERY);
        stmt.setObject(1, username);
        ResultSet rs = stmt.executeQuery();
        rs.next();

        String storedUsername = rs.getString("username");
        String storedPassword = rs.getString("password");
        byte[] salt = rs.getBytes("salt");
        String role = rs.getString("role");
        String user_id = rs.getString("user_id");

        boolean isCorrect = PasswordHash.verifyPassword(password, storedPassword, salt);
        System.out.println("Role: " + role);
        System.out.println("User: " + storedUsername);
        System.out.println("Password is correct: " + isCorrect);

        System.out.println(rs.getString("username"));
        return isCorrect ? user_id: null;
    }

    public static void signup(String username, String password, String name, String mobileNumber, String gender, int age, String email) {
        try {
            System.out.println("hellooooo");
            String user_id = UUID.randomUUID().toString();
            Object[] hashedPassword = PasswordHash.hashPassword("Admin@123");
            PreparedStatement credentialStmnt = conn.prepareStatement(SIGNUP_CREDENTIAL_QUERY);
            credentialStmnt.setObject(1, user_id);
            credentialStmnt.setObject(2, "admin123");
            credentialStmnt.setObject(3, hashedPassword[0]);
            credentialStmnt.setObject(4, "admin");
            credentialStmnt.setObject(5, hashedPassword[1]);

            PreparedStatement userStmnt = conn.prepareStatement(SIGNUP_USER_QUERY);
            userStmnt.setObject(1, user_id);
            userStmnt.setObject(2, "Agrima Shukla");
            userStmnt.setObject(3, "8982920456");
            userStmnt.setObject(4, "female");
            userStmnt.setObject(5, 22);
            userStmnt.setObject(6, "ag");

            credentialStmnt.execute();
            userStmnt.execute();


        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
