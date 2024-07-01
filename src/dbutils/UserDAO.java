package dbutils;

import java.sql.*;
import java.util.UUID;
import io.github.cdimascio.dotenv.Dotenv;


public class UserDAO {


    public static Connection connection() throws Exception {
        Dotenv dt = Dotenv.load();
        String URL = dt.get("DB_URL");
        String USERNAME = dt.get("DB_USERNAME");
        String PASSWORD = dt.get("DB_PASSWORD");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;

    }

    public static boolean login() throws Exception {
        Connection connect = UserDAO.connection();
        Statement st = connect.createStatement();
        String insertQuery = "INSERT INTO Credentials values (U_12345, admin123, Admin@123, admin)";
        st.execute(insertQuery);
        return true;
    }



    public static boolean signup(String username, String password, String name, String mobile_number, String gender, int age, String email) throws Exception {
        Connection connect = UserDAO.connection();
        String uniqueID = UUID.randomUUID().toString();

        PreparedStatement st=connect.prepareStatement("insert into credentials values(?,?)");
        PreparedStatement stmt=connect.prepareStatement("insert into users values(?,?,?,?,?,?)");
        st.setObject(1, username);
        st.setObject(2, password);
        stmt.setObject(1, uniqueID);
        stmt.setObject(2, name);
        stmt.setObject(3, mobile_number);
        stmt.setObject(4, gender);
        stmt.setObject(5, age);
        stmt.setObject(6, email);
        return true;

    }
}
