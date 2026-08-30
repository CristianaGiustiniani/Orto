package com.orto.logic.model.entity;

import com.orto.logic.utils.ProductType;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

public class Seller extends Role {
    private final Integer id;
    private final String name;
    private final Address address;
    private final List<ProductType> productTypes;
    private final Map<DayOfWeek, TimeSlot> openingTimes;

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
        DayOfWeek today = LocalDateTime.now(ZoneId.systemDefault()).getDayOfWeek();
        LocalTime now = LocalTime.now(ZoneId.systemDefault());

        //negated expression to include the boundaries of the opening and closing times
        return !(now.isBefore(openingTimes.get(today).openingTime())) && (!now.isAfter(openingTimes.get(today).closingTime()));
    }
}
