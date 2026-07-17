package com.orto.logic.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {
    private static ResourceBundle bundle;

    public static void init(Locale locale) {
        bundle = ResourceBundle.getBundle("i18n", locale);
    }

    public static String t(String key) {
        return bundle.getString(key);
    }
}
