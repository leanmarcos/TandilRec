package com.tandilrec.TandilRec.modules.appointments;

public enum AppointmentState {
    ACTIVE,
    CANCELLED,
    PENDING ,
    SUCCESS ,
    FAILURE;

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

}
