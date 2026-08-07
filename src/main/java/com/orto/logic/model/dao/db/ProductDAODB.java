package com.orto.logic.model.dao.db;

import com.orto.logic.model.dao.ProductDAO;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.entity.Product;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.utils.DBConnection;
import com.orto.logic.utils.QuantityUnit;
import com.orto.logic.utils.exceptions.InvalidQuantityTypeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAODB implements ProductDAO {
    @Override
    public List<Product> getProducts(Seller seller) throws ConnectionException {
        String query = "SELECT id, name, description, price, unit FROM product WHERE seller = ?";

        List<Product> products = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, seller.getId());
            ResultSet rs = ps.executeQuery();
            products = getProductsFromResultSet(rs);

        } catch (SQLException e) {
            throw new ConnectionException();
        }

        return products;
    }

    private List<Product> getProductsFromResultSet(ResultSet rs) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            try {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getBigDecimal("price"),
                        QuantityUnit.fromString(rs.getString("unit"))));
            } catch (InvalidQuantityTypeException e) {
                // Ignore invalid database values; this product must still have a valid quantity unit
            }
        }
        return products;
    }

}
