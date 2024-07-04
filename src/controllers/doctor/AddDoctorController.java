package controllers.doctor;

import handlers.doctor.AddDoctorHandler;
import models.Doctor;

public class AddDoctorController {


    public static String addDoctor(Doctor doc) {
        try {
            AddDoctorHandler adh = new AddDoctorHandler();
            adh.addDoctor(doc);
            return "Success";
        }
        catch(Exception e){
            System.out.println(e);
            return "Some error occurred. Please try again later.";
        }
    }
}
