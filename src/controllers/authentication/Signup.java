package controllers.authentication;

import handlers.UserHandler;

public class Signup {

    private String name;
    private String mobileNumber;
    private int age;
    private String gender;
    private String email;
    private String username;
    private String password;

    public Signup(String username, String password, String name, String mobileNumber, String gender, int age, String email){
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public boolean signup () {
        try {
            UserHandler.signup(username, password, name, mobileNumber, gender, age, email);
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
