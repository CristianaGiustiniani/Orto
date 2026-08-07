package com.orto.logic.utils;

import com.orto.logic.utils.exceptions.InvalidQuantityTypeException;

public enum QuantityUnit {
    LITER,
    MILLILITER,
    KILOGRAM,
    HECTOGRAM,
    GRAM,
    PIECE,
    PACK;

    public static QuantityUnit fromString(String string) throws InvalidQuantityTypeException {
        return switch (string) {
            case "L" -> LITER;
            case "mL" -> MILLILITER;
            case "kg" -> KILOGRAM;
            case "g" -> GRAM;
            case "hg" -> HECTOGRAM;
            case "piece" -> PIECE;
            case "pack" -> PACK;
            default -> throw new InvalidQuantityTypeException();
        };
    }
}
