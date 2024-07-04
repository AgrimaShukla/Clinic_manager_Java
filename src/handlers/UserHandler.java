package handlers;

import utils.DatabaseConnection;
import utils.PasswordHash;
import java.util.*;
import java.sql.*;
import java.util.HashMap;
import java.util.UUID;

public class UserHandler {

    private static String uuid;
    private static String role;
    private static final Connection conn = DatabaseConnection.getInstance().conn;
    private static final String LOGIN_QUERY = "SELECT * FROM credentials WHERE username = ?";
    private static final String SIGNUP_CREDENTIAL_QUERY = "INSERT INTO credentials VALUES(?, ?, ?, ?, ?)";
    private static final String SIGNUP_USER_QUERY = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?)";
    private static final String PROFILE_QUERY = "SELECT * FROM user";

    public static Map<String, String> login(String username, String password) throws Exception{

        PreparedStatement stmt = conn.prepareStatement(LOGIN_QUERY);
        stmt.setObject(1, username);
        ResultSet rs = stmt.executeQuery();
        rs.next();

        String storedUsername = rs.getString("username");
        String storedPassword = rs.getString("password");
        byte[] salt = rs.getBytes("salt");
        role = rs.getString("role");
        uuid = rs.getString("uuid");

        boolean isCorrect = PasswordHash.verifyPassword(password, storedPassword, salt);

        System.out.println(rs.getString("username"));
        Map<String, String> hash = new HashMap<String, String>();
        hash.put("user_id", uuid);
        hash.put("role", role);
        return isCorrect ? hash: null;

    }

    public static void signup(String username, String password, String name, String mobileNumber, String gender, int age, String email) {
        try {
            String user_id = UUID.randomUUID().toString();
            Object[] hashedPassword = PasswordHash.hashPassword(password);
            PreparedStatement credentialStmnt = conn.prepareStatement(SIGNUP_CREDENTIAL_QUERY);
            credentialStmnt.setObject(1, user_id);
            credentialStmnt.setObject(2, username);
            credentialStmnt.setObject(3, hashedPassword[0]);
            credentialStmnt.setObject(4, "customer");
            credentialStmnt.setObject(5, hashedPassword[1]);

            PreparedStatement userStmnt = conn.prepareStatement(SIGNUP_USER_QUERY);
            userStmnt.setObject(1, user_id);
            userStmnt.setObject(2, name);
            userStmnt.setObject(3, email);
            userStmnt.setObject(4, age);
            userStmnt.setObject(5, mobileNumber);
            userStmnt.setObject(6, gender);
            credentialStmnt.execute();
            userStmnt.execute();

        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    public static String getUserId() {
        return uuid;
    }

    public static String getRole() {
        return role;
    }
}
