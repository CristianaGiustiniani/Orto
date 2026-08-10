package com.orto.test;

import com.orto.logic.model.entity.*;
import com.orto.logic.model.entity.exceptions.NoProductSelectedException;
import com.orto.logic.utils.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;


public class OrderTest {
    /**
     * Tests for the Order class
     *
     * @author Cristiana Giustiniani
     */

    @Test
    public void testAddSeller() {
        Order order = new Order();

        //creating a seller
        Map< DayOfWeek, TimeSlot> openingTimes = new EnumMap<>(DayOfWeek.class);
        for (DayOfWeek day : DayOfWeek.values()) {
            openingTimes.put(day,
                    new TimeSlot(LocalTime.of(8, 0), LocalTime.of(18, 0)));
        }

        Seller seller = new Seller(
                1,
                "Federico Bianchi",
                new Address(
                        "via roma",
                        "12",
                        "02033",
                        "Ginestra Sabina",
                        "Rieti",
                        "Italia"),
                Arrays.asList(ProductType.AGRICULTURAL, ProductType.ANIMAL),
                openingTimes);

        //adding seller to order
        order.addSeller(seller);

        //asserting that the seller is in the order
        assertEquals(seller, order.getSeller());
    }

    @Test
    public void testAddLines() throws NoProductSelectedException {
        Order order = new Order();

        //creating an OrderLine
        List<OrderLine> lines = new ArrayList<>();
        Product product = new Product(
                1,
                "Carote viola",
                null,
                BigDecimal.valueOf(3.00),
                QuantityUnit.KILOGRAM);

        OrderLine line = new OrderLine(
                product,
                1.5,
                "se possibile, con il ciuffo");

        lines.add(line);

        //adding lines to order
        order.addLines(lines);

        //asserting that the lines are in the order
        assertEquals(lines, order.getOrderLines());
    }

    @Test
    public void testAddLinesEmptyLines() {
        Order order = new Order();

        //creating an empty OrderLine
        List<OrderLine> lines = new ArrayList<>();

        //adding empty lines to order and asserting that it throws the proper exception
        try {
            order.addLines(lines);
        } catch (NoProductSelectedException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testAddDeliveryInfo() {
        Order order = new Order();

        //creating a delivery
        Delivery delivery = new Delivery(
                DeliveryType.SHIPPING,
                "name",
                "surname",
                new Address(
                        "via roma",
                        "12",
                        "02033",
                        "Ginestra Sabina",
                        "Rieti",
                        "Italia"),
                "123456789");

        //adding delivery to order
        order.addDeliveryInfo(delivery);

        //asserting that the delivery info is in the order
        assertEquals(delivery, order.getDeliveryInfo());
    }

    @Test
    public void testIsDeliveryShipping() {
        Order order = new Order();

        //creating a delivery
        Delivery delivery = new Delivery(
                DeliveryType.SHIPPING,
                "name",
                "surname",
                new Address(
                        "via roma",
                        "12",
                        "02033",
                        "Ginestra Sabina",
                        "Rieti",
                        "Italia"),
                "123456789");

        //adding delivery to order
        order.addDeliveryInfo(delivery);

        //asserting that isDeliveryShipping returns true
        assertTrue(order.isDeliveryShipping());
    }

    @Test
    public void testIsDeliveryPickup() {
        Order order = new Order();

        //creating a delivery
        Delivery delivery = new Delivery(
                DeliveryType.PICKUP,
                "name",
                "surname",
                new Address(
                        "via roma",
                        "12",
                        "02033",
                        "Ginestra Sabina",
                        "Rieti",
                        "Italia"),
                "123456789");

        //adding delivery to order
        order.addDeliveryInfo(delivery);

        //asserting that isDeliveryPickup returns true
        assertTrue(order.isDeliveryPickup());
    }

    @Test
    public void testAddPaymentInfo() {
        Order order = new Order();

        //creating a payment
        Payment payment = new Payment(
                PaymentType.ONLINE,
                PaymentStatus.SUCCESSFUL);

        //adding payment to order
        order.addPaymentInfo(payment);

        //asserting that the payment info is in the order
        assertEquals(payment, order.getPaymentInfo());
    }

    @Test
    public void testIsPaymentCash() {
        Order order = new Order();

        //creating a payment
        Payment payment = new Payment(
                PaymentType.CASH,
                PaymentStatus.SUCCESSFUL);

        //adding payment to order
        order.addPaymentInfo(payment);

        //asserting that the payment type is cash
        assertTrue(order.isPaymentCash());
    }

    @Test
    public void testIsPaymentOnline() {
        Order order = new Order();

        //creating a payment
        Payment payment = new Payment(
                PaymentType.ONLINE,
                PaymentStatus.SUCCESSFUL);

        //adding payment to order
        order.addPaymentInfo(payment);

        //asserting that the payment type is online
        assertTrue(order.isPaymentOnline());
    }
}
