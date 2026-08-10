package com.orto.logic.model.entity;

import com.orto.logic.utils.ProductType;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Seller {
    private Integer id;
    private String name;
    private Address address;
    private List<ProductType> productTypes;
    private Map<DayOfWeek, TimeSlot> openingTimes;

    public Seller(Integer id, String name, Address address, List<ProductType> productTypes, Map<DayOfWeek, TimeSlot> openingTimes) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.productTypes = productTypes;
        this.openingTimes = openingTimes;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() { return address; }

    public List<ProductType> getProductTypes() {
        return productTypes;
    }

    public Map<DayOfWeek, TimeSlot> getOpeningTimes() {
        return openingTimes;
    }

    public boolean isOpen() {
        DayOfWeek today = LocalDateTime.now().getDayOfWeek();
        LocalTime now = LocalTime.now();

        //negated expression to include the boundaries of the opening and closing times
        return !(now.isBefore(openingTimes.get(today).openingTime())) && (!now.isAfter(openingTimes.get(today).closingTime()));
    }
}
