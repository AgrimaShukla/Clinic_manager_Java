package utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    public Connection conn;
    private DatabaseConnection() {

        try {
            Dotenv dt = Dotenv.load();
            String URL = dt.get("DB_URL");
            String USERNAME = dt.get("DB_USERNAME");
            String PASSWORD = dt.get("DB_PASSWORD");
            this.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }

    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public static void destroyInstance(){
        try{
            if(instance != null){
                instance.conn.close();
                instance = null;
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
