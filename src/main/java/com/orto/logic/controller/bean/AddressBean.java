package com.orto.logic.controller.bean;

import com.orto.logic.controller.bean.exceptions.InvalidStringException;

import java.util.regex.Pattern;

public class AddressBean {
    private String streetName;
    private String civicNumber;
    private String postalCode;
    private String city;
    private String province;
    private String country;


    //GETTERS AND SETTERS
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCivicNumber() {
        return civicNumber;
    }

    public void setCivicNumber(String civicNumber) {
        this.civicNumber = civicNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    //DATA VALIDATION METHODS
    public void validate() throws InvalidStringException {
        validateString(streetName);
        validateString(civicNumber);
        validateString(postalCode);
        validateString(city);
        validateString(province);
        validateString(country);
    }
    private void validateString(String string) throws InvalidStringException {
        boolean ok = Pattern.compile("[a-zA-Z0-9]").matcher(string).find();
        if (!ok) {
            throw new InvalidStringException();
        }
    }
}
