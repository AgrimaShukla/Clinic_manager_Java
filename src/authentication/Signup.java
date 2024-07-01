package authentication;
import java.sql.*;

public class Signup {

    private String name;
    private String mobileNumber;
    private int age;
    private String gender;
    private String email;
    private String username;
    private String password;

    public Signup(String name, String mobileNumber, int age, String gender, String email, String username, String password){
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    void signup () throws Exception {

    }
}
