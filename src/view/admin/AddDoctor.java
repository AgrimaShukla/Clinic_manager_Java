package view.admin;

import java.util.Scanner;
import controllers.doctor.AddDoctorController;
import models.Doctor;

public class AddDoctor {

    public static void addDoctor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add a doctor by filling these fields: ");
        System.out.println("Name");
        String name = sc.next();
        System.out.println("Mobile Number: ");
        String mobile_number = sc.next();
        System.out.println("Age: ");
        int age = sc.nextInt();
        System.out.println("Email: ");
        String email = sc.next();
        System.out.println("Gender: ");
        String gender = sc.next();
        System.out.println("Specialization: ");
        String specialization = sc.next();
        Doctor doc = new Doctor(name, email, mobile_number, specialization, gender, age);
        String message = AddDoctorController.addDoctor(doc);
        System.out.println(message);
    }
}
