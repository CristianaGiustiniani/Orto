package com.orto.logic.utils;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class I18n {
    private static ResourceBundle bundle;

    private I18n() {}

    public static void init(Locale locale) {
        if (locale == null) {
            locale = Locale.ENGLISH;
        }
        bundle = ResourceBundle.getBundle("i18n", locale);
    }

    public static String t(String key) {
        if (bundle == null) {
            init(Locale.ENGLISH);
        }
        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            return key;
        }
    }
}
