package com.orto.logic.model.dao.db;

import com.orto.logic.model.dao.SellerDAO;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.entity.Address;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.model.entity.TimeSlot;
import com.orto.logic.utils.DBConnection;
import com.orto.logic.utils.ProductType;
import com.orto.logic.utils.exceptions.InvalidProductTypeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.*;

public class SellerDAODB implements SellerDAO {
    @Override
    public List<Seller> getAll() throws ConnectionException {
        String query = "SELECT " +
                "Seller.id, " +
                "Seller.name, " +
                "Seller.addressStreet, " +
                "Seller.addressNumber, " +
                "Seller.addressPostalCode, " +
                "Seller.addressCity, " +
                "Seller.addressProvince, " +
                "Seller.addressCountry, " +
                "SellerProductType.productType, " +
                "OpeningHours.monOpening, " +
                "OpeningHours.monClosing, " +
                "OpeningHours.tueOpening, " +
                "OpeningHours.tueClosing, " +
                "OpeningHours.wedOpening, " +
                "OpeningHours.wedClosing, " +
                "OpeningHours.thuOpening, " +
                "OpeningHours.thuClosing, " +
                "OpeningHours.friOpening, " +
                "OpeningHours.friClosing, " +
                "OpeningHours.satOpening, " +
                "OpeningHours.satClosing, " +
                "OpeningHours.sunOpening, " +
                "OpeningHours.sunClosing " +
                "FROM Seller " +
                "INNER JOIN SellerProductType ON Seller.id = SellerProductType.seller " +
                "INNER JOIN OpeningHours ON Seller.id = OpeningHours.sellerId " +
                "ORDER BY Seller.id;";

        List<Seller> sellers;

        try (   Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();
            sellers = getAllFromResultSet(rs);
        } catch (SQLException e) {
            throw new ConnectionException();
        }

        return sellers;
    }

    private List<Seller> getAllFromResultSet(ResultSet rs) throws SQLException {
        List<Seller> sellers = new ArrayList<>();

        Integer currentId = null;
        String name = null;
        String addressStreet = null;
        String addressNumber = null;
        String addressPostalCode = null;
        String addressCity = null;
        String addressProvince = null;
        String addressCountry = null;
        List<ProductType> productTypes = null;
        Map<DayOfWeek, TimeSlot> openingTimes = null;

        //add each seller to sellers
        while (rs.next()) {
            int readId = rs.getInt("id");
            if (!Objects.equals(currentId, readId)) {
                if (currentId != null && !productTypes.isEmpty()) {
                    sellers.add(new Seller(
                            currentId,
                            name,
                            new Address(
                                    addressStreet,
                                    addressNumber,
                                    addressPostalCode,
                                    addressCity,
                                    addressProvince,
                                    addressCountry),
                            productTypes,
                            openingTimes));
                }
                currentId = readId;
                name = rs.getString("name");
                addressStreet = rs.getString("addressStreet");
                addressNumber = rs.getString("addressNumber");
                addressPostalCode = rs.getString("addressPostalCode");
                addressCity = rs.getString("addressCity");
                addressProvince = rs.getString("addressProvince");
                addressCountry = rs.getString("addressCountry");
                productTypes = new ArrayList<>();
                openingTimes = new EnumMap<>(DayOfWeek.class);
                openingTimes.put(DayOfWeek.MONDAY, new TimeSlot(rs.getTime("monOpening").toLocalTime(), rs.getTime("monClosing").toLocalTime()));
                openingTimes.put(DayOfWeek.TUESDAY, new TimeSlot(rs.getTime("tueOpening").toLocalTime(), rs.getTime("tueClosing").toLocalTime()));
                openingTimes.put(DayOfWeek.WEDNESDAY, new TimeSlot(rs.getTime("wedOpening").toLocalTime(), rs.getTime("wedClosing").toLocalTime()));
                openingTimes.put(DayOfWeek.THURSDAY, new TimeSlot(rs.getTime("thuOpening").toLocalTime(), rs.getTime("thuClosing").toLocalTime()));
                openingTimes.put(DayOfWeek.FRIDAY, new TimeSlot(rs.getTime("friOpening").toLocalTime(), rs.getTime("friClosing").toLocalTime()));
                openingTimes.put(DayOfWeek.SATURDAY, new TimeSlot(rs.getTime("satOpening").toLocalTime(), rs.getTime("satClosing").toLocalTime()));
                openingTimes.put(DayOfWeek.SUNDAY, new TimeSlot(rs.getTime("sunOpening").toLocalTime(), rs.getTime("sunClosing").toLocalTime()));
            }

            try {
                productTypes.add(ProductType.fromString(rs.getString("productType")));
            } catch (InvalidProductTypeException e) {
                // Ignore invalid database values; this seller must still have a valid product type.
            }
        }
        //add the last seller to sellers
        if (currentId != null && !productTypes.isEmpty()) {
            sellers.add(new Seller(
                    currentId,
                    name,
                    new Address(
                            addressStreet,
                            addressNumber,
                            addressPostalCode,
                            addressCity,
                            addressProvince,
                            addressCountry),
                    productTypes,
                    openingTimes));
        }

        return sellers;
    }
}
