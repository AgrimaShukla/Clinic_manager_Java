package controllers.doctor;

import handlers.UserHandler;
import handlers.doctor.ViewAllDoctorHandler;
import view.admin.ViewAllDoctor;

import java.sql.ResultSet;

public class ViewAllDoctorController {

    public void ViewDoctor()
    {
        try {

            String role = UserHandler.getRole();
            ViewAllDoctorHandler doctors = new ViewAllDoctorHandler();
            ResultSet set = doctors.viewDoctor();
            if(role.equals("admin")) {
                while (set.next()) {
                    System.out.println("Doctor ID: " + set.getString(1) + ", Name: " + set.getString(2) + ", Mobile Number: " + set.getString(3) + ", Email: " + set.getString(4) + ", Age: " + set.getInt(5) + ", Gender: " + set.getString(6));
                }
            }
            else {
                while (set.next()) {
                    System.out.println("Doctor Id: "+ set.getString(1) +", Name: " + set.getString(2) + ", Mobile Number: " + set.getString(3) + ", Email: " + set.getString(4) + ", Specialization: " + set.getString(7));
                }
            }

        } catch (Exception e) {
            System.out.println("Some error occurred");
        }
    }
}
