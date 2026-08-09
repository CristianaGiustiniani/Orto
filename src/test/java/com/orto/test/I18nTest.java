package com.orto.test;

import com.orto.logic.utils.I18n;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class I18nTest {

    @Test
    public void testI18nTranslation() {
        I18n.init(Locale.ENGLISH);
        assertEquals("Back", I18n.t("BACK"));
        assertEquals("Next", I18n.t("NEXT"));
        assertEquals("Log in", I18n.t("GUI_LOGIN_VIEW_LOGIN"));
    }

    @Test
    public void testI18nLazyInitAndFallback() {
        // Test translation without explicit init (lazy init)
        String translated = I18n.t("BACK");
        assertEquals("Back", translated);

        // Test missing key fallback
        String missing = I18n.t("NON_EXISTENT_KEY_12345");
        assertEquals("NON_EXISTENT_KEY_12345", missing);
    }
}
