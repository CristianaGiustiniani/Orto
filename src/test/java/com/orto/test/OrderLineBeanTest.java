package com.orto.test;

import com.orto.logic.graphic_controller.bean.OrderLineBean;
import com.orto.logic.graphic_controller.bean.exceptions.AnnotationTooLongException;
import com.orto.logic.graphic_controller.bean.exceptions.NullQuantityException;
import com.orto.logic.graphic_controller.bean.exceptions.WrongFormatQuantityException;
import com.orto.logic.utils.QuantityUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderLineBeanTest {
    /**
     * Tests for the OrderLineBean class
     *
     * @author Cristiana Giustiniani
     */

    @Test
    public void testValidateRightBean() {
        //creating a properly formatted bean
        OrderLineBean bean = new OrderLineBean();
        bean.setProductId(1);
        bean.setProductName("product");
        bean.setQuantity("1");
        bean.setQuantityUnit(QuantityUnit.KILOGRAM);
        bean.setAnnotation("annotation");

        //asserting that no exception is thrown
        assertDoesNotThrow(bean::validate);
    }

    @Test
    public void testValidateRightBeanPoorlyFormattedQuantity() {
        //creating a bean with a poorly formatted quantity that can still be parsed
        OrderLineBean bean = new OrderLineBean();
        bean.setProductId(1);
        bean.setProductName("product");
        bean.setQuantity("  1,23 ");
        bean.setQuantityUnit(QuantityUnit.KILOGRAM);
        bean.setAnnotation("annotation");

        //asserting that no exception is thrown
        assertDoesNotThrow(bean::validate);
    }

    @Test
    public void testValidateIncompatibleQuantity() {
        //creating a bean with quantity not compatible with quantity unit
        OrderLineBean bean = new OrderLineBean();
        bean.setProductId(1);
        bean.setProductName("product");
        bean.setQuantity("1.5");
        bean.setQuantityUnit(QuantityUnit.PIECE);
        bean.setAnnotation("annotation");

        //asserting that a WrongFormatQuantityException exception is thrown
        assertThrows(WrongFormatQuantityException.class, bean::validate);
    }

    @Test
    public void testValidateWrongFormatQuantity() {
        //creating a bean with a wrong format quantity
        OrderLineBean bean = new OrderLineBean();
        bean.setProductId(1);
        bean.setProductName("product");
        bean.setQuantity("this is a wrong format quantity 1234");
        bean.setQuantityUnit(QuantityUnit.KILOGRAM);
        bean.setAnnotation("annotation");

        //asserting that a WrongFormatQuantityException exception is thrown
        assertThrows(WrongFormatQuantityException.class, bean::validate);
    }

    @Test
    public void testValidateNullQuantity() {
        //creating a bean but not defining a quantity
        OrderLineBean bean = new OrderLineBean();
        bean.setProductId(1);
        bean.setProductName("product");
        bean.setQuantityUnit(QuantityUnit.KILOGRAM);
        bean.setAnnotation("annotation");

        //asserting that a NullQuantityException exception is thrown
        assertThrows(NullQuantityException.class, bean::validate);
    }

    @Test
    public void testValidateAnnotationTooLong() {
        //creating an annotation that is longer than 200 characters
        String annotation = "";
        for (int i = 0; i < 201; i++) {
            annotation = annotation.concat("a");
        }

        //creating a bean with the 201-character annotation
        OrderLineBean bean = new OrderLineBean();
        bean.setProductId(1);
        bean.setProductName("product");
        bean.setQuantity("1");
        bean.setQuantityUnit(QuantityUnit.KILOGRAM);
        bean.setAnnotation(annotation);

        //asserting that a NullQuantityException exception is thrown
        assertThrows(AnnotationTooLongException.class, bean::validate);
    }
}
