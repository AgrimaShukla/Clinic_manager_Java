package models;

public class Appointment {
    private String patientId;
    private String did;
    private String dateTime;

    public Appointment(String patientId, String did, String dateTime) {
        this.patientId = patientId;
        this.did = did;
        this.dateTime = dateTime;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDid() {
        return did;
    }

    public String getDateTime() {
        return dateTime;
    }
}
