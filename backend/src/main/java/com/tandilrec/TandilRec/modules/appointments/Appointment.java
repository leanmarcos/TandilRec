package com.tandilrec.TandilRec.modules.appointments;
import lombok.Data;
import lombok.Getter;

public class Appointment {
    private int id;
    private int citizen_id;
    private int municipal_id;
    private String verification_code;
    private String status;
    private String scheduled_date;
    private String citizen_notes;
    // fechas

    public Appointment() {

    }

    /*
    Getter
    Setter
    getVerificationCode
    setState
     */






}
