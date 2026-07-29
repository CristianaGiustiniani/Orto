package com.orto.logic.model.entity;

import com.orto.logic.utils.ProductType;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

public class Seller {
    private Integer id;
    private String name;
    private Address address;
    private List<ProductType> productTypes;
    private Map<DayOfWeek, TimeSlot> openingTimes;



    //CONSTRUCTOR
    public Seller(Integer id, String name, Address address, List<ProductType> productTypes, Map<DayOfWeek, TimeSlot> openingTimes) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.productTypes = productTypes;
        this.openingTimes = openingTimes;
    }

    //GETTERS
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
}
