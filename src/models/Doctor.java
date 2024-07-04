package models;

public class Doctor {
    private String name;
    private String email;
    private String mobile_number;
    private String specialization;
    private String gender;
    private int age;

    public Doctor(String name, String email, String mobile_number, String specialization, String gender, int age){
        this.name = name;
        this.email = email;
        this.mobile_number = mobile_number;
        this.specialization = specialization;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
