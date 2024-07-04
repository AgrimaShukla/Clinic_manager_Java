package controllers.doctor;

import handlers.doctor.DeleteDoctorHandler;

public class DeleteDoctorController {

    public static String deleteDoctor(String did) {
        try{
            DeleteDoctorHandler deleteDoc = new DeleteDoctorHandler();
            deleteDoc.deleteDoctor(did);
            return "Success";
        }
        catch (Exception e){
            System.out.println(e);
            return "Some error occurred";
        }

    }
}
