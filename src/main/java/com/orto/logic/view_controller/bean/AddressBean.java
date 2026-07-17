package com.orto.logic.view_controller.bean;

import com.orto.logic.view_controller.bean.exceptions.InvalidStringException;

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

    public void setStreetName(String streetName) throws InvalidStringException {

        try {
            validateString(streetName);
            this.streetName = streetName;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Street name has no characters or digits");
        }
    }

    public String getCivicNumber() {
        return civicNumber;
    }

    public void setCivicNumber(String civicNumber) throws InvalidStringException {
        try {
            validateString(civicNumber);
            this.civicNumber = civicNumber;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Civic number has no characters or digits");
        }
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) throws InvalidStringException {
        try {
            validateString(postalCode);
            this.postalCode = postalCode;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Postal code has no characters or digits");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws InvalidStringException {
        try {
            validateString(city);
            this.city = city;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("City has no characters or digits");
        }
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) throws InvalidStringException {
        try {
            validateString(province);
            this.province = province;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Province has no characters or digits");
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws InvalidStringException {
        try {
            validateString(country);
            this.country = country;
        } catch (InvalidStringException e) {
            throw new InvalidStringException("Country has no characters or digits");
        }
    }

    //DATA VALIDATION METHODS
    private void validateString(String string) throws InvalidStringException {
        boolean ok = string.matches("[a-zA-Z0-9]+");
        if (!ok) {
            throw new InvalidStringException();
        }
    }
}
