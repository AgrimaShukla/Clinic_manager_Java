package models;

public class User {

    private final String username;
    private final String name;
    private final String mobile_number;
    private final String gender;
    private final int age;
    private final String email;

    public User(String username, String name, String mobile_number, String gender, int age, String email) {
        this.username = username;
        this.name = name;
        this.mobile_number = mobile_number;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
