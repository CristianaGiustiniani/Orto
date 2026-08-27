package com.orto.logic.controller.bean;

import java.time.LocalTime;

public class TimeSlotBean {
    private LocalTime openingTime;
    private LocalTime closingTime;

    //GETTERS AND SETTERS
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    //DATA VALIDATION METHODS
    //not needed yet
}
