package com.orto.logic.model.entity;

public class Address {
    private String street;
    private String number;
    private String postalCode;
    private String city;
    private String province;
    private String country;

    public Address(String street, String number, String postalCode, String city, String province, String country) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.country = country;
    }

    //GETTERS
    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }
}
