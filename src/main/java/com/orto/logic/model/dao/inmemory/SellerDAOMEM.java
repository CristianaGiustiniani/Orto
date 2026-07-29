package com.orto.logic.model.dao.inmemory;

import com.orto.logic.model.dao.SellerDAO;
import com.orto.logic.model.entity.Address;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.model.entity.TimeSlot;
import com.orto.logic.utils.ProductType;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

public class SellerDAOMEM implements SellerDAO {
    private static final List<Seller> sellers = new ArrayList<>();

    static {
        //Populating in-memory sellers
        // Seller 1
        Map<DayOfWeek, TimeSlot> openingTimes1 = new EnumMap<>(DayOfWeek.class);
        for (DayOfWeek day : DayOfWeek.values()) {
            openingTimes1.put(day,
                    new TimeSlot(LocalTime.of(8, 0), LocalTime.of(18, 0)));
        }

        sellers.add(new Seller(
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
                openingTimes1
        ));

        // Seller 2
        Map<DayOfWeek, TimeSlot> openingTimes2 = new EnumMap<>(DayOfWeek.class);
        for (DayOfWeek day : DayOfWeek.values()) {
            openingTimes2.put(day,
                    new TimeSlot(LocalTime.of(9, 0), LocalTime.of(19, 0)));
        }

        sellers.add(new Seller(
                2,
                "La dispensa di Maria",
                new Address(
                        "via alessandro manzoni",
                        "10",
                        "02030",
                        "Casali di Poggio Narivo",
                        "Rieti",
                        "Italia"),
                Arrays.asList(ProductType.AGRICULTURAL, ProductType.CLEANING_COSMETICS),
                openingTimes2
        ));
    }

    @Override
    public List<Seller> getAll() {
        return sellers;
    }
}
