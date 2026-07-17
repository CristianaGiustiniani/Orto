package com.orto.logic.view_controller.bean;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimeSlotBean {

    private DayOfWeek day;
    private LocalTime openingTime;
    private LocalTime closingTime;

    //GETTERS AND SETTERS
    //todo: syntactic data validation
    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

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
}
