package com.orto.logic.utils;

import com.orto.logic.utils.exceptions.InvalidProductTypeException;

public enum ProductType {
    AGRICULTURAL,
    ANIMAL,
    CLEANING_COSMETICS;

    public static ProductType fromString(String string) throws InvalidProductTypeException{
        if (string.equals(AGRICULTURAL.name().toLowerCase())) {
            return AGRICULTURAL;
        } else if (string.equals(ANIMAL.name().toLowerCase())) {
            return ANIMAL;
        } else if (string.equals(CLEANING_COSMETICS.name().toLowerCase())) {
            return CLEANING_COSMETICS;
        } else {
            throw new InvalidProductTypeException();
        }
    }
}
